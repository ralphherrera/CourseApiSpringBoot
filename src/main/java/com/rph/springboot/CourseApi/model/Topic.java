package com.rph.springboot.CourseApi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;
	
//	private List<Course> courses;
	
	public Topic() {
		// Default constructor
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Topic(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
