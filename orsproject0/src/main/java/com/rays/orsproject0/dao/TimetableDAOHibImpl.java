package com.rays.orsproject0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.orsproject0.dto.TimetableDTO;

/**
 * Hibernate implementation of Timetable DAO.
 * 
 * @author Neeraj
 * 
 */
@Repository("timetableDAO")
public class TimetableDAOHibImpl implements TimetableDAOInt {
	private static Logger log = Logger.getLogger(TimetableDAOHibImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CourseDAOInt courseDao;
	
	@Autowired
	private SubjectDAOInt subjectDao;

	/**
	 * Adds a Timetable
	 * 
	 * @param dto : the dto
	 * @return long: the long
	 *
	 */
	public long add(TimetableDTO dto) {
		
		log.debug("DAO add Started");
		dto.setCourseName(courseDao.findByPK(dto.getCourseId()).getName());
		dto.setSubjectName(subjectDao.findByPK(dto.getSubjectId()).getName());
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}
	
	/**
	 * checkBySemester a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO checkBySemester(TimetableDTO dto){
		log.debug("Check Duplicates");
		TimetableDTO dtoGet = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from TimetableDTO where courseId=? and subjectId=? and semester=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setLong(1, dto.getSubjectId());
		q.setString(2, dto.getSemester());
		q.setDate(3, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	       } else {
	           dtoGet = null;
	    }
	       log.debug("model checksubject end");
	       return dtoGet;
	}
	
	/**
	 * checkBySubject a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	public TimetableDTO checkBySubject(TimetableDTO dto){
		log.debug("Check Duplicates");
		TimetableDTO dtoGet = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from TimetableDTO where courseId=? and subjectId=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setLong(1, dto.getSubjectId());
		q.setDate(2, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	       } else {
	           dtoGet = null;
	    }
	       log.debug("model checksubject end");
	       return dtoGet;
	}
	
	/**
	 * checkByCourse a Timetable
	 * 
	 * @param dto : the dto
	 * @return dto : the dto
	 *
	 */
	
	public TimetableDTO checkByCourse(TimetableDTO dto){
		log.debug("Check Duplicates");
		TimetableDTO dtoGet = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from TimetableDTO where courseId=? and examDate=?");
		q.setLong(0, dto.getCourseId());
		q.setDate(1, dto.getExamDate());
		List list = q.list();
		 if (list.size() > 0) {
	           dtoGet = (TimetableDTO) list.get(0);
	           System.out.println(dtoGet.getCourseId()+".......................");
	       } else {
	           dtoGet = null;
	    }
		 
	       log.debug("model checksubject end");
	       return dtoGet;
	}
	
	/**
	 * Updates a Timetable
	 * 
	 * @param dto : the dto
	 *
	 */

	public void update(TimetableDTO dto) {
		log.debug("DAO update Started");
		dto.setCourseName(courseDao.findByPK(dto.getCourseId()).getName());
		dto.setSubjectName(subjectDao.findByPK(dto.getSubjectId()).getName());
		sessionFactory.getCurrentSession().update(dto);
	}

	/**
	 * Deletes a Timetable
	 * 
	 * @param id : the id
	 *
	 */

	public void delete(long id) {
		log.debug("DAO delete Started");
		TimetableDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Timetable by PK
	 * 
	 * @param pk
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */

	public TimetableDTO findByPK(long pk) {

		Session session = sessionFactory.getCurrentSession();
		TimetableDTO dto = (TimetableDTO) session.get(TimetableDTO.class, pk);
		session.evict(dto);
		return dto;
	}

	/**
	 * Finds Timetable by Name
	 * 
	 * @param name
	 *            : get @parameter
	 * @return dto : the dto
	 *
	 */

	public TimetableDTO findByName(String name) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TimetableDTO.class).add(Restrictions.eq("name", name));
		List list = criteria.list();

		TimetableDTO dto = null;
		if (list.size() == 1) {
			dto = (TimetableDTO) list.get(0);
			session.evict(dto);
		}

		return dto;
	}

	/**
	 * Searches Timetables
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 *
	 */

	public List search(TimetableDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Searches Timetables with pagination
	 * 
	 * @return list : List of Timetables
	 * @param dto
	 *            : Search @parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 */

	public List search(TimetableDTO dto, int pageNo, int pageSize) {

		log.debug("DAO search Started");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimetableDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseId() > 0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}
			if (dto.getSubjectId() > 0) {
				criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
			}
			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			if (dto.getSemester() != null && dto.getSemester().length() > 0) {
				criteria.add(Restrictions.eq("semester", dto.getSemester()));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				criteria.add(Restrictions.like("description", dto.getDescription()));
			}
			if (dto.getExamDate() != null && dto.getExamDate().getDate() > 0) {
				criteria.add(Restrictions.eq("examDate", dto.getExamDate()));
			}
			if (dto.getExamTime() != null && dto.getExamTime().length() > 0) {
				criteria.add(Restrictions.like("examTime", dto.getExamTime()));
			}
		}

		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}
		return criteria.list();
	}
}

