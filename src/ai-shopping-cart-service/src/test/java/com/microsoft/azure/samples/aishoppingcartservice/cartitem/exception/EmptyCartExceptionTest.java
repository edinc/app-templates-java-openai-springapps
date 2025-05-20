package com.microsoft.azure.samples.aishoppingcartservice.cartitem.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmptyCartExceptionTest {
    @Test
    void testExceptionMessage() {
        EmptyCartException ex = new EmptyCartException("Empty cart");
        assertEquals("Empty cart", ex.getMessage());
    }
}
