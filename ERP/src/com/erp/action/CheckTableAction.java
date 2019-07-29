package com.erp.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.erp.pojo.CheckTable;
import com.erp.pojo.Emp;
import com.erp.pojo.Goods;
import com.erp.pojo.TbvNewDetail;
import com.erp.service.CheckTableService;
import com.erp.service.GoodsService;
import com.erp.service.UserInfoServiceDao;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CheckTableAction extends ActionSupport{
	private CheckTableService service;
	private GoodsService goodsService;
	private UserInfoServiceDao userService;
	private JSONArray jsonA;
	private String resultContent;
	private Long checkId;
	private Long goodsId;
	private Long empId;
	private int pageCurrent;
	private int id;
	private Emp emp;
	private Goods goods;
	private Date checkDate;
	private Long checkCal;
	private Long checkPerson;
	private CheckTable pojo;
	private String goodsName;
	private int goodsStop;
	private TbvNewDetail tbv;
	private Long eId;

	
	public TbvNewDetail getTbv() {
		return tbv;
	}
	public void setTbv(TbvNewDetail tbv) {
		this.tbv = tbv;
	}
	public CheckTableService getService() {
		return service;
	}
	public void setService(CheckTableService service) {
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
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Long getCheckCal() {
		return checkCal;
	}
	public void setCheckCal(Long checkCal) {
		this.checkCal = checkCal;
	}
	public Long getCheckPerson() {
		return checkPerson;
	}
	public void setCheckPerson(Long checkPerson) {
		this.checkPerson = checkPerson;
	}
	public CheckTable getPojo() {
		return pojo;
	}
	public void setPojo(CheckTable pojo) {
		this.pojo = pojo;
	}
	
	
	
	
public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
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
public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	
	
	public UserInfoServiceDao getUserService() {
		return userService;
	}
	public void setUserService(UserInfoServiceDao userService) {
		this.userService = userService;
	}
	public JSONArray getJsonA() {
		return jsonA;
	}
	public void setJsonA(JSONArray jsonA) {
		this.jsonA = jsonA;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	
	
	
	
	public Long geteId() {
		return eId;
	}
	public void seteId(Long eId) {
		this.eId = eId;
	}
	public String findAll(){
		
		//System.out.println("sb"+empId);
		List<CheckTable> list = this.service.findByTimeGoodsId(goodsId, empId,checkDate, pageCurrent);
		//System.out.println(list.size());
		int count = this.service.findCountByTimeGoodsId( goodsId, empId,checkDate);
		//System.out.println(count);
		StringBuffer sb  = new StringBuffer();
		Calendar c = new GregorianCalendar();
		//c.set(Calendar.DAY_OF_MONTH, 1);//设置为当前月第一天
		c.add(Calendar.DAY_OF_MONTH, -1);//jia一天
		Date cd = c.getTime();//转换成Date类型
		System.out.println(cd);
		sb.append("<input type = 'hidden' id = 'count' value= '"+count+"'>");
		sb.append("<table class='table table-hover table-bordered'>");
		sb.append("<tr><th>商品名</th><th>盘点时间</th><th>计算库余量</th><th>盘点库余量</th><th>操作</th></tr>");
		Iterator<CheckTable> it = list.iterator();
		while(it.hasNext()){
			CheckTable pojo = it.next();
			sb.append("<tr><td>"
					+pojo.getGoods().getGoodsName()+"</td>"+"<td>"
					+pojo.getCheckDate()+"</td><td>"+pojo.getCheckCal()
					+"</td><td>"+pojo.getCheckPerson()+"</td>");
//					if(pojo.getCheckDate() >= cd){
//						
//					}
					sb.append("</td><td><a href='#' onclick='goUpd(" + pojo.getCheckId()+ ")'>修改</tr>");
		}
		sb.append("</table>");
		this.setResultContent(sb.toString());
		return "success";
		}
	    public String doIns(){
	    	
     	    Date checkDate= new Date();//创建一个时间对象，获取到当前的时间
//     	    Emp emp = this.userService.findById(tbv.getId().);
	    	Goods goods = this.goodsService.findById(goodsId);
	    	if(null == checkPerson){
	    		checkPerson = (long) 500;
	    	}
	    	CheckTable pojo = new CheckTable(null,goods,checkDate,checkCal,checkPerson);
	    	boolean bool = this.service.doIns(pojo);
	    	this.setResultContent(Boolean.toString(bool));
	    	return "success";
	    }
	    public String doUpd(){
	    	
	    	Date checkDate= new Date();
	    	
    	    Goods goods = this.goodsService.findById(goodsId);
	    	Emp emp = this.userService.findbyId(empId);
	    	System.out.println(emp);
	    	if(null == checkPerson){
	    		checkPerson = (long) 500;
	    	}
	    	CheckTable pojo1 = new CheckTable(emp,goods,checkDate,checkCal,checkPerson);
	    	pojo1.setCheckId(checkId);
	    	System.out.println(pojo1);
	    	boolean bool = this.service.doUpd(pojo1);
	    	this.setResultContent(Boolean.toString(bool));
	    	return "success";
	    }
	    public String findById(){
	    	CheckTable abc = this.service.findById(checkId);
			this.setPojo(abc);
			return "suc";
		}
//	    public String findEmp(){
//			List<Emp> emplist = this.empService.findEmp();
//			jsonA = new JSONArray();
//			for(Emp e:emplist){
//				JSONObject jsonO = new JSONObject();
//				jsonO.put("EmpName", e.getEmpName());
//				jsonO.put("EmpId", e.getEmpId());
//				jsonA.add(jsonO);
//			}
//			return "successEmp";
//		}
	    
//	    public String getTime(){
//	    	Timestamp ts = new Timestamp(System.currentTimeMillis());   
//	  	    Date date= new Date();//创建一个时间对象，获取到当前的时间
//	  	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置时间显示格式
//	  	    
//	  	    String str = sdf.format(date);
//	  	    	
//	  	    //将当前时间格式化为需要的类型
//	  	            try {   
//	  	                ts = Timestamp.valueOf(str);  
//	  	                System.out.println(ts);   
//	  	            } catch (Exception e) {   
//	  	                e.printStackTrace();   
//	  	            };
//	 
//	    	
//	    }
	  
	
}


