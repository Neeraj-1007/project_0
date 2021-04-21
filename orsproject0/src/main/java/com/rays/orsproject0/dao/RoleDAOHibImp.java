package com.rays.orsproject0.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.dto.UserDTO;

@Repository("roleDAO")
public class RoleDAOHibImp implements RoleDAOInt{

	
	
	@Autowired
	SessionFactory sessionFactory;

	public long add(RoleDTO dto) {
		// TODO Auto-generated method stub
		Long pk=(Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(RoleDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);
		
	}

	
	public void delete(long id) {
		// TODO Auto-generated method stub
		RoleDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
	}
	
	
	
	public RoleDTO findByName(String roleName) {
		// TODO Auto-generated method stub
		RoleDTO dto=null;
		List list=sessionFactory.getCurrentSession().createCriteria(RoleDTO.class).add(Restrictions.eq("roleName", roleName)).list();
		if (list.size() == 1) {
			dto = (RoleDTO) list.get(0);
			System.out.println("DTO Not Null");
		}
		
		return null;
	}

	public RoleDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		RoleDTO dto=null;
		dto=(RoleDTO) sessionFactory.getCurrentSession().get(RoleDTO.class,pk);
		return dto;
	}

	public List search(RoleDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
				criteria.add(Restrictions.like("roleName", dto.getRoleName() + "%"));
			}
			if (dto.getRoleDescription() != null && dto.getRoleDescription().length() > 0) {
				criteria.add(Restrictions.like("roleDescription", dto.getRoleDescription() + "%"));
			}
		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();

		return list;
	}

	public List search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	

	
	
	
	
}
