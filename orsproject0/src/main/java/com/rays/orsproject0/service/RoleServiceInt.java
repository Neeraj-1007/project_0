package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**RoleService Interface
 * 
 * @author Neeraj
 *
 */

public interface RoleServiceInt {

	
	/**
	 * Adds a Role.
	 * 
	 * @param dto : the dto
	 * @return the long : the long
     * @throws DuplicateRecordException
	 *             : @throws when Role is already exists 
	 */
	public long add(RoleDTO dto) throws DuplicateRecordException;
	
	/**
	 * Update a Role.
	 * 
	 * @param dto : Role dto
	 * @return void
     * @throws DuplicateRecordException
	 *             : @throws when Role is already exists 
	 */
	public void update(RoleDTO dto);
	
	
	
	/**
	 * Delete a Role.
	 * 
	 * @param long : pk
	 * @return void 
	 */
	public void  delete(long id);
	
	
	/**
	 * Finds Role by ID
	 * 
	 * @param id
	 *            : get @parameter
	 * @return dto : the dto
	 */
	public RoleDTO findById(long id);
	
	
	/**
	 * FindByName .
	 * 
	 * @param String : RoleName
	 * @return dto:Role dto 
	 */
	
	public RoleDTO findByName(String roleName);
	
	
	 /**
	 * Searches Role with pagination
	 * 
	 * @return list : List of Roles
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(RoleDTO dto,int pageSize,int pageNo);
	
	
	/**
	 * Searches Role
	 * 
	 * @return list : List of Roles
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(RoleDTO dto);
	
	
}
