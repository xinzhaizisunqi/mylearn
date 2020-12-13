
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file = new File("src/main/resources");
       System.out.println(file.getAbsolutePath());
                registry.addResourceHandler("/image/**").addResourceLocations("file:/Users/sunqi/Desktop/work/mylearn/src/main/resources/static/");



    }
}

