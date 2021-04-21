package com.rays.orsproject0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Faculty POJO class. It is persistent object.
 * 
 * @author Neeraj
 */

@Entity
@Table(name = "ST_FACULTY")
public class FacultyDTO extends BaseDTO{
	/**
	 * First Name of Faculty
	 */
	@Column(name = "FIRST_NAME" ,length = 50)
	private String firstName;
	/**
	 * Last Name of Faculty
	 */
	@Column(name = "LAST_NAME" ,length = 50)
	private String lastName;
	/**
	 * Date of Birth of Faculty
	 */
	@Column(name = "DOB" ,length = 50)
	private Date dob;
	/**
	 * Gender of Faculty
	 */
	@Column(name = "GENDER" ,length = 50)
	private String gender;
	/**
	 * Mobileno of Faculty
	 */
	@Column(name = "MOBILE_NO" ,length = 50)
	private String mobileNo;
	/**
	 * Email of Faculty
	 */
	@Column(name = "EMAIL_ID" ,length = 50)
	private String email;
	/**
	 * CollegeId of Faculty
	 */
	@Column(name = "COLLEGE_ID" ,length = 50)
	private long collegeId;
	/**
	 * CollegeName of Faculty
	 */
	@Column(name = "COLLEGE_NAME" ,length = 50)
	private String collegeName;
	/**
	 * CourseId of Faculty
	 */
	@Column(name = "COURSE_ID" ,length = 50)
	private long courseId;
	/**
	 * CourseName of Faculty
	 */
	@Column(name = "COURSE_NAME" ,length = 50)
	private String courseName;
	/**
	 * SubjectId of Faculty
	 */
	@Column(name = "SUBJECT_ID" ,length = 50)
	private long subjectId;
	/**
	 * Subject Name of Faculty
	 */
	@Column(name = "SUBJECT_NAME" ,length = 50)
	private String subjectName;

	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return firstName + " " + lastName;
	}

}
