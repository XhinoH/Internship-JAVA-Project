package com.lhind.service;

import com.lhind.model.dto.AuthenticationRequest;
import com.lhind.model.dto.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse authenticate (AuthenticationRequest  authenticationRequest);
}
