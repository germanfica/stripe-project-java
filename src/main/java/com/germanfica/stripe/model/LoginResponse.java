package com.germanfica.stripe.model;

import lombok.Value;

@Value
public class LoginResponse {
    String status;
    String message;

    public LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
