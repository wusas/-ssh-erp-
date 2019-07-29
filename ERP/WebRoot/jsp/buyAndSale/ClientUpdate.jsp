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
		<form action="" method="post" name="client_update">
			<table border="0">
				<tr>
					<td style="text-align: right;">客户姓名：</td>
					<td><input type="text" name="clientName" id="clientName"
						value="${client.clientName }"
						onfocus='if(this.value=="${client.clientName }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${client.clientName }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">客户地址：</td>
					<td><input type="text" name="clientAddr" id="clientAddr"
						value="${client.clientAddr }"
						onfocus='if(this.value=="${client.clientAddr }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${client.clientAddr }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">客户等级：</td>
					<td><select name="clientGrade">
							<option value="1">高</option>
							<option value="2">中</option>
							<option value="3">低</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人：</td>
					<td><input type="text" name="linkName" id="linkName"
						value="${client.linkName }"
						onfocus='if(this.value=="${client.linkName }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${client.linkName }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人性别：</td>
					<td><input type="radio" id="girl2" name="linkSex" value="0" />女
						<input type="radio" id="boy1" name="linkSex" value="1" />男</td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人电话：</td>
					<td><input type="text" name="linkTel" id="linkTel"
						value="${client.linkTel }"
						onfocus='if(this.value=="${client.linkTel }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${client.linkTel }";};' /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="确定"
						onclick="update()" /> <input type="button" value="返回"
						onclick="back()" /></td>
				</tr>
			</table>
		</form>
	</center>

</body>
<script type="text/javascript">
	client_update.clientGrade.value = ${client.clientGrade};
	if(${client.linkSex} == 1){
		document.getElementById("boy1").checked = true;
	}else if(${client.linkSex} == 0){
		document.getElementById("girl2").checked = true;
	} 
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
	function update(){
		var clientName = client_update.clientName.value;
		var clientAddr = client_update.clientAddr.value;
		var clientGrade = client_update.clientGrade.value;
		var linkName = client_update.linkName.value;
		var linkSex = getSex();
		var linkTel = client_update.linkTel.value;
		$.post("<%=path%>/client_doUpd.action",{
			"clientId":${client.clientId },
			"clientName":clientName,
			"clientAddr":clientAddr,
			"clientGrade":clientGrade,
			"linkName":linkName,
			"linkSex":linkSex,
			"linkTel":linkTel
		},function(data){
			if(data.indexOf("true")!=-1){
				alert("修改成功");
				back();
			}else{
				alert("修改失败");
			}
		});
	}
	function back() {
		window.dialogArguments.query();//刷新之前页面	
		window.close();//关闭当前页面
	}
</script>
</html>
