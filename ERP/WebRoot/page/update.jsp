<%@page contentType="text/html; charset=utf-8"%>
<% 
	String path =request.getContextPath();//取得系统的跟路径
%>
<html>
<head>
 <link href="<%=path%>/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="dashboard.css" rel="stylesheet">
    <script src="<%=path%>/assets/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/datepicker/WdatePicker.js" ></script>
	<script type="text/javascript" src="<%=path %>/assets/js/jquery-1.7.2.js"></script>
</head>

	<body>
	<h3  style="text-align: center">修改职工</h3>

			          <div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
           	  <form name="f" >
                <div class="form-group">
                   <input type="hidden" style="width: 220px;" name="empId" class="form-control"value="${pojo.empId }"/>
                </div>
                 <div class="form-group">
                     <label for="exampleInputEmail1">职工姓名：</label><input class="form-control" name="empName" value="${pojo.empName }"/>
                </div>
                <div class="form-group">
                      <label >职工性别：</label>
                                      <select name="empSex" id="empSex">
                              <option value="${pojo.empSex }" selected="selected">男</option>
                              <option value="${pojo.empSex }">女</option>
                            </select>
                </div>
                   <div class="form-group">
                     <label for="exampleInputEmail1">联系电话：</label><input class="form-control" name="empSfnum" value="${pojo.empSfnum }"/>
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">登录名：</label><input class="form-control" id="exampleInputPassword1" type="text" name="loginName" value="${pojo.loginName }"/>
                </div>
                   <div class="form-group">
                     <label for="exampleInputEmail1">密码：</label><input class="form-control" id="exampleInputEmail1" name="loginPass" value="${pojo. loginPass}" type="password" />
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">出生日期：</label><input class="form-control" name="empBir" id="empBir"  value="${pojo. empBir}" onclick="javascript:WdatePicker()" id="InputPassword1" type="date" />
                </div>
                 <div class="form-group">
                        <label >选择部门：</label>
                            <select name="deptId"  >
                              <option value="1">销售部</option>
                              <option value="2">采购部</option>
                              <option value="3">仓管部</option>
                              <option value="4">财务部</option>
                              <option value="4">系统管理员</option>
                            </select>
                </div>
            
                <div class="checkbox">
                </div> <button class="btn btn-default" type="submit" onclick="configR()">提交</button>
                <input class="btn btn-default" type="reset" value="   重    置    " />
            </form>
        </div>
    </div>
</div>
	</body>
	<script type="text/javascript">
function configR() {
			var empId = f.empId.value;
			var deptId=f.deptId.value;
			var empName = f.empName.value;
			var empSex = f.empSex.value;
			var empSfnum=f.empSfnum.value;
			var empBir = f.empBir.value;
			var loginName = f.loginName.value;
			var loginPass = f.loginPass.value;
	$(document).ready(function() {
		$.post("<%=path%>/user_doUpd.action", {
			deptId:deptId,
			empName : empName,
			empSex:empSex ,
			empSfnum : empSfnum,
			empBir : empBir,
			loginPass : loginPass,
			empId:empId
		}, function(data) {
			if (data=="true") {
				alert("修改成功");
				window.location.href="<%=path %>/page/index.jsp"
			}
		});
	});
}
function back() {
	window.close();//关闭当前页面
}
</script>
</html>