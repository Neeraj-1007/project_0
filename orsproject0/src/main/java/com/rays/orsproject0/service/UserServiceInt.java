package com.rays.orsproject0.service;

import java.util.List;

import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.exception.ApplicationException;
import com.rays.orsproject0.exception.DuplicateRecordException;

/**
 * 
 * User Service interface.
 * @author Neeraj
 *
 */
public interface UserServiceInt {

	
	
    /**
     * Adds a user
     * 
     * @param dto : the dto
     * 
	 * @throws DuplicateRecordException
	 *             : @throws when User is already exists
	 * @return long : the long            
     */
    public long add(UserDTO dto) throws DuplicateRecordException ;

    /**
     * Registers a user
     * 
     *    @param dto : the dto
      * 
	 * @throws DuplicateRecordException
	 *             :  when User is already exists  
	 * @throws ApplicationException
	 *             : when User is not exists              
	 * @return long : the long            
	 *                */
    public long registerUser(UserDTO dto) throws DuplicateRecordException,ApplicationException;

    /**
     * Updates a User
     * 
     * @param dto : the dto
      *
	 * @throws DuplicateRecordException
	 *             : @throws when updated user  already exists
     */
    public void update(UserDTO dto)throws DuplicateRecordException;

    /**
     * Deletes a user
     * 
     * @param id : the id
     */
    public void delete(long id);

    /**
     * Finds user by Login
     * 
     * @param login
     *            : get @parameter
     * @return dto : the dto
     */
    public UserDTO findByLogin(String login);

    /**
     * Finds user by PK
     * 
     * @param pk
     *            : get @parameter
     * @return dto : the dto
     */
    public UserDTO findByPK(long pk);

    /**
     * Searches Users with pagination
     * 
     * @return list : List of Users
     * @param dto
     *            : Search @parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     */
    public List search(UserDTO dto, int pageNo, int pageSize);

    /**
     * Searches Users
     * 
     * @return list : List of Users
     * @param dto
     *            : Search @parameters
     */
    public List search(UserDTO dto);

    /**
     * Change Password By pk
     * 
     * @param id
     *             : get @parameter
     * @param  oldPassword : old password
     * @param newPassword : new Password          
     * @return dto
     * @throws DuplicateRecordException : Duplicaterecord Exception
     */
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) throws DuplicateRecordException;

    /**
     * User Authentication
     * 
     * @return dto : Contains User's information
     * @param dto : the dto
     */
    public UserDTO authenticate(UserDTO dto);

    /**
     * Lock User for certain time duration
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     */
    public boolean lock(String login);

    /**
     * Reset Password of User with auto generated Password
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     * @throws ApplicationException :
     * Application exception
     */
    public boolean resetPassword(String login) throws ApplicationException;

    /**
     * Send the password of User to his Email
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     * @throws ApplicationException : Application Exception
     */
    public boolean forgetPassword(String login) throws ApplicationException;

    /**
     * Get User Roles
     * 
     * @return RoleDTO : User Role
     * @param dto : the roledto
     */
    public RoleDTO getRole(UserDTO dto);

    /**
     * Update User access
     * 
     * @return dto : the dto
     * @param dto : the dto
     * 
     */
    public UserDTO updateAccess(UserDTO dto);
}
