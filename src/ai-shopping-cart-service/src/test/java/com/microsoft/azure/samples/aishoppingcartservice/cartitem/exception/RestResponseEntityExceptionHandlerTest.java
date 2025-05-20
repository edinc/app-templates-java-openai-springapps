package com.microsoft.azure.samples.aishoppingcartservice.cartitem.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestResponseEntityExceptionHandlerTest {
    @Test
    void testHandleCartItemNotFoundException() {
        RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler();
        CartItemNotFoundException ex = new CartItemNotFoundException(42L);
        WebRequest request = mock(WebRequest.class);
        ResponseEntity<Object> response = handler.handleCartItemNotFoundException(ex, request);
        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void testHandleEmptyCartException() {
        RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler();
        EmptyCartException ex = new EmptyCartException("Empty cart");
        WebRequest request = mock(WebRequest.class);
        ResponseEntity<Object> response = handler.handleEmptyCartException(ex, request);
        assertEquals(400, response.getStatusCode().value());
    }
}
