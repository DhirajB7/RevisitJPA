package com.learn.reLearningSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.reLearningSpringBoot.exception.StudentAlreadyInDB;
import com.learn.reLearningSpringBoot.exception.StudentNotFoundException;
import com.learn.reLearningSpringBoot.modal.StudentModal;
import com.learn.reLearningSpringBoot.services.StudentService;

@RestController
@RequestMapping(value = "/student")
public class Student {

	@Autowired
	StudentService studentService;
	
	@PostMapping(value = "/")
	public ResponseEntity<Object> addStudent(@RequestBody StudentModal student) {

		if(studentService.dbContainsStudentId(student.getId())) {
			throw new StudentAlreadyInDB();
		} else {
			studentService.addStudent(student);
			String message = "STUDENT WITH ID : " + student.getId() + " ADDED IN DB";
			return new ResponseEntity<>(new String(message),HttpStatus.CREATED);
		}

	}

	@PutMapping(value = "/")
	public ResponseEntity<Object> updateStudent(@RequestBody StudentModal student) {
		if(studentService.dbContainsStudentId(student.getId())) {
			studentService.updateStudent(student);
			return new ResponseEntity<>(studentService.getOneStudent(student.getId()) ,HttpStatus.ACCEPTED);
		}else {
			throw new StudentNotFoundException();
		}
	}

	@GetMapping(value = "/")
	public ResponseEntity<Object> getAllStudent() {
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getOneStudent(@PathVariable(required = true) int id) {
		if(studentService.dbContainsStudentId(id)) {
			return new ResponseEntity<>(studentService.getOneStudent(id),HttpStatus.OK);
		}else {
			throw new StudentNotFoundException();
		}
		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable(required = true) int id) {
		if(studentService.dbContainsStudentId(id)) {
			studentService.deleteStudent(id);
			return new ResponseEntity<>(new String("DELETED ID : "+id+" FROM DB.") ,HttpStatus.OK);
		}else {
			throw new StudentNotFoundException();
		}
	}

}
