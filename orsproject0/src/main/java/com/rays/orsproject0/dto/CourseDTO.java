package com.rays.orsproject0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Course POJO class. It is persistent object.
 * 
 * @author Neeraj
 */
@Entity
@Table(name = "ST_COURSE")
public class CourseDTO extends BaseDTO{
	/**
	 * Name of Course
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String name;
	/**
	 * Address of Course
	 */
	@Column(name = "DESCRIPTION", length = 100)
	private String description;
	/**
	 * Duration of Course
	 */
	@Column(name = "DURATION", length = 50)
	private String duration;
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}
}
