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
		<form action="" method="post" name="client_insert">
			<table border="0">
				<tr>
					<td style="text-align: right;">商品名：</td>
					<td><input type="text" name="goodsName" id="goodsName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">供应商：</td>
					<td>
						<div id="showSupplier"></div>
					</td>
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
	showSupp();
	function showSupp(){
		$.post("<%=path%>/supplier_showSupp.action",{},function(data){
			document.getElementById("showSupplier").innerHTML = data;
		});
	}
	
	function insert(){
		var goodsName = client_insert.goodsName.value;
		var goodsStop = 0;
		var obj = document.getElementsByName("supplierId");
		var checkSupp = "";
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].checked) {
				checkSupp += obj[i].value + ","
			}
		}
		$.post("<%=path%>/goods_doIns.action",{
			"goodsName":goodsName,
			"goodsStop":goodsStop,
			"checkSupp":checkSupp
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
