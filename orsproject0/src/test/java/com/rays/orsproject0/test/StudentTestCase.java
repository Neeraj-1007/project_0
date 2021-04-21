package com.rays.orsproject0.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rays.orsproject0.dto.StudentDTO;
import com.rays.orsproject0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class StudentTestCase {

	
	@Autowired
	private StudentServiceInt s;
	
	@Test
	public void testAdd() {
		
		StudentDTO dto = new StudentDTO();
		
		dto.setCollegeId(1l);
		dto.setCreatedBy("Absaar");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setEmail("absaarkhan12@gmail.com");
		
		dto.setFirstName("Akf");
		dto.setLastName("King");
		dto.setMobileNo("7865323");
		dto.setModifiedBy("Absaarkhan");
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setGender("male");
		
		try {
			s.add(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Add fail");
		}
		
	}
	
	@Ignore
	public void update() {
    StudentDTO dto = new StudentDTO();
		
		dto.setCollegeId(2l);
		dto.setCreatedBy("Absaar");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setEmail("absaarkhan12@gmail.com");
		dto.setFirstName("Akngfn");
		dto.setLastName("King");
		dto.setMobileNo("7865323");
		dto.setModifiedBy("Absaarkhan");
		dto.setModifiedDatetime(dto.getCreatedDatetime());
	     dto.setId(21l);	
		try {
			s.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Add fail");
		}
	}
	
	@Ignore
	public void delete() {
		
		try {
			s.delete(21l);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Ignore
	public void findByEmail() {
		StudentDTO dto = new StudentDTO();
		
		try {
		StudentDTO d	 = s.findByEmail("nikhilpac12@gmail.com");
		System.out.println(d.getCollegeName());
		System.out.println(d.getCreatedBy());
		System.out.println(d.getEmail());
		System.out.println(d.getFirstName());
		System.out.println(d.getId());
		System.out.println(d.getLastName());
		System.out.println(d.getMobileNo());
		System.out.println(d.getModifiedBy());
		System.out.println(d.getCollegeId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Ignore
	public void findByPK() {
     StudentDTO dto = new StudentDTO();
		
		try {
		StudentDTO d = s.findByPK(1L);
		System.out.println(d.getCollegeName());
		System.out.println(d.getCreatedBy());
		System.out.println(d.getEmail());
		System.out.println(d.getFirstName());
		System.out.println(d.getId());
		System.out.println(d.getLastName());
		System.out.println(d.getMobileNo());
		System.out.println(d.getModifiedBy());
		System.out.println(d.getCollegeId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
	@Ignore
	public void TestSearch() {
		
		StudentDTO dto = new StudentDTO();
		
		try {
			List l = s.search(dto, 0, 10);
			System.out.println(dto);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				StudentDTO d = (StudentDTO) it.next();
				System.out.println(d.getCollegeName());
				System.out.println(d.getCreatedBy());
				System.out.println(d.getEmail());
				System.out.println(d.getFirstName());
				System.out.println(d.getId());
				System.out.println(d.getLastName());
				System.out.println(d.getMobileNo());
				System.out.println(d.getModifiedBy());
				System.out.println(d.getCollegeId());
				System.out.println(d.getGender());
				
				System.out.println(dto.toString());
				
				System.out.println(dto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			/* fail("FAIL"); */
		}
		
		
}
	@Ignore
	public void TestSearch1() {
		
		StudentDTO dto = new StudentDTO();
		
		try {
			List l = s.search(dto);
			System.out.println(dto);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				StudentDTO studentDTO = (StudentDTO) it.next();
				System.out.println(studentDTO.toString());
				System.out.println(dto.toString());
				System.out.println(studentDTO.getCollegeName());
				System.out.println(dto);
				System.out.println(studentDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("FAIL");
		}
		
		
}
}