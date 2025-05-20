package com.microsoft.azure.samples.aishoppingcartservice.openai;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartAiRecommendationsTest {
    @Test
    void testGetAINutritionAnalysisThrowsOnEmptyList() {
        ShoppingCartAiRecommendations rec = new ShoppingCartAiRecommendations(
            "dummy-key", "https://dummy-endpoint", "dummy-deployment", 0.0, 0.0, true
        );
        assertThrows(Exception.class, () -> rec.getAINutritionAnalysis(Collections.emptyList()));
    }
}
