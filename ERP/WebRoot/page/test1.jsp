<%@page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
 %>
<html>
<head>
   <link href="<%=path%>/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="dashboard.css" rel="stylesheet">
    <script src="<%=path%>/assets/js/ie-emulation-modes-warning.js"></script>
	<script  src="<%=path%>/assets/js/jquery-1.7.2.js"></script>
</head>
<body>
		<form action=""  class="navbar-form navbar"  method="post" name="f">
			用户名：<input type="text" class="form-control" name="username" id="username">
			<input type="button" value="查询" class="btn btn-info btn-default" onclick="query(1)">
			<input type="button" value="新增" class="btn btn-info btn-default" onclick="goIns()">
		</form>
	
	<hr/>
	<div id="showTable"></div>
	<hr/>
	<span id="page_message"></span>
	<input type="button" value="首页" id="first" class="btn btn-default btn-success"  onclick="query(5)">
	<input type="button" value="上一页" id="up"  class="btn btn-default btn-success"  onclick="query(2)">
	<input type="button" value="下一页" id="end" class="btn btn-default btn-success"   onclick="query(3)">
	<input type="button" value="尾页" id="down"  class="btn btn-default btn-success"  onclick="query(4)">
</body>
<script>
var username = null;//查询条件
var count = 0;//总共有多少笔数据
var page_count = 0;//总共多少页
var pageSize = 5;//一页显示多少比
var pageCurrnet = 1;//当前第几页
query(1);
function query(a) {
username =f.username.value;
	if(a==1){
		pageCurrnet = 1;
	}else if(a==2){//查询上一页
		pageCurrnet = pageCurrnet-1;
	}else if(a==3){//查询下一页
		pageCurrnet = pageCurrnet+1;
	}else if(a==4){//最后一页
		pageCurrnet = page_count;
	}else if(a==5){//首页
		pageCurrnet = 1;
	}

	$(document).ready(function (){
		$.post("<%=path%>/user_findAll.action"
		,{"username":username,"pageCurrnet":pageCurrnet,"pageSize":pageSize},function(data){
			document.getElementById("showTable").innerHTML = data;
			calc();//计算总页数，控制按钮是否可用
		});
		
	});
}
/*
	按钮控制
*/
function calc(){
	count = document.getElementById("count").value;
	if(count%pageSize==0){
		page_count = count/pageSize;
	}else{
		var v = count%pageSize;
		page_count = (count-v)/pageSize + 1;
	}
	if(pageCurrnet == 1&&page_count!=1){
		document.getElementById("first").disabled = true;//按钮不可用
		document.getElementById("up").disabled = true;
		document.getElementById("end").disabled = false;
		document.getElementById("down").disabled = false;
	}else if(pageCurrnet == page_count&&page_count!=1){
		document.getElementById("first").disabled = false;
		document.getElementById("up").disabled = false;
		document.getElementById("end").disabled = true;
		document.getElementById("down").disabled = true;
	}else if(page_count==1){
		document.getElementById("first").disabled = true;
		document.getElementById("up").disabled = true;
		document.getElementById("end").disabled = true;
		document.getElementById("down").disabled = true;
	}else if(pageCurrnet<page_count&&pageCurrnet>1){
		document.getElementById("first").disabled = false;
		document.getElementById("up").disabled = false;
		document.getElementById("end").disabled = false;
		document.getElementById("down").disabled = false;
	}
	document.getElementById("page_message").innerHTML="<font color='blue'>当前第"+pageCurrnet+"页&nbsp;&nbsp;总共"+count+"笔，共"+page_count+"页</font>";
}
/*
	新增
*/
function goIns(){
	window.open("addEmp.jsp",window,"dialogHeight:300px;dialogWidth:280px;")
}
/*
	修改
*/
function goUpd(id_key){
	window.open("<%=path%>/user_findById.action?id="+id_key,window,"dialogHeight:300px;dialogWidth:280px;")
}
/*
	删除
*/
function goDel(id_key){
	if(confirm("确认修改状态？")){
		$(document).ready(function (){
		$.post("<%=path%>/user_doDel.action",{id:id_key},function(data){
			if(data==true){
				alert("修改成功");
				query(0);
			}else{
				alert("修改成功");
			}
		});
	});
	}
}	
</script>
</html>

             
