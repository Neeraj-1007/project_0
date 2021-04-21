package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.CourseDAOInt;
import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of Course Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 */

@Service("courseService")
public class CourseServiceSpringImpl implements CourseServiceInt {

	@Autowired
	private CourseDAOInt dao;

	/**
	 * Adds a Course
	 * 
	 * @param dto : the dto
	 * @throws DuplicateRecordException : when faculty already exist
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {

		CourseDTO dtoExist = dao.findByName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Course Name");
		}
		return dao.add(dto);
	}

	/**
	 * Updates a Course
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated Course is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		CourseDTO dtoExist = dao.findByName(dto.getName());
		// Check if updated Course is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a Course
	 * 
	 * @param id : the id
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	/**
	 * Finds Course by primary key
	 * 
	 * @param id
	 *            : get @parameter
	 * @return dto : the dto
	 */
	@Transactional(readOnly = true)
	public CourseDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Finds Course by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	@Transactional(readOnly = true)
	public CourseDTO findByName(String name) {
		return dao.findByName(name);
	}

	/**
	 * Searches Courses
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search @parameters
	 * 
	 */
	@Transactional(readOnly = true)
	public List search(CourseDTO dto) {
		return dao.search(dto);
	}

	/**
	 * Searches Courses with pagination
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 */
	@Transactional(readOnly = true)
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}

