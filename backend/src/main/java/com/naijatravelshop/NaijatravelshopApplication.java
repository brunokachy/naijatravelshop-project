package com.naijatravelshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableAsync
@SpringBootApplication
public class NaijatravelshopApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NaijatravelshopApplication.class, args);
	}

}
