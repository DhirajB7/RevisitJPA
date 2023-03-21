package com.learn.reLearningSpringBoot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
public class ReLearningSpringBootApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReLearningSpringBootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("I AM APPLICATION RUNNER");

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
