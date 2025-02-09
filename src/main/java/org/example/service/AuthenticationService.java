package org.example.service;

import org.example.dto.AuthRequestDto;
import org.example.dto.AuthResponseDto;
import org.example.dto.UserRegistrationDto;
import org.example.entity.AppUser;
import org.example.security.JwtService;
import org.example.utils.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtUtil;

    public AuthenticationService(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                                 JwtService jwtUtil, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;

    }

    public AuthResponseDto registerUser(UserRegistrationDto userRegistrationDto){
        if(userService.findByUsername(userRegistrationDto.getUsername()) != null){
            return new AuthResponseDto(null, "Error: user with such username is already exist");
        }

        AppUser user = new AppUser();
        user.setBirthdate(userRegistrationDto.getBirthday());
        user.setEmail(userRegistrationDto.getEmail());
        user.setLastname(userRegistrationDto.getLastname());
        user.setFirstname(userRegistrationDto.getFirstname());
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        userService.saveUser(user);

        AuthRequestDto authDto = new AuthRequestDto();
        authDto.setUsername(userRegistrationDto.getUsername());
        authDto.setPassword(userRegistrationDto.getPassword());

        return loginUser(authDto);
    }

    public AuthResponseDto loginUser(AuthRequestDto authRequestDto){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
            final String token = jwtUtil.generateJwtsToken(authRequestDto.getUsername(), Role.USER);
            return new AuthResponseDto(token, "Success");
        }catch(BadCredentialsException e){
            return  new AuthResponseDto(null, e.getMessage());
        }
    }
}
