<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>用户界面</title>
</head>

<body>



<%
request.setCharacterEncoding("UTF-8");
String username=request.getParameter("username");
String pwd=request.getParameter("pwd");
String returnValue=(String)request.getAttribute("ReturnValue");
String id=(String)request.getAttribute("id");
String gender=(String)request.getAttribute("gender");
String tel=(String)request.getAttribute("tel");

out.print("用户名为："+username);
out.print("密码为："+pwd);
out.print("用户ID为："+id);
out.print("性别："+gender);
out.print("电话："+tel);
out.println("当前状态："+returnValue);
%>

 <form id="form1" name="form1" method="post" action="shoppingServlet">
  		&nbsp;商品类型：
  		<input name="goodsTypeID" type="text" id="goodsTypeID" />
  		<br />
  		<br />
  		商品ID：
  		<input name="goodsID" type="text" id="goodsID" />
  		<br />
  		<br />
  		商品名字：
  		<input name="goodsName" type="text" id="goodsName" />
  		<br />
  		<br />
  		<input type="submit" name="Submit" value="提交" />
	</form>

</body>
</html>