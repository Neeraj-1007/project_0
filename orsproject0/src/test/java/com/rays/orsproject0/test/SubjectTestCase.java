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

import com.rays.orsproject0.dto.SubjectDTO;
import com.rays.orsproject0.service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class SubjectTestCase {

	
	@Autowired
	private SubjectServiceInt su;
	
	@Ignore
	public void add() {
		SubjectDTO dto = new SubjectDTO();
		dto.setCourseId(1l);
		dto.setCreatedBy("absaar");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setName("Physical Education");
		dto.setModifiedBy("absaar");
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setDescription("Physical knowledge");
		try {
			su.add(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
	@Ignore
	public void update() {
		SubjectDTO dto = new SubjectDTO();
		dto.setCourseId(1l);
		dto.setCreatedBy("absaarKhan");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setName("Physical Education");
		dto.setModifiedBy("absaarkhan");
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setDescription("Physical knowledge");
		dto.setId(61l);
		try {
			su.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
	@Ignore
	public void delete() {
		
		try {
			su.delete(61l);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	@Ignore
	public void findByNmae() {
		SubjectDTO dto = new SubjectDTO();
		try {
			dto = su.findByName("Advances in Drug Delivery systems");
			System.out.println(dto.getCourseId());
			System.out.println(dto.getCourseName());
			System.out.println(dto.getName());
			System.out.println(dto.getId());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getDescription());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	@Ignore
	public void findByPK() {
		SubjectDTO dto = new SubjectDTO();
		try {
			dto = su.findByPK(1l);
			System.out.println(dto.getCourseId());
			System.out.println(dto.getCourseName());
			System.out.println(dto.getName());
			System.out.println(dto.getId());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getDescription());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
	@Ignore
	public void TestSearch() {
		SubjectDTO dt = new SubjectDTO();
		List l = null;
		try {
			l = su.search(dt, 0, 10);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				SubjectDTO dto = (SubjectDTO) it.next();
				System.out.println(dto.getCourseId());
				System.out.println(dto.getCourseName());
				System.out.println(dto.getName());
				System.out.println(dto.getId());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedDatetime());
				System.out.println(dto.getDescription());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void TestSearch1() {
		SubjectDTO dt = new SubjectDTO();
		List l = null;
		try {
			l = su.search(dt);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				SubjectDTO dto = (SubjectDTO) it.next();
				System.out.println(dto.getCourseId());
				System.out.println(dto.getCourseName());
				System.out.println(dto.getName());
				System.out.println(dto.getId());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedDatetime());
				System.out.println(dto.getDescription());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
}
