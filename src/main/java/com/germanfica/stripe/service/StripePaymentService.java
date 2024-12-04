package com.germanfica.stripe.service;

import com.stripe.exception.*;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService {
    public void createPaymentIntent() {
        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(300L)
                    .setAmount(2000L) // Monto en centavos
                    .setCurrency("usd")
                    .setPaymentMethod("pm_card_visa") // ID del método de pago
                    .setConfirm(true)
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);
            System.out.println("Pago exitoso: " + paymentIntent.getId());
        } catch (CardException e) {
            // Error relacionado con el pago, como tarjeta rechazada
            System.out.println("Error de pago: " + e.getMessage());
        } catch (InvalidRequestException e) {
            // Parámetros inválidos proporcionados a la API
            System.out.println("Solicitud inválida: " + e.getMessage());
        } catch (AuthenticationException e) {
            // Fallo en la autenticación con la API de Stripe
            System.out.println("Error de autenticación: " + e.getMessage());
        } catch (ApiConnectionException e) {
            // Problema de comunicación de red con Stripe
            System.out.println("Error de conexión: " + e.getMessage());
        } catch (StripeException e) {
            // Otros errores relacionados con Stripe
            System.out.println("Error en la API de Stripe: " + e.getMessage());
        } catch (Exception e) {
            // Cualquier otro error no relacionado con Stripe
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
