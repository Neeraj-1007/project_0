package com.rays.orsproject0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Student POJO class. It is persistent object.
 * 
 * @author Neeraj
 */

@Entity
@Table(name = "ST_STUDENT")
public class StudentDTO extends BaseDTO{

	/**
	 * First Name of Student
	 */
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	/**
	 * Last Name of Student
	 */
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	/**
	 * Date of Birth of Student
	 */
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	/**
	 * Mobileno of Student
	 */
	@Column(name = "MOBILE_NO", length = 15)
	private String mobileNo;
     
	/**
	 * Gender of Student
	 */
	@Column(name = "GENDER" , length = 15)
	private String gender;
	
	

	/**
	 * Email of Student
	 */
	@Column(name = "EMAIL", length = 50)
	private String email;
	/**
	 * CollegeId of Student
	 */
	@Column(name = "COLLEGE_ID")
	private long collegeId;
	/**
	 * College name of Student
	 */
	@Column(name = "COLLEGE_NAME", length = 50)
	private String collegeName;

	

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public Long getCollegeId() {
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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "StudentDTO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", mobileNo="
				+ mobileNo + ", gender=" + gender + ", email=" + email + ", collegeId=" + collegeId + ", collegeName="
				+ collegeName + "]";
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return firstName+lastName;
	}

}
