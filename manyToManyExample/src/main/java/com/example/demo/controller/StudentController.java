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

import com.example.demo.modal.Student;
import com.example.demo.repo.StudentRepo;

@RestController
@RequestMapping(path = "student")
public class StudentController {

	@Autowired
	private StudentRepo repo;

	@GetMapping(path = "/")
	public ResponseEntity<Object> getAllStudents() {
		return new ResponseEntity<Object>(repo.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable Long id) {
		return new ResponseEntity<Object>(repo.findById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/")
	public ResponseEntity<Object> addStudent(@RequestBody Student student) {
		return new ResponseEntity<Object>(repo.save(student), HttpStatus.OK);
	}

}
