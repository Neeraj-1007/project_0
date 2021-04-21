package com.rays.orsproject0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.MarksheetDAOInt;
import com.rays.orsproject0.dao.StudentDAOInt;
import com.rays.orsproject0.dto.MarksheetDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * Session facade of Marksheet Service. It is transactional, apply delcarative
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

@Service("marksheetService")
public class MarksheetServiceSpringImpl implements MarksheetServiceInt {
	private static Logger log = Logger.getLogger(MarksheetServiceSpringImpl.class);

	@Autowired
	private MarksheetDAOInt dao = null;
	
	@Autowired
	private StudentDAOInt student = null;
	
	/**
     * Adds a marksheet
     * 
     * @param dto : the dto
     * @return the long : the long
     * @throws DuplicateRecordException
	 *             : @throws when Marksheet is already exists 
     */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		
		MarksheetDTO dtoExist = dao.findByRollNo(dto.getRollNo());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Duplicate Marksheet");
		}
		
		dto.setName(student.findByPK(dto.getStudentId()).getFirstName());
		return dao.add(dto);
	}

	 /**
     * updates Marksheet
     * 
     * @param dto : the dto
     * @return the long : the long
     * @throws DuplicateRecordException
	 *             : @throws when updated Marksheet is already exists
     */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long update(MarksheetDTO dto) throws DuplicateRecordException {
		MarksheetDTO dtoExist = findByRollNo(dto.getRollNo());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Marksheet");
		}
		return dao.update(dto);
	}


    /**
     * Delets marksheet
     * 
     * @param id : the id
     */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

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
	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
    
	/**
	 * Searches Marksheet
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search @parameters
	 */
	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto) {
		return dao.search(dto, 0, 0);
	}
    
	/**
	 * Finds Marksheet by RollNo
	 * 
	 * @param rollNo
	 *            : get @parameter
	 * @return dto
	 */
	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo) {
		return dao.findByRollNo(rollNo);
	}
    
	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 */
	@Transactional(readOnly = true)
	public MarksheetDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}
     
	/**
     * Get merit list
     * 
     * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *            @return list : the lists of Marksheet

     */
	@Transactional(readOnly = true)
	public List getMeritList(int pageNo, int pageSize) {
		return dao.getMeritList(pageNo, pageSize);
	}
}
