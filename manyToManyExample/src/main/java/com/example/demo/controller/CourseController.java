package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Course;
import com.example.demo.repo.CourseRepo;

@RestController
@RequestMapping(path = "course")
public class CourseController {

	@Autowired
	private CourseRepo repo;

	@GetMapping(path = "/")
	public ResponseEntity<Object> getAllCourse() {
		return new ResponseEntity<Object>(repo.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
		return new ResponseEntity<Object>(repo.findById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/")
	public ResponseEntity<Object> addCourse(@RequestBody Course course) {
		return new ResponseEntity<Object>(repo.save(course), HttpStatus.OK);
	}

}
