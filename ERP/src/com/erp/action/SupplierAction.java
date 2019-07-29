package com.erp.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.erp.pojo.Goods;
import com.erp.pojo.Supplier;
import com.erp.service.SupplierService;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport{
	private SupplierService ss;
	private String resultContent;
	private long supplierId;
	private String supplierName;
	private String supplierAddr;
	private Integer supplierGrade;
	private String linkName;
	private Integer linkSex;
	private String linkTel;
	private Supplier supplier;
	private int pageCurrent;
	private int supplierDel;
	
	public SupplierService getSs() {
		return ss;
	}

	public void setSs(SupplierService ss) {
		this.ss = ss;
	}

	public String getResultContent() {
		return resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddr() {
		return supplierAddr;
	}

	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

	public Integer getSupplierGrade() {
		return supplierGrade;
	}

	public void setSupplierGrade(Integer supplierGrade) {
		this.supplierGrade = supplierGrade;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Integer getLinkSex() {
		return linkSex;
	}

	public void setLinkSex(Integer linkSex) {
		this.linkSex = linkSex;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getSupplierDel() {
		return supplierDel;
	}

	public void setSupplierDel(int supplierDel) {
		this.supplierDel = supplierDel;
	}

	public String findBySome(){
		List<Supplier> list = this.ss.findByNameGrade(supplierName, supplierGrade, supplierDel, pageCurrent);
		int count = this.ss.findCountByNameGrade(supplierName, supplierGrade ,supplierDel);
		StringBuffer sb = new StringBuffer();
		sb.append("<input type='hidden' id='count' value='" + count + "'>");
		sb.append("<table class='table table-hover table-bordered'>");
		sb.append("<tr><th>供应商名称</th><th>供应商地址</th><th>供应商等级</th><th>联系人</th><th>联系人性别</th><th>联系人电话</th><th>操作</th></tr>");
		Iterator<Supplier> it = list.iterator();
		while (it.hasNext()) {
			Supplier pojo = it.next();
			String state = "低";
			String sex = "男";
			if (pojo.getSupplierGrade() == 3) {
				state = "低";
			} else if (pojo.getSupplierGrade() == 2) {
				state = "中";
			} else if (pojo.getSupplierGrade() == 1) {
				state = "高";
			}
			if(0 == pojo.getLinkSex()){
				sex = "女";
			}
			String button = "";
			if(0 == supplierDel){
				button = "<a href='javascript:void(0)' onclick='goUpd(" + pojo.getSupplierId()+
					")'>修改</a><a href='javascript:void(0)' onclick='goDel(" + pojo.getSupplierId()+
					")'>删除</a>";
			}else if(1 == supplierDel){
				button = "<a href='javascript:void(0)' onclick='goBack(" + pojo.getSupplierId()+
					")'>还原</a>";
			}
			sb.append("<tr><td>" + 
					this.checkNull(pojo.getSupplierName()) + "</td><td>"+
					this.checkNull(pojo.getSupplierAddr()) + "</td><td>"+
					state + "</td><td>"+
					this.checkNull(pojo.getLinkName()) + "</td><td>"+
					sex + "</td><td>"+
					this.checkNull(pojo.getLinkTel()) + "</td>"+
					"<td>"+button+"</td></tr>");
		}
		sb.append("</table>");
		this.setResultContent(sb.toString());
		return SUCCESS;
	}
	
	public String doIns(){
		Supplier pojo = new Supplier(supplierName, supplierAddr, supplierGrade, linkName, linkSex, linkTel, 0, null, null);
		boolean flag = this.ss.doIns(pojo);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String doDel(){
		boolean flag = this.ss.doDel(supplierId);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String findById(){
		Supplier pojo = this.ss.findByClientId(supplierId);
		this.setSupplier(pojo);
		return "goUpd";
	}
	
	public String doUpd(){
		Supplier pojo = new Supplier(supplierName, supplierAddr, supplierGrade, linkName, linkSex, linkTel, 0, null, null);
		pojo.setSupplierId(supplierId);
		boolean bool = this.ss.doUpd(pojo);
		this.setResultContent(Boolean.toString(bool));
		return SUCCESS;
	}
	
	public String showSupp(){
		List<Supplier> list = this.ss.findAll();
		StringBuffer sb = new StringBuffer();
		int index = 5;
		for(Supplier mp : list ){
			sb.append("<input type='checkbox' name='supplierId' value="+mp.getSupplierId()+" />"+mp.getSupplierName() );
	 		index--;
	 		if(index==0){
	 			sb.append("<br>");
	 			index =5;
	 		}
	 	}
		this.setResultContent(sb.toString());
		return SUCCESS;
	}
	
	public String doBack(){
		boolean flag = this.ss.doBack(supplierId);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String checkNull(String source){
		if(null == source){
			return "空";
		}else return source;
	}
}
