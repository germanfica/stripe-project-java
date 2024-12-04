package com.germanfica.stripe.util;

import com.stripe.exception.CardException;
import com.stripe.model.StripeError;

public class FakeExceptionUtil {
    public static CardException createFakeCardException() {
        // Valores comunes para StripeError y CardException
        String message = "Tu tarjeta fue rechazada";
        String code = "card_declined";
        String declineCode = "insufficient_funds";
        String docUrl = "https://stripe.com/docs/error-codes/card-declined";

        // Crear y configurar el StripeError
        StripeError error = new StripeError();
        error.setMessage(message);
        error.setCode(code);
        error.setType("card_error");
        error.setDeclineCode(declineCode);
        error.setDocUrl(docUrl);

        // Crear y retornar el CardException usando los valores del StripeError
        CardException exception = new CardException(
                error.getMessage(),
                null, // No hay una solicitud real
                error.getCode(),
                null, // Parámetro asociado al error
                error.getDeclineCode(),
                null, // ID del cargo
                402,
                null // Excepción original
        );
        exception.setStripeError(error);
        return exception;
    }
}
