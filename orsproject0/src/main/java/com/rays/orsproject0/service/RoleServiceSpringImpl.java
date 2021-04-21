package com.rays.orsproject0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dao.RoleDAOInt;
import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;

@Service("roleService")
public class RoleServiceSpringImpl implements RoleServiceInt {

	@Autowired
	private RoleDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(RoleDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		RoleDTO dtoExist = dao.findByName(dto.getRoleName());

		if (dtoExist != null) {
			throw new DuplicateRecordException("Role Name already exists");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(RoleDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);

	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public RoleDTO findById(long id) {
		// TODO Auto-generated method stub
		RoleDTO dto = null;
		dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public RoleDTO findByName(String roleName) {
		// TODO Auto-generated method stub
		RoleDTO dto = null;
		dto = dao.findByName(roleName);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(RoleDTO dto, int pageSize, int pageNo) {
		// TODO Auto-generated method stub

		List list = dao.search(dto, pageNo, pageSize);

		return list;
	}

	@Transactional(readOnly = true)
	public List search(RoleDTO dto) {
		// TODO Auto-generated method stub
		List list = dao.search(dto);
		return list;
	}

	

	


}
