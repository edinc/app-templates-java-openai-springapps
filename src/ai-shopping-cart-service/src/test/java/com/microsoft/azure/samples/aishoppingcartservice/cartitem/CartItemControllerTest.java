package com.microsoft.azure.samples.aishoppingcartservice.cartitem;

import com.microsoft.azure.samples.aishoppingcartservice.openai.ShoppingCartAiRecommendations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import java.util.Collections;

@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {CartItemController.class, CartItemControllerTest.StubConfig.class})
@WebMvcTest(CartItemController.class)
@Import(CartItemControllerTest.StubConfig.class)
class CartItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartItemRepository cartItemRepository;

    // Use a stub instead of @MockBean for ShoppingCartAiRecommendations
    @Configuration
    static class StubConfig {
        @Bean
        public ShoppingCartAiRecommendations shoppingCartAiRecommendations() {
            return new ShoppingCartAiRecommendations("key", "https://endpoint", "deployment", 0.5, 0.9, false) {
                @Override
                public String getAINutritionAnalysis(java.util.List<CartItem> cartItems) {
                    return "{\"nutriscore\":\"A\",\"explanation\":\"Good\",\"recommendation\":\"Eat more veggies\"}";
                }
                @Override
                public String getTop3Recipes(java.util.List<CartItem> cartItems) {
                    return "{\"recipes\":[]}";
                }
            };
        }
    }

    @Test
    void testGetCartItems() throws Exception {
        given(cartItemRepository.findAll()).willReturn(Collections.emptyList());
        mockMvc.perform(get("/api/cart-items"))
                .andExpect(status().isOk());
    }

    @Test
    void testAddCartItem() throws Exception {
        CartItem item = new CartItem("Eggs", "Dairy", 1);
        given(cartItemRepository.save(any(CartItem.class))).willReturn(item);
        String json = "{\"name\":\"Eggs\",\"category\":\"Dairy\",\"quantity\":1}";
        mockMvc.perform(post("/api/cart-items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }
}
