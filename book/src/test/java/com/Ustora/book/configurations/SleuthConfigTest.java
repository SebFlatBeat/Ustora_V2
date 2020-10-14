package com.Ustora.book.configurations;

import brave.sampler.Sampler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SleuthConfigTest {

    private SleuthConfig sleuthConfigUnderTest;

    @BeforeEach
    void setUp() {
        sleuthConfigUnderTest = new SleuthConfig();
    }

    @Test
    void testDefaultSampler() {
        // Setup

        // Run the test
        final Sampler result = sleuthConfigUnderTest.defaultSampler();

        // Verify the results
    }
}
