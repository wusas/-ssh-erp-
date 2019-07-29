package com.erp.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.erp.pojo.Goods;
import com.erp.pojo.Supplier;
import com.erp.service.GoodsService;
import com.erp.service.SupplierService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GoodsAction extends ActionSupport{
	private GoodsService gs;
	private long goodsId;
	private String goodsName;
	private int goodsStop;
	private int pageCurrent;
	private Goods goods;
	private String resultContent;
	private SupplierService ss;
	private String checkSupp;
	private JSONArray jsonA;
	

	public JSONArray getJsonA() {
		return jsonA;
	}

	public void setJsonA(JSONArray jsonA) {
		this.jsonA = jsonA;
	}

	public GoodsService getGs() {
		return gs;
	}

	public void setGs(GoodsService gs) {
		this.gs = gs;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsStop() {
		return goodsStop;
	}

	public void setGoodsStop(int goodsStop) {
		this.goodsStop = goodsStop;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public String getResultContent() {
		return resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

	public SupplierService getSs() {
		return ss;
	}

	public void setSs(SupplierService ss) {
		this.ss = ss;
	}

	public String getCheckSupp() {
		return checkSupp;
	}

	public void setCheckSupp(String checkSupp) {
		this.checkSupp = checkSupp;
	}

	@SuppressWarnings("unchecked")
	public String findBySome(){
		List<Goods> list = this.gs.findByGoodsNameGoodsStop(goodsName, goodsStop, pageCurrent);
		int count = this.gs.findCountByGoodsNameGoodsStop(goodsName, goodsStop);
		StringBuffer sb = new StringBuffer();
		sb.append("<input type='hidden' id='count' value='" + count + "'>");
		sb.append("<table class='table table-hover table-bordered'>");
		sb.append("<tr><th>商品名</th><th>是否停售</th><th>供应商</th><th>操作</th></tr>");
		for(Goods pojo : list){
			String state = "是";
			if(0 == pojo.getGoodsStop()){
				state = "否";
			}
			Set<Supplier> suppliers = pojo.getSuppliers();
			String su = "";
			for(Supplier s: suppliers){
				su+= s.getSupplierName()+"&nbsp;";
			}
			sb.append("<tr><td>" + 
					this.checkNull(pojo.getGoodsName()) + "</td><td>"+
					state + "</td><td>"+
					su + "</td><td><a href='javascript:void(0)' onclick='goUpd(" + pojo.getGoodsId()+
					")'>修改</a></td></tr>");
			}
		sb.append("</table>");
		this.setResultContent(sb.toString());
		return SUCCESS;
	}
	
	public String findById(){
		Goods c = this.gs.findById(goodsId);
		this.setGoods(c);
		return "goUpd";
	}
	
	public String doUpd(){
		Set<Supplier> set = new HashSet<Supplier>();
		String[] supplierIds = checkSupp.trim().split(",");
		for(String str : supplierIds){
			long l = Long.parseLong(str);
			Supplier s = this.ss.findByClientId(l);
			set.add(s);
		}
		Goods pojo = new Goods(goodsName, goodsStop, null, set, null, null);
		pojo.setGoodsId(goodsId);
		boolean bool = this.gs.doUpd(pojo);
		this.setResultContent(Boolean.toString(bool));
		return SUCCESS;
	}
	
	public String doIns(){
		Set<Supplier> set = new HashSet<Supplier>();
		String[] supplierIds = checkSupp.trim().split(",");
		for(String str : supplierIds){
			long l = Long.parseLong(str);
			Supplier s = this.ss.findByClientId(l);
			set.add(s);
		}
		Goods pojo = new Goods(goodsName, goodsStop, null, set, null, null);
		boolean flag = this.gs.doIns(pojo);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String showSupp(){
		List<Supplier> list = this.ss.findAll();
		Set<Supplier> suppliers = this.gs.findById(goodsId).getSuppliers();
		List<Long> in2 = new ArrayList<Long>();
		for(Supplier s : suppliers){
			in2.add(s.getSupplierId());
		}
		StringBuffer sb = new StringBuffer();
		int index = 5;
		for(Supplier mp : list ){
			if(-1 != in2.indexOf(mp.getSupplierId())){
				sb.append("<input type='checkbox' name='supplierId' value="+mp.getSupplierId()+" checked='checked' />"+mp.getSupplierName() );
			}else {
				sb.append("<input type='checkbox' name='supplierId' value="+mp.getSupplierId()+" />"+mp.getSupplierName() );
			}
	 		index--;
	 		if(index==0){
	 			sb.append("<br>");
	 			index =5;
	 		}
	 	}
		this.setResultContent(sb.toString());
		return SUCCESS;
	}
	
	public String findGoods(){
		List<Goods> goodslist = this.gs.findAll();
		jsonA = new JSONArray();
		for(Goods g:goodslist){
			JSONObject jsonO = new JSONObject();
			jsonO.put("GoodsName",g.getGoodsName() );
			jsonO.put("GoodsId", g.getGoodsId());
			jsonA.add(jsonO);
		}
		return "goodsList";
	}
	
	//用来替换null
	public String checkNull(String source){
		if(null == source){
			return "空";
		}else return source;
	}
}
