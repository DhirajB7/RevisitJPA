package com.learn.reLearningSpringBoot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/")
public class Check {

	@Value("${application.message:SERVICE IS UP AND RUNNING}")
	private String message;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("up")
	public String check() {
		return message.toUpperCase();
	}

	@Scheduled(fixedDelay = 60000, initialDelay = 60000)
	public void getSomeData() {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		System.out.println(restTemplate.exchange("http://localhost:3030/up", HttpMethod.GET, entity, String.class).getBody());		
		
	}
}
