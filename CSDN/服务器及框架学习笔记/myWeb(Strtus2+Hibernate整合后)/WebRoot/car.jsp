<%@ page language="java" import="java.util.*"
import="com.yhy.model.GoodsInfo" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
   <form method="post" action="goodsCar.action">
  	<table width="500px" height="200px">
  		<tr>
  			<td align="center">商品编号</td>
  			<td align="center">商品名字</td>
  			<td align="center">商品类型</td>
	  		<td align="center">商品价格</td>
	  		<td align="center">移出购物车</td>
  		</tr>
  		
  		<s:iterator var="car" value="#session.carShopping">	
    	<tr>
    		<td align="center"><s:property value="#car.goods_id"/></td>
    		<td align="center"><s:property value="#car.goods_name"/></td>
    		<td align="center"><s:property value="#car.getGoodsType().type_name"/></td>
    		<td align="center"><s:property value="#car.goods_price"/></td>
    		<td align="center"><s:checkbox name="delGoods" fieldValue="%{#car.goods_id}"/></td>
    	</tr>
    	</s:iterator>
    	
    </table> 
  </center>
     <input type="submit" name="submitCar" value="从购物车移除" onclick="return addCar()"/>
</form>
  </body>
</html>
