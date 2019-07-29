package com.erp.action;

import java.util.Iterator;
import java.util.List;

import com.erp.pojo.CheckTable;
import com.erp.pojo.TbvNewDetail;
import com.erp.service.CheckTableService;
import com.erp.service.TbvNewDetailService;

public class TbvNewDetailAction {
	private TbvNewDetailService service;
	private String resultContent;
	private Long checkId;
	private Long goodsId;
	private int id;

	private int pageCurrent;
	private TbvNewDetail pojo;
	public TbvNewDetailService getService() {
		return service;
	}
	public void setService(TbvNewDetailService service) {
		this.service = service;
	}
	public String getResultContent() {
		return resultContent;
	}
	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}
	public Long getCheckId() {
		return checkId;
	}
	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public TbvNewDetail getPojo() {
		return pojo;
	}
	public void setPojo(TbvNewDetail pojo) {
		this.pojo = pojo;
	}
	
	
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	
	public String findById(){
		    TbvNewDetail abc = this.service.findById(goodsId);
			this.setPojo(abc);
			return "suc";
		}
	 
	 public String findAll(){
		 List<TbvNewDetail> list = this.service.findGoods(pageCurrent);
		 int count = this.service.findCountGoods();
		 System.out.println(count);
		 StringBuffer sb  = new StringBuffer();
		    sb.append("<input type = 'hidden' id = 'count' value= '"+count+"'>");
			sb.append("<table class='table table-hover table-bordered'>");
			sb.append("<tr><th>商品名</th><th>计算库余量</th><th>盘点库余量</th><th>操作</th></tr>");
			Iterator<TbvNewDetail> it = list.iterator();
			while(it.hasNext()){
				TbvNewDetail pojo =it.next();
				sb.append("<tr><td>"+pojo.getId().getGoodsName()+"</td><td>"
						+pojo.getId().getDetail()
						+"</td><td>"+"请盘算"+"</td>");
//						if(pojo.getCheckDate() >= cd){
//							
//						}
						sb.append("</td><td><a href='#' onclick='goUpd(" + pojo.getId().getGoodsId()+ ")'>盘算</tr>");
			}
			sb.append("</table>");
			this.setResultContent(sb.toString());
			return "success";
	 }
	
	

}
