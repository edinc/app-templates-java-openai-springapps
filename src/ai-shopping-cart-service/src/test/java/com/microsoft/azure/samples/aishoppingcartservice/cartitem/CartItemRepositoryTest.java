package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartItemRepositoryTest {
    @Test
    void testFindByIdReturnsItem() {
        CartItemRepository repo = mock(CartItemRepository.class);
        CartItem item = new CartItem("Apple", "Fruit", 2);
        when(repo.findById(1L)).thenReturn(Optional.of(item));
        Optional<CartItem> result = repo.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Apple", result.get().getName());
    }

    @Test
    void testFindByIdReturnsEmpty() {
        CartItemRepository repo = mock(CartItemRepository.class);
        when(repo.findById(2L)).thenReturn(Optional.empty());
        Optional<CartItem> result = repo.findById(2L);
        assertFalse(result.isPresent());
    }
}
