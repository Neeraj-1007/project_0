package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.CourseDTO;

/**
 * 
 * Course DAO interface.
 * 
 * @author Neeraj
 */
public interface CourseDAOInt {

	
	/**
	 * Adds a Course
	 * 
	 * @param dto : the dto
	 * @return : long
	 *
	 */
	public long add(CourseDTO dto);

	/**
	 * Updates a Course
	 * 
	 * @param dto : object of Coursedto
	 *
	 */
	public void update(CourseDTO dto);

	/**
	 * Deletes a Course
	 * 
	 * @param id : Id
	 *
	 */
	public void delete(long id);

	/**
	 * Finds Course by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public CourseDTO findByName(String name);

	/**
	 * Finds Course by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public CourseDTO findByPK(long pk);

	/**
	 * Searches Courses
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search @parameters
	 *
	 */
	public List search(CourseDTO dto);

	/**
	 * Searches Courses with pagination
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize);
}
