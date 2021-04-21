package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.MarksheetDTO;

/**
 * 
 * Marksheet DAO interface.
 * 
 * @author Neeraj
 */

public interface MarksheetDAOInt {
	/**
	 * Adds a Marksheet.
	 * 
	 * @param dto : the dto
	 * @return  long : the long
	 *
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Updates a Marksheet.
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 * 
	 */
	public Long update(MarksheetDTO dto);

	/**
	 * Deletes a Marksheet.
	 * 
	 * @param id : the id
	 * 
	 */
	public void delete(long id);

	/**
	 * Finds Marksheet by RollNo
	 * 
	 * @param rollNo
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public MarksheetDTO findByRollNo(String rollNo);

	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto  : the dto
	 *
	 */
	public MarksheetDTO findByPK(long pk);

	/**
	 * Searches Marksheet
	 * 
	 * @return list : List of Marksheet
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(MarksheetDTO dto);

	/**
	 * Searches Marksheet with pagination
	 * 
	 * @return list : List of Facultys
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);

	/**
	 * Get MeritList 
	 * 
	 * @return list : List of Facultys
	 * 
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List getMeritList(int pageNo, int pageSize);
}
