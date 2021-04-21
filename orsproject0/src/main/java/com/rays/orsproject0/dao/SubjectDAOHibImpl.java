package com.rays.orsproject0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.SubjectDTO;
/**
 * Hibernate implementation of Subject DAO.
 * 
 * @author Neeraj
 * 
 */
@Repository("subjectDAO")
public class SubjectDAOHibImpl implements SubjectDAOInt {
	private static Logger log = Logger.getLogger(SubjectDAOHibImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CourseDAOInt courseDao;
	/**
	 * Adds a Subject
	 * 
	 * @param dto : the dto
	 * @return long : the long
	 *
	 */
	public long add(SubjectDTO dto) {

		log.debug("DAO add Started");
		dto.setCourseName(courseDao.findByPK(dto.getCourseId()).getName());
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Subject
	 * 
	 * @param dto : the dto
	 *
	 */

	public void update(SubjectDTO dto) {
		log.debug("DAO update Started");
		dto.setCourseName(courseDao.findByPK(dto.getCourseId()).getName());
		sessionFactory.getCurrentSession().update(dto);
	}

	/**
	 * Deletes a Subject
	 * 
	 * @param id : the id
	 *
	 */

	public void delete(long id) {
		log.debug("DAO delete Started");
		SubjectDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("DAO delete ends");
	}

	/**
	 * Finds Subject by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */

	public SubjectDTO findByPK(long pk) {
		log.debug("DAO findByPK Started");
		Session session = sessionFactory.getCurrentSession();
		SubjectDTO dto = (SubjectDTO) session.get(SubjectDTO.class, pk);
		log.debug("DAO findByPK Started");
		return dto;
	}

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */

	public SubjectDTO findByName(String name) {
		log.debug("DAO findByName Started");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubjectDTO.class).add(Restrictions.eq("name", name));
		List list = criteria.list();

		SubjectDTO dto = null;
		if (list.size() == 1) {
			dto = (SubjectDTO) list.get(0);
			session.evict(dto);
		}
		log.debug("DAO findByName Started");
		return dto;
	}

	/**
	 * Searches Subjects
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 *
	 */

	public List search(SubjectDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Searches Subjects with pagination
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 */

	public List search(SubjectDTO dto, int pageNo, int pageSize) {

		log.debug("DAO search Started");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
		}

		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}
		log.debug("DAO search Started");
		return criteria.list();
	}
}


