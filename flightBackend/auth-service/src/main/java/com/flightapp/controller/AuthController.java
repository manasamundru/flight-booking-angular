package com.flightapp.controller;
import com.flightapp.dto.AuthResponse;
import com.flightapp.dto.LoginRequest;
import com.flightapp.dto.SignUpRequest;
import com.flightapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SignUpRequest request) {
        String msg = authService.signUp(request);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestBody SignUpRequest request) {
        String msg = authService.registerAdmin(request);
        return ResponseEntity.ok(msg);
    }

}


