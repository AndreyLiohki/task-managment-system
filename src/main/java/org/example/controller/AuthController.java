package org.example.controller;

import org.example.dto.AuthRequestDto;
import org.example.dto.AuthResponseDto;
import org.example.dto.UserRegistrationDto;
import org.example.service.AuthenticationService;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService, UserService userService, PasswordEncoder passwordEncoder) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody UserRegistrationDto userRegistrationDto){
        AuthResponseDto responseDto = authService.registerUser(userRegistrationDto);

        if("Success".equals(responseDto.getResponseMessage())){
            return ResponseEntity.ok(responseDto);
        }else{
            return ResponseEntity.badRequest().body(responseDto);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto){
        AuthResponseDto responseDto = authService.loginUser(authRequestDto);

        if("Success".equals(responseDto.getResponseMessage())){
            return ResponseEntity.ok(responseDto);
        }else{
            return ResponseEntity.badRequest().body(responseDto);
        }
    }

}
