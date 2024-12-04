package com.germanfica.stripe.controller;

import com.germanfica.stripe.model.LoginResponse;
import com.germanfica.stripe.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    // == fields ==
    private final ApiService apiService;

    // == constructors ==
    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    // == endpoints ==
    @ResponseBody
    @GetMapping(value = "/wsaa/invoke")
    public ResponseEntity<LoginResponse> invokeWsaa() {
        return ResponseEntity.ok(apiService.invokeWsaa());
    }
}
