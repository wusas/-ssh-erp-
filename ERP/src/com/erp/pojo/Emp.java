package com.erp.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Long empId;
	private Dept dept;
	private String empName;
	private Long empSfnum;
	private Integer empSex;
	private Date empBir;
	private String empPic;
	private String loginName;
	private String loginPass;
	private Integer empLeave;
	private Set checkTables = new HashSet(0);
	private Set sales = new HashSet(0);
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(Dept dept, String empName, Long empSfnum, Integer empSex, Date empBir, String empPic, String loginName,
			String loginPass, Integer empLeave, Set checkTables, Set sales, Set purchases) {
		this.dept = dept;
		this.empName = empName;
		this.empSfnum = empSfnum;
		this.empSex = empSex;
		this.empBir = empBir;
		this.empPic = empPic;
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.empLeave = empLeave;
		this.checkTables = checkTables;
		this.sales = sales;
		this.purchases = purchases;
	}
	public Emp(Dept dept, String empName, Long empSfnum, Integer empSex, Date empBir, String empPic, String loginName,
			String loginPass) {
		this.dept = dept;
		this.empName = empName;
		this.empSfnum = empSfnum;
		this.empSex = empSex;
		this.empBir = empBir;
		this.empPic = empPic;
		this.loginName = loginName;
		this.loginPass = loginPass;
	}
	public Emp(Dept dept, String empName, Long empSfnum, Integer empSex, Date empBir, String empPic, String loginName,
			String loginPass, Integer empLeave) {
		this.dept = dept;
		this.empName = empName;
		this.empSfnum = empSfnum;
		this.empSex = empSex;
		this.empBir = empBir;
		this.empPic = empPic;
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.empLeave = empLeave;
	}
	public Emp(String empName, Long empSfnum,  Date empBir, String loginPass) {
		this.empName = empName;
		this.empSfnum = empSfnum;
		this.empBir = empBir;
		this.loginPass = loginPass;
	}
	// Property accessors

	public Long getEmpId() {
		return this.empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getEmpSfnum() {
		return this.empSfnum;
	}

	public void setEmpSfnum(Long empSfnum) {
		this.empSfnum = empSfnum;
	}

	public Integer getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}

	public Date getEmpBir() {
		return this.empBir;
	}

	public void setEmpBir(Date empBir) {
		this.empBir = empBir;
	}

	public String getEmpPic() {
		return this.empPic;
	}

	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPass() {
		return this.loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public Integer getEmpLeave() {
		return this.empLeave;
	}

	public void setEmpLeave(Integer empLeave) {
		this.empLeave = empLeave;
	}

	public Set getCheckTables() {
		return this.checkTables;
	}

	public void setCheckTables(Set checkTables) {
		this.checkTables = checkTables;
	}

	public Set getSales() {
		return this.sales;
	}

	public void setSales(Set sales) {
		this.sales = sales;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}