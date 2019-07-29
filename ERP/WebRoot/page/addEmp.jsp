<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
    <title> - 新增职工 -</title>
     <link href="<%=path%>/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="dashboard.css" rel="stylesheet">
    <script src="<%=path%>/assets/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/datepicker/WdatePicker.js" ></script>
</head>
<body class="gray-bg">
                        <h3  style="text-align: center">新增职工</h3>
                   
			            <div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
         <form name="f" >
         
                <div class="form-group">
                     <label for="exampleInputEmail1">职工姓名：</label><input class="form-control" type="text" name="empName" id="empName" />
                </div>
                <div class="form-group">
                      <label >职工性别：</label>
                                <select name="empSex" id="empSex">
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                </select>
                </div>
                   <div class="form-group">
                     <label for="exampleInputEmail1">联系电话：</label><input class="form-control" name="empSfnum" id="empTel"//>
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">登录名：</label><input class="form-control" id="exampleInputPassword1" type="text"  name="loginName"/>
                </div>
                   <div class="form-group">
                     <label for="exampleInputEmail1">密码：</label><input class="form-control" id="exampleInputEmail1"name="loginPass"  type="password" />
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">出生日期：</label><input class="form-control"  name="empBir" id="empDate" onclick="javascript:WdatePicker()" id="exampleInputPassword1" type="date" />
                </div>
                 <div class="form-group">
                        <label >选择部门：</label>
                                <select name="deptId" >
                                    <option value="1">销售部</option>
                                    <option value="2">采购部</option>
                                    <option value="3">仓管部</option>
                                    <option value="4">财务部</option>
                                    <option value="4">系统管理员</option>
                                </select>
                </div>
            
                <div class="checkbox">
                </div> <button class="btn btn-default" type="submit" onclick="add()">提交</button>
                <input class="btn btn-default" type="reset" value="   重    置    " />
		            </form>
        </div>
    </div>
</div>
    <script type="text/javascript">
        function add(){
        	var dept=f.deptId.value;
			var empName = f.empName.value;
			var empSex = f.empSex.value;
			var empSfnum=f.empSfnum.value;
			var empBir = f.empBir.value;
			var loginName = f.loginName.value;
			var loginPass = f.loginPass.value;
			$(document).ready(function(){
			//dept,empName,empSfnum,empSex,empBir,empPic,
			//	loginName,loginPass
				$.post("<%=path%>/user_doIns.action", { "deptId":dept,
				"empName":empName,"empSfnum":empSfnum,"empSex":empSex,
				"empBir":empBir, empPic:"empPic","loginName":loginName,"loginPass":loginPass},
				function(data){
					/* alert(); */
					alert("aa");
				if(data == "true"){
					alert("新增成功");
					window.location.href="<%=path %>/page/index.jsp"
				}else{
					alert("新增失败");
				}
				});
			});
		}
    </script>
</body>
</html>
