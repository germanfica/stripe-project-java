package com.germanfica.stripe.service;

import com.germanfica.stripe.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public LoginResponse invokeWsaa() {
        return new LoginResponse("success", "Login exitoso");
    }
}
