package com.rph.springboot.CourseApi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
//		return topicList;
		return topicRepository.findAll();
	}

	public Topic getTopic(int id) {
//		return getAllTopics().stream().filter(t -> t.getId() == (id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void saveTopic(Topic topic) {
//		topicList.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(int id, Topic topic) {
//		for(int i = 0; i < topicList.size(); i++) {
//			if (topicList.get(i).getId() == id) {
//				topicList.set(i, topic);
//			}
//		}
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
//		topicList.removeIf(t -> t.getId() == id);
		/*for(int i = 0; i < topicList.size(); i++) {
			if (topicList.get(i).getId() == id) {
				topicList.remove(topicList.get(i));
			}
		}*/
	}
}
