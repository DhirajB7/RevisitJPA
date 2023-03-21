package com.learn.reLearningSpringBoot.serviceImplimentation;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.learn.reLearningSpringBoot.modal.StudentModal;
import com.learn.reLearningSpringBoot.services.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	
	private HashMap<Integer, StudentModal> map = new HashMap<Integer, StudentModal>();

	@Override
	public void addStudent(StudentModal student) {
		map.put(student.getId(), student);
	}

	@Override
	public HashMap<Integer, StudentModal> getAllStudents() {
		return map;
	}

	@Override
	public StudentModal getOneStudent(int id) {
		return map.get(id);
	}

	@Override
	public void updateStudent(StudentModal student) {
		map.put(student.getId(),student);
	}

	@Override
	public void deleteStudent(int id) {
		map.remove(id);
	}

	@Override
	public boolean dbContainsStudentId(int id) {
		return map.containsKey(id);
	}

	
}
