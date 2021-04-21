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

import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class CourseTestCase {

	
	
	@Autowired
	private CourseServiceInt c;
	
@Ignore
public void testAdd() {
		
		CourseDTO dto = new CourseDTO();
		
		dto.setName("bsjw4eyt45ytcsj");
		dto.setCreatedBy("daDFJ");
		dto.setModifiedBy("bfehbf");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
	   
		try {
		 c.add(dto);
		
		} catch (Exception e) {
			// TODO: handle exception
			
			fail("Colllege already exist");
			
		}
	
}
	
 @Ignore	
 public void testupdate() {
		
		CourseDTO dto = new CourseDTO();
		
		dto.setId(28l);
		
		dto.setName("bsjw656u6u4eyt45ytcsj");
		dto.setCreatedBy("dau65u6DFJ");
		dto.setModifiedBy("bfu65u6uehbf");
	   
		try {
		 c.add(dto);
		
		} catch (Exception e) {
			// TODO: handle exception
			
			fail("Colllege already exist");
			
		}
	
}
	
 @Ignore
 public void delete() {
		CourseDTO dto = new CourseDTO();
				
				
		dto.setId(22l);
		try {
			c.delete(dto.getId());
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
		
	}
 @Ignore
	public void findByName() {
		CourseDTO dto = new CourseDTO();
		dto.setName("ME");
		try {
			CourseDTO dtoget = c.findByName(dto.getName());
			
	
			
			System.out.println(dtoget.getCreatedBy());
			System.out.println(dtoget.getId());
			System.out.println(dtoget.getKey());
			System.out.println(dtoget.getModifiedBy());
			System.out.println(dtoget.getName());
	
		} catch (Exception e) {
			// TODO: handle exception
			fail("name does not exist");
		}
	}
	@Ignore
	public void findByPK() {
		CourseDTO dto = new CourseDTO();
		dto.setId(2l);
		try {
			CourseDTO dtoget = c.findByPK(dto.getId());
			if(dtoget!=null) {
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
			}else {
				System.out.println("dto is null");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("name does not exist");
		}	
	}
	
	@Ignore
	public void testSearch() {
		
		CourseDTO dto = new CourseDTO();
		try {
			List l = c.search(dto, 0, 10);
			
			Iterator it = l.iterator();
			while (it.hasNext()) {
				CourseDTO dtoget = (CourseDTO) it.next();
				
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			fail(" Search fail");
		}
		
	}
	
	@Ignore
	public void testSearch2() {
		
		CourseDTO dto = new CourseDTO();
		try {
			List<CourseDTO> dt = c.search(dto);
			Iterator it = dt.iterator();
			while (it.hasNext()) {
				CourseDTO dtoget = (CourseDTO) it.next();
				
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			fail("Search fail");
		}
	
	
	}
 
}
