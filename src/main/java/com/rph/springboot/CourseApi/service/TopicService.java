package com.rph.springboot.CourseApi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rph.springboot.CourseApi.model.Course;
import com.rph.springboot.CourseApi.model.Topic;
import com.rph.springboot.CourseApi.repository.CourseRepository;
import com.rph.springboot.CourseApi.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = topicRepository.findAll();
		
		for (Topic topic : topics) {
			List<Course> courses = courseRepository.findByTopic(topic);
//			topic.setCourses(courses);
			for (Course course : courses) {
				System.out.println(course.getId());
				System.out.println(course.getName());
				System.out.println(course.getDescription());
			}
		}
		return topics;
	}

	public Topic getTopic(int id) {
		return topicRepository.findById(id);
	}

	public void saveTopic(Topic topic) {
		topic.setCourses(courseRepository.findByTopic(topic));
		topicRepository.save(topic);
	}

	public void updateTopic(int id, Topic topic) {
		topic.setCourses(courseRepository.findByTopic(topic));
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
	}
}
