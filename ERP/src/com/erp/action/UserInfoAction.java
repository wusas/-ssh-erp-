package com.erp.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.erp.pojo.Dept;
import com.erp.pojo.Emp;
import com.erp.service.UserInfoServiceDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
public class UserInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfoServiceDao service;
	private int pageSize;
	private int pageCurrnet;
	private long id;
	private int count;
	private String resultContent;
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
	private JSONArray jsonA;
	private boolean flag;
	private String username;
	private Emp pojo;
	private Long deptId;
	
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getResultContent() {
		return resultContent;
	}
	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}
	public Emp getPojo() {
		return pojo;
	}
	public void setPojo(Emp pojo) {
		this.pojo = pojo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public UserInfoServiceDao getService() {
		return service;
	}
	public void setService(UserInfoServiceDao service) {
		this.service = service;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCurrnet() {
		return pageCurrnet;
	}
	public void setPageCurrnet(int pageCurrnet) {
		this.pageCurrnet = pageCurrnet;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpSfnum() {
		return empSfnum;
	}
	public void setEmpSfnum(Long empSfnum) {
		this.empSfnum = empSfnum;
	}
	public Integer getEmpSex() {
		return empSex;
	}
	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}
	public Date getEmpBir() {
		return empBir;
	}
	public void setEmpBir(Date empBir) {
		this.empBir = empBir;
	}
	public String getEmpPic() {
		return empPic;
	}
	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public Integer getEmpLeave() {
		return empLeave;
	}
	public void setEmpLeave(Integer empLeave) {
		this.empLeave = empLeave;
	}
	public JSONArray getJsonA() {
		return jsonA;
	}
	public void setJsonA(JSONArray jsonA) {
		this.jsonA = jsonA;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//查找所有职工信息
	public String findAll(){
		int count = this.service.findCountByUsername(username);
		List<Emp> list = this.service.findByUsername(username, pageCurrnet, pageSize);
		StringBuffer sb = new StringBuffer();
		System.out.println(list.size());
		sb.append("<input type='hidden' id='count' value='" + count + "'>");
		sb.append("<table class='table table-hover table-bordered'>");
		sb.append("<tr><th>职工id</th><th>姓名</th><th>性别</th><th>电话</th><th>生日</th><th>是否离职</th><th>操作</th></tr>");
		Iterator<Emp> it = list.iterator();
		while (it.hasNext()) {
			Emp pojo = it.next();
			String sex="";
			String leave="";
			if(pojo.getEmpSex()==1){
				sex="男";
			}else{
				sex="女";
			}
			if(pojo.getEmpLeave()==0){
				leave="是";
			}else {
				leave="否";
			}
			sb.append("<tr><td>" + pojo.getEmpId() + "</td><td>"
					+ pojo.getEmpName() + "</td><td>"+sex+"</td><td>"
                    + pojo.getEmpSfnum() + "</td><td>" + pojo.getEmpBir()+
					"</td><td><a href='#' onclick='goDel(" + pojo.getEmpId()
					+ ")'>"+leave+"</a>"+ "</td></td>"+
					"<td><a href='#' onclick='goUpd(" + pojo.getEmpId()
					+ ")'>修改</a></td></tr>");
		}
		sb.append("</table>");
		this.setResultContent(sb.toString());
		return "success";
	}
	//删除
	public String doDel(){
		boolean bool = this.service.doDel(id);
		this.setResultContent(Boolean.toString(bool));
		return "success";
	}
	//新增
	public String doIns(){
		Dept  dept = this.service.findByDId(deptId);
		Emp pojo = new Emp(dept, empName, empSfnum, empSex, empBir, null, loginName, loginPass, 1, null, null, null);
		boolean bool = this.service.doIns(pojo);
		this.setResultContent(Boolean.toString(bool));
		return "success";
	}
	//登录
	public String dologin(){
		Emp user = this.service.checkLoginname(loginName, loginPass);
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(null != user){
			//登陆成功
			session.put("user", user);
			flag=true;
			this.setResultContent(Boolean.toString(flag));
			return "success";
		}else{
			flag=false;
			this.setResultContent(Boolean.toString(flag));
			return "fail";
		}
	}
	//查找个人信息
	public String findById(){
		Emp abc = this.service.findbyId(id);
		this.setPojo(abc);
		return "suc";
	}
	//修改个人信息
	public String doUpd(){
		// dept, empName,empSfnum, empSex,  empBir,  empPic, loginName,
		// loginPass, empLeave
		dept = this.service.findByDId(deptId);
		Emp user =new Emp();
		user.setDept(dept);
		user.setEmpBir(empBir);
		user.setEmpName(empName);
		user.setEmpSfnum(empSfnum);
		user.setEmpSex(empSex);
		user.setEmpLeave(1);
		user.setLoginName(loginName);
		user.setLoginPass(loginPass);
		user.setEmpId(empId);
		boolean flag=this.service.doDpd(user);
		this.setResultContent(Boolean.toString(flag));
		return "success";
	}
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		flag=true;
		this.setResultContent(Boolean.toString(flag));
		return "success";
	}
}
