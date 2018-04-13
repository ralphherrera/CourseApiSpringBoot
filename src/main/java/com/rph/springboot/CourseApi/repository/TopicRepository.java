package com.rph.springboot.CourseApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rph.springboot.CourseApi.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	public Topic findById(int id);

}
