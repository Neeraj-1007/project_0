package com.rays.orsproject0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.MarksheetDTO;

/**
 * Hibernate implementation of Marksheet DAO.
 * 
 * @author Neeraj
 * 
 */
@Repository("marksheetDAO")
public class MarksheetDAOHibImpl implements MarksheetDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	 /**
     * Add a Marksheet
     * 
     * @param dto : the dto
     * @return long : the long 
     *
     */
	public long add(MarksheetDTO dto) {
		return (Long) sessionFactory.getCurrentSession().save(dto);
	}


	/**
    * Update a Marksheet
    * 
    * @param dto : the dto
    * @return long :  the long
    *
    */
	public Long update(MarksheetDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
		return dto.getId();
	}

	/**
	   * Delete a Marksheet
	   * 
	   * @param id : the id
	   *
	   */    
	public void delete(long id) {
		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
     * Searches Marksheet
     * 
     * @return list : List of Marksheet
     * @param dto
     *            : Search @parameters
     *
     */
	public List search(MarksheetDTO dto) {
		return search(dto, 0, 0);
	}

	/**
     * Searches Marksheet with pagination
     * 
     * @return list : List of Marksheet
     * @param dto
     *            : Search @parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     *
     */
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		System.out.println("DAO search Started");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);

		if (dto != null) {

			if (dto.getStudentId() != null && dto.getStudentId() > 0) {
				c.add(Restrictions.eq("studentId", dto.getStudentId()));
			}

			if (dto.getRollNo()!= null && dto.getRollNo().length() > 0) {
				c.add(Restrictions.eq("rollNo", dto.getRollNo()));
			}
			if (dto.getName()!= null && dto.getName().length() > 0) {
				c.add(Restrictions.like("name", dto.getName()+"%"));
			}
			

			if (pageSize > 0) {
				c.setFirstResult((pageNo - 1) * pageSize);
				c.setMaxResults(pageSize);
			}
		}
		return c.list();
	}
    
	/**
     * Finds Marksheet by PK
     * 
     * @param pk
     *            : get @parameter
     * @return dto : the dto
     *
     */
	public MarksheetDTO findByPK(long pk) {
		Session session = sessionFactory.getCurrentSession();
		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, pk);
		session.evict(dto);
		return dto;
	}
    
	/**
     * Finds Marksheet by RollNo
     * 
     * @param rollNo
     *            : get @parameter
     * @return dto : the dto
     *
     */
	public MarksheetDTO findByRollNo(String rollNo) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(MarksheetDTO.class);
		criteria.add(Restrictions.eq("rollNo", rollNo));
		List<MarksheetDTO> list = criteria.list();

		MarksheetDTO dto = null;

		if (list.size() == 1) {
			dto = (MarksheetDTO) list.get(0);
			session.evict(dto);
		}
		return dto;
	}
    
	 /**
     * Get MeritList
     * 
     * @return list : List of Marksheet
     * 
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     *
     */
	public List getMeritList(int pageNo, int pageSize) {

		String hql = "from MarksheetDTO where physics>33 and chemistry>33 and maths>33 order by (physics + chemistry + maths) desc";
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(hql);
		return q.list();
	}
}
