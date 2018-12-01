<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>个人中心</title>
<link href="/myWeb/main/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/myWeb/main/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="/myWeb/main/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<script>
	function submit()
	{
		
		$("#detailID").val($session.get("username"));
	}										
</script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world">
				<div class="cart box_1">
						<a href="main/carDetail.jsp">
						<h3> <div class="total">
							<span class="simpleCart_total"></span></div>
							<img src="/myWeb/main/images/cart.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">购物车</a></p>
					</div>	
			</div>
				
				<div class="col-sm-4 logo">
					<a href="main/main.jsp"><img src="/myWeb/main/images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-sm-4 header-left">		
					<p class="log"><a>在线ing。。。</a> </p>
					<div class="clearfix"> </div>
			</div>
			
				<div class="clearfix"> </div>
			</div>
		</div>
		
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<div class="glyphicon glyphicon-phone" > 官方热线：</div>
					<div>132 7735 1070</div>
				</div>
			<div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="main/main.jsp">首页</a></li>	
				      <li><a  href="main/menProducts.jsp">男装</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>服装style</h4>
									<ul>
										<li><a href="products.html">佩奇T恤</a></li>
										<li><a href="products.html">小红帽</a></li>
										<li><a href="products.html">西部牛仔</a></li>
										<li><a href="products.html">专业装</a></li>
										<li><a href="products.html">社会装</a></li>										
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋袜Style</h4>
									<ul>
										<li><a href="products.html">老北京</a></li>
										<li><a href="products.html">黄球孩</a></li>
										<li><a href="products.html">长征鞋</a></li>
										<li><a href="products.html">花花袜</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>酷炫Style</h4>
									<ul>
										<li><a href="products.html">李宁</a></li>
										<li><a href="products.html">耐克</a></li>
										<li><a href="products.html">阿迪</a></li>
										<li><a href="products.html">新百伦</a></li>
										<li><a href="products.html">乔丹</a></li>
									</ul>	
								</div>
							</div>
						  </div>
						</div>
					</li>
					
				    <li class="grid"><a  href="main/womenProducts.jsp">女装</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>靓女Style</h4>
									<ul>
										<li><a href="products.jsp">中国风</a></li>
										<li><a href="products.jsp">泰国风</a></li>
										<li><a href="products.jsp">韩国风</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>运动Style</h4>
									<ul>
										<li><a href="products.html">休闲</a></li>
										<li><a href="products.html">浪</a></li>
										<li><a href="products.html">稳</a></li>
										<li><a href="products.html">校园女神</a></li>
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>流行Style</h4>
									<ul>
										<li><a href="products.html">前卫</a></li>
										<li><a href="products.html">中卫</a></li>
										<li><a href="products.html">后卫</a></li>
										<li><a href="products.html">门将</a></li>
									</ul>	
								</div>
							</div>
						  </div>
						</div>
					</li>
			  </ul> 
			</div>
			
			<div class="col-sm-2 search">		
				<ul> 
					
				</ul>
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="/myWeb/main/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
		</div>
	</div>
</div>
				
			
				
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
					<link href="/myWeb/main/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!---->		
		</div>
	</div>
</div>
<!--//header-->
<div class="contact">
			<div class="container">
				<h1>个人中心</h1>
				
				<div class="contact-grids">
					<div class="contact-form">
						<div>
								<button type="button" onclick="submit()">测试</button>
						</div>
							
							<form>
								<!--  div class="contact-bottom"-->
								<div>
									<div class="col-md-4 in-contact">
										<span>用户编号</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_id}" />
										
									</div>
									<div class="col-md-4 in-contact">
										<span>用户名</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_name}" />
	
									</div>
									<div class="col-md-4 in-contact">
										<span>用户类型</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_type}" />
									</div>
									<div class="col-md-4 in-contact">
										<span>性别</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_gender}" />
									</div>
									<div class="col-md-4 in-contact">
										<span>Tel</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_tel}" />
									</div>
									<div class="col-md-4 in-contact">
										<span>地址</span>
										<s:textfield name="detailID" label="" value="%{#session.userInfo.user_address}" />
									</div>
									<div class="clearfix"> </div>
								</div>
							</form>
						</div>
				<div class="address">
					<div class=" address-more">
						<h2>翀购网Address</h2>
						<div class="col-md-4 address-grid">
							<i class="glyphicon glyphicon-map-marker"></i>
							
							<div class="address1">
								<p>湖北·中国</p>
								<p>荆州市长江大学</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-phone"></i>
							<div class="address1">
								<p>+86 13277351070</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-envelope"></i>
							<div class="address1">
								<p>610254602@qq.com</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--//content-->

<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>翀购网优惠多多</h2>
				<h2>  欢迎前来选购</h2>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-sm-3 footer-bottom-cate">
					<ul>
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<ul>
					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<ul>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class">&copy; 荆州市翀购网络有限公司版权所有</p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
</html>