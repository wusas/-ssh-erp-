package com.erp.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Long supplierId;
	private String supplierName;
	private String supplierAddr;
	private Integer supplierGrade;
	private String linkName;
	private Integer linkSex;
	private String linkTel;
	private Integer supplierDel;
	private Set goodses = new HashSet(0);
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** full constructor */
	public Supplier(String supplierName, String supplierAddr, Integer supplierGrade, String linkName, Integer linkSex,
			String linkTel, Integer supplierDel, Set goodses, Set purchases) {
		this.supplierName = supplierName;
		this.supplierAddr = supplierAddr;
		this.supplierGrade = supplierGrade;
		this.linkName = linkName;
		this.linkSex = linkSex;
		this.linkTel = linkTel;
		this.supplierDel = supplierDel;
		this.goodses = goodses;
		this.purchases = purchases;
	}

	// Property accessors

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddr() {
		return this.supplierAddr;
	}

	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

	public Integer getSupplierGrade() {
		return this.supplierGrade;
	}

	public void setSupplierGrade(Integer supplierGrade) {
		this.supplierGrade = supplierGrade;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Integer getLinkSex() {
		return this.linkSex;
	}

	public void setLinkSex(Integer linkSex) {
		this.linkSex = linkSex;
	}

	public String getLinkTel() {
		return this.linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public Integer getSupplierDel() {
		return this.supplierDel;
	}

	public void setSupplierDel(Integer supplierDel) {
		this.supplierDel = supplierDel;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}