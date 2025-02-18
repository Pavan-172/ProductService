package com.project.productservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

//     need to understand why bean here and what's bean completely
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
