package com.mhc3.mhc3_3tory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Default 값
     * Allow all origins.
     * Allow "simple" methods GET, HEAD and POST.
     * Allow all headers.
     * Set max age to 1800 seconds (30 minutes).
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("https://www.story-gonggam.com/", "http://localhost:3000")
                .allowedMethods("GET","POST","HEAD")
                .maxAge(3600); // 3600 seconds
    }
}
