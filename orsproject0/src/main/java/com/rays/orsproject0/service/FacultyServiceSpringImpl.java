package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.FacultyDAOInt;
import com.rays.orsproject0.dto.FacultyDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of Faculty Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction is rolled
 * back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 */

@Service(value = "facultyService")
public class FacultyServiceSpringImpl implements FacultyServiceInt {
	@Autowired
	private FacultyDAOInt dao;



	
	/**
	 * Adds a Faculty
	 * 
	 * @param dto : the dto
	 * 
	 *  @throws DuplicateRecordException :  when updated faculty is already exists
	 *  
	 *  @return long : the long
	 */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(FacultyDTO dto) throws DuplicateRecordException{
		FacultyDTO dtoExist = dao.findByEmail(dto.getEmail());
		if(dtoExist != null) {
			throw new DuplicateRecordException("Faculty already Exist");
		}
		return dao.add(dto);
	}
	
	/**
	 * Updates a Faculty
	 * 
	 * @param dto : the dto
	 * 
	 * @throws DuplicateRecordException
	 *             : @throws when updated faculty is already exists
	 */

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long update(FacultyDTO dto) throws DuplicateRecordException{
		FacultyDTO dtoExist = dao.findByEmail(dto.getEmail());
		if(dtoExist != null && dto.getId() != dtoExist.getId()) {
			throw new DuplicateRecordException("Faculty already Exist");
		}
		return dao.update(dto);
	}
    
	/**
	 * Deletes a Faculty
	 * 
	 * @param id : the id
	 * 
	 */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	/**
	 * Finds Faculty By Email
	 * 
	 * @param email
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	
	
	@Transactional(readOnly = true)
	public FacultyDTO findByEmail(String email) {
		return dao.findByEmail(email);
	}

	/**
	 * Finds Faculty by PK
	 * 
	 * @param pk
	 *           : get @parameter
	 * @return dto : the dto
	 */
	@Transactional(readOnly = true)
	public FacultyDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}
    
	/**
	 * Searches Faculty with pagination
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
	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
    
	/**
	 * Searches Faculty
	 * 
	 * @return list : List of Faculty
	 * @param dto
	 *            : Search @parameters
	 * 
	 */
	
	@Transactional(readOnly = true)
	public List<FacultyDTO> search(FacultyDTO dto) {
		return dao.search(dto, 0, 0);
	}

}
