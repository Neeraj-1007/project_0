package com.rays.orsproject0.ctl;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Base Controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow.
 * 
 * @author Neeraj
 */
public class BaseCtl {
	
	/**
     * Operation constants
     */
	protected static final String OP_SAVE = "Save";
    protected static final String OP_CHANGEPASSWORD = "ChangePassword";
    protected static final String OP_SEARCH = "Search";
    protected static final String OP_NEW = "New";
    protected static final String OP_BACK = "Back";
    protected static final String OP_DELETE = "Delete";
    protected static final String OP_CANCEL = "Cancel";
    protected static final String OP_RESET = "Reset";  
    protected static final String OP_ERROR = "Error";
    protected static final String OP_NEXT = "Next";
    protected static final String OP_PREVIOUS = "Previous";
    protected static final String OP_LOGOUT = "Logout";
    protected static final String OP_GO = "Go";
    protected static final String OP_GET = "Get";
    public static final String Physics = "Physics";
	public static final String Chemistry = "Chemistry";
	public static final String MATHS = "Maths";
	public static final int MAX_MARKS = 100;
	public static final int MIN_MARKS = 35;
	public static final int TOTAL_MARKS = MAX_MARKS * 3;

    
    /**
     * Loads preloaded data and stores in Model object.
     * @param model : the model object
     */
    @ModelAttribute
    public void preload(Model model) {
        System.out.println("this is preload method");
    }
	
}
