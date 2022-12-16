package com.tekup.service.auth;



import java.util.HashMap;
import java.util.Map;

import com.tekup.ConfigSwager.JwtUtils;
import com.tekup.dto.auth.AuthenticationRequest;
import com.tekup.dto.auth.AuthenticationResponse;
import com.tekup.dto.auth.RegistrationRequest;
import com.tekup.model.*;
import com.tekup.repository.ClientRepository;
import com.tekup.repository.DeliveryManRepository;
import com.tekup.repository.ManagerRepository;
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
    private DeliveryManRepository deliveryManRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private  AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegistrationRequest request) {

        Manager user = RegistrationRequest.toEntityManager(request);
        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole());

       // var savedUser = (user.getRole()== Role.CLIENT)? clientRepository.save((Client) user):(user.getRole()== Role.MANAGER)? managerRepository.save((Manager) user): deliveryManRepository.save((DeliveryMan) user);
        var savedUser= managerRepository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", savedUser.getId()); // optional
        claims.put("fullName", savedUser.getFullName()); // optional

        // generate a JWT token
        String token = jwtUtils.generateToken(savedUser, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .name(savedUser.getFullName())
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
        claims.put("fullName", user.getFullName()); // optional
        // generate a JWT token
        String token = jwtUtils.generateToken(user, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .name(user.getFullName())
                .build();
    }


}
