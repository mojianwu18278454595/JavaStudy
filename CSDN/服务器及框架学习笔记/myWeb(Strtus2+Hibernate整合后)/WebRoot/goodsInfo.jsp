<%@ page language="java" import="java.util.*" import="com.yhy.model.GoodsInfo" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
  	
  <form action="goodsCar.action" method="post">
  <center>
  <input type="submit" name="submitCar" value="添加到购物车" >
  	<table width="500px" height="200px">
  		<tr>
  			<td align="center">商品编号</td>
  			<td align="center">商品名字</td>
  			<td align="center">商品类型名</td>
	  		<td align="center">商品价格</td>
	  		<td align="center">加入购物车</td>
  		</tr>
  		
  	
  		<s:iterator var="l" value="#session.goodsInfo">
  		<tr>
    		<td align="center"><s:property value="#l.goods_id"/></td>
    		<td align="center"><s:property value="#l.goods_name"/></td>
    		<td align="center"><s:property value="#l.getGoodsType().type_name"/></td>
    		<td align="center"><s:property value="#l.goods_price"/></td>
    		<td align="center"><s:checkbox name="addGoods" fieldValue="%{#l.goods_id}"/></td>
    	</tr>
    	</s:iterator>
    
    	
    </table> 
  </center>
  </form>
  </body>
</html>
