package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.CollegeDTO;

/**
 * 
 * College DAO interface.
 * 
 * @author Neeraj
 */
public interface CollegeDAOInt {

	/**
	 * Adds a College
	 * 
	 * @param dto : the dto
	 *  @return : the long
	 */
	public long add(CollegeDTO dto);

	/**
	 * Updates a College
	 * 
	 * @param dto : the dto
	 *
	 */
	public void update(CollegeDTO dto);

	/**
	 * Deletes a College
	 * 
	 * @param id : the id
	 *
	 */
	public void delete(long id);

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto
	 *
	 */
	public CollegeDTO findByName(String name);

	/**
	 * Finds College by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public CollegeDTO findByPK(long pk);

	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search @parameters
	 *
	 */
	public List search(CollegeDTO dto);

	/**
	 * Searches Colleges with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);
}
