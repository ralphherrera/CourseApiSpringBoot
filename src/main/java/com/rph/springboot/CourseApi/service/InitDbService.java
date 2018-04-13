package com.rph.springboot.CourseApi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.springboot.CourseApi.model.Course;
import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.repository.CourseRepository;
import com.rph.springboot.CourseApi.repository.TopicRepository;

@Service
public class InitDbService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@PostConstruct
	public void init() {
		
		if (topicRepository.findAll().isEmpty()) {
			List<Topic> testDataTopicList = new ArrayList<>();
			
			Topic topicOne = new Topic();
			topicOne.setName("Topic One Namae");
			topicOne.setDescription("Topic One Description");
			
			Topic topicTwo = new Topic();
			topicTwo.setName("Topic Two Namae");
			topicTwo.setDescription("Topic Two Description");
			
			Topic topicThree = new Topic();
			topicThree.setName("Topic Three Namae");
			topicThree.setDescription("Topic Three Description");

			List<Course> testDataCourseList = new ArrayList<>();
			
			Course courseOne = new Course();
			courseOne.setName("Course One");
			courseOne.setDescription("Course One Description");
			
			Course courseTwo = new Course();
			courseTwo.setName("Course Two");
			courseTwo.setDescription("Course Two Description");
			
			Course courseThree = new Course();
			courseThree.setName("Course Three");
			courseThree.setDescription("Course Three Description");
			
			topicOne.setCourses(testDataCourseList);
			topicOne.setCourses(testDataCourseList);
			topicTwo.setCourses(testDataCourseList);
			topicThree.setCourses(testDataCourseList);
			
			testDataTopicList.add(topicOne);
			testDataTopicList.add(topicTwo);
			testDataTopicList.add(topicThree);
			
			testDataCourseList.add(courseOne);
			testDataCourseList.add(courseTwo);
			testDataCourseList.add(courseThree);
			
			courseOne.setTopic(topicOne);
			courseTwo.setTopic(topicTwo);
			courseThree.setTopic(topicThree);
			
			topicRepository.saveAll(testDataTopicList);
			courseRepository.saveAll(testDataCourseList);
		}
	}
}
