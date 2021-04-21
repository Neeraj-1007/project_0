package com.rays.orsproject0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Subject POJO class. It is persistent object.
 * 
 * @author Neeraj
 */
@Entity
@Table(name = "ST_SUBJECT")
public class SubjectDTO extends BaseDTO {
	/**
	 * Name of Subject
	 */
	@Column(name = "SUBJECT_NAME", length = 50)
	private String name;
	/**
	 * Course id of Subject
	 */
	@Column(name = "COURSE_ID", length = 50)
	private long courseId;
	/**
	 * Course name of Subject
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;
	/**
	 * Description of Subject
	 */
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
}
