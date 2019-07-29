package com.erp.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */

public class Client implements java.io.Serializable {

	// Fields

	private Long clientId;
	private String clientName;
	private String clientAddr;
	private Integer clientGrade;
	private String linkName;
	private Integer linkSex;
	private String linkTel;
	private Integer clientDel;
	private Set sales = new HashSet(0);

	// Constructors

	/** default constructor */
	public Client() {
	}

	/** full constructor */
	public Client(String clientName, String clientAddr, Integer clientGrade, String linkName, Integer linkSex,
			String linkTel, Integer clientDel, Set sales) {
		this.clientName = clientName;
		this.clientAddr = clientAddr;
		this.clientGrade = clientGrade;
		this.linkName = linkName;
		this.linkSex = linkSex;
		this.linkTel = linkTel;
		this.clientDel = clientDel;
		this.sales = sales;
	}

	// Property accessors

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddr() {
		return this.clientAddr;
	}

	public void setClientAddr(String clientAddr) {
		this.clientAddr = clientAddr;
	}

	public Integer getClientGrade() {
		return this.clientGrade;
	}

	public void setClientGrade(Integer clientGrade) {
		this.clientGrade = clientGrade;
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

	public Integer getClientDel() {
		return this.clientDel;
	}

	public void setClientDel(Integer clientDel) {
		this.clientDel = clientDel;
	}

	public Set getSales() {
		return this.sales;
	}

	public void setSales(Set sales) {
		this.sales = sales;
	}

}