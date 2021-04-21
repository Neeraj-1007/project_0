package com.rays.orsproject0.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.orsproject0.dto.CollegeDTO;
import com.rays.orsproject0.dto.FacultyDTO;
import com.rays.orsproject0.dto.StudentDTO;
import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;
import com.rays.orsproject0.form.TimetableForm;
import com.rays.orsproject0.form.UserForm;
import com.rays.orsproject0.service.CourseServiceInt;
import com.rays.orsproject0.service.SubjectServiceInt;
import com.rays.orsproject0.service.TimetableServiceInt;

/**
 * Timetable functionality Controller. Performs operation for add,update,delete and find list
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
@Controller
@RequestMapping(value="/ctl/Timetable")
public class TimetableCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(TimetableCtl.class);
	
	@Autowired
	private TimetableServiceInt service;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void preload(Model model) {
		log.debug("TimetableCtl preload method started");
		model.addAttribute("courseList",courseService.search(null));
    	model.addAttribute("subjectList",subjectService.search(null));
		log.debug("TimetableCtl preload method ended");
	}
	
	/**
     * Displays Timetable View
     * @param locale:
     * 				Object of Locale 
     * @param id:
     * 				Primary Key
     * @param form:
     * 				Object of TimetableForm
     * @param model:
     * 				Object of Model Interface
     * @return Timetable:
     * 					View of Timetable Form
     */
	@RequestMapping(value="/Timetable", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") TimetableForm form, Model model,Locale locale) {
		log.debug("TimetableCtl display method to display TimetableForm started");
		String entername=messageSource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("TimetableCtl display method to display TimetableForm ended");
		return "Timetable";
	}
	
	/**
     * Submit Timetable View
     * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation given By User
     * @param form:
     * 				Object of TimetableForm
     * @param bindingResult:
     * 						Object of BindingResult
     * @param model:	
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @param session:
     * 					Object of HttpSession
     * @return Timetable:
     * 					View of Timetable Form
     */
	@RequestMapping(value="/Timetable", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, @ModelAttribute("form") @Valid TimetableForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		log.debug("TimetableCtl submit method to submit TimetableForm started");
		UserDTO userDto = (UserDTO) session.getAttribute("user"); 
	    TimetableDTO dto=(TimetableDTO) form.getDto();
	    if(OP_SAVE.equalsIgnoreCase(operation)) {
	    	if(bindingResult.hasErrors()) {
	    		return "Timetable";
	    	}
	    	try {
	    		if(dto.getId()>0) {
	    			dto.setModifiedBy(userDto.getLogin());
	      			service.update(dto);
	      			String msg=messageSource.getMessage("message.updatesuccess",null,locale);
	  			    model.addAttribute("success",msg);
	  			    model.addAttribute("id",dto.getId());
	    		}else {
	    			dto.setCreatedBy(userDto.getLogin());
	      			dto.setModifiedBy(userDto.getLogin());
	      			service.add(dto);
	      			String msg=messageSource.getMessage("message.success",null,locale);
	      			model.addAttribute("success", msg);
	    		}
	    	}catch(DuplicateRecordException e) {
	    		String msg=messageSource.getMessage("error.record",null,locale);
	  		    model.addAttribute("error",msg);
	  		    return "Timetable";
	    	}
	    }else if(OP_RESET.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/Timetable/Timetable";
	    }else if(OP_CANCEL.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/Timetable/Search";
	    }
		log.debug("TimetableCtl submit method to submit TimetableForm ended");
		return "Timetable";
	}
	
	/**
     * Displays TimetableList View
     * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of TimetableForm
     * @param model:
     * 				Object of Model Interface
     * @return TimetableList:
     * 						View of TimetableList
     */
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") UserForm form, Model model, Locale locale) {
		log.debug("UserCtl display method to display User List started");

		String entersubjectName = messageSource.getMessage("label.entersubjectname", null, locale);
		model.addAttribute("entersubjectName", entersubjectName);
		String entercourseName = messageSource.getMessage("label.entercoursename", null, locale);
		model.addAttribute("entercourseName", entercourseName);
		String entersemester=messageSource.getMessage("label.semester",null,locale);
		model.addAttribute("entersemester",entersemester);
		
		
		model.addAttribute("list", service.search(null, form.getPageNo(), form.getPageSize()));
		model.addAttribute("findList", service.search(null));
		model.addAttribute("courseList",courseService.search(null));
		model.addAttribute("subjectList",subjectService.search(null));
//		int pageNo = 1;
//		List next = service.search(new TimetableDTO(), pageNo+1, form.getPageSize());
//		model.addAttribute("nextlistsize",next.size());
		log.debug("UserCtl display method to display User List ended");
		return "TimetableList";
	}
	
	/**
     * Submit TimetableList View
      * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of TimetableForm
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 				Object of Locale
     * @return Timetable:
     * 						View of TimetableList
     */
	
	
	
	
	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public String submit(@ModelAttribute("form") TimetableForm form, BindingResult bindingResult, Model model,
			@RequestParam(required = false) String operation, Locale locale) {
		log.debug("timetablectl submit method to submit User List started");
		
		String entersubjectName = messageSource.getMessage("label.entersubjectname", null, locale);
		model.addAttribute("entersubjectName", entersubjectName);
		String entercourseName = messageSource.getMessage("label.entercoursename", null, locale);
		model.addAttribute("entercourseName", entercourseName);
		String entersemester=messageSource.getMessage("label.semester",null,locale);
		model.addAttribute("entersemester",entersemester);
		
		
		model.addAttribute("findList", service.search(null));
		int pageNo = form.getPageNo();
		
		if (OP_PREVIOUS.equalsIgnoreCase(form.getOperation())) {
			pageNo--;
		} else if (OP_NEXT.equalsIgnoreCase(form.getOperation())) {
			pageNo++;
		} else if (OP_DELETE.equalsIgnoreCase(form.getOperation())) {
			System.out.println("Delete my record 1");
			if (form.getChk_1() != null) {
				System.out.println("Delete my record 2");
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			} else {

				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
			}
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;
		form.setPageNo(pageNo);
		TimetableDTO dto = (TimetableDTO) form.getDto();
		List list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		List next = service.search(dto, pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Timetable/Search";
		} else if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Timetable/Timetable";
		} else if (OP_BACK.equals(operation)) {
			return "redirect:/ctl/Timetable/Search";
		}
		log.debug("timetablectl submit method to submit User List ended");
		return "TimetableList";
	}
	

	
	
//	@ModelAttribute("semester")
//	public Map<String, String> getgenderList() {
//		Map<String, String> semester = new HashMap<String, String>();
//		semester.put("1 semester", "1 semester");
//		semester.put("2 semester", "2 semester");
//		semester.put("3 semester", "3 semester");
//		semester.put("4 semester", "4 semester");
//		semester.put("5 semester", "5 semester");
//		semester.put("6 semester", "6 semester");
//		semester.put("7 semester", "7 semester");
//		semester.put("8 semester", "8 semester");
//		semester.put("9 semester", "9 semester");
//		semester.put("10 semester", "10 semester");
//		return semester;
//	}
//	
//	@ModelAttribute("examTime")
//	public Map<String, String> getExamTime() {
//		Map<String, String> examTime = new HashMap<String, String>();
//		examTime.put("09:00AM to 12:00PM", "09:00AM to 12:00PM");
//		examTime.put("12:00PM to 03:00PM", "12:00PM to 03:00PM");
//		examTime.put("03:00PM to 06:00PM", "03:00PM to 06:00PM");
//		return examTime;
//	}

}
