package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.TimetableDTO;

/**
 * 
 * Timetable DAO interface.
 * 
 * @author Neeraj
 */

public interface TimetableDAOInt {
	/**
	 * Adds a Timetable
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 *
	 */
	public long add(TimetableDTO dto);
	
	/**
	 * checkBySemester a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO checkBySemester(TimetableDTO dto);
	
	/**
	 * checkByCourse a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO checkByCourse(TimetableDTO dto);
	
	/**
	 * checkByCourse a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO checkBySubject(TimetableDTO dto);
	
	/**
	 * Updates a Timetable
	 * 
	 * @param dto : the dto
	 *
	 */
	public void update(TimetableDTO dto);

	/**
	 * Deletes a Timetable
	 * 
	 * @param id : the id
	 * 
	 *
	 */
	public void delete(long id);

	/**
	 * Finds Timetable by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO findByName(String name);

	/**
	 * Finds Timetable by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO findByPK(long pk);

	/**
	 * Searches Timetables
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 *
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
	 *
	 */
	public List search(TimetableDTO dto, int pageNo, int pageSize);
}
