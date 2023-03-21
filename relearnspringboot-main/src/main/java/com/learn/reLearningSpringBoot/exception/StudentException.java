package com.learn.reLearningSpringBoot.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {
	
	@Value("${student.notFound:NOT IN DB}")
	private String notFoundInDB;
	
	@Value("${student.alreadyPresent:ALREADY IN DB}")
	private String messageAlreadyInDB;
	
	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException exception) {
		return new ResponseEntity<>(notFoundInDB,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = StudentAlreadyInDB.class)
	public ResponseEntity<Object> exception(StudentAlreadyInDB exception) {
		return new ResponseEntity<>(messageAlreadyInDB,HttpStatus.FOUND);
	}

}
