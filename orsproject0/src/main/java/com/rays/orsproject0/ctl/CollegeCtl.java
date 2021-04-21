package com.rays.orsproject0.ctl;

import java.util.List;
import java.util.Locale;

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
import com.rays.orsproject0.dto.UserDTO;
import com.rays.orsproject0.exception.DuplicateRecordException;
import com.rays.orsproject0.form.CollegeForm;
import com.rays.orsproject0.service.CollegeServiceInt;

/**
 * College functionality Controller. Performs operation for add,update,delete and find list
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
@Controller
@RequestMapping(value="/ctl/College")
public class CollegeCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(CollegeCtl.class);
	
	@Autowired
	private CollegeServiceInt service;
	
	/**
     * i18n Message source
     */
	@Autowired
	private MessageSource messageSource;
	
	/**
     * Displays CollegeView.
     * @param locale:
     * 				Object of Locale 
     * @param id:
     * 			PrimaryKey
     * @param form:
     * 				CollegeForm object
     * @param model:
     * 				Model Interface object
     * @return College:
     * 				View of CollegeForm
     */
	@RequestMapping(value="/College",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") CollegeForm form, Model model,Locale locale) {
		log.debug("CollegeCtl display method to display CollegeForm started");
		
		String entername=messageSource.getMessage("label.entercname",null,locale);
		model.addAttribute("enterName",entername);
		
		String enteraddress=messageSource.getMessage("label.enteraddress",null,locale);
		model.addAttribute("enterAddress",enteraddress);
		
		String enterstate=messageSource.getMessage("label.enterstate",null,locale);
		model.addAttribute("enterState",enterstate);
		
		String entercity=messageSource.getMessage("label.entercity",null,locale);
		model.addAttribute("enterCity",entercity);
		
		String enterphone =messageSource.getMessage("label.enterphone",null,locale);
		model.addAttribute("enterPhoneNo",enterphone);
		
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("CollegeCtl display method to display CollegeForm ended");
		return "College";
	}
	
	/**
     * Submit CollegeView.
      * @param locale:
     * 				Object of Locale 
     * @param operation:
     * 					Operation Given by user
     * @param form:
     * 				Object Of CollegeForm
     * @param model:
     * 				Object of Model Interface
     * @param bindingResult:
     * 						Object of BindingResult
     * @param session:
     * 					Object of HttpSession
     * @param locale:
     * 					Object Of Locale
     * @return College:
     * 				View of CollegeForm
     */
	@RequestMapping(value="/College", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, Model model, @ModelAttribute("form") @Valid CollegeForm form, BindingResult bindingResult, HttpSession session, Locale locale) {
		log.debug("CollegeCtl submit method to submit CollegeForm started");
		String entername=messageSource.getMessage("label.entercname",null,locale);
		model.addAttribute("enterName",entername);
		
		String enteraddress=messageSource.getMessage("label.enteraddress",null,locale);
		model.addAttribute("enterAddress",enteraddress);
		
		String enterstate=messageSource.getMessage("label.enterstate",null,locale);
		model.addAttribute("enterState",enterstate);
		
		String entercity=messageSource.getMessage("label.entercity",null,locale);
		model.addAttribute("enterCity",entercity);
		
		String enterphone =messageSource.getMessage("label.enterphone",null,locale);
		model.addAttribute("enterPhoneNo",enterphone);
		CollegeDTO dto = (CollegeDTO) form.getDto();
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			if(bindingResult.hasErrors()) {
				return "College";
			}
			try {
				if(dto.getId()>0) {
					service.update(dto);
					String msg=messageSource.getMessage("message.updatesuccess",null,locale);
				    model.addAttribute("success",msg);
				    model.addAttribute("id",dto.getId());
				    return "College";
				}else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg=messageSource.getMessage("message.success",null,locale);
					model.addAttribute("success",msg);
					form.populate(new CollegeDTO());
				}
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.collegename",null,locale);
			    model.addAttribute("error",msg);
			    return "College";
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/College/College";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/College/Search";
		}
		log.debug("CollegeCtl submit method to submit CollegeForm ended");
		return "College";
	}
	
	/**
     * Displays CollegeListView.
      * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of College Form
     * @param model:
     * 				Object of Model Interface
     * @return CollegeList:
     * 						View of College List
     */
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String display(@ModelAttribute("form") CollegeForm form, Model model,Locale locale) {
		log.debug("CollegeCtl display method to display CollegeList started");
		String entername=messageSource.getMessage("label.entercname",null,locale);
		model.addAttribute("enterName",entername);
		String enterstate=messageSource.getMessage("label.enterstate",null,locale);
		model.addAttribute("enterState",enterstate);
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		List next = service.search(new CollegeDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
        model.addAttribute("findList",service.search(null));
		log.debug("CollegeCtl display method to display CollegeList ended");
		return "CollegeList";
	}
	
	/**
     * Submit College List.
      * @param locale:
     * 				Object of Locale 
     * @param form:
     * 				Object of CollegeForm
     * @param model:
     * 				Object of Model Interface
     * @param operation:
     * 					Operation given by User
     * @param locale:
     * 					Locale Object
     * @return CollegeList:
     * 						View of CollegeList
     */ 
	@RequestMapping(value="/Search", method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") CollegeForm form, Model model, Locale locale) {
		log.debug("CollegeCtl submit method to submit CollegeList started");
		model.addAttribute("findList",service.search(null));
		int pageNo=form.getPageNo();
		if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		}else if(OP_DELETE.equalsIgnoreCase(operation)) {
			if(form.getChk_1()!=null) {
				for (long id : form.getChk_1()) {
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
	    CollegeDTO dto=(CollegeDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list",list);
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
			
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
	    
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/College/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/College/College";
		}else if(OP_BACK.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/College/Search";
		}
		log.debug("CollegeCtl submit method to submit CollegeList ended");
		return "CollegeList";
	}

}	

