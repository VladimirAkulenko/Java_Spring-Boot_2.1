package org.example.springbootrest.controller;

import org.example.springbootrest.exeption.InvalidCredentials;
import org.example.springbootrest.exeption.UnauthorizedUser;
import org.example.springbootrest.model.Authorities;
import org.example.springbootrest.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials msg) {
        System.out.println("Exception: " + msg.getMessage());
        return new ResponseEntity<>("Exception: " + msg.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser msg) {
        System.out.println("Exception: " + msg.getMessage());
        return new ResponseEntity<>("Exception: " + msg.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
