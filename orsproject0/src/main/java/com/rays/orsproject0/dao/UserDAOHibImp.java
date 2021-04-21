package com.rays.orsproject0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.dao.UserDAOHibImp;


@Repository(value="userDAO")
public class UserDAOHibImp implements UserDAOInt{

	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	 private static Logger log = Logger.getLogger(UserDAOHibImp.class);

	
	public long add(UserDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao Add Started");
		long pk = 0;
		 pk=(Long) sessionFactory.getCurrentSession().save(dto);
		 log.debug("User Dao Add End");
		return pk;
	}

	public void update(UserDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao Update Started");
		sessionFactory.getCurrentSession().update(dto);
		log.debug("User Dao Update Ends");
	}

	public void delete(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao delete starts");
		UserDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("User Dao delete Ends");
	}

	public UserDTO findByLogin(String login) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao FindByLogin Started");
		UserDTO dto = null;
		List list = (List) sessionFactory.getCurrentSession().createCriteria(UserDTO.class).add(Restrictions.eq("login", login)).list();
		if (list.size() == 1) {
            dto = (UserDTO) list.get(0);
        }
		log.debug("User Dao FindByLogin End");
		return dto;
	}

	public UserDTO findByPK(long pk) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao findByPK starts");
		UserDTO dto=null;
		dto=(UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		log.debug("User Dao FinfindByPK End");
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User Dao Search Started");
		List list = null;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                UserDTO.class);

        if (dto != null) {
            if (dto.getId() > 0) {
                criteria.add(Restrictions.eq("id", dto.getId()));
            }
            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
                criteria.add(Restrictions.like("firstName", dto.getFirstName()
                        + "%"));
            }
            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
                criteria.add(Restrictions.like("lastName", dto.getLastName()
                        + "%"));
            }
            if (dto.getLogin() != null && dto.getLogin().length() > 0) {
                criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
            }
            if (dto.getPassword() != null && dto.getPassword().length() > 0) {
                criteria.add(Restrictions.like("password", dto.getPassword()
                        + "%"));
            }
            if (dto.getGender() != null && dto.getGender().length() > 0) {
                criteria.add(Restrictions.eq("gender", dto.getLastName()));
            }
            if (dto.getDob() != null && dto.getDob().getDate() > 0) {
                criteria.add(Restrictions.eq("dob", dto.getDob()));
            }
            if (dto.getLastLogin() != null && dto.getLastLogin().getTime() > 0) {
                criteria.add(Restrictions.eq("lastLogin", dto.getLastLogin()));
            }
            if (dto.getRoleId() > 0) {
                criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
            }
            if (dto.getUnSuccessfulLogin() > 0) {
                criteria.add(Restrictions.eq("unSuccessfulLogin",
                        dto.getUnSuccessfulLogin()));
            }
            if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
                criteria.add(Restrictions.eq("mobileNo", dto.getMobileNo()));
            }

        }

        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult((pageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize);
        }

        list = criteria.list();
        log.debug("User Dao Search End");
        return list;

	}

	public List search(UserDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

}
