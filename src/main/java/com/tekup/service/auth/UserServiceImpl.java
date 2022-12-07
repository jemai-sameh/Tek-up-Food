package com.tekup.service.auth;



import java.util.HashMap;
import java.util.Map;

import com.tekup.ConfigSwager.JwtUtils;
import com.tekup.dto.auth.AuthenticationRequest;
import com.tekup.dto.auth.AuthenticationResponse;
import com.tekup.dto.auth.RegistrationRequest;
import com.tekup.model.AppUser;
import com.tekup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private  AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegistrationRequest request) {

        AppUser user = RegistrationRequest.toEntity(request);
        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole());
        var savedUser = repository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", savedUser.getId()); // optional
        claims.put("fullName", savedUser.getFirstname() + " " + savedUser.getLastname()); // optional

        // generate a JWT token
        String token = jwtUtils.generateToken(savedUser, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .name(savedUser.getFirstname() + " " + savedUser.getLastname())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final AppUser user = repository.findByEmail(request.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId()); // optional
        claims.put("fullName", user.getFirstname() + " " + user.getLastname()); // optional
        // generate a JWT token
        String token = jwtUtils.generateToken(user, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }


}
