package com.rph.springboot.CourseApi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.service.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping()
	public List<Topic> displayAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/{id}")
	public Topic displayTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.saveTopic(topic);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void editTopic(@RequestBody Topic topic, @PathVariable int id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
}
