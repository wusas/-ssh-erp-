package com.erp.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erp.pojo.Client;
import com.erp.pojo.Goods;
import com.erp.pojo.Sale;
import com.erp.pojo.SaleDetail;
import com.erp.service.ClientService;
import com.erp.service.GoodsService;
import com.erp.service.SaleDetailService;
import com.erp.service.SaleService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SaleAction extends ActionSupport{
	private SaleService ss;
	private String resultContent;
	private String saleName;
	private long clientId;
	private long empId;
	private Date startDate;
	private Date endDate;
	private int saleState;
	private int saleDel;
	private int pagecur;
	private JSONArray jsonA;
	private GoodsService gs;
	private ClientService cs;
	private SaleDetailService sds;
	private String sixgoods;
	private String sixnum;
	private String sixprice;
	private String sixDeId;
	private long saleId;
	private List<SaleDetail> lists;
	private double saleAll;
	
	
	public double getSaleAll() {
		return saleAll;
	}

	public void setSaleAll(double saleAll) {
		this.saleAll = saleAll;
	}

	public String getSixDeId() {
		return sixDeId;
	}

	public void setSixDeId(String sixDeId) {
		this.sixDeId = sixDeId;
	}

	public List<SaleDetail> getLists() {
		return lists;
	}

	public void setLists(List<SaleDetail> lists) {
		this.lists = lists;
	}

	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public SaleService getSs() {
		return ss;
	}

	public void setSs(SaleService ss) {
		this.ss = ss;
	}

	public String getResultContent() {
		return resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSaleState() {
		return saleState;
	}

	public void setSaleState(int saleState) {
		this.saleState = saleState;
	}

	public int getSaleDel() {
		return saleDel;
	}

	public void setSaleDel(int saleDel) {
		this.saleDel = saleDel;
	}

	public int getPagecur() {
		return pagecur;
	}

	public void setPagecur(int pagecur) {
		this.pagecur = pagecur;
	}

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

	public ClientService getCs() {
		return cs;
	}

	public void setCs(ClientService cs) {
		this.cs = cs;
	}

	public String getSixgoods() {
		return sixgoods;
	}

	public void setSixgoods(String sixgoods) {
		this.sixgoods = sixgoods;
	}

	public String getSixnum() {
		return sixnum;
	}

	public void setSixnum(String sixnum) {
		this.sixnum = sixnum;
	}

	public String getSixprice() {
		return sixprice;
	}

	public void setSixprice(String sixprice) {
		this.sixprice = sixprice;
	}

	public SaleDetailService getSds() {
		return sds;
	}

	public void setSds(SaleDetailService sds) {
		this.sds = sds;
	}

		public String findBySome(){
			List<Sale> list = this.ss.findByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel, pagecur);
			int count = this.ss.findCountByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel);
			StringBuffer sb = new StringBuffer();
			sb.append("<input type='hidden' id='count' value='" + count + "'>");
			sb.append("<table  class='table table-hover table-bordered'>");
			sb.append("<tr><th>销售单名</th><th>职工</th><th>客户</th><th>总价</th>	"
					+ "<th>销售时间</th><th>当前状态</th><th>是否删除</th><th>操作</th></tr>");
			for (Sale s : list) {
				String state = "";
				if(1 == s.getSaleState()){
					state = "只拟定订单";
				}else if(2 == s.getSaleState()){
					state = "已出库";
				}else if(3 == s.getSaleState()){
					state = "已结算";
				}
				String del = "否";
				if(1 == s.getSaleDel()){
					del = "是";
				}
				double all = 0;
				if(null != s.getSaleAll()){
					all = s.getSaleAll();
				}
				String button = ""; 
				 if(s.getSaleState() == 1){
				 	button = "<a href='javascript:void(0)' onclick='goDel(" + s.getSaleId()+")'>删除</a>";
				 }
				sb.append("<tr><td>" + 
						this.checkNull(s.getSaleName()) + "</td><td>"+
						"空" + "</td><td>"+
						this.checkNull(s.getClient().getClientName()) + "</td><td>"+
						all + "</td><td>"+
						checkNull(s.getSaleDate().toString()) + "</td><td>"+
						state + "</td><td>"+
						del + "</td><td>"+
						"<a href='javascript:void(0)' onclick='goShow(" + s.getSaleId()+")'>查看明细</a>"+button+"</td></tr>");
			}
			sb.append("</table>");
			this.setResultContent(sb.toString());
			return "succ";
		}

		public String checkOut(){
			List<Sale> list = this.ss.findByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel, pagecur);
			int count = this.ss.findCountByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel);
			StringBuffer sb = new StringBuffer();
			sb.append("<input type='hidden' id='count' value='" + count + "'>");
			sb.append("<table  class='navbar-form navbar-left'>");
			sb.append("<tr><th>销售单名</th><th>职工</th><th>客户</th><th>总价</th>	"
					+ "<th>销售时间</th><th>当前状态</th><th>是否删除</th><th>操作</th></tr>");
			for (Sale s : list) {
				String state = "";
				if(1 == s.getSaleState()){
					state = "只拟定订单";
				}else if(2 == s.getSaleState()){
					state = "已出库";
				}else if(3 == s.getSaleState()){
					state = "已结算";
				}
				String del = "否";
				if(1 == s.getSaleDel()){
					del = "是";
				}
				double all = 0;
				if(null != s.getSaleAll()){
					all = s.getSaleAll();
				}
				String button = "";
				if(2 > s.getSaleState() && 0 == s.getSaleDel()){
					button = "<a href='javascript:void(0)' onclick='goOut(" + s.getSaleId()+")'>出库</a>";
				}
				sb.append("<tr><td>" + 
						this.checkNull(s.getSaleName()) + "</td><td>"+
						"空" + "</td><td>"+
						this.checkNull(s.getClient().getClientName()) + "</td><td>"+
						all + "</td><td>"+
						checkNull(s.getSaleDate().toString()) + "</td><td>"+
						state + "</td><td>"+
						del + "</td><td>"+
						button+"</td></tr>");
			}
			sb.append("</table>");
			this.setResultContent(sb.toString());
			return "succ";
		}

		public String doOut(){
			boolean flag = this.ss.doOut(saleId);
			this.setResultContent(Boolean.toString(flag));
			return SUCCESS;
		}
	
	public String findGoods(){
		jsonA = new JSONArray();
		List<Goods> list2 = this.gs.findAll();
		for(Goods g : list2){
				JSONObject jsonO = new JSONObject();
				jsonO.put("goodsName", g.getGoodsName());
				jsonO.put("goodsId", g.getGoodsId());
				jsonO.put("goodsStop", g.getGoodsStop());
				jsonA.add(jsonO);
		}
		return SUCCESS;
	}
	public String findClient(){
		jsonA = new JSONArray();
		List<Client> list = this.cs.findAll();
		for(Client c : list){
				JSONObject jsonO = new JSONObject();
				jsonO.put("clientName", c.getClientName());
				jsonO.put("clientId", c.getClientId());
				jsonO.put("clientDel", c.getClientDel());
				jsonA.add(jsonO);
		}
		return SUCCESS;
	}
	
	public String doIns(){
		jsonA = new JSONArray();
		String[] sg = sixgoods.trim().split(",");
		String[] sn = sixnum.trim().split(",");
		String[] sp = sixprice.trim().split(",");
		double saleAll = 0;
		for(int i = 0 ;i<sp.length;i++){
			saleAll += Integer.parseInt(sp[i])*Double.parseDouble(sn[i]);
		}
		Date date = new Date();
		Client client1 = this.cs.findByClientId(clientId);
		//需要职工
		Sale sale = new Sale(null, client1, saleName, saleAll, date, 1, 0, null);
		Sale sale1 = this.ss.doIns(sale);
		boolean flag = true;
		for(int i = 0;i<sg.length;i++){
			Goods goods = this.gs.findById(Long.parseLong(sg[i]));
			SaleDetail sd = new SaleDetail(sale1, goods, Double.parseDouble(sn[i]), Integer.parseInt(sp[i]), 0);
			if(!this.sds.doIns(sd)){
				flag =false;
				break;
			}
		}
		JSONObject jsonO = new JSONObject();
		jsonO.put("flag", flag);
		jsonA.add(jsonO);
		return SUCCESS;
	}
	
	public String doUpd(){
		jsonA = new JSONArray();
		String[] sg = sixgoods.trim().split(",");
		String[] sn = sixnum.trim().split(",");
		String[] sp = sixprice.trim().split(",");
		String[] si = sixDeId.trim().split(",");
		double saleAll = 0;
		for(int i = 0 ;i<sp.length;i++){
			saleAll += Double.parseDouble(sp[i])*Integer.parseInt(sn[i]);
		}
		Date date = new Date();
		//需要职工
		Client client = this.cs.findByClientId(clientId);
		Sale sale = new Sale(null, client, saleName, saleAll, date, saleState, saleDel, null);
		sale.setSaleId(saleId);
		boolean flag = false;
		if(this.ss.doUpd(sale)){
			flag = true;
			for(int i = 0;i<sg.length;i++){
				Goods goods = this.gs.findById(Long.parseLong(sg[i]));
				SaleDetail sd = new SaleDetail(sale, goods,  Double.parseDouble(sp[i]),Integer.parseInt(sn[i]), 0);
				sd.setSaleDetailId(Long.parseLong(si[i]));
				if(!this.sds.doUpd(sd)){
					flag =false;
					break;
				}
			}
		}
		JSONObject jsonO = new JSONObject();
		jsonO.put("flag", flag);
		jsonA.add(jsonO);
		return SUCCESS;
	}
	
	public String findById(){
		Sale sale = this.ss.findBySaleId(saleId);
		List<SaleDetail> list = this.sds.findById(sale);
		StringBuffer sb = new StringBuffer();
		List<Goods> list1 = this.gs.findAll();
		sb.append("<input type='hidden' name='number' id='number' value='"+list.size()+"' />");
		sb.append("<input type='hidden' name='saleId' id='saleId' value='"+sale.getSaleId()+"' />");
		sb.append("<input type='hidden' name='clientId' id='clientId' value='"+sale.getClient().getClientId()+"' />");
		sb.append("<input type='hidden' name='state' id='state' value='"+sale.getSaleState()+"' />");
		sb.append("<input type='hidden' name='del' id='del' value='"+sale.getSaleDel()+"' />");
		sb.append("<input type='hidden' name='saleName' id='saleName' value='"+sale.getSaleName()+"' />");
		sb.append("<table id='goodsAdd'><tr><th>商品</th><th>单价</th><th>数量</th></tr>");
		 for(int i = 0 ; i<list.size(); i++){ 
			 int j = i+1;
			String good = "<option value=''>请选择商品</option>";
			for(Goods g:list1){
				if(0 == g.getGoodsStop()){
					if(g.getGoodsId() == list.get(i).getGoods().getGoodsId()){
						good += "<option value='"+g.getGoodsId()+"' selected='selected'>"+g.getGoodsName()+"</option>";
					}else{
						good += "<option value='"+g.getGoodsId()+"'>"+g.getGoodsName()+"</option>";
					}
				}
			}
			sb.append("<tr><td><select class='showGoods' name='goods" + j + "'>" + good + "</select></td>");
			sb.append("<td><input type='text' name='price"+j+"' value='"+list.get(i).getSaleDetailPrice()+"'/></td>");
			sb.append("<td><input type='text' name='num"+j+"' value='"+list.get(i).getSaleDetailNum()+"' />"
					+ "<input type='hidden' name='saleDetailId"+j+"' value='"+list.get(i).getSaleDetailId()+"' /></td>");
			sb.append("</tr>");
		}
		 sb.append("</table>");
		 this.setResultContent(sb.toString());
		return "goUpd";
	}
	
	public String doDel(){
		boolean flag = this.ss.doDel(saleId);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String checkGet(){
		List<Sale> list = this.ss.findByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel, pagecur);
		int count = this.ss.findCountByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel);
		StringBuffer sb = new StringBuffer();
		sb.append("<input type='hidden' id='count' value='" + count + "'>");
		sb.append("<table  class='navbar-form navbar-left'>");
		sb.append("<tr><th>销售单名</th><th>职工</th><th>客户</th><th>总价</th>	"
				+ "<th>销售时间</th><th>当前状态</th><th>是否删除</th><th>操作</th></tr>");
		for (Sale s : list) {
			String state = "";
			if(1 == s.getSaleState()){
				state = "只拟定订单";
			}else if(2 == s.getSaleState()){
				state = "已出库";
			}else if(3 == s.getSaleState()){
				state = "已结算";
			}
			String del = "否";
			if(1 == s.getSaleDel()){
				del = "是";
			}
			double all = 0;
			if(null != s.getSaleAll()){
				all = s.getSaleAll();
			}
			String button = "";
			if(3 > s.getSaleState() && 0 == s.getSaleDel()){
				button = "<a href='javascript:void(0)' onclick='goGet(" + s.getSaleId()+")'>结算</a>";
			}
			sb.append("<tr><td>" + 
					this.checkNull(s.getSaleName()) + "</td><td>"+
					"空" + "</td><td>"+
					this.checkNull(s.getClient().getClientName()) + "</td><td>"+
					all + "</td><td>"+
					checkNull(s.getSaleDate().toString()) + "</td><td>"+
					state + "</td><td>"+
					del + "</td><td>"+
					button+"</td></tr>");
		}
		sb.append("</table>");
		this.setResultContent(sb.toString());
		return "succ";
	}
	public String doCheckAll(){
		boolean flag = this.ss.doCheckAll(saleId, saleAll);
		this.setResultContent(Boolean.toString(flag));
		return SUCCESS;
	}
	
	public String checkNull(String source){
		if(null == source){
			return "空";
		}else return source;
	}
}
