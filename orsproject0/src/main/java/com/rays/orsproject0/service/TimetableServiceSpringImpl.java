package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.TimetableDAOInt;
import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of Timetable Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Neeraj
 */

@Service("timetableService")
public class TimetableServiceSpringImpl implements TimetableServiceInt {

	@Autowired
	private TimetableDAOInt dao;

	/**
	 * Adds a Timetable
	 * 
	 * @param dto : the dto
	 * @throws DuplicateRecordException : @throws when updated Timetable is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(TimetableDTO dto) throws DuplicateRecordException {
		if(dao.checkBySemester(dto)!=null){
			throw new DuplicateRecordException("Semester and course already Exist on date");
		}if(dao.checkByCourse(dto)!=null){
			throw new DuplicateRecordException("course already exist on this date");
		}if(dao.checkBySubject(dto)!=null){
			throw new DuplicateRecordException("subject for course already exist on this date");
		}
		return dao.add(dto);
	}

	/**
	 * Updates a Timetable
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated Timetable is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(TimetableDTO dto) throws DuplicateRecordException {
		if(dao.checkBySemester(dto)!=null){
			throw new DuplicateRecordException("Semester and course already Exist on date");
		}if(dao.checkByCourse(dto)!=null){
			throw new DuplicateRecordException("course already exist on this date");
		}if(dao.checkBySubject(dto)!=null){
			throw new DuplicateRecordException("subject for course already exist on this date");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a Timetable
	 * 
	 * @param id  :the id
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	/**
	 * Finds record by Primary Key
	 * @param id : the id
	 * @return long : the long
	 */
	@Transactional(readOnly = true)
	public TimetableDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Searches Timetables
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 * 
	 */
	@Transactional(readOnly = true)
	public List search(TimetableDTO dto) {
		return dao.search(dto);
	}

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
	@Transactional(readOnly = true)
	public List search(TimetableDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
