package com.rays.orsproject0.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.dto.FacultyDTO;
import com.rays.orsproject0.dto.SubjectDTO;



/**
 * Hibernate implementation of Faculty DAO.
 * 
 * @author Neeraj
 * 
 */

@Repository(value = "facultyDAO")
public class FacultyDAOHibImpl implements FacultyDAOInt{
	
	@Autowired
    private SessionFactory sessionFactory = null;
	
	@Autowired
	CollegeDAOInt collegeDao;
	
	@Autowired
	CourseDAOInt courseDao;
	
	@Autowired
	SubjectDAOInt subjectDao;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

    /**
     * Add a Faculty
     * 
     * @param dto : the dto
     * @return long : the long 
     * 
     */
    public long add(FacultyDTO dto) {
    	Session session = sessionFactory.getCurrentSession();
       SubjectDTO subjectDTO = new SubjectDTO();
        CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDto.getName());
		CourseDTO courseDto = courseDao.findByPK(dto.getCourseId());
		dto.setCourseName(courseDto.getName());
		 subjectDTO = subjectDao.findByPK(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getName());
        
        session.save(dto);
       
        return dto.getId();
    }

    /**
     * Update a Faculty
     * 
     * @param dto : the dto
     * @return long : the long
     *
     */
    public long update(FacultyDTO dto) {
		/* Session session = sessionFactory.getCurrentSession(); */
        CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDto.getName());
		CourseDTO courseDto = courseDao.findByPK(dto.getCourseId());
		dto.setCourseName(courseDto.getName());
		
		SubjectDTO sdto = subjectDao.findByPK(dto.getSubjectId());
		dto.setSubjectName(sdto.getName());
		
		/* session.update(dto); */
		sessionFactory.getCurrentSession().merge(dto);
        return dto.getId();
    }

    /**
    * Delete a Faculty
    * 
    * @param id : the id
    *
    */
    public void delete(long id) {
        FacultyDTO dto = findByPK(id);
        Session session = sessionFactory.getCurrentSession();
        session.delete(dto);

    }
    
    /**
     * Finds Faculty by Email
     * 
     * @param email
     *            : get @parameter
     * @return dto : the dto
     *
     */
    public FacultyDTO findByEmail(String email) {
        System.out.println("in findBy email");
        FacultyDTO dto = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(FacultyDTO.class);
        List list = (List) criteria.add(Restrictions.eq("email", email)).list();

        if (list.size() == 1) {
            dto = (FacultyDTO) list.get(0);
        }
        System.out.println("in finby email");
        return dto;

    }
    
    /**
     * Finds Faculty by PK
     * 
     * @param id
     *            : get @parameter
     * @return dto : the dto
     *
     */
    public FacultyDTO findByPK(long id) {

        System.out.println("in DAO findBYPK before session");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("in DAO findBYPK after session");

        System.out.println("in DAO findByPK");
        FacultyDTO dto = (FacultyDTO) session.get(FacultyDTO.class, id);
        System.out.println(dto.getFirstName());
        return dto;
    }
    
    /**
     * Searches Faculty with pagination
     * 
     * @return list : List of Faculty
     * @param dto
     *            : Search @parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     *
     */
    public List search(FacultyDTO dto, int pageNo, int pageSize) {
        System.out.println("DAO Search pagination");
        List list = null;

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(FacultyDTO.class);
        if (dto != null) {

            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
                criteria.add(Restrictions.like("firstName", dto.getFirstName()
                        + "%"));
            }
            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
                criteria.add(Restrictions.like("lastName", dto.getLastName()
                        + "%"));
            }
            if (dto.getDob() != null) {
                criteria.add(Restrictions.eq("dob", dto.getDob()));
            }
            if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
                criteria.add(Restrictions.eq("mobileNo", dto.getMobileNo()
                        + "%"));
            }
            if (dto.getEmail() != null && dto.getEmail().length() > 0) {
                criteria.add(Restrictions.like("email", dto.getEmail() + "%"));
            }
            
            if(dto.getCollegeId() > 0) {
    			criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
    			}
    			if(dto.getCollegeName() != null && dto.getCollegeName().length() > 0){
    				criteria.add(Restrictions.like("collegeName", dto.getCollegeName()));
    			}
    			if (dto.getSubjectId() > 0) {
    		    criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
    			}
    			if (dto.getCourseId() > 0) {
    			criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
    			}
        }
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {

            criteria.setFirstResult((pageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize);
        }
        System.out.println("after DAO Search pagination");

        list = criteria.list();
        System.out.println("after criteria");
        return list;

    }
    
    /**
     * Searches Faculty
     * 
     * @return list : List of Faculty
     * @param dto
     *            : Search @parameters
     *
     */
    public List search(FacultyDTO dto) {
        System.out.println("DAO Search");
        return search(dto, 0, 0);

    }
	
}
