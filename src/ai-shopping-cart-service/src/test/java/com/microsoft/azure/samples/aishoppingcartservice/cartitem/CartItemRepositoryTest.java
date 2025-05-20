package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CartItemRepositoryTest {
    @Autowired
    private CartItemRepository repository;

    @Test
    void testSaveAndFind() {
        CartItem item = new CartItem("Milk", "Dairy", 1);
        repository.save(item);
        assertTrue(repository.findAll().iterator().hasNext());
    }
}
