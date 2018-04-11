package com.rph.springboot.CourseApi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.repository.TopicRepository;

@Service
public class InitDbService {

	@Autowired
	private TopicRepository topicRepository;

	@PostConstruct
	public void init() {
		
		if (topicRepository.findAll().isEmpty()) {
			List<Topic> testDataTopicList = new ArrayList<>(Arrays.asList(
					new Topic(1, "Topic one", "Topic one description"), new Topic(2, "Topic two", "Topic two description"),
					new Topic(3, "Topic three", "Topic three description")));
			
			for (Topic topic : testDataTopicList) {
				topicRepository.save(topic);
				
			}
		}
	}
}
