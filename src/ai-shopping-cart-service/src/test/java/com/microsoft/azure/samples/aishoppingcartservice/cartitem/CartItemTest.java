package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {
    @Test
    void testCartItemGettersAndSetters() {
        CartItem item = new CartItem("Apple", "Fruit", 2);
        item.setId(1L);
        assertEquals(1L, item.getId());
        assertEquals("Apple", item.getName());
        assertEquals("Fruit", item.getCategory());
        assertEquals(2, item.getQuantity());
    }

    @Test
    void testToString() {
        CartItem item = new CartItem("Banana", "Fruit", 3);
        item.setId(2L);
        String str = item.toString();
        assertTrue(str.contains("Banana"));
        assertTrue(str.contains("Fruit"));
        assertTrue(str.contains("3"));
    }
}
