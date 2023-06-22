package ru.rubik.lightdigital.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rubik.lightdigital.exception.AlreadyExistsException;
import ru.rubik.lightdigital.exception.AuthenticationException;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.security.JwtService;
import ru.rubik.lightdigital.user.dto.AuthDto;
import ru.rubik.lightdigital.user.entity.User;
import ru.rubik.lightdigital.user.repository.UserRepository;
import ru.rubik.lightdigital.user.requests.AuthRequest;
import ru.rubik.lightdigital.user.requests.RegisterRequest;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new AlreadyExistsException("User with username " + request.getUsername() + " already exists");
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);
    }

    public AuthDto authUser(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Username or password is not correct");
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + request.getUsername() + " is not found"
                ));

        var token = jwtService.generateToken(user);

        return new AuthDto(token);
    }
}
