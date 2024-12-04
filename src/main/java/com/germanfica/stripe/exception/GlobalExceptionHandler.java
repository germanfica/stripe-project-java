package com.germanfica.stripe.exception;

import com.stripe.exception.CardException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.stripe.exception.StripeException;
import com.stripe.model.StripeError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // incluye @ControllerAdvice y @ResponseBody
//@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CardException.class)
    public ResponseEntity<StripeError> handleCardException(CardException e) {
        // Retornamos el StripeError directamente
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getStripeError());
    }

    @ExceptionHandler(StripeException.class)
    public ResponseEntity<String> handleStripeException(StripeException e) {
        // Otros errores generales de Stripe
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Stripe error: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        // Manejo genérico para otros errores
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error inesperado: " + e.getMessage());
    }
}
