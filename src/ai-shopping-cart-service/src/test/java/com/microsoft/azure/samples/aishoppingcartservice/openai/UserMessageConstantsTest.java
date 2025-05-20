package com.microsoft.azure.samples.aishoppingcartservice.openai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserMessageConstantsTest {
    @Test
    void testConstantsNotNull() {
        assertNotNull(UserMessageConstants.GPT_3_5_RECIPES_POSTFIX);
    }
}
