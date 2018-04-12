package com.rph.springboot.CourseApi.service;

import java.util.ArrayList;
import java.util.Arrays;

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
			ArrayList<Topic> testDataTopicList = new ArrayList<>(Arrays.asList(
					new Topic(1, "Topic one", "Topic one description"), new Topic(2, "Topic two", "Topic two description"),
					new Topic(3, "Topic three", "Topic three description")));
		
			topicRepository.saveAll(testDataTopicList);
			
			Course courseOne = new Course();
			courseOne.setId(1);
			courseOne.setName("Course One");
			courseOne.setDescription("Course One Description");
			courseOne.setTopic(testDataTopicList.get(0));
			
			Course courseTwo = new Course();
			courseTwo.setId(2);
			courseTwo.setName("Course Two");
			courseTwo.setDescription("Course Two Description");
			courseTwo.setTopic(testDataTopicList.get(1));
			
			Course courseThree = new Course();
			courseThree.setId(1);
			courseThree.setName("Course Three");
			courseThree.setDescription("Course Three Description");
			courseThree.setTopic(testDataTopicList.get(2));
			
			courseRepository.save(courseOne);
			courseRepository.save(courseTwo);
			courseRepository.save(courseThree);
		}
	}
}
