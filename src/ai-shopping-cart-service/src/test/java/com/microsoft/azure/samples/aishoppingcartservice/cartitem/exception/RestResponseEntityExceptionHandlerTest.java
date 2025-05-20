package com.microsoft.azure.samples.aishoppingcartservice.cartitem.exception;

import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestResponseEntityExceptionHandlerTest {
    @Test
    void testHandleCartItemNotFoundException() {
        RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler();
        CartItemNotFoundException ex = new CartItemNotFoundException(123L);
        WebRequest request = mock(WebRequest.class);
        var response = handler.handleCartItemNotFoundException(ex, request);
        assertEquals(404, response.getStatusCode().value());
        Object body = response.getBody();
        assertNotNull(body);
        assertTrue(body.toString().contains("Could not find cart item 123"));
    }

    @Test
    void testHandleEmptyCartException() {
        RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler();
        EmptyCartException ex = new EmptyCartException("Cart is empty");
        WebRequest request = mock(WebRequest.class);
        var response = handler.handleEmptyCartException(ex, request);
        assertEquals(400, response.getStatusCode().value());
        Object body = response.getBody();
        assertNotNull(body);
        assertTrue(body.toString().contains("Cart is empty"));
    }
}
