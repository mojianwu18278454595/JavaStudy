<%@ page language="java" import="java.util.*" import="com.yhy.model.pictureInfo"
import="com.yhy.model.Shooping" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
   <form method="post" action="carServlet">
  	<table width="500px" height="200px">
  		<tr>
  			<td align="center">商品编号</td>
  			<td align="center">商品名字</td>
  			<td align="center">商品类型</td>
	  		<td align="center">商品价格</td>
	  		<td align="center">商品图片编号</td>
	  		<td align="center">移出购物车</td>
  		</tr>
  		
  		<% 
  		pictureInfo pic=new pictureInfo();
  		ArrayList<Shooping> list=new ArrayList<Shooping>();
  		list=(ArrayList<Shooping>)session.getAttribute("carShopping");
  		for(Shooping h:list)
  		{
  		%>
  	
    	<tr>
    		<td align="center"><%=h.getGoodsID() %></td>
    		<td align="center"><%=h.getGoodsName() %></td>
    		<td align="center"><%=h.getGoodsTypeID() %></td>
    		<td align="center"><%=h.getGoodsPrice() %></td>
    		<td align="center"><%=h.getGoodsPictureID() %></td>
    		<td> <input type="checkbox" name="delGoods" value="<%=h.getGoodsID()%>:<%=h.getGoodsName()%>:<%=h.getGoodsPrice()%>"> </td>
    	</tr>
    	<%
    	}
    	 %>
    	
    </table> 
  </center>
     <input type="submit" name="submitCar" value="从购物车移除" onclick="return addCar()"/>
</form>
  </body>
</html>
