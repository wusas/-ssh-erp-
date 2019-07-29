<%@page contentType="text/html; charset=utf-8"%>
<%@page import="com.erp.pojo.*"  %>
<%@page import="java.util.*"  %>
<%
	String path = request.getContextPath();//取得访问项目的根路径
%>
<html>
	<head>
		<script type="text/javascript" src="<%=path %>/assets/js/jquery-1.8.3.js"></script>
		
	
	</head>
	<body>
	<center>
		<form name = "f" action = "" method="post">
		<table border="1">
			<tr>
				<td>盘点库余量：</td>
				<td><input type="text" name="checkPerson"   id="person" /></td>
			</tr>
			<tr >
				<td colspan="2" align="center"><input type="button" value="确认" onclick="goSure()"/>
				<input type="button" value="返回" onclick="goBack()"/></td>
			</tr>
		</table>
	</form>
	</center>
</body>
<script type="text/javascript">
	function goSure(){
	var checkPerson = f.checkPerson.value;
		$(document).ready(function(){
				$.post("<%=path %>/checkTable_doIns.action",{
				   // "empId" : ${user.empId},
					"goodsId" : ${pojo.id.goodsId},
					"checkCal" : ${pojo.id.detail},
					"checkPerson" : checkPerson
					},
				function (data){//data就是Action返回我们要的字符串
					if(data == "true"){
						alert("修改成功");
					}else{
						alert("修改失败");
					}
	 			});
		});
		}
			
	function goBack(){
		window.dialogArguments.query(0);//刷新之前页面 
		window.close();//关闭当前页面
	}
</script>
</html>
