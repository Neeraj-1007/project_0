package com.rays.orsproject0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.rays.orsproject0.dto.UserDTO;

/**
 * User DAO Interface provides abstract methods of CRUD operations.
 * Implementation will be done by JDBC, Hibrenate or JPA.
 * 
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception handling provided by Spring-DAO.
 * 
 * If DataAccessException is propagated from a method then declarative
 * transaction is rolled back by Spring AOP.
 * 
 * @author Neeraj
 * 
 */

public interface UserDAOInt{

	
	 /**
     * Add a User
     * 
     * @param dto : the dto
     * @return long : the long
     */
    public long add(UserDTO dto) throws DataAccessException;

    /**
     * Update a User
     * 
     * @param dto : the dto
     * 
     */
    public void update(UserDTO dto) throws DataAccessException;

    /**
     * Delete a User
     * 
     * @param id : the id
     * 
     */
    public void delete(long id) throws DataAccessException;

    /**
     * Find User by Login
     * 
     * @param login
     *            : get @parameter
     * @return dto : the dto
     */
    public UserDTO findByLogin(String login) throws DataAccessException;

    /**
     * Find User by PK
     * 
     * @param pk
     *            : get @parameter
     * @return dto : the dto
     */
    public UserDTO findByPK(long pk) throws DataAccessException;

    /**
     * Search Users with pagination
     * 
     * @return list : List of Users
     * @param dto
     *            : Search @parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     */
    public List search(UserDTO dto, int pageNo, int pageSize)
            throws DataAccessException;

    /**
     * Search Users
     * 
     * @param dto
     *            : Search @parameters
     *            @return list : list of users
     */
    public List search(UserDTO dto) throws DataAccessException;
}
