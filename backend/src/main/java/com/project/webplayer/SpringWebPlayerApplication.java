package com.project.webplayer;

import com.project.webplayer.services.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebPlayerApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringWebPlayerApplication.class, args);
		StorageService storageService = applicationContext.getBean(StorageService.class);
	}

}