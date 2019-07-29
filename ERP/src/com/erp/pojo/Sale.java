package com.erp.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sale entity. @author MyEclipse Persistence Tools
 */

public class Sale implements java.io.Serializable {

	// Fields

	private Long saleId;
	private Emp emp;
	private Client client;
	private String saleName;
	private Double saleAll;
	private Date saleDate;
	private Integer saleState;
	private Integer saleDel;
	private Set saleDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sale() {
	}

	/** full constructor */
	public Sale(Emp emp, Client client, String saleName, Double saleAll, Date saleDate, Integer saleState,
			Integer saleDel, Set saleDetails) {
		this.emp = emp;
		this.client = client;
		this.saleName = saleName;
		this.saleAll = saleAll;
		this.saleDate = saleDate;
		this.saleState = saleState;
		this.saleDel = saleDel;
		this.saleDetails = saleDetails;
	}

	// Property accessors

	public Long getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getSaleName() {
		return this.saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public Double getSaleAll() {
		return this.saleAll;
	}

	public void setSaleAll(Double saleAll) {
		this.saleAll = saleAll;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Integer getSaleState() {
		return this.saleState;
	}

	public void setSaleState(Integer saleState) {
		this.saleState = saleState;
	}

	public Integer getSaleDel() {
		return this.saleDel;
	}

	public void setSaleDel(Integer saleDel) {
		this.saleDel = saleDel;
	}

	public Set getSaleDetails() {
		return this.saleDetails;
	}

	public void setSaleDetails(Set saleDetails) {
		this.saleDetails = saleDetails;
	}

}