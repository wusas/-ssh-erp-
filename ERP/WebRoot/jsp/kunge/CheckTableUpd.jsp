<%@page contentType="text/html; charset=utf-8"%>
<%@page import="com.erp.pojo.*"%>
<%@page import = "java.util.*" %>

<%
	String path = request.getContextPath();
	
	
%>
<html>
	<head>
	<script type="text/javascript" src="<%=path %>/assets/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/assets/datepicker/WdatePicker.js" ></script>
	

	</head>
	<body>
	<center>
		<form name = "f" action = "" >
		<table border="1">
			<tr>
				<td>盘点库余量：</td>
				<td><input type="text" name="checkPerson" value="${pojo.checkPerson}" /></td>
			</tr>
			<tr >
				<td colspan="2" align="center"><input type="button" value="确认" onclick="update()"/><input type="button" value="返回" onclick="backQ()"/></td>
			</tr>
		</table>
	</form>
	</center>	
	</body>
	<script type="text/javascript">

		//设置下拉列表的默认值
		function update(){
		var checkPerson = f.checkPerson.value;
		$(document).ready(function() {
				$.post("<%=path %>/checkTable_doUpd.action", {
					"checkId":${pojo.checkId},
					"goodsId" : ${pojo.goods.goodsId},
					"checkCal" : ${pojo.checkCal},
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
			
		function backQ(){
			opener.location.reload();
			window.close();
		}
	</script>
</html>