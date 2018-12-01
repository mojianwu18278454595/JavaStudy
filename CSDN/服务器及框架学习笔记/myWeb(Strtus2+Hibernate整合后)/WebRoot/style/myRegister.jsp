<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翀购网注册界面</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>
	
<body>
<div class="container">
	<section id="content">
		<form action="${pageContext.request.contextPath }/user_register.action" method="post">
			<h1>翀购网注册中心</h1>
				<s:actionerror/>
			<div>
  				<input name="user_name" placeholder="用户名" type="text" id="user_name" />
			</div>
			<div>
				<input type="password" placeholder="密 码" name="user_pwd" id="user_pwd" />
			</div>
			<div>
				<input name="pwdAgin" placeholder="确认密码" type="password" id="pwdAgin" />
			</div>
			<div>
				<input name="user_gender" placeholder="性 别" type="text" id="user_gender"/>
			</div>
			<div>
				<input name="user_tel" placeholder="电 话" type="text" id="user_tel" />
			</div>
			
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
			</div> 
		
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" name="Submit" value="提交" />
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div>
<!-- container -->


<br><br><br><br>
<div style="text-align:center;">
<p>荆州市翀购网络科技有限公司版权所有</p>
</div>
</body>
</html>
