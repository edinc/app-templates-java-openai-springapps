package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {
    @Test
    void testCartItemConstructorAndGetters() {
        CartItem item = new CartItem("Apple", "Fruit", 2);
        assertEquals("Apple", item.getName());
        assertEquals("Fruit", item.getCategory());
        assertEquals(2, item.getQuantity());
    }

    @Test
    void testSetters() {
        CartItem item = new CartItem();
        item.setId(10L);
        item.setName("Banana");
        item.setCategory("Fruit");
        item.setQuantity(5);
        assertEquals(10L, item.getId());
        assertEquals("Banana", item.getName());
        assertEquals("Fruit", item.getCategory());
        assertEquals(5, item.getQuantity());
    }
}
