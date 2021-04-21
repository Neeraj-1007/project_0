package com.rays.orsproject0.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.mapping.results.Success;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.orsproject0.dto.FacultyDTO;
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;
import com.rays.orsproject0.form.FacultyForm;
import com.rays.orsproject0.service.CollegeServiceInt;
import com.rays.orsproject0.service.CourseServiceInt;
import com.rays.orsproject0.service.FacultyServiceInt;
import com.rays.orsproject0.service.SubjectServiceInt;

/**
 * Faculty functionality Controller. Performs operation for add,update,delete and find list
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Controller
@RequestMapping(value="/ctl/Faculty")
public class FacultyCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(FacultyCtl.class);
	
	@Autowired
	private FacultyServiceInt service;
	
	@Autowired
	private CollegeServiceInt collegeService;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void preload(Model model) {
		log.debug("FacultyCtl preload method started");
		model.addAttribute("collegeList",collegeService.search(null));
    	model.addAttribute("courseList",courseService.search(null));
    	model.addAttribute("subjectList",subjectService.search(null));
		log.debug("FacultyCtl preload method ended");
	}
	
	/**
     * Display Faculty view.
     * @param locale:
     * 				Object of Locale 
     * @param id:
     * 				Primary Key
     * @param form:
     * 				Object of FacultyForm
     * @param model:
     * 				Object of Model Interface
     * @return Faculty:
     * 					View of Faculty Form
     */
	@RequestMapping(value="/Faculty", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") FacultyForm form, Model model,Locale locale) {
		log.debug("FacultyCtl display method to display FacultyForm strated");
		String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterdob=messageSource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);

		 
		String enterMobile=messageSource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);  
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("FacultyCtl display method to display FacultyForm ended");
		return "Faculty";
	}
	
	/**
     * Submit Faculty view.
      * @param locale:
     * 				Object of Locale 
     *@param operation:
     *					Operation given by user
     * @param form:
     * 				Object of FacultyForm
     * @param bindingResult:
     * 						Object of BindingResult
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @param session:
     * 					Object of HttpSession
     * @return Faculty:
     * 					View of faculty Form
     */
	@RequestMapping(value="/Faculty", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, @ModelAttribute("form") @Valid FacultyForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		log.debug("FacultyCtl submit method to submit FacultyForm started");
		String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterdob=messageSource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		 
		String enterMobile=messageSource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);  
		UserDTO userDto = (UserDTO) session.getAttribute("user");
		FacultyDTO dto=(FacultyDTO) form.getDto();
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			if(bindingResult.hasErrors()) {
				return "Faculty";
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
					form.populate(new FacultyDTO());
				}
			} catch (DuplicateRecordException e) {
				// TODO: handle exception
				String msg=messageSource.getMessage("error.faculty",null,locale);
			    model.addAttribute("error",msg);
			    return "Faculty";

			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/Faculty";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Faculty/Search";
		}
		log.debug("FacultyCtl submit method to submit FacultyForm ended");
		return "Faculty";
	}
	
	/**
     * Displays Faculty List.
     * 
     * @param form:
     * 				Object of FacultyForm
     * @param model:
     * 				Object of Model Interface
     * @return FacultyList:
     * 						View of FacultyList
     */
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") FacultyForm form, Model model,Locale locale) {
		log.debug("FacultyCtl display method to display FacultyList started");
		
		String enterfirstName = messageSource.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfFirstName", enterfirstName);
		String enterLastName = messageSource.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLastName", enterLastName);
		String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new FacultyDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
		log.debug("FacultyCtl display method to display FacultyList ended");
		return "FacultyList";
	}
	
	/**
     * Submit Faculty List.
      * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of FacultyForm
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @return FacultyList:
     * 						View of FacultyList
     */
	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") FacultyForm form, Model model, Locale locale) {
		log.debug("FacultyCtl submit method to submit FacultyList started");
	    int pageNo=form.getPageNo();
	    String enterfirstName = messageSource.getMessage("label.enterfname", null, locale);
		model.addAttribute("enterfFirstName", enterfirstName);
		String enterlname = messageSource.getMessage("label.enterlname", null, locale);
		model.addAttribute("enterLname", enterlname);
	    if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
	    	pageNo--;
	    }else if(OP_NEXT.equalsIgnoreCase(operation)) {
	    	pageNo++;
	    }else if(OP_DELETE.equalsIgnoreCase(operation)) {
	    	if(form.getChk_1()!=null) {
	    		for(long id:form.getChk_1()){
	    			service.delete(id);
	    		}
	    		String msg = messageSource.getMessage("message.deleterecord", null, locale);
	    		model.addAttribute("success", msg);
	    	}else {
	    		String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error1", msg);
	    	}
	    }
	    pageNo=(pageNo<1)?1:pageNo;
	    form.setPageNo(pageNo);
	    FacultyDTO dto=(FacultyDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	    model.addAttribute("list", list);
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) ){
	    	model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	  	}
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Faculty";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Faculty/Search";
	    }
		log.debug("FacultyCtl submit method to submit FacultyList ended");
		return "FacultyList";
	}

	
	@ModelAttribute("genderList")
	public Map<String, String> getgenderList() {
		Map<String, String> genderList = new HashMap<String, String>();
		genderList.put("Male", "Male");
		genderList.put("Female", "Female");
		return genderList;
	}
}


