package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.CollegeDAOInt;
import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of College Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Neeraj
 */

@Service("collegeService")
public class CollegeServiceSpringImpl implements CollegeServiceInt {

	@Autowired
	private CollegeDAOInt dao;

	/**
	 * Adds a College
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException : @throws when updated College is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {

		CollegeDTO dtoExist = dao.findByName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("College Name");
		}
		return dao.add(dto);
	}
	

	/**
	 * Updates a College
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated College is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CollegeDTO dto) throws DuplicateRecordException {
		CollegeDTO dtoExist = dao.findByName(dto.getName());
		// Check if updated College is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a College
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
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findByName(String name) {
		return dao.findByName(name);
	}

	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search @parameters
	 * 
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto) {
		return dao.search(dto);
	}

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
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
