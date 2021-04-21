package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.StudentDTO;
import com.rays.orsproject0.util.Util;

/**
 * Contains Student form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
public class StudentForm extends BaseForm{
	
		/**
		 * firstname of StudentForm
		 */
	    @NotEmpty
	    private String firstName;
	    /**
	     * lastname of StudentForm
	     */
	    @NotEmpty
	    private String lastName;
	    /**
	     * dob of StudentForm
	     */
	    @NotEmpty
	    private String dob;
	    /**
	     * mobileNo of StudentForm
	     */
		@NotEmpty
	    @Pattern(regexp = "\\d{10}", message = "{Pattern.form.phoneNo}")
	    private String mobileNo;
		/**
		 * email of StudentForm
		 */
	    @NotEmpty
	    @Email
	    private String email;
	    /**
	     * collegeName of StudentForm
	     */
	    private String collegeName;
	    /**
	     * collegeId of StudentForm
	     */
	    @Min(value=1,message="{Min.form.collegeId}")
	    private long collegeId;
	    
	    /**
		 * gender of StudentForm
		 */
	    @NotEmpty
	    private String gender;

	    public long getCollegeId() {
	        return collegeId;
	    }

	    public void setCollegeId(long collegeId) {
	        this.collegeId = collegeId;
	    }

	    public String getCollegeName() {
	        return collegeName;
	    }

	    public void setCollegeName(String collegeName) {
	        this.collegeName = collegeName;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    public String getMobileNo() {
	        return mobileNo;
	    }

	    public void setMobileNo(String mobileNo) {
	        this.mobileNo = mobileNo;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	     @Override
	    public BaseDTO getDto() {
	        StudentDTO dto = new StudentDTO();
	        dto.setId(id);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        if(dob!=""){
	            dto.setDob(Util.getDate(dob));
	            }
	        dto.setMobileNo(mobileNo);
	        dto.setEmail(email);
	        dto.setCollegeId(collegeId);
	        dto.setCreatedBy(createdBy);
	        dto.setModifiedBy(modifiedBy);
	        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	        
	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bDto) {
	        StudentDTO dto = (StudentDTO) bDto;
	        System.out.println("------------------------------");
	        id = dto.getId();
	        firstName = dto.getFirstName();
	        lastName = dto.getLastName();
	        dob = Util.getDate(dto.getDob());
	        mobileNo = dto.getMobileNo();
	        email = dto.getEmail();
	        collegeId = dto.getCollegeId();
	        firstName=dto.getFirstName();
	        lastName=dto.getLastName();
	        createdBy = dto.getCreatedBy();
	        modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDatetime() != null) {
	            createdDatetime = dto.getCreatedDatetime().getTime();
	        }
	        if (dto.getModifiedDatetime() != null) {
	            modifiedDatetime = dto.getModifiedDatetime().getTime();
	        }
	        System.out.println("----------------------------e--");
	    }

}
