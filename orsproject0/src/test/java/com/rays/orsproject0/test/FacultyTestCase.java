package com.rays.orsproject0.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.rays.orsproject0.dto.FacultyDTO;
import com.rays.orsproject0.service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class FacultyTestCase {

	@Autowired
	private FacultyServiceInt f;
	
	
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
	
	@Ignore
	public void add() {
		
		FacultyDTO dto = new FacultyDTO();
		
		dto.setCollegeId(1l);
		dto.setCollegeName("jvdF");
		dto.setCourseName("bdwahfb");
		dto.setCourseId(2l);
		dto.setSubjectId(1l);
		/* dto.setDob(formatter.parse("10-02-2020")); */
		dto.setEmail("Ahaan@gmail.com");
		dto.setFirstName("Irfan");
		dto.setLastName("khan");
		dto.setGender("male");
		dto.setMobileNo("2345678");
		dto.setCreatedBy("absaarKhan");
		dto.setModifiedBy("absaarKhan");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		//dto.setId(1l);
		try {
			 f.add(dto);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("faculty add fail");
		}
	}
	
	@Ignore
    public void update() {
  FacultyDTO dto = new FacultyDTO();
		
		dto.setCollegeId(1l);
		dto.setCollegeName("jvdF");
		dto.setCourseName("bdwahfb");
		dto.setCourseId(2l);
		dto.setSubjectId(1l);
		/* dto.setDob(formatter.parse("10-02-2020")); */
		dto.setEmail("arush12@gmail.com");
		dto.setFirstName("Irfan");
		dto.setLastName("khan");
		dto.setGender("male");
		dto.setMobileNo("2345678");
		dto.setCreatedBy("absaarKhan");
		dto.setModifiedBy("absaarKhan");
		dto.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDatetime(dto.getCreatedDatetime());
		dto.setId(1l);
		try {
			 f.update(dto);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("faculty add fail");
		}
    }
	
	@Ignore
	public void delete() {
		FacultyDTO dto = new FacultyDTO();
		dto.setId(82l);
		try {
			f.delete(dto.getId());
		} catch (Exception e) {
			// TODO: handle exception
			fail("Delete fails");
		}
	}
	@Ignore
	public void findByEmail(){
		
		FacultyDTO dto = new FacultyDTO();
		dto.setEmail("arush12@gmagfdghil.com");
		try {
			FacultyDTO d = f.findByEmail(dto.getEmail());
			System.out.println(d.getCollegeId());
			System.out.println(d.getCollegeName());
			System.out.println(d.getSubjectId());
			System.out.println(d.getSubjectName());
			System.out.println(d.getCourseId());
			System.out.println(d.getCourseName());
			System.out.println(d.getCreatedBy());
			System.out.println(d.getEmail());
			System.out.println(d.getFirstName());
			System.out.println(d.getGender());
			System.out.println(d.getId());
		} catch (Exception e) {
			// TODO: handle exception
			fail("FaIL");
		}
		
	}
	
	@Ignore
	public void findByPk() {
		FacultyDTO dto = new FacultyDTO();
		dto.setId(1l);
		try {
			FacultyDTO d = f.findByPK(dto.getId());
			System.out.println(d.getCollegeId());
			System.out.println(d.getCollegeName());
			System.out.println(d.getSubjectId());
			System.out.println(d.getSubjectName());
			System.out.println(d.getCourseId());
			System.out.println(d.getCourseName());
			System.out.println(d.getCreatedBy());
			System.out.println(d.getEmail());
			System.out.println(d.getFirstName());
			System.out.println(d.getGender());
			System.out.println(d.getId());
		} catch (Exception e) {
			// TODO: handle exception
			fail("FaIL");
		}
	}
	
	@Ignore
	public void testSearch() {
		FacultyDTO dto = new FacultyDTO();
		List l = null;
		try {
			l = f.search(dto, 0, 10);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				FacultyDTO dt = (FacultyDTO) it.next();
				
				System.out.println(dt.getCreatedBy());
				System.out.println(dt.getId());
				System.out.println(dt.getModifiedBy());
				System.out.println(dt.getCollegeName());
				System.out.println(dt.getCollegeId());
				System.out.println(dt.getCourseId());
				System.out.println(dt.getCourseName());
				System.out.println(dt.getEmail());
				System.out.println(dt.getSubjectId());
				System.out.println(dt.getSubjectName());
				System.out.println(dt.getFirstName());
				System.out.println(dt.getGender());
				System.out.println(dt.getId());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Test search fail");
		}
		
	}
	@Test
	public void testSearch2() {
		FacultyDTO dto = new FacultyDTO();
		List l = null;
		try {
			l = f.search(dto);
			Iterator it = l.iterator();
			while (it.hasNext()) {
				FacultyDTO dt = (FacultyDTO) it.next();
				
				System.out.println(dt.getCreatedBy());
				System.out.println(dt.getId());
				System.out.println(dt.getModifiedBy());
				System.out.println(dt.getCollegeName());
				System.out.println(dt.getCollegeId());
				System.out.println(dt.getCourseId());
				System.out.println(dt.getCourseName());
				System.out.println(dt.getEmail());
				System.out.println(dt.getSubjectId());
				System.out.println(dt.getSubjectName());
				System.out.println(dt.getFirstName());
				System.out.println(dt.getGender());
				System.out.println(dt.getId());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Test search fail");
		}
		
	}
}
