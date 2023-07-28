package com.wtech.core.config;

import com.wtech.core.parts.Engine;
import com.wtech.core.parts.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    @Configuration
    @ComponentScan("com.wtech.core")
    public class SpringBeansConfig {

        @Bean
        public Engine engine() {
            return new Engine("v8", 5);
        }

        @Bean
        public Transmission transmission() {
            return new Transmission("manual");
        }
    }
