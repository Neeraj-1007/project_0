package com.rays.orsproject0.dto;

/**
 * DropdownList interface is implemented by DTOs those are used to create drop
 * down list on HTML pages
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * Copyright (c) Chain of Responsibility
 */

public interface DropdownList {
	/**
	 * Returns key of list element
	 * 
	 * @return key : the key
	 */
	public String getKey();

	/**
	 * Returns display text of list element
	 * 
	 * @return value : the string
	 */
	public String getValue();
}
