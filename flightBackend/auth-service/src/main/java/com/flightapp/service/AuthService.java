package com.flightapp.service;

import java.util.Set;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.flightapp.dto.AuthResponse;
import com.flightapp.dto.LoginRequest;
import com.flightapp.dto.SignUpRequest;
import com.flightapp.model.User;
import com.flightapp.repo.UserRepo;
import com.flightapp.security.JwtService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    
    public String signUp(SignUpRequest request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Set.of("ROLE_USER")
        );
        userRepo.save(user);
        return "User registered successfully";
    }
    
    public AuthResponse login(LoginRequest request) {
        var authToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());
        authenticationManager.authenticate(authToken);

        UserDetails userDetails = userRepo.findByUsername(request.getUsername())
                .map(u -> org.springframework.security.core.userdetails.User
                        .withUsername(u.getUsername())
                        .password(u.getPassword())
                        .authorities(u.getRoles().toArray(String[]::new))
                        .build())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }
    
}
