package ru.rubik.lightdigital.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rubik.lightdigital.user.dto.AuthDto;
import ru.rubik.lightdigital.user.requests.AuthRequest;
import ru.rubik.lightdigital.user.requests.RegisterRequest;
import ru.rubik.lightdigital.user.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterRequest request) {
        authService.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> authUser(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authUser(request));
    }


}
