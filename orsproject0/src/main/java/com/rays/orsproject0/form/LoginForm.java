package com.rays.orsproject0.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains Login form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 * 
 */
public class LoginForm extends BaseForm{

	/**
	 * email of LoginForm
	 */
	@NotEmpty
	@Email
	private String emailId;
	
	/**
	 * password of LoginForm
	 */
	@NotEmpty
	@Size(min=2,max=10)
	private String password;
	
	private String uri=null;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
