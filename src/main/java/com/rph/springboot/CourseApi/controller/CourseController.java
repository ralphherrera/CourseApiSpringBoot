package com.rph.springboot.CourseApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rph.springboot.CourseApi.model.Course;
import com.rph.springboot.CourseApi.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> displayAllCourses(@PathVariable int topicId) {
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course displayCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public void doAddCourse(@RequestBody Course course, @PathVariable int topicId) {
		courseService.saveCourse(topicId, course);
	}

	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
	public void doUpdateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id) {
		courseService.updateTopic(topicId, course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
	public void doDeleteTopic(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
}