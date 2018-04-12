package com.rph.springboot.CourseApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.springboot.CourseApi.model.Course;
import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourse(int topicId) {
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(int id) {
		return courseRepository.findById(id);
	}
	
	public void saveCourse(int topicId, Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseRepository.save(course);
	}

	public void updateTopic(int topicId, Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseRepository.save(course);
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}
	
}
