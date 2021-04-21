package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.util.Util;

/**
 * Contains TimeTable form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 * 
 */
public class TimetableForm extends BaseForm{
	
	/**
	 * Subject of Time-Table
	 */
	@Min(value=1,message="{Min.form.subjectId}")
	private long subjectId;
	/**
	 * Subject Name of Time-Table
	 */
	
	private String subjectName;
	
	/**
	 * courseId of Time-Table
	 */
	@Min(value=1,message="{Min.form.courseId}")
	private long courseId;
	/**
	 * Course Name of Time-Table
	 */
	
	private String courseName;
	/**
	 * Exam Date of Time-Table
	 */
	@NotEmpty
	private String examDate;
	/**
	 * Exam Time of Time-Table
	 */
	@NotEmpty
	private String examTime;
	/**
	 * semester of Time-Table
	 */
	@NotEmpty
	private String semester;
	/**
	 * description of Time-Table
	 */
	@NotEmpty
	private String description;


	

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
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	
@Override
	public BaseDTO getDto() {
		TimetableDTO dto=new TimetableDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
		   if(examDate!=""){
			   dto.setExamDate(Util.getDate(examDate));
		      }
		dto.setSemester(semester);
		dto.setDescription(description);
		dto.setExamTime(examTime);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		return dto;
	}



@Override
public void populate(BaseDTO bDto) {

	TimetableDTO dto=(TimetableDTO) bDto;
	id=dto.getId();
	courseId=dto.getCourseId();
	courseName=dto.getCourseName();
	subjectId=dto.getSubjectId();
	subjectName=dto.getSubjectName();
	examTime=dto.getExamTime();
	examDate=Util.getDate(dto.getExamDate()); 
	semester=dto.getSemester();
	description=dto.getDescription();
	createdBy=dto.getCreatedBy();
   	modifiedBy=dto.getModifiedBy();
	  if (dto.getCreatedDatetime() != null) {
          createdDatetime = dto.getCreatedDatetime().getTime();
      }
      if (dto.getModifiedDatetime() != null) {
          modifiedDatetime = dto.getModifiedDatetime().getTime();
      }
	
}

}
