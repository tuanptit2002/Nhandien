package com.example.Be_Java.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  // Allows all origins
                .allowedMethods("*")  // Allows all methods (GET, POST, etc.)
                .allowedHeaders("*"); // Allows all headers
    }
}
