package com.rph.springboot.CourseApi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rph.springboot.CourseApi.model.Topic;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<>();
		topicList.add(new Topic(1, "Topic one", "Topic one description"));
		topicList.add(new Topic(2, "Topic two", "Topic two description"));
		topicList.add(new Topic(3, "Topic three", "Topic three description"));
		return topicList;
	}
}
