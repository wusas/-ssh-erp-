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
		<form action="" method="post" name="supplier_update">
			<table border="0">
				<tr>
					<td style="text-align: right;">供应商姓名：</td>
					<td><input type="text" name="supplierName" id="supplierName"
						value="${supplier.supplierName }"
						onfocus='if(this.value=="${supplier.supplierName }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${supplier.supplierName }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">供应商地址：</td>
					<td><input type="text" name="supplierAddr" id="supplierAddr"
						value="${supplier.supplierAddr }"
						onfocus='if(this.value=="${supplier.supplierAddr }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${supplier.supplierAddr }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">供应商等级：</td>
					<td><select name="supplierGrade">
							<option value="1">高</option>
							<option value="2">中</option>
							<option value="3">低</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人：</td>
					<td><input type="text" name="linkName" id="linkName"
						value="${supplier.linkName }"
						onfocus='if(this.value=="${supplier.linkName }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${supplier.linkName }";};' /></td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人性别：</td>
					<td><input type="radio" id="girl2" name="linkSex" value="0" />女
						<input type="radio" id="boy1" name="linkSex" value="1" />男</td>
				</tr>
				<tr>
					<td style="text-align: right;">联系人电话：</td>
					<td><input type="text" name="linkTel" id="linkTel"
						value="${supplier.linkTel }"
						onfocus='if(this.value=="${supplier.linkTel }"){this.value="";}; '
						onblur='if(this.value==""){this.value="${supplier.linkTel }";};' /></td>
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
	supplier_update.supplierGrade.value = ${supplier.supplierGrade};
	if(${supplier.linkSex} == 1){
		document.getElementById("boy1").checked = true;
	}else if(${supplier.linkSex} == 0){
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
		var supplierName = supplier_update.supplierName.value;
		var supplierAddr = supplier_update.supplierAddr.value;
		var supplierGrade = supplier_update.supplierGrade.value;
		var linkName = supplier_update.linkName.value;
		var linkSex = getSex();
		var linkTel = supplier_update.linkTel.value;
		$.post("<%=path%>/supplier_doUpd.action",{
			"supplierId":${supplier.supplierId },
			"supplierName":supplierName,
			"supplierAddr":supplierAddr,
			"supplierGrade":supplierGrade,
			"linkName":linkName,
			"linkSex":linkSex,
			"linkTel":linkTel,
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
