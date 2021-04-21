package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Timetable Service interface.
 * 
 * @author Neeraj
 */
public interface TimetableServiceInt {
	/**
	 * Adds a Timetable
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : throws when Timetable is already exists
	 *@return long : the long             
	 */
	public long add(TimetableDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Timetable
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : throws when updated Timetable is already exists
	 */
	public void update(TimetableDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Timetable
	 * 
	 * @param id : the id
	 */
	public void delete(long id);

	/**
	 * Finds Timetable by primary key
	 * 
	 * @param id
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public TimetableDTO findByPK(long id);

	/**
	 * Searches Timetables
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(TimetableDTO dto);

	/**
	 * Searches Timetables with pagination
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(TimetableDTO dto, int pageNo, int pageSize);
}