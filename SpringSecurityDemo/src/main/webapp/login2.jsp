<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>车险未决管理系统</title>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="" />
</head>
<body>
<div class="back_top_div"></div>
<div class="login">
	<div class="login-top">
		<div><h2>车险未决管理系统</h2></div>
		<div class="pic_1">
			<img id="u17_img" class="img " src="images/u17.png"/>
		</div>
		<div class="login_right">
			<p>用户登录</p>
			 <form action="j_spring_security_check" method="post">
				<input type="text" id="j_username" name="username" value="登录帐号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '登录帐号';}">
				<input type="password" id="j_password" name="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}">
				<select style="width:200px;height:30px;" id="acntList">
				 <!--  <option value ="volvo">Volvo</option>
				  <option value ="saab">Saab</option>
				  <option value="opel">Opel</option>
				  <option value="audi">Audi</option> -->
				</select>
				<div class="forgot">
				<input type="submit" value="登录" >
				${SPRING_SECURITY_LAST_EXCEPTION.message }
			</div>
			</form>
			
		</div>
	</div>
</div>	
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery.md5.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</body>
</html>