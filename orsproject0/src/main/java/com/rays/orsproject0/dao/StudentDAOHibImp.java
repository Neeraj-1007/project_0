package com.rays.orsproject0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.StudentDTO;
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.dao.CollegeDAOInt;

@Repository("studentDAO")
public class StudentDAOHibImp implements StudentDAOInt{
	private static Logger log=Logger.getLogger(StudentDTO.class);
	
	
	@Autowired
    private SessionFactory sessionFactory = null;
	
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	@Autowired
	CollegeDAOInt collegedao;
	
	 /**
     * Add a Student
     * 
     * @param dto : the dto
     * @return long : the long
     *
     */
	public long add(StudentDTO dto) {
		// TODO Auto-generated method stub
		log.debug(" Student DAO add method starts");
		 Session session = sessionFactory.getCurrentSession();
	        CollegeDTO cdto = collegedao.findByPK(dto.getCollegeId());
			dto.setCollegeName(cdto.getName());
	        session.save(dto);
	        log.debug(" Student DAO add method ends");
	        return dto.getId();
	}
	/**
     * Add a Student
     * 
     * @param dto : the dto
     * @return long : the long
     *
     * 
     */ 
	public long update(StudentDTO dto) {
		// TODO Auto-generated method stub
		log.debug(" Student DAO update method starts");
		Session session = sessionFactory.getCurrentSession();
        CollegeDTO cdto = collegedao.findByPK(dto.getCollegeId());
        dto.setCollegeName(cdto.getName());
        session.update(dto);
        log.debug(" Student DAO update method ends");
        return dto.getId();
	}
	/**
     * Add a Student
     * 
     * @param id : the id
     *
     */
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.debug(" Student DAO delete method starts");
		 StudentDTO dto = findByPK(id);
	        Session session = sessionFactory.getCurrentSession();
	      
	        session.delete(dto);
	        log.debug(" Student DAO add method ends");
	}
	/**
     * Finds Student by Email
     * 
     * @param email
     *            : get @parameter
     * @return dto : the dto
     *
     */
	public StudentDTO findByEmail(String email) {
		// TODO Auto-generated method stub
		  log.debug(" Student DAO findbyEmail method start");
		System.out.println("in findBy email");
        StudentDTO dto = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StudentDTO.class);
        List list = (List) criteria.add(Restrictions.eq("email", email)).list();

        if (list.size() == 1) {
            dto = (StudentDTO) list.get(0);
        }
        System.out.println("in finby email");
        log.debug(" Student DAO findbyEmail method ends");
        return dto;
	}
	/**
     * Finds Student by PK
     * 
     * @param id
     *            : get @parameter
     * @return dto : the dto
     *
     */
	public StudentDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		  log.debug(" Student DAO findbyPK method Starts");
		 System.out.println("in DAO findBYPK before session");
	        Session session = sessionFactory.getCurrentSession();
	        System.out.println("in DAO findBYPK after session");

	        System.out.println("in DAO findByPK");
	        StudentDTO dto = (StudentDTO) session.get(StudentDTO.class, pk);
	        System.out.println(dto.getFirstName());
	        log.debug(" Student DAO findbyPK method ends");
	        return dto;
	}
	 /**
     * Searches Student with pagination
     * 
     * @return list : List of Students
     * @param dto
     *            : Search @parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     *
     */
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		  log.debug(" Student DAO search method starts");
		System.out.println("DAO Search pagination");
        List<StudentDTO> list = null;

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                StudentDTO.class);   
        
        
        if (dto != null) {
        	if(dto.getCollegeId()!= null){
        		criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
        	}

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
            if (dto.getGender() != null && dto.getGender().length() > 0) {
                criteria.add(Restrictions.like("gender", dto.getGender() + "%"));
            }
        }
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {

            criteria.setFirstResult((pageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize);
        }
        
        System.out.println("after DAO Search pagination");
     System.out.println(pageSize);
        list = criteria.list();
        System.out.println("after criteria");
        System.out.println(list);
        log.debug(" Student DAO search method ends");
        return list;
	}
	/**
     * Searches Student
     * 
     * @return list : List of Students
     * @param dto
     *            : Search @parameters
     *
     */
	public List search(StudentDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}
	
	

}
