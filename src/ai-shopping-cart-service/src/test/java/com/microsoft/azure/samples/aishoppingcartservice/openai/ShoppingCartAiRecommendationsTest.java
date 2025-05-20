package com.microsoft.azure.samples.aishoppingcartservice.openai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;

import com.microsoft.azure.samples.aishoppingcartservice.cartitem.CartItem;

class ShoppingCartAiRecommendationsTest {
    
    // Test stub class to prevent actual network calls
    static class TestShoppingCartAiRecommendations extends ShoppingCartAiRecommendations {
        public TestShoppingCartAiRecommendations() {
            super("fake-key", "https://localhost", "deployment-id", 0.5, 0.9, false);
        }
        
        @Override
        protected String getChatCompletion(String systemMessage, List<CartItem> cartItems, String userMessagePostfix) {
            // Return a dummy response instead of making a real API call
            return "{\"dummy\": \"response\"}";
        }
    }
    
    @Test
    void testConstructorAndMethods() {
        // Use the test subclass instead of the real class
        ShoppingCartAiRecommendations rec = new TestShoppingCartAiRecommendations();
        
        assertNotNull(rec);
        // Now these methods should run without trying to make network calls
        assertDoesNotThrow(() -> rec.getAINutritionAnalysis(Collections.emptyList()));
        assertDoesNotThrow(() -> rec.getTop3Recipes(Collections.emptyList()));
    }
}
