package com.Ustora.book.configurations;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

/**
 * The type Sleuth config.
 */
@Configuration
public class SleuthConfig {

    /**
     * Default sampler sampler.
     *
     * @return the sampler
     */
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
