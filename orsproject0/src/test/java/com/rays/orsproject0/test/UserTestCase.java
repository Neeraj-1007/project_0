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

import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class UserTestCase {

	
	@Autowired
	private UserServiceInt u;
	
	@Ignore
	public void Testadd() {
		UserDTO dto = new UserDTO();
		
		dto.setConfirmPassword("absaar@123");
		dto.setPassword("absaar@123");
		dto.setFirstName("Absaar");
		dto.setLastName("khan");
		dto.setLogin("absaarkhan52@gmail.com");
		dto.setCreatedBy("absaar");
		dto.setMobileNo("73454636");
		dto.setModifiedBy("absaar");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setUnSuccessfulLogin(1);
		dto.setLastLogin(dto.getCreatedDatetime());
		dto.setRoleId(1l);
		dto.setLastLoginIP("123:12:12");
		try {
			u.add(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail user");
		}
		
		
		
	}
	
	@Ignore
	public void update() {
      UserDTO dto = new UserDTO();
		dto.setId(1);
//		dto.setConfirmPassword("absaar@12");
//		dto.setPassword("absaar@12");
//		dto.setFirstName("Absaar");
//		dto.setLastName("khan");
//		dto.setLogin("absaarkhan52@gmail.com");
		dto.setCreatedBy("Neeraj");
//		dto.setMobileNo("73454636");
//		dto.setModifiedBy("absaar");
//		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
//		dto.setModifiedDatetime(dto.getCreatedDatetime());
//		dto.setUnSuccessfulLogin(1);
//		dto.setLastLogin(dto.getCreatedDatetime());
//		dto.setRoleId(1l);
//		dto.setId(23l);
//		dto.setLastLoginIP("123:12:12");
		try {
			u.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail user");
		}
		
		
		
	}
	
	
	@Ignore
	public void delete() {
		try {
			u.delete(1l);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail");
		}
	}
	
	
	@Test
	public void findByLogin() {
		UserDTO dto = new UserDTO();
		try {
			dto = u.findByLogin("neerajkumarjha10@gmail.com");
			System.out.println(dto.getConfirmPassword());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnSuccessfulLogin());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getId());
			System.out.println(dto.getLock());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getGender());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail");
		}
		
	}
	
	@Ignore
	public void findByPK() {
		UserDTO dto = new UserDTO();
		try {
			dto = u.findByPK(1l);
			System.out.println(dto.getConfirmPassword());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnSuccessfulLogin());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getId());
			System.out.println(dto.getLock());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getGender());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail");
		}
	}
	
	@Ignore
	public void testSearch() {
		UserDTO dt = new UserDTO();
		try {
		List l = u.search(dt);
		 Iterator it = l.iterator();
		 while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getConfirmPassword());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnSuccessfulLogin());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getId());
			System.out.println(dto.getLock());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getGender());
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail");
		}
		
	}
	
	@Ignore
	public void testSearch1() {
		UserDTO dt = new UserDTO();
		try {
		List l = u.search(dt,0,10);
		 Iterator it = l.iterator();
		 while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getConfirmPassword());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnSuccessfulLogin());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getModifiedDatetime());
			System.out.println(dto.getId());
			System.out.println(dto.getLock());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getGender());
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("fail");
		}
	}
	
	@Ignore
	public void testRegisterUser() {
		UserDTO dto = new UserDTO();
		dto.setConfirmPassword("absaar@123");
		dto.setPassword("absaar@123");
		dto.setFirstName("Absaar");
		dto.setLastName("khan");
		dto.setLogin("absaarkhan52@gmail.com");
		dto.setCreatedBy("absaar");
		dto.setMobileNo("73454636");
		dto.setModifiedBy("absaar");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setUnSuccessfulLogin(1);
		dto.setLastLogin(dto.getCreatedDatetime());
		dto.setRoleId(1l);
		dto.setLastLoginIP("123:12:12");
		try {
			u.registerUser(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
}
