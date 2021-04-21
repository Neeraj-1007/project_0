package com.rays.orsproject0.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rays.orsproject0.dao.TimetableDAOInt;
import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.service.TimetableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Ignore
public class TimetableTestCase {
      
	@Autowired
	private TimetableDAOInt ti;
	
	@Autowired
	private TimetableServiceInt t;
	
	@Ignore
	public void add() throws ParseException {
		SimpleDateFormat fo = new SimpleDateFormat("dd-mm-yyyy");
		TimetableDTO dto = new TimetableDTO();
		dto.setSubjectId(1l);
		dto.setCourseId(2l);
		dto.setCreatedBy("BABA");
		dto.setModifiedBy("BABA");
		dto.setDescription("Modificatation");
		dto.setExamTime("12:00");
		dto.setExamDate(fo.parse("10-02-2077"));
		dto.setSemester("4");
		dto.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedDatetime(dto.getModifiedDatetime());
		try {
			t.add(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Add timetable fail");
		}
		
	}
	@Ignore
	public void update() throws ParseException {
		SimpleDateFormat fo = new SimpleDateFormat("dd-mm-yyyy");
		TimetableDTO dto = new TimetableDTO();
		dto.setSubjectId(2l);
		dto.setCourseId(1l);
		dto.setCreatedBy("BABA");
		dto.setModifiedBy("BABA");
		dto.setDescription("Modificatation");
		dto.setExamTime("12:00");
		dto.setExamDate(fo.parse("10-02-2077"));
		dto.setSemester("4");
		dto.setId(26l);
		dto.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedDatetime(dto.getModifiedDatetime());
		try {
			t.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Add timetable fail");
		}
		
	}
	
	@Ignore
	public void delete() {
		try {
			t.delete(27l);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void TestCheckByExamTime() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		TimetableDTO dto = new TimetableDTO();
		
		dto.setCourseId(55l);
		dto.setExamDate(sdf.parse("10-01-2099"));
		try {
	        TimetableDTO dto1 = ti.checkByCourse(dto);
	        if(dto1 != null) {
	        	System.out.println("Course  exist");
	        }
	        else {
				System.out.println("Course does not Exist");
				//t.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		fail("fail");
		}
		
	}
	
}
