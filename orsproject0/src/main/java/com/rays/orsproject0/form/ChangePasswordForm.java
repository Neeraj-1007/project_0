package com.rays.orsproject0.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains Change Password form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0 Copyright (c) Chain of Responsibility
 */
public class ChangePasswordForm extends BaseForm{
	
	/**
	 * oldPassword of ChangePassword
	 *
	 */
    @NotEmpty
    private String oldPassword;
    /**
	 * newPassword of ChangePassword
	 *
	 */
    @NotEmpty
    private String newPassword;
    /**
	 * confirmPassword of ChangePassword
	 *
	 */
    @NotEmpty
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
