package com.microsoft.azure.samples.aishoppingcartservice.cartitem.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmptyCartExceptionTest {
    @Test
    void testExceptionMessage() {
        EmptyCartException ex = new EmptyCartException("Cart is empty");
        assertEquals("Cart is empty", ex.getMessage());
    }
}
