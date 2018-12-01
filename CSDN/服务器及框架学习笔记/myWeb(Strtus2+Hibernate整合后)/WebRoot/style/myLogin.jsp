<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.net.URLDecoder"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<%
	Cookie[] cookies=request.getCookies();
	String username=null;
	String pwd=null;
	if(cookies!=null)
	{
		for(Cookie ck:cookies)
		{
			if("username".equals(ck.getName()))
                username =URLDecoder.decode(ck.getValue(), "UTF-8"); //Cookie中文解码
			if("pwd".equals(ck.getName()))
				pwd=URLDecoder.decode(ck.getValue(), "UTF-8");	
			request.setAttribute("username", username);
			request.setAttribute("pwd", pwd);
		}
	}
	
	request.setAttribute("username", username);
	request.setAttribute("pwd", pwd);
 %>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翀购网登录界面</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>

<body>

<div class="container">
	<section id="content">
		<form action="${pageContext.request.contextPath }/user_login.action"  method="post">
			<h1>翀购网登录中心</h1>
			<s:actionerror/>
			<div id="user_name">
				<input type="text" placeholder="用户名" value="${username}"
				 name="user_name"/>
			</div>
			<div id="user_pwd">
				<input type="password" placeholder="密 码" value="${pwd}" name="user_pwd" />
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
			</div> 
			<div>
				<input type="radio" name="cookie"  value="15" />
				<label for="radio"></label> <span>记住密码(Cookie 15天有效)</span>
			</div>
			
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录"  name="login" />			
				<a href="#">忘记密码?</a>
				<a href="${pageContext.request.contextPath }/style/myRegister.jsp">注册</a>
				<!-- <a href="#">Register</a> -->
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