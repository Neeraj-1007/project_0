package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.FacultyDTO;

/**
 * 
 * Faculty DAO interface.
 * 
 * @author Neeraj
 */
public interface FacultyDAOInt {

	
	/**
	 * Adds a Faculty
	 *  @param dto : the dto
	 *  @return : the long
	 */
	public long add(FacultyDTO dto);

	/**
	 * Updates a Faculty
	 *  @param dto : the dto
	 *  @return : the long
	 */
	public long update(FacultyDTO dto);

	/**
	 * Deletes a Faculty
	 *  @param id : the id
	 */
	public void delete(long id);

	/**
	 * Finds Faculty by Email
	 * 
	 * @param email
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public FacultyDTO findByEmail(String email);

	/**
	 * Finds Faculty by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public FacultyDTO findByPK(long pk);

	/**
	 * Searches Facultys with pagination
	 * 
	 * @return list : List of Facultys
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Facultys
	 * 
	 * @return list : List of Facultys
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(FacultyDTO dto);
}
