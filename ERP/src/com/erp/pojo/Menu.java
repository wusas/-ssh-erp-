package com.erp.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Long menuId;
	private String menuName;
	private String menuUrl;
	private Set depts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(String menuName, String menuUrl, Set depts) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.depts = depts;
	}

	// Property accessors

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Set getDepts() {
		return this.depts;
	}

	public void setDepts(Set depts) {
		this.depts = depts;
	}

}