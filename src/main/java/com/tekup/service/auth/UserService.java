package com.tekup.service.auth;

import com.tekup.dto.auth.AuthenticationRequest;
import com.tekup.dto.auth.AuthenticationResponse;
import com.tekup.dto.auth.RegistrationRequest;

public interface UserService  {


    AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}

