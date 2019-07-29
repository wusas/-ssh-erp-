package com.erp.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */

public class Purchase implements java.io.Serializable {

	// Fields

	private Long purchaseId;
	private Emp emp;
	private Supplier supplier;
	private String purchaseName;
	private Double purchaseAll;
	private Integer purchaseState;
	private Date purchaseDate;
	private Integer purchaseDel;
	private Set pcDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** full constructor */
	public Purchase(Emp emp, Supplier supplier, String purchaseName, Double purchaseAll, Integer purchaseState,
			Date purchaseDate, Integer purchaseDel, Set pcDetails) {
		this.emp = emp;
		this.supplier = supplier;
		this.purchaseName = purchaseName;
		this.purchaseAll = purchaseAll;
		this.purchaseState = purchaseState;
		this.purchaseDate = purchaseDate;
		this.purchaseDel = purchaseDel;
		this.pcDetails = pcDetails;
	}

	// Property accessors

	public Long getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getPurchaseName() {
		return this.purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public Double getPurchaseAll() {
		return this.purchaseAll;
	}

	public void setPurchaseAll(Double purchaseAll) {
		this.purchaseAll = purchaseAll;
	}

	public Integer getPurchaseState() {
		return this.purchaseState;
	}

	public void setPurchaseState(Integer purchaseState) {
		this.purchaseState = purchaseState;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getPurchaseDel() {
		return this.purchaseDel;
	}

	public void setPurchaseDel(Integer purchaseDel) {
		this.purchaseDel = purchaseDel;
	}

	public Set getPcDetails() {
		return this.pcDetails;
	}

	public void setPcDetails(Set pcDetails) {
		this.pcDetails = pcDetails;
	}

}