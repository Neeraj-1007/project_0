 package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.MarksheetDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Marksheet Service interface.
 * 
 * @author Neeraj
 */

public interface MarksheetServiceInt {
	
	/**
     * Adds a marksheet
     * 
     * @param dto : the dto
     * @return the long : the long
     * @throws DuplicateRecordException
	 *             : @throws when Marksheet is already exists 
     */
    public long add(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * updates Marksheet
     * 
     * @param dto : the dto
     * @return the long : the long
     * @throws DuplicateRecordException
	 *             : @throws when updated Marksheet is already exists
     */
    public long update(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * Delets marksheet
     * 
     * @param id : the id
     */
    public void delete(long id);

    /**
	 * Finds Marksheet by RollNo
	 * 
	 * @param rollNo
	 *            : get @parameter
	 * @return dto : the dto
	 */
    public MarksheetDTO findByRollNo(String rollNo);

    /**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 */
    public MarksheetDTO findByPK(long pk);

    /**
	 * Searches Marksheet
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search @parameters
	 */
    public List search(MarksheetDTO dto);

    /**
	 * Searches Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
    public List search(MarksheetDTO dto, int pageNo, int pageSize);

    /**
     * Get merit list
     * 
     * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 * 
	 *            : Size of Page
	 *            @return list : lists of marksheet

     */
    public List getMeritList(int pageNo, int pageSize);
	
}
