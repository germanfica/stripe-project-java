package com.germanfica.stripe.service;

import com.germanfica.stripe.model.LoginResponse;
import com.germanfica.stripe.util.FakeExceptionUtil;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public LoginResponse invokeWsaa() throws StripeException {
        throw FakeExceptionUtil.createFakeCardDeclinedException();
        //return new LoginResponse("success", "Login exitoso");
    }
}
