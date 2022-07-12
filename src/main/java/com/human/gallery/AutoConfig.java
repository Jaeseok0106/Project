package com.human.gallery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(
		 basePackages = "com.human")
@MapperScan(
		basePackages = "com.human")
public class AutoConfig {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource =new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages/errors");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(60);
		
		return messageSource;
	}

}