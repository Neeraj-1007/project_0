package com.rays.orsproject0.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 * 
 */
public class ApplicationException extends Exception {

    /**
     * @param msg
     *            : Error message
     */
    public ApplicationException(String msg) {
        super(msg);
    }
}

