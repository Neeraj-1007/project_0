package com.rays.orsproject0.form;


import java.sql.Timestamp;

import com.rays.orsproject0.dto.BaseDTO;

public class BaseForm {

	
	/**
     * Contains non-business primary key
     */
	protected long id = 0 ;
	
	private Long[] chk_1;
	
	/**
     * Current page number
     */
	private int pageNo=1;
	
	
	/**
     * Number of records displayed on list page
     */
    private int pageSize = 5;

    /**
     * Value of button clicked
     */
    private String operation;

    /**
     * Created by User ID
     */
    protected String createdBy;

    /**
     * Modified by User ID
     */
    protected String modifiedBy;

    /**
     * Record created datetime
     */
    protected long createdDatetime;

    /**
     * Record last modified datetime
     */
    protected long modifiedDatetime;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long[] getChk_1() {
		return chk_1;
	}

	public void setChk_1(Long[] chk_1) {
		this.chk_1 = chk_1;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


    
	public long getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(long createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public long getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(long modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

    

    /**
     * Converts from into dto.
     * 
     * @return dto:
     * 				Object of BaseDTO
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Converts fto into form.
     * 
     * @param bDto:
     * 				Object of BaseDTO
     */
    public void populate(BaseDTO bDto) {

    }

}
