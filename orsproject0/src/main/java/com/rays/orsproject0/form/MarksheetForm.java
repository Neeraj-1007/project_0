package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;
import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.MarksheetDTO;
import com.rays.orsproject0.util.Util;

/**
 * Contains Marksheet form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * 
 */
public class MarksheetForm extends BaseForm{
	
	/**
	 * ROLLNO of Marksheet
	 *
	 */
	@NotEmpty
	private String rollNo;
	/**
	 * studentId of Marksheet
	 *
	 */
	@Min(value=1,message=("Min.form.studentId"))
	private long studentId;
	/**
	 * studentName of Marksheet
	 *
	 */
	
	private String studentName;
	/**
	 * mathsMarks of Marksheet
	 *
	 */
	
	@NotEmpty
    private String maths;
	/**
	 * physicsMarks of Marksheet
	 *
	 */
    
	@NotEmpty
	private String physics;
	/**
	 * chemistryMarks of Marksheet
	 *
	 */
    
	@NotEmpty
	private String chemistry;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getChemistry() {
		return chemistry;
	}
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto=new MarksheetDTO();
		dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(studentName);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		return dto;
	}
	
	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto=(MarksheetDTO) bDto;
		id=dto.getId();
		rollNo=dto.getRollNo();
		studentId=dto.getStudentId();
		studentName=dto.getName();
		maths=dto.getMaths();
		chemistry=dto.getChemistry();
		physics=dto.getPhysics();
		createdBy=dto.getCreatedBy();
	   	modifiedBy=dto.getModifiedBy();
		  if (dto.getCreatedDatetime() != null) {
	          createdDatetime =dto.getCreatedDatetime().getTime();
	      }
	      if (dto.getModifiedDatetime() != null) {
	          modifiedDatetime =dto.getModifiedDatetime().getTime();
	      }
	}
}
