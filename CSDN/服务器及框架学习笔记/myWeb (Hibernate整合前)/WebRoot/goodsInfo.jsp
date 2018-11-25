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
    
    <title>商品清单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function addCar(){
			var flag=false;
			var eles=doucument.getElementsByName("addGoods");
			for(var i=0;i<eles.length;i++)
			{
				if(eles[i].checked)
				{
					falg=true;
					break;
				}
			}
			if(flag){
				return true;
			}else
			{
				alert("对不起，您没有选择商品！");
				return false;
			}
		}
	</script>

  </head>
  
  <body>
  	
  <form action="carServlet" method="post">
  <center>
  <input type="submit" name="submitCar" value="添加到购物车" >
  	<table width="500px" height="200px">
  		<tr>
  			<td align="center">商品编号</td>
  			<td align="center">商品名字</td>
  			<td align="center">商品类型</td>
	  		<td align="center">商品价格</td>
	  		<td align="center">商品图片编号</td>
	  		<td align="center">加入购物车</td>
  		</tr>
  		
  		<% 
  		pictureInfo pic=new pictureInfo();
  		ArrayList<Shooping> list=(ArrayList<Shooping>)request.getAttribute("listShop");
  		for(Shooping h:list)
  		{
  		%>
  	
    	<tr>
    		<td align="center"><%=h.getGoodsID() %></td>
    		<td align="center"><%=h.getGoodsName() %></td>
    		<td align="center"><%=h.getGoodsTypeID() %></td>
    		<td align="center"><%=h.getGoodsPrice() %></td>
    		<td align="center"><%=h.getGoodsPictureID() %></td>
    		<td> <input type="checkbox" name="addGoods" value="<%=h.getGoodsID()%>:<%=h.getGoodsName()%>:<%=h.getGoodsPrice()%>"> </td>
    	</tr>
    	<%
    	}
    	 %>
    	
    </table> 
  </center>
  </form>
  </body>
</html>
