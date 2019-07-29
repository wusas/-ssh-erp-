package com.erp.action;

import java.util.Iterator;
import java.util.List;

import com.erp.pojo.Client;
import com.erp.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport{
	
	private ClientService cs;
	private String resultContent;
	private String clientName;
	private int clientGrade;
	private Client client;
	private long clientId;
	private int pageCurrent;
	private String clientAddr;
	private String linkName;
	private int linkSex;
	private String linkTel;
	private int clientDel;
	
	public ClientService getCs() {
		return cs;
	}

	public void setCs(ClientService cs) {
		this.cs = cs;
	}

	public String getResultContent() {
		return resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getClientGrade() {
		return clientGrade;
	}

	public void setClientGrade(int clientGrade) {
		this.clientGrade = clientGrade;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	
	public String getClientAddr() {
		return clientAddr;
	}

	public void setClientAddr(String clientAddr) {
		this.clientAddr = clientAddr;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public int getLinkSex() {
		return linkSex;
	}

	public void setLinkSex(int linkSex) {
		this.linkSex = linkSex;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public int getClientDel() {
		return clientDel;
	}

	public void setClientDel(int clientDel) {
		this.clientDel = clientDel;
	}

	public String findBySome(){
		List<Client> list = this.cs.findByNameGrade(clientName, clientGrade, clientDel, pageCurrent);
		int count = this.cs.findCountByNameGrade(clientName, clientGrade, clientDel);
		StringBuffer sb = new StringBuffer();
		sb.append("<input type='hidden' id='count' value='" + count + "'>");
		sb.append("<table class='table table-hover table-bordered'>");
		sb.append("<tr><th>客户名称</th><th>客户地址</th><th>客户等级</th><th>联系人</th><th>联系人性别</th><th>联系人电话</th><th>操作</th></tr>");
		Iterator<Client> it = list.iterator();
		while (it.hasNext()) {
			Client pojo = it.next();
			String state = "低";
			String sex = "男";
			if (pojo.getClientGrade() == 3) {
				state = "低";
			} else if (pojo.getClientGrade() == 2) {
				state = "中";
			} else if (pojo.getClientGrade() == 1) {
				state = "高";
			}
			if(0 == pojo.getLinkSex()){
				sex = "女";
			}
			String button = "";
			if(clientDel == 0){
				button = "<a href='javascript:void(0)' onclick='goUpd(" + pojo.getClientId()+
					")'>修改</a><a href='javascript:void(0)' onclick='goDel(" + pojo.getClientId()+
					")'>删除</a>";
			}else if(clientDel == 1){
				button = "<a href='javascript:void(0)' onclick='goBack(" + pojo.getClientId()+
					")'>还原</a>";
			}
			sb.append("<tr><td>" + 
					this.checkNull(pojo.getClientName()) + "</td><td>"+
					this.checkNull(pojo.getClientAddr()) + "</td><td>"+
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
	
	public String findById(){
		Client c = this.cs.findByClientId(clientId);
		this.setClient(c);
		return "goUpd";
	}
	
	public String doUpd(){
		Client pojo = new Client(clientName, clientAddr, clientGrade, linkName, linkSex, linkTel, 0, null);
		pojo.setClientId(clientId);
		boolean bool = this.cs.doUpd(pojo);
		this.setResultContent(Boolean.toString(bool));
		return SUCCESS;
	}
	
	public String doIns(){
		Client pojo = new Client(clientName, clientAddr, clientGrade, linkName, linkSex, linkTel, 0, null);
		boolean flag = this.cs.doIns(pojo);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String doDel(){
		boolean flag = this.cs.doDel(clientId);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String doBack(){
		boolean flag = this.cs.doBack(clientId);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	//用来替换null
	public String checkNull(String source){
		if(null == source){
			return "空";
		}else return source;
	}
}
