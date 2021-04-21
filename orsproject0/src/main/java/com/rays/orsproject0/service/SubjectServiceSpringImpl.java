package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.SubjectDAOInt;
import com.rays.orsproject0.dto.SubjectDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of Subject Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Neeraj
 */

@Service("subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	@Autowired
	private SubjectDAOInt dao;

	/**
	 * Adds a Subject
	 * 
	 * @param dto : the dto
	 * @throws DuplicateRecordException : @throws when updated Subject is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {

		SubjectDTO dtoExist = dao.findByName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Subject Name");
		}
		return dao.add(dto);
	}

	/**
	 * Updates a Subject
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated Subject is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		SubjectDTO dtoExist = dao.findByName(dto.getName());
		// Check if updated Subject is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a Subject
	 * 
	 * @param id : the id
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	/**
	 * Finds record by Primary Key
	 * @param id : the id
	 * @return dto : the dto
	 */
	@Transactional(readOnly = true)
	public SubjectDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	@Transactional(readOnly = true)
	public SubjectDTO findByName(String name) {
		return dao.findByName(name);
	}

	/**
	 * Searches Subjects
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 * 
	 */
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto) {
		return dao.search(dto);
	}

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
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
