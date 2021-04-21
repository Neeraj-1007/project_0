package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.SubjectDTO;

/**
 * 
 * Subject DAO interface.
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 */

public interface SubjectDAOInt {
	/**
	 * Adds a Subject
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 *
	 */
	public long add(SubjectDTO dto);

	/**
	 * Updates a Subject
	 * 
	 * @param dto : the dto
	 *
	 */
	public void update(SubjectDTO dto);

	/**
	 * Deletes a Subject
	 * 
	 * @param id : the id
	 *
	 */
	public void delete(long id);

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public SubjectDTO findByName(String name);

	/**
	 * Finds Subject by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public SubjectDTO findByPK(long pk);

	/**
	 * Searches Subjects
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 *
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
	 *
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);
}
