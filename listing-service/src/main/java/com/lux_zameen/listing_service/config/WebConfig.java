package com.lux_zameen.listing_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${app.media.dir}")
    private String mediaDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path root = Paths.get(mediaDir).toAbsolutePath().normalize();

        registry.addResourceHandler("/media/**")                 // URLs like /media/images/abc.jpg
                .addResourceLocations(root.toUri().toString());
    }

}