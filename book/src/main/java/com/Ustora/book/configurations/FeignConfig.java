package com.Ustora.book.configurations;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Feign config.
 */
@Configuration
public class FeignConfig {

    /**
     * M basic auth request interceptor basic auth request interceptor.
     *
     * @return the basic auth request interceptor
     */
    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor(){
        return  new BasicAuthRequestInterceptor("utilisateur", "mdp");
    }

}
