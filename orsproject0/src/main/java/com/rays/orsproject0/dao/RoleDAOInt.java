package com.rays.orsproject0.dao;

import java.util.List;

import com.rays.orsproject0.dto.RoleDTO;

public interface RoleDAOInt {

	
	/**
	 * Add a Role.
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 * 
	 */
	public long add(RoleDTO dto);
	
	
	
	/**
	 * Updates a Role.
	 * 
	 * @param dto : the dto
	 */
	public void update(RoleDTO dto);

	/**
	 * Deletes a Role.
	 * 
	 * @param id : the id 
	 * 
	 */
	public void delete(long id);

	/**
	 * Finds Role by Name
	 * 
	 * @param roleName
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */	public RoleDTO findByName(String roleName);

	/**
	 * Finds Role by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */
	public RoleDTO findByPK(long pk);

	/**
	 * Searches Role with pagination
	 * 
	 * @return list : List of Role
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */	public List search(RoleDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Role
	 * 
	 * @return list : List of Role
	 * @param dto
	 *            : Search @parameters
	 */
	public List search(RoleDTO dto);
}
