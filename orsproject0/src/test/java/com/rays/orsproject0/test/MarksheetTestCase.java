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

import com.rays.orsproject0.dto.MarksheetDTO;

import com.rays.orsproject0.service.MarksheetServiceInt;


@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")

public class MarksheetTestCase {
		
		@Autowired
		private MarksheetServiceInt u;
		
		@Test
		public void TestGetMarksheet() {
			MarksheetDTO dto =null;
			
			
			try {
				dto=u.findByRollNo("EX1234");
				
				System.out.println(dto.getChemistry());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				fail("fail user");
			}
			
			
			
		}
		
		

}
