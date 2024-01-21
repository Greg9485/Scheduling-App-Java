package com.schedulingapp.scheduling.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Value("$allowed.origins")
    private String[] theAllowedOrigins;

    @Value("$allowed-headers")
    private String[] theAllowedHeaders;

    @Value("$max-age")
    private String[] theMaxAge;

    @Value("$allowed-methods")
    private String[] theAllowedMethods;

    @Value("$spring.data.rest.base-path")
    String basePath;

    @Override
    public void addCorsMappings(CorsRegistry cors){
        //set up cors mapping
        cors.addMapping(basePath + "/**")
                .allowedOrigins(theAllowedOrigins)
                .allowedHeaders(theAllowedHeaders)
                .allowCredentials(false)
                .allowedMethods(theAllowedMethods)
               .allowedHeaders("*");
    }

}
