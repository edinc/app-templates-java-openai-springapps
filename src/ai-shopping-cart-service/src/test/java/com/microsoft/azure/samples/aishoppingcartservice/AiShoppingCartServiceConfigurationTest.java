package com.microsoft.azure.samples.aishoppingcartservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AiShoppingCartServiceConfigurationTest {
    @Test
    void testConfigurationLoads() {
        AiShoppingCartServiceConfiguration config = new AiShoppingCartServiceConfiguration();
        assertNotNull(config);
    }
}
