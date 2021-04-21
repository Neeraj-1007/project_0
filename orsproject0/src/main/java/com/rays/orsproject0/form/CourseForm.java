package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.util.Util;

/**
 * Contains Course form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
public class CourseForm extends BaseForm{
	
	/**
	 * Name of course
	 *
	 */	
	@NotEmpty
	private String name;
	/**
	 * Duration of course
	 *
	 */	
	@NotEmpty
    private String duration;
	/**
	 * description of course
	 *
	 */	
	@NotEmpty
    private String description;

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

	@Override
    public BaseDTO getDto() {
    	CourseDTO dto=new CourseDTO();
    	dto.setId(id);
    	dto.setName(name);
    	dto.setDuration(duration);
        dto.setDescription(description);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
    	return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {
       CourseDTO dto=(CourseDTO) bDto;
    	  id=dto.getId();
    	  name=dto.getName();
    	  duration=dto.getDuration();
    	  description=dto.getDescription();
    	  createdBy = dto.getCreatedBy();
          modifiedBy = dto.getModifiedBy();
          if (dto.getCreatedDatetime() != null) {
              createdDatetime =dto.getCreatedDatetime().getTime();
          }
          if (dto.getModifiedDatetime() != null) {
              modifiedDatetime = dto.getModifiedDatetime().getTime();
          }
    }

}

