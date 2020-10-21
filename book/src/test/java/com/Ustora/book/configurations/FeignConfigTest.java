package com.Ustora.book.configurations;

import feign.auth.BasicAuthRequestInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FeignConfigTest {

    private FeignConfig feignConfigUnderTest;

    @BeforeEach
    void setUp() {
        feignConfigUnderTest = new FeignConfig();
    }

    @Test
    void testMBasicAuthRequestInterceptor() {
        // Setup

        // Run the test
        final BasicAuthRequestInterceptor result = feignConfigUnderTest.mBasicAuthRequestInterceptor();

        // Verify the results
    }
}
