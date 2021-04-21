package com.rays.orsproject0.exception;
/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 * 
 */

public class RecordNotFoundException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public RecordNotFoundException(String msg) {
        super(msg);

    }
}
