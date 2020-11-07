package com.assignment.usermanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hemanshu.banga
 *
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements  WebMvcConfigurer{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/usermanagement.html").addResourceLocations("classpath:/templates/usermanagement.html");
        registry.addResourceHandler("/usermanagement.js").addResourceLocations("classpath:/static/usermanagement.js");
        registry.setOrder(-1);
    }
	
}
