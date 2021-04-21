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
import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.dto.TimetableDTO;
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;
import com.rays.orsproject0.form.CourseForm;
import com.rays.orsproject0.service.CourseServiceInt;

/**
 * Course functionality Controller. Performs operation for add,update,delete and find list
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
@Controller
@RequestMapping(value="/ctl/Course")
public class CourseCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(CourseCtl.class);
	
	@Autowired
	private CourseServiceInt service;
	
	/**
     * i18n Message source
     */
	@Autowired
	private MessageSource messageSource;
	
	
	
	@Override
	public void preload(Model model) {
		log.debug("SubjectCtl preload method started");
		List list = service.search(null);
		model.addAttribute("courseList", list);
		log.debug("SubjectCtl preload method ended");
	}
	
	/**
     * Display Course view.
     * @param locale:
     * 				Object of Locale  
     * @param id:
     * 			Primary Key
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return Course:
     * 				View of Course Form
     */
	@RequestMapping(value="/Course",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") CourseForm form, Model model, Locale locale) {
		log.debug("CourseCtl display method to display CourseForm started");
		
		String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		
		model.addAttribute("enterdescription",enterdescription);
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("CourseCtl display method to display CourseForm ended");
		return "Course";
	}
	/**
     * Submit Course view.
     * @param session:
     * 					Object of HttpSession
     * @param bindingResult:
     * 						Object of BindingResult
     * @param locale:
     * 					Object of Locale
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return Course:
     * 					View of Course Form
     */
	@RequestMapping(value="/Course",method=RequestMethod.POST)
	public String submit(@RequestParam String operation, Model model, Locale locale, @ModelAttribute("form") @Valid CourseForm form, BindingResult bindingResult, HttpSession session) {
		log.debug("CourseCtl submit method to submit CourseForm started");
		
		String entername=messageSource.getMessage("label.entercoursename",null,locale);
		model.addAttribute("enterName",entername);
		
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
		
		CourseDTO dto = (CourseDTO) form.getDto();
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			if(bindingResult.hasErrors()) {
				return "Course";
			}
			try {
				if(dto.getId()>0) {
					service.update(dto);
	    			String msg=messageSource.getMessage("message.updatesuccess",null,locale);
				    model.addAttribute("success",msg);
				    model.addAttribute("id",dto.getId());
				    return "Course";
				}else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg=messageSource.getMessage("message.success",null,locale);
					model.addAttribute("success",msg);
					form.populate(new CourseDTO());
				}
				
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.coursename",null,locale);
			    model.addAttribute("error",msg);
			    return "Course";
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Course";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Search";
		}
		log.debug("CourseCtl submit method to submit CourseForm ended");
		return "Course";
	}

	/**
     * Display CourseList view.
      * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return CourseList:
     * 						View of CourseList
     */ 
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") CourseForm form, Model model,Locale locale) {
		log.debug("CourseCtl display method to display CourseList started");
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		model.addAttribute("findList", service.search(null));
		
		log.debug("CourseCtl display method to display CourseList ended");
		return "CourseList";
	}
	
	/**
     * submit CourseList view.
     * @param locale:
     * 					Object of Locale
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return CourseList:
     * 						View of CourseList
     */
	@RequestMapping(value="/Search",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") CourseForm form, Model model, Locale locale) {
		log.debug("CourseCtl submit method to submit CourseList started");
		
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
		CourseDTO dto = (CourseDTO) form.getDto();
		List list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		List next = service.search(dto, pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Search";
		} else if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Course";
		} else if (OP_BACK.equals(operation)) {
			return "redirect:/ctl/Course/Search";
		}
		log.debug("CourseCtl submit method to submit User List ended");
		return "CourseList";
	}
	
    @ModelAttribute("duration")
    public Map<String, String> getgenderList() {
       Map<String, String> duration = new HashMap<String, String>();
       duration.put("1Year", "1Year");
       duration.put("2Year", "2Year");
       duration.put("3Year", "3Year");
       duration.put("4Year", "4Year");
       return duration;
    }
	
}