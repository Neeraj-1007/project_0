package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.StudentDTO;

/**
 * Student Service interface.
 * 
 * @author Neeraj
 */


public interface StudentServiceInt {
	/**
	 * Adds a Student
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 * 
	 */
	public long add(StudentDTO dto);

	/**
	 * Updates a Student
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 * 
	 */
	public long update(StudentDTO dto);

	/**
	 * Deletes a Student
	 * 
	 * @param id : the id
	 */
	public void delete(long id);

	/**
	 * Finds Student by Email
	 * 
	 * @param email
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds Student by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	public StudentDTO findByPK(long pk);

	/**
	 * Searches Students with pagination
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Students
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(StudentDTO dto);
}
