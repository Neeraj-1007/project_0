package com.rays.orsproject0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Timetable POJO class. It is persistent object.
 * 
 * @author Neeraj
 */

@Entity
@Table(name = "ST_TIMETABLE")
public class TimetableDTO extends BaseDTO {
	/**
	 * Semester of Timetable
	 */
	@Column(name = "SEMESTER", length = 50)
	private String semester;
	/**
	 * Description of Timetable
	 */
	@Column(name = "DESCRIPTION", length = 100)
	private String description;
	/**
	 * Exam Date of Timetable
	 */
	@Column(name = "EXAM_DATE", length = 50)
	private Date examDate;
	/**
	 * Exam Time of Timetable;
	 */
	@Column(name = "EXAM_TIME", length = 50)
	private String examTime;
	/**
	 * CourseId of Timetable
	 */
	@Column(name = "COURSE_ID", length = 50)
	private long courseId;
	/**
	 * CourseName of Timetable
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;
	/**
	 * SubjectId of Timetable
	 */
	@Column(name = "SUBJECT_ID", length = 50)
	private long subjectId;
	/**
	 * Subject Name of Timetable
	 */
	@Column(name = "SUBJECT_NAME", length = 50)
	private String subjectName;

	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
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

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return subjectName;
	}
}
