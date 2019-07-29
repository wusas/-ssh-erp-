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
		<form action="" method="post" name="sale_insert">
			<table border="0">
				<tr>
					<td style="text-align: right;">销售单名称：</td>
					<td><input type="text" name="saleName" id="saleName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">办理人员：</td>
					<td>
						<select id="salePerson" name="empId"></select>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">客户：</td>
					<td><select id="clientPerson" name="clientId"></select></td>
				</tr>
				</table>
				<hr>
				<table id="goodsAdd">
					<tr><th>商品</th><th>单价</th><th>数量</th></tr>
					<tr>
						<td><select class="showGoods" name="goods1"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price1"/></td>
						<td><input type="text" name="num1" /></td>
					</tr>
					<tr>
						<td><select class="showGoods" name="goods2"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price2"/></td>
						<td><input type="text" name="num2" /></td>
					</tr>
					<tr>
						<td><select class="showGoods" name="goods3"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price3"/></td>
						<td><input type="text" name="num3" /></td>
					</tr>
					<tr>
						<td><select class="showGoods" name="goods4"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price4"/></td>
						<td><input type="text" name="num4" /></td>
					</tr>
					<tr>
						<td><select class="showGoods" name="goods5"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price5"/></td>
						<td><input type="text" name="num5" /></td>
					</tr>
					<tr>
						<td><select class="showGoods" name="goods6"><option value="" selected="selected">请选择商品</option></select></td>
						<td><input type="text" name="price6"/></td>
						<td><input type="text" name="num6" /></td>
					</tr>
				</table>
				<hr>
						<input type="button" value="确定" onclick="insert()"/> 
						<input type="button" value="返回" onclick="back()"/>
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
	getGoods();
	function getGoods(){
		$(document).ready(function() {
			$.post("<%=path%>/sale_findGoods.action", {}, function(data) {
			 	var jsonA = eval(data);
				 $.each(jsonA, function (i, item) {  
				 	if(0 == item.goodsStop){
				 		$(".showGoods").append("<option value='"+item.goodsId+"'>"+item.goodsName+"</option>");
				 	}
       			 }); 
			});
		});
	}
	getClient();
	function getClient(){
		$(document).ready(function() {
			$.post("<%=path%>/sale_findClient.action", {}, function(data) {
			 	var jsonA = eval(data);
				 $.each(jsonA, function (i, item) {  
				 	if(0 == item.clientDel){
				 		$("#clientPerson").append("<option value='"+item.clientId+"'>"+item.clientName+"</option>");
				 	}
       			 }); 
			});
		});
	}
	function insert(){
		var saleName = sale_insert.saleName.value;
		var empId = sale_insert.empId.value;
		var clientId = sale_insert.clientId.value;
		var goods1 = sale_insert.goods1.value;
		var goods2 = sale_insert.goods2.value;
		var goods3 = sale_insert.goods3.value;
		var goods4 = sale_insert.goods4.value;
		var goods5 = sale_insert.goods5.value;
		var goods6 = sale_insert.goods6.value;
		var num1 = sale_insert.num1.value;
		var num2 = sale_insert.num2.value;
		var num3 = sale_insert.num3.value;
		var num4 = sale_insert.num4.value;
		var num5 = sale_insert.num5.value;
		var num6 = sale_insert.num6.value;
		var price1 = sale_insert.price1.value;
		var price2 = sale_insert.price2.value;
		var price3 = sale_insert.price3.value;
		var price4 = sale_insert.price4.value;
		var price5 = sale_insert.price5.value;
		var price6 = sale_insert.price6.value;
		var sixgoods = "";
		var sixnum = "";
		var sixprice = "";
		if(goods1 == "" && goods2 == "" && "" == goods3 && "" == goods4 && "" == goods5 && "" == goods6){
			alert("至少添加一条明细");
			return false;
		}
		/* else if(!(((goods1 != goods2 && goods1 != goods3 && goods1 != goods4 && goods1 != goods5 && goods1 != goods6) && goods1 != "")
					&& ((goods2 != goods3 && goods2 != goods4 && goods2 != goods5 && goods2 != goods6 ) && goods2 != "")
					&& ((goods3 != goods4 && goods3 != goods5 && goods3 != goods6 ) && goods3 != "")
					&& ((goods4 != goods5 && goods4 != goods6 ) && goods4 != "")
					&& ((goods5 != goods6 ) && goods5 != ""))){
			alert("请不要选择重复的商品");
			return false;
		} */
		if(null !=goods1 && "" != goods1){
			sixgoods += goods1 + ",";
			sixnum += num1 + ",";
			sixprice += price1 + ",";
		}
		if(null !=goods2 && "" != goods2){
			sixgoods += goods2 + ",";
			sixnum += num2 + ",";
			sixprice += price2 + ",";
		}
		if(null !=goods3 && "" != goods3){
			sixgoods += goods3 + ",";
			sixnum += num3 + ",";
			sixprice += price3 + ",";
		}
		if(null !=goods4 && "" != goods4){
			sixgoods += goods4 + ",";
			sixnum += num4 + ",";
			sixprice += price4 + ",";
		}
		if(null !=goods5 && "" != goods5){
			sixgoods += goods5 + ",";
			sixnum += num5 + ",";
			sixprice += price5 + ",";
		}
		if(null !=goods6 && "" != goods6){
			sixgoods += goods6 + ",";
			sixnum += num6 + ",";
			sixprice += price6 + ",";
		}
		$.post("<%=path%>/sale_doIns.action",{
			"saleName":saleName,
			"empId":empId,
			"clientId":clientId,
			"sixgoods":sixgoods,
			"sixnum":sixnum,
			"sixprice":sixprice
		},function(data){
			var jsonA = eval(data);
				 $.each(jsonA, function (i, item) {  
				 	if(true == item.flag){
				 		alert("新增成功");
				 		bcak();
				 	}else{
				 		alert("新增失败");
				 	}
       			 }); 
		});
	}
	function back() {
		window.dialogArguments.query();//刷新之前页面	
		window.close();//关闭当前页面
	}
</script>
</html>
