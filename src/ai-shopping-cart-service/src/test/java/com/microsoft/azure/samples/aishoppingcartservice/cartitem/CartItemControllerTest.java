package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartItemControllerTest {
    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemController cartItemController;

    public CartItemControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllItemsReturnsEmptyList() {
        when(cartItemRepository.findAll()).thenReturn(Collections.emptyList());
        Iterable<CartItem> items = cartItemController.getCartItems();
        assertNotNull(items);
        assertFalse(items.iterator().hasNext());
    }

    @Test
    void testAddCartItemNullInput() {
        // Enforce null check in controller: should throw NullPointerException
        assertThrows(NullPointerException.class, () -> cartItemController.addCartItem(null));
    }
}
