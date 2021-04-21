package com.rays.orsproject0.ctl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.locale.converters.LongLocaleConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.orsproject0.form.MarksheetForm;
import com.rays.orsproject0.service.MarksheetServiceInt;
import com.rays.orsproject0.service.StudentServiceInt;

import com.rays.orsproject0.exception.DuplicateRecordException;
import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.dto.MarksheetDTO;
import com.rays.orsproject0.dto.UserDTO;

/**
 * Marksheet functionality Controller. Performs operation for add,update,delete and find list
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
@Controller
@RequestMapping(value="ctl/Marksheet")
public class MarksheetCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(MarksheetCtl.class);
	
	@Autowired
	private MarksheetServiceInt service;
	
	@Autowired
	private StudentServiceInt studentService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void preload(Model model) {
		log.debug("MarksheetCtl preload method started");
		model.addAttribute("studentList",studentService.search(null));
		log.debug("MarksheetCtl preload method ended");
	}
	
	/**
     * Display Marksheet view
      * @param locale:
     * 				Object of Locale 
     * @param id:
     * 				Primary Key
     * @param form:
     * 				Object of MarksheetForm
     * @param model:
     * 				Object of Model Interface
     * @return Marksheet:
     * 						View of Marksheet Form
     */
	@RequestMapping(value="/Marksheet",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") MarksheetForm form, Model model,Locale locale) {
		log.debug("MarksheetCtl display method to display MarksheetForm started");
		
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		
		String enterphysics=messageSource.getMessage("label.enterphysics",null,locale);
		model.addAttribute("enterPhysics",enterphysics);
		
		String enterchemistry=messageSource.getMessage("label.enterchemistry",null,locale);
		model.addAttribute("enterChemistry",enterchemistry);
		
		String entermaths=messageSource.getMessage("label.entermaths",null,locale);
		model.addAttribute("enterMaths",entermaths);
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("MarksheetCtl display method to display MarksheetForm ended");
		return "Marksheet";
	}
	
	/**
     * submit Marksheet view
      * @param locale:
     * 				Object of Locale  
     * @param operation:
     * 					Operation Given by User
     * @param form:
     * 					Object of MarksheetForm
     * @param bindingResult:
     * 						Object of BindingResult
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @param session:
     * 					Object of HttpSession
     * @return Marksheet:
     * 						View of Marksheet Form
     */
	@RequestMapping(value="/Marksheet", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, @ModelAttribute("form") @Valid MarksheetForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		log.debug("MarksheetCtl submit method to submit Marksheet form started");
		System.out.println("in post");
		UserDTO userDto = (UserDTO) session.getAttribute("user"); 
        MarksheetDTO dto=(MarksheetDTO) form.getDto();
        if(OP_SAVE.equalsIgnoreCase(operation)){
        	System.out.println("in save");
	      	 if(bindingResult.hasErrors()){
	      		 return "Marksheet";
	      	 }
	      	 try{
	      		 if(dto.getId()>0){
	      			 dto.setModifiedBy(userDto.getLogin());
	      			 service.update(dto);
	      			 String msg=messageSource.getMessage("message.updatesuccess",null,locale);
	  			     model.addAttribute("success",msg);
	  			     model.addAttribute("id",dto.getId());	 
	      		 }else{
	      			 dto.setCreatedBy(userDto.getLogin());
	      			 dto.setModifiedBy(userDto.getLogin());
	      			 service.add(dto);
	      			 String msg=messageSource.getMessage("message.success",null,locale);
	      			 model.addAttribute("success", msg);
	      		 }
	      	 }catch(DuplicateRecordException e){
	      		 String msg=messageSource.getMessage("message.rollno",null,locale);
	  		     model.addAttribute("error",msg);
	  		     return "Marksheet";
	      	 }
	       
	       }else if(OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/ctl/Marksheet/Marksheet";
			}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
				return "redirect:/ctl/Marksheet/Search";
			}
		log.debug("MarksheetCtl submit method to submit Marksheet form ended");
		return "Marksheet";
	}
	
	/**
     * Display MarksheetList view
     * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of MarksheetForm
     * @param model:
     * 				Object of Model Interface
     * @return MarksheetList:
     * 				View of MarksheetList
     */
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form, Model model,Locale locale) {
		log.debug("MarksheetCtl display method to display MarksheetList started");
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		model.addAttribute("list",service.search(new MarksheetDTO(), form.getPageNo(),form.getPageSize()));
        int pageNo = 1;
        List next = service.search(new MarksheetDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
		log.debug("MarksheetCtl display method to display MarksheetList ended");
		return "MarksheetList";
	}
	
	/**
     * submit MarksheetList view
     * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation Given by User
     * @param form:
     * 				Object of MarksheetForm
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @return MarksheetList:
     * 						View of MarksheetList
     */
	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") MarksheetForm form, Model model, Locale locale) {
		log.debug("MarksheetCtl submit method to submit MarksheetList started");
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		model.addAttribute("findList",service.search(null));
	    int pageNo=form.getPageNo();
	    if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
	    	pageNo--;
	    }else if(OP_NEXT.equalsIgnoreCase(operation)) {
	    	pageNo++;
	    }else if (OP_DELETE.equalsIgnoreCase(operation)) {
	    	if(form.getChk_1()!=null) {
	    		for(long id:form.getChk_1()){
	    			service.delete(id);
	    		}
	    		String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
	    	}else {
	    		String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
	    	}
	    }
	    pageNo=(pageNo<1)?1:pageNo;
	    form.setPageNo(pageNo);
	    MarksheetDTO dto=(MarksheetDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	    model.addAttribute("list", list);
        List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) ){
	    	model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	  	}
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Marksheet/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Marksheet/Marksheet";
	    }else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/Marksheet/Search";
	    }
		log.debug("MarksheetCtl submit method to submit MarksheetList ended");
		return "MarksheetList";
	}
	
	/**
     * Display MarksheetMeritList view
     * @param form:
     * 				Object of MarksheetForm
     * @param model:
     * 				Object of Model Interface
     * @return MarksheetMeritList:
     * 								View of MarksheetMeritList
     */
	@RequestMapping(value="/MarksheetMeritList", method=RequestMethod.GET)
	public String displayMeritList(@ModelAttribute("form") MarksheetForm form, Model model,Locale locale) {
		log.debug("MarksheetCtl displayMeritList method to display Marksheet Merit List strated");
		model.addAttribute("list",service.getMeritList(form.getPageNo(),form.getPageSize()));
		log.debug("MarksheetCtl displayMeritList method to display Marksheet Merit List ended");
		return "MarksheetMeritList";
	}
	
	/**
     * Display GetMarksheet view
      * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of MarksheetForm
     * @param model:
     * 				Object of Model Interface
     * @return GetMarksheet:
     * 						View page of GetMarksheet
     */
	@RequestMapping(value="/GetMarksheet",method=RequestMethod.GET)
	public String displayMarksheet(@ModelAttribute("form") MarksheetForm form, Model model,Locale locale) {
		log.debug("MarksheetCtl displayMarksheet method to display Marksheet started");
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		log.debug("MarksheetCtl displayMarksheet method to display Marksheet ended");
		return "GetMarksheet";
	}
	
	/**
     * submit GetMarksheet view
     * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation given by user
     * @param form:
     * 				Object of Marksheet form
     * @param bindingResult:
     * 						Object of BindingResult
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @return GetMarksheet:
     * 						View page of GetMarksheet
     */
	@RequestMapping(value="/GetMarksheet",method=RequestMethod.POST)
	public String submitMarksheet(@ModelAttribute("form") @Valid MarksheetForm form, BindingResult result,
			@RequestParam(required = false) String operation, Model model, Locale locale) {
		log.debug("MarksheetCtl submitMarksheet method to submit Marksheet started");
		System.out.println("in method 1");
		if(OP_SEARCH.equalsIgnoreCase(operation)) {
			System.out.println("in method 1");
			if(form.getRollNo()!="") {
				System.out.println("in method 1");
				MarksheetDTO dto=service.findByRollNo(form.getRollNo());
				System.out.println("in method 1---------------form.getRollNo()"+form.getRollNo());
				/*
				 * String msg1=messageSource.getMessage("has dto",null,locale);
				 * model.addAttribute("success", msg1);
				 */
				if(dto!=null){	
					System.out.println("in method rollno "+dto.getChemistry());
					System.out.println(dto.getId());
					model.addAttribute("GetMarksheet",dto);
					form.populate(dto);
					
				}else{
					String msg1=messageSource.getMessage("error.roll",null,locale);
					model.addAttribute("error", msg1);
				}
			}else {
				String msg1=messageSource.getMessage("NotEmpty",null,locale);
				model.addAttribute("error", msg1);
			}
		}
		if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/GetMarksheet";
		}
		log.debug("MarksheetCtl submitMarksheet method to submit Marksheet ended");
		return "GetMarksheet";
	}
	
}
