package com.rays.orsproject0.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author Chain of Responsibility		
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 * 
 */

public class DuplicateRecordException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}
