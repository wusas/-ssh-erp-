package com.erp.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Long goodsId;
	private String goodsName;
	private Integer goodsStop;
	private Set saleDetails = new HashSet(0);
	private Set suppliers = new HashSet(0);
	private Set checkTables = new HashSet(0);
	private Set pcDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(String goodsName, Integer goodsStop, Set saleDetails, Set suppliers, Set checkTables, Set pcDetails) {
		this.goodsName = goodsName;
		this.goodsStop = goodsStop;
		this.saleDetails = saleDetails;
		this.suppliers = suppliers;
		this.checkTables = checkTables;
		this.pcDetails = pcDetails;
	}

	// Property accessors

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsStop() {
		return this.goodsStop;
	}

	public void setGoodsStop(Integer goodsStop) {
		this.goodsStop = goodsStop;
	}

	public Set getSaleDetails() {
		return this.saleDetails;
	}

	public void setSaleDetails(Set saleDetails) {
		this.saleDetails = saleDetails;
	}

	public Set getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Set suppliers) {
		this.suppliers = suppliers;
	}

	public Set getCheckTables() {
		return this.checkTables;
	}

	public void setCheckTables(Set checkTables) {
		this.checkTables = checkTables;
	}

	public Set getPcDetails() {
		return this.pcDetails;
	}

	public void setPcDetails(Set pcDetails) {
		this.pcDetails = pcDetails;
	}

}