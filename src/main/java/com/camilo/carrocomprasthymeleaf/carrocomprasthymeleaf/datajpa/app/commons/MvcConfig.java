package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    private ApplicationContext applicationContext;

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
        log.info(resourcePath);
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(resourcePath);
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        WebMvcConfigurer.super.addResourceHandlers(registry);

		/*String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		log.info(resourcePath);

		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(resourcePath);
		*/
    }
}
