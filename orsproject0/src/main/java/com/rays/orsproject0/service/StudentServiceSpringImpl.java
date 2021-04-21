package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.StudentDAOInt;
import com.rays.orsproject0.dto.StudentDTO;

/**
 * Session facade of Student Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction is rolled
 * back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author Neeraj
 */

@Service(value = "studentService")
public class StudentServiceSpringImpl implements StudentServiceInt {
	@Autowired
	private StudentDAOInt dao;

	public void setDao(StudentDAOInt dao) {
		this.dao = dao;
	}
    
	/**
	 * Adds a Student
	 * 
	 * @param dto : the dto
	 * @return long :the long
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) {
		return dao.add(dto);
	}
    
	
	/**
	 * Updates a Student
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long update(StudentDTO dto) {
		return dao.update(dto);
	}
    
	
	/**
	 * Deletes a Student
	 * 
	 * @param id : the id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}
    
	
	/**
	 * Finds Student by Email
	 * 
	 * @param email
	 *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	@Transactional(readOnly = true)
	public StudentDTO findByEmail(String email) {
		return dao.findByEmail(email);
	}
    
	
	/**
	 * Finds Student by PK
	 * 
	 * @param pk
     *            : get @parameter
	 * @return dto : the dto
	 * 
	 */
	@Transactional(readOnly = true)
	public StudentDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}
    
	
	/**
	 * Searches Students with pagination
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	@Transactional(readOnly = true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
    
	
	/**
	 * Searches Students
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search @parameters
	 */
	@Transactional(readOnly = true)
	public List search(StudentDTO dto) {
		return dao.search(dto, 0, 0);
	}

}