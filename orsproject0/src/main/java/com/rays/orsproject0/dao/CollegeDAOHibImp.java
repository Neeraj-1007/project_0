package com.rays.orsproject0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.dao.CollegeDAOHibImp;

@Repository("collegeDAO")
public class CollegeDAOHibImp implements CollegeDAOInt{
	private static Logger log = Logger.getLogger(CollegeDAOHibImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	
	/**
     * Adds a College
     * 
     * @param dto : Object of Collegedto
     *@return long : the long
     */
	public long add(CollegeDTO dto) {
		// TODO Auto-generated method stub

        log.debug("DAO add Started");
        long pk = (Long) sessionFactory.getCurrentSession().save(dto);
        log.debug("DAO add Ends");
        return pk;
	}
	 /**
     * Updates a College
     * 
     * @param dto : Object of Collegedto
     *
     */
	public void update(CollegeDTO dto) {
		// TODO Auto-generated method stub
		 log.debug("DAO update Started");
	        sessionFactory.getCurrentSession().update(dto);
	        log.debug("DAO update Ends");
	}
	/**
     * Deletes a College
     * 
     * @param id : the id
     *
     */

	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug("DAO delete Started");
        CollegeDTO dto = findByPK(id);
        sessionFactory.getCurrentSession().delete(dto);
        log.debug("DAO delete Ends");
	}
	
	/**
     * Finds College by PK
     * 
     * @param pk
     *            : get @parameter
     * @return dto : the dto
     *
     */

	 public CollegeDTO findByName(String name) {

	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(CollegeDTO.class).add(
	                Restrictions.eq("name", name));
	        List list = criteria.list();

	        CollegeDTO dto = null;
	        if (list.size() == 1) {
	            dto = (CollegeDTO) list.get(0);
	            session.evict(dto);
	        }

	        return dto;
	    }

	public CollegeDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		log.debug("DAO findByPk Started");
		CollegeDTO dto=null;
		dto=(CollegeDTO) sessionFactory.getCurrentSession().get(CollegeDTO.class, pk);
		log.debug("DAO findByPk Started");
		return dto;
	}

	public List search(CollegeDTO dto) {
		// TODO Auto-generated method stub
		
			return search(dto,0,0);
	}

	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.debug("DAO search Started");
		List list = null;
        Criteria criteria =sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getName()!=null && dto.getName().length()>0) {
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getAddress()!=null && dto.getAddress().length()>0) {
				criteria.add(Restrictions.like("address", dto.getAddress()+"%"));
			}
			if(dto.getState()!=null && dto.getState().length()>0) {
				criteria.add(Restrictions.like("state", dto.getState()+"%"));
			}
			if(dto.getCity()!=null && dto.getCity().length()>0) {
				criteria.add(Restrictions.like("city", dto.getCity()+"%"));
			}
		}
		
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		
		
		log.debug("DAO search Ends");
	
		return list;
	}

}
