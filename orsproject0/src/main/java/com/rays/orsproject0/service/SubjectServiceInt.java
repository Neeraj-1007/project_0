package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.SubjectDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Subject Service interface.
 * 
 * @author Neeraj
 */
public interface SubjectServiceInt {
	/**
	 * Adds a Subject
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : throws when Subject is already exists
	 *             
	 * @return long : the long            
	 */
	public long add(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Subject
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : throws when updated Subject is already exists
	 */
	public void update(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Subject
	 * 
	 * @param id  :the id
	 */
	public void delete(long id);

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public SubjectDTO findByName(String name);

	/**
	 * Finds Subject by primary key
	 * 
	 * @param id
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public SubjectDTO findByPK(long id);

	/**
	 * Searches Subjects
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(SubjectDTO dto);

	/**
	 * Searches Subjects with pagination
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);
}