package com.learn.reLearningSpringBoot.services;

import java.util.HashMap;

import com.learn.reLearningSpringBoot.modal.StudentModal;

public interface StudentService {
	
	public abstract void addStudent(StudentModal student);
	public abstract HashMap<Integer, StudentModal> getAllStudents();
	public abstract StudentModal getOneStudent(int id);
	public abstract void updateStudent(StudentModal student);
	public abstract void deleteStudent(int id);
	public abstract boolean dbContainsStudentId(int id);
}
