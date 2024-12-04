package com.germanfica.stripe.util;

import com.stripe.exception.CardException;
import com.stripe.model.StripeError;

public class FakeExceptionUtil {
    /**
     * Crea una excepción simulada de tarjeta rechazada con información detallada.
     *
     * @return CardException simulada completamente configurada.
     */
    public static CardException createFakeCardDeclinedException() {
        // Valores comunes para StripeError y CardException
        String message = "Tu tarjeta fue rechazada debido a fondos insuficientes.";
        String code = "card_declined";
        String declineCode = "insufficient_funds";
        String docUrl = "https://stripe.com/docs/error-codes/card-declined";
        String chargeId = "ch_123456789"; // ID simulado de un cargo fallido
        String requestId = "req_123456789"; // ID simulado de la solicitud
        String type = "card_error"; // Tipo general del error

        // Crear y configurar el StripeError
        StripeError error = new StripeError();
        error.setMessage(message);
        error.setCode(code);
        error.setType(type);
        error.setDeclineCode(declineCode);
        error.setDocUrl(docUrl);
        error.setCharge(chargeId); // Asociar un ID de cargo fallido

        // Crear y retornar el CardException usando los valores configurados
        CardException exception = new CardException(
                error.getMessage(),  // Mensaje del error
                requestId,           // ID de la solicitud
                error.getCode(),     // Código del error
                "amount",            // Parámetro asociado (simulado)
                error.getDeclineCode(), // Código de rechazo
                error.getCharge(),   // ID del cargo fallido
                402,                 // Código HTTP
                null                 // Excepción original
        );

        exception.setStripeError(error); // Asociar el StripeError al CardException
        return exception;
    }
}
