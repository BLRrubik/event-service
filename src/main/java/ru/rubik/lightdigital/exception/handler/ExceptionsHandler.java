package ru.rubik.lightdigital.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rubik.lightdigital.exception.AlreadyExistsException;
import ru.rubik.lightdigital.exception.AuthenticationException;
import ru.rubik.lightdigital.exception.ConflictException;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.exception.dto.ExceptionDto;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionDto(
                        e.getMessage(),
                        ZonedDateTime.now()
                ),
                HttpStatusCode.valueOf(404)
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> alreadyExists(AlreadyExistsException e) {
        return new ResponseEntity<>(
                new ExceptionDto(
                        e.getMessage(),
                        ZonedDateTime.now()
                ),
                HttpStatusCode.valueOf(409)
        );
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionDto> authException(AuthenticationException e) {
        return new ResponseEntity<>(
                new ExceptionDto(
                        e.getMessage(),
                        ZonedDateTime.now()
                ),
                HttpStatusCode.valueOf(403)
        );
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDto> authException(ConflictException e) {
        return new ResponseEntity<>(
                new ExceptionDto(
                        e.getMessage(),
                        ZonedDateTime.now()
                ),
                HttpStatusCode.valueOf(409)
        );
    }

}
