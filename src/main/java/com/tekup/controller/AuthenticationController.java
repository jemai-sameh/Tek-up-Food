package com.tekup.controller;


import com.tekup.dto.auth.AuthenticationRequest;
import com.tekup.dto.auth.AuthenticationResponse;
import com.tekup.dto.auth.RegistrationRequest;
import com.tekup.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/food/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegistrationRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

