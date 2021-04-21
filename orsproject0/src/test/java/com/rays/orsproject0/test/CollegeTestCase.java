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

import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.service.CollegeServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class CollegeTestCase {

	
	@Autowired
	private CollegeServiceInt i;
	
	
	
	@Ignore
	public void testAdd() {
		
		CollegeDTO dto = new CollegeDTO();
		dto.setAddress("shvfj");
		dto.setState("vjhd");
		
		dto.setAddress("bdadb");
		dto.setName("sdjgk");
		dto.setCreatedBy("daDFJ");
		dto.setModifiedBy("bfehbf");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
	   
		try {
		 i.add(dto);
		
		} catch (Exception e) {
			// TODO: handle exception
			
			fail("College already exist");
			
		}
		
		
	}
	@Ignore
	public void update() {
		
		CollegeDTO dto = new CollegeDTO();
		
		dto.setAddress("shu65u6uvfj");
		dto.setState("vjhu6u6ud");
		dto.setId(26l);
		dto.setAddress("bddsagrghrehryhyh6yadb");
		dto.setName("bsjw656u6u4eyt45ytcsj");
		dto.setCreatedBy("dau65u6DFJ");
		dto.setModifiedBy("bfu65u6uehbf");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		try {
			i.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			fail("update fail");
		}
	}
	@Ignore
	public void delete() {
		CollegeDTO dto = new CollegeDTO();
		dto.setId(19l);
		try {
			i.delete(dto.getId());
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
		
	}
	
	@Ignore
	public void findByName() {
		CollegeDTO dto = new CollegeDTO();
		dto.setName("IPS");
		try {
			CollegeDTO dtoget = i.findByName(dto.getName());
			
			System.out.println(dto.getAddress());
			System.out.println(dto.getCity());
			System.out.println(dtoget.getAddress());
			System.out.println(dtoget.getCity());
			System.out.println(dtoget.getCreatedBy());
			System.out.println(dtoget.getId());
			System.out.println(dtoget.getKey());
			System.out.println(dtoget.getModifiedBy());
			System.out.println(dtoget.getName());
			System.out.println(dtoget.getPhoneNo());
			System.out.println(dtoget.getState());
			System.out.println(dtoget.getValue());
		} catch (Exception e) {
			// TODO: handle exception
			fail("name does not exist");
		}
	}
	@Ignore
	public void findByPK() {
		CollegeDTO dto = new CollegeDTO();
		dto.setId(2L);
		try {
			CollegeDTO dtoget = i.findByPK(dto.getId());
			
			System.out.println(dto.getAddress());
			System.out.println(dto.getCity());
			System.out.println(dtoget.getAddress());
			System.out.println(dtoget.getCity());
			System.out.println(dtoget.getCreatedBy());
			System.out.println(dtoget.getId());
			System.out.println(dtoget.getKey());
			System.out.println(dtoget.getModifiedBy());
			System.out.println(dtoget.getName());
			System.out.println(dtoget.getPhoneNo());
			System.out.println(dtoget.getState());
			System.out.println(dtoget.getValue());
		} catch (Exception e) {
			// TODO: handle exception
			fail("name does not exist");
		}	
	}
	
	@Ignore
	public void testSearch() {
		
		CollegeDTO dto = new CollegeDTO();
		try {
			List l = i.search(dto, 0, 10);
			
			Iterator it = l.iterator();
			while (it.hasNext()) {
				CollegeDTO dtoget = (CollegeDTO) it.next();
				System.out.println(dtoget.getAddress());
				System.out.println(dtoget.getCity());
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
				System.out.println(dtoget.getPhoneNo());
				System.out.println(dtoget.getState());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			fail(" Search fail");
		}
		
	}
	
	@Ignore
	public void testSearch2() {
		
		CollegeDTO dto = new CollegeDTO();
		try {
			List<CollegeDTO> dt = i.search(dto);
			Iterator it = dt.iterator();
			while (it.hasNext()) {
				CollegeDTO dtoget = (CollegeDTO) it.next();
				System.out.println(dtoget.getAddress());
				System.out.println(dtoget.getCity());
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
				System.out.println(dtoget.getPhoneNo());
				System.out.println(dtoget.getState());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	}
}
