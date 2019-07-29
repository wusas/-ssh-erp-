<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="<%=path%>/assets/js/jquery-1.7.2.js"></script>
</head>
<body>

	<center>
		<form action="" method="post" name="supplier_insert">
			<table border="0">
				<tr>
					<td style="text-align: right;">供应商姓名：</td>
					<td><input type="text" name="supplierName" id="supplierName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">供应商地址：</td>
					<td><input type="text" name="supplierAddr" id="supplierAddr" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">供应商等级：</td>
					<td><select name="supplierGrade">
							<option value="1" selected="selected">高</option>
							<option value="2">中</option>
							<option value="3">低</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人：</td>
					<td><input type="text" name="linkName" id="linkName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人性别：</td>
					<td>
						<input type="radio" id="girl" name="linkSex" value="0"/>女
						<input type="radio" id="boy" name="linkSex" value="1"/>男
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人电话：</td>
					<td><input type="text" name="linkTel" id="linkTel" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="确定" onclick="insert()"/> 
						<input type="button" value="返回" onclick="back()"/>
					</td>
				</tr>
			</table>
		</form>
	</center>

</body>
<script type="text/javascript">
	/*
		取得Ajax核心类的对象
	*/
	var xmlhttp;
	createxmlhttp();
	function createxmlhttp() {
		if (window.XMLHttpRequest) { //如果浏览器是类似于FireFox
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHttp"); //使用的是ＩＥ的机制
		}
	}
	function getSex(){
	  var value="";
	  var radio=document.getElementsByName("linkSex");
	  for(var i=0;i<radio.length;i++){
		if(radio[i].checked==true){
		  value=radio[i].value;
		  break;
		}
	  }
	  return value;
	}
	function insert(){
		var supplierName = supplier_insert.supplierName.value;
		var supplierAddr = supplier_insert.supplierAddr.value;
		var supplierGrade = supplier_insert.supplierGrade.value;
		var linkName = supplier_insert.linkName.value;
		var linkSex = getSex();
		var linkTel = supplier_insert.linkTel.value;
		$.post("<%=path%>/supplier_doIns.action",{
			"supplierName":supplierName,
			"supplierAddr":supplierAddr,
			"supplierGrade":supplierGrade,
			"linkName":linkName,
			"linkSex":linkSex,
			"linkTel":linkTel
		},function(data){
			if(data.indexOf("true")!=-1){
				alert("新增成功");
				back();
			}else{
				alert("新增失败");
			}
		});
	}
	function back() {
		window.dialogArguments.query();//刷新之前页面	
		window.close();//关闭当前页面
	}
</script>
</html>
