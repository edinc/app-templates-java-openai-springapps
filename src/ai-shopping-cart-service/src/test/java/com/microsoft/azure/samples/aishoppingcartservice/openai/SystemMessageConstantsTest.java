package com.microsoft.azure.samples.aishoppingcartservice.openai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemMessageConstantsTest {
    @Test
    void testConstantsNotNull() {
        assertNotNull(SystemMessageConstants.AI_NUTRITION_ANALYSIS);
        assertNotNull(SystemMessageConstants.RECIPES);
    }
}
