package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * College Service interface.
 * 
 * @author Neeraj
 */
public interface CollegeServiceInt {
	/**
	 * Adds a College
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when College is already exists
	 *             
	 * @return long : the long            
	 */
	public long add(CollegeDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a College
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated College is already exists
	 */
	public void update(CollegeDTO dto) throws DuplicateRecordException ;

	/**
	 * Deletes a College
	 * 
	 * @param id : the id
	 */
	public void delete(long id);

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public CollegeDTO findByName(String name);

	/**
	 * Finds College by primary key
	 * 
	 * @param id
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public CollegeDTO findByPK(long id);

	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search @parameters
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
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);
}
