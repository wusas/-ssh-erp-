<%@page import="com.erp.pojo.SaleDetail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<SaleDetail> list = (List<SaleDetail>)request.getAttribute("lists");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="<%=path%>/assets/js/jquery-1.7.2.js"></script>
</head>
<body>
	<center>
		<form action="" method="post" name="sale_insert">
				<div id="goodsAdd"></div>
				<hr>
				<input type="button" value="确定" onclick="update()"/> 
				<input type="button" value="返回" onclick="back()"/>
		</form>
	</center>

</body>
<script type="text/javascript">
	/*
		取得Ajax核心类的对象
	*/
	document.getElementById("goodsAdd").innerHTML = "${resultContent}";
	var xmlhttp;
	createxmlhttp();
	function createxmlhttp() {
		if (window.XMLHttpRequest) { //如果浏览器是类似于FireFox
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHttp"); //使用的是ＩＥ的机制
		}
	}
	function update(){
		var saleId = document.getElementById("saleId").value;
		var number = document.getElementById("number").value;
		var clientId = document.getElementById("clientId").value;
		var saleState = document.getElementById("state").value;
		var saleDel = document.getElementById("del").value;
		var saleName = document.getElementById("saleName").value;
		if (number == 1) {
			var goods1 = sale_insert.goods1.value;
			var goods2 = "";
			var goods3 = "";
			var goods4 = "";
			var goods5 = "";
			var goods6 = "";
			var num1 = sale_insert.num1.value;
			var price1 = sale_insert.price1.value;
			var saleDetailId1 = sale_insert.saleDetailId1.value;
		} else if (number == 2) {
			var goods1 = sale_insert.goods1.value;
			var goods2 = sale_insert.goods2.value;
			var goods3 = "";
			var goods4 = "";
			var goods5 = "";
			var goods6 = "";
			var num1 = sale_insert.num1.value;
			var num2 = sale_insert.num2.value;
			var price1 = sale_insert.price1.value;
			var price2 = sale_insert.price2.value;
			var saleDetailId1 = sale_insert.saleDetailId1.value;
			var saleDetailId2 = sale_insert.saleDetailId2.value;
		} else if (number == 3) {
			var goods1 = sale_insert.goods1.value;
			var goods2 = sale_insert.goods2.value;
			var goods3 = sale_insert.goods3.value;
			var goods4 = "";
			var goods5 = "";
			var goods6 = "";
			var num1 = sale_insert.num1.value;
			var num2 = sale_insert.num2.value;
			var num3 = sale_insert.num3.value;
			var price1 = sale_insert.price1.value;
			var price2 = sale_insert.price2.value;
			var price3 = sale_insert.price3.value;
			var saleDetailId1 = sale_insert.saleDetailId1.value;
			var saleDetailId2 = sale_insert.saleDetailId2.value;
			var saleDetailId3 = sale_insert.saleDetailId3.value;
		} else if (number == 4) {
			var goods1 = sale_insert.goods1.value;
			var goods2 = sale_insert.goods2.value;
			var goods3 = sale_insert.goods3.value;
			var goods4 = sale_insert.goods4.value;
			var goods5 = "";
			var goods6 = "";
			var num1 = sale_insert.num1.value;
			var num2 = sale_insert.num2.value;
			var num3 = sale_insert.num3.value;
			var num4 = sale_insert.num4.value;
			var price1 = sale_insert.price1.value;
			var price2 = sale_insert.price2.value;
			var price3 = sale_insert.price3.value;
			var price4 = sale_insert.price4.value;
			var saleDetailId1 = sale_insert.saleDetailId1.value;
			var saleDetailId2 = sale_insert.saleDetailId2.value;
			var saleDetailId3 = sale_insert.saleDetailId3.value;
			var saleDetailId4 = sale_insert.saleDetailId4.value;
		} else if (number == 5) {
			var goods1 = sale_insert.goods1.value;
			var goods2 = sale_insert.goods2.value;
			var goods3 = sale_insert.goods3.value;
			var goods4 = sale_insert.goods4.value;
			var goods5 = sale_insert.goods5.value;
			var goods6 = "";
			var num1 = sale_insert.num1.value;
			var num2 = sale_insert.num2.value;
			var num3 = sale_insert.num3.value;
			var num4 = sale_insert.num4.value;
			var num5 = sale_insert.num5.value;
			var price1 = sale_insert.price1.value;
			var price2 = sale_insert.price2.value;
			var price3 = sale_insert.price3.value;
			var price4 = sale_insert.price4.value;
			var price5 = sale_insert.price5.value;
			var saleDetailId1 = sale_insert.saleDetailId1.value;
			var saleDetailId2 = sale_insert.saleDetailId2.value;
			var saleDetailId3 = sale_insert.saleDetailId3.value;
			var saleDetailId4 = sale_insert.saleDetailId4.value;
			var saleDetailId5 = sale_insert.saleDetailId5.value;
		} else if (number == 6) {
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
			var saleDetailId1 = sale_insert.saleDetailId1.value;
			var saleDetailId2 = sale_insert.saleDetailId2.value;
			var saleDetailId3 = sale_insert.saleDetailId3.value;
			var saleDetailId4 = sale_insert.saleDetailId4.value;
			var saleDetailId5 = sale_insert.saleDetailId5.value;
			var saleDetailId6 = sale_insert.saleDetailId6.value;
			}
		var sixgoods = "";
		var sixnum = "";
		var sixprice = "";
		var sixDeId = "";
		if(goods1 == "" && goods2 == "" && "" == goods3 && "" == goods4 && "" == goods5 && "" == goods6){
			alert("至少添加一条明细");
			return false;
		}
		if(null !=goods1 && "" != goods1){
			sixgoods += goods1 + ",";
			sixnum += num1 + ",";
			sixprice += price1 + ",";
			sixDeId += saleDetailId1 + ",";
			
		}
		if(null !=goods2 && "" != goods2){
			sixgoods += goods2 + ",";
			sixnum += num2 + ",";
			sixprice += price2 + ",";
			sixDeId += saleDetailId2 + ",";
		}
		if(null !=goods3 && "" != goods3){
			sixgoods += goods3 + ",";
			sixnum += num3 + ",";
			sixprice += price3 + ",";
			sixDeId += saleDetailId3 + ",";
		}
		if(null !=goods4 && "" != goods4){
			sixgoods += goods4 + ",";
			sixnum += num4 + ",";
			sixprice += price4 + ",";
			sixDeId += saleDetailId4 + ",";
		}
		if(null !=goods5 && "" != goods5){
			sixgoods += goods5 + ",";
			sixnum += num5 + ",";
			sixprice += price5 + ",";
			sixDeId += saleDetailId5 + ",";
		}
		if(null !=goods6 && "" != goods6){
			sixgoods += goods6 + ",";
			sixnum += num6 + ",";
			sixprice += price6 + ",";
			sixDeId += saleDetailId6 + ",";
		}
		$.post("<%=path%>/sale_doUpd.action",{
			"saleName":saleName,
			"clientId":clientId,
			"saleState":saleState,
			"saleDel":saleDel,
			"saleId":saleId,
			"sixgoods":sixgoods,
			"sixnum":sixnum,
			"sixprice":sixprice,
			"sixDeId":sixDeId
		},function(data){
			var jsonA = eval(data);
				 $.each(jsonA, function (i, item) {  
				 	if(true == item.flag){
				 		alert("修改成功");
				 		bcak();
				 	}else{
				 		alert("修改失败");
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
