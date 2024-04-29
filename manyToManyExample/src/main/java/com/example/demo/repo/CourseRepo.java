package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
