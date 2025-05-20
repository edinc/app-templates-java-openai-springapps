package com.microsoft.azure.samples.aishoppingcartservice.cartitem.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartItemNotFoundExceptionTest {
    @Test
    void testExceptionMessage() {
        CartItemNotFoundException ex = new CartItemNotFoundException(42L);
        assertEquals("Could not find cart item 42", ex.getMessage());
    }
}
