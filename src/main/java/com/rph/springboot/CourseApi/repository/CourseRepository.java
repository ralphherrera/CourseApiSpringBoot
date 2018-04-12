package com.rph.springboot.CourseApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rph.springboot.CourseApi.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> findByTopicId(int id);
	public Course findById(int id);
}
