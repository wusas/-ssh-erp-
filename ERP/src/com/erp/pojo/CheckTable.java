package com.erp.pojo;

import java.util.Date;

/**
 * CheckTable entity. @author MyEclipse Persistence Tools
 */

public class CheckTable implements java.io.Serializable {

	// Fields

	private Long checkId;
	private Emp emp;
	private Goods goods;
	private Date checkDate;
	private Long checkCal;
	private Long checkPerson;

	// Constructors

	/** default constructor */
	public CheckTable() {
	}

	/** full constructor */
	public CheckTable(Emp emp, Goods goods, Date checkDate, Long checkCal, Long checkPerson) {
		this.emp = emp;
		this.goods = goods;
		this.checkDate = checkDate;
		this.checkCal = checkCal;
		this.checkPerson = checkPerson;
	}

	// Property accessors

	public Long getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Long getCheckCal() {
		return this.checkCal;
	}

	public void setCheckCal(Long checkCal) {
		this.checkCal = checkCal;
	}

	public Long getCheckPerson() {
		return this.checkPerson;
	}

	public void setCheckPerson(Long checkPerson) {
		this.checkPerson = checkPerson;
	}

}