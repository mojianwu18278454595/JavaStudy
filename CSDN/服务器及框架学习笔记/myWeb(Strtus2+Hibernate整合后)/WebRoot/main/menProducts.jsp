<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
<title>商品信息</title>
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
					  <li class="grid"><a  href="main/womenProducts.jsp">女装</a></li>	     
					<li><a class="color6" href="main/myDetail.jsp">个人中心</a></li>
			  </ul> 
			</div>
			
			<div class="col-sm-2 search">		
				
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
<!--content-->
<div class="products">
	<div class="container">
		<h1>商品架</h1>
		<div class="col-md-9">
			<div class="content-top1">
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi2.png" alt="" />
						</a>
						<h3><a href="single.html">T-Shirt</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi4.png" alt="" />
						</a>
						<h3><a href="single.html">Shirt</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			
			<div class="clearfix"> </div>
			</div>	
			<div class="content-top1">
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi1.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi3.png" alt="" />
						</a>
						<h3><a href="single.html">T-Shirt</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi5.png" alt="" />
						</a>
						<h3><a href="single.html">T-Shirt</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			
			<div class="clearfix"> </div>
			</div>	
			<div class="content-top1">
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi6.png" alt="" />
						</a>
						<h3><a href="single.html">Jeans</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi7.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="/myWeb/main/images/pi.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			
			<div class="clearfix"> </div>
			</div>	
		</div>
		<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
						<h3 class="cate">男装分区</h3>
							 <ul class="menu-drop">
							<li class="item1"><a href="#"> </a>
								<ul class="cute">
										<li><a href="products.jsp">佩奇T恤</a></li>
										<li><a href="products.jsp">小红帽</a></li>
										<li><a href="products.jsp">西部牛仔</a></li>
										<li><a href="products.jsp">专业装</a></li>
										<li><a href="products.jsp">社会装</a></li>	
								
										<li><a href="products.jsp">老北京</a></li>
										<li><a href="products.jsp">黄球孩</a></li>
										<li><a href="products.jsp">长征鞋</a></li>
										<li><a href="products.jsp">花花袜</a></li>
								
										<li><a href="products.jsp">李宁</a></li>
										<li><a href="products.jsp">耐克</a></li>
										<li><a href="products.jsp">阿迪</a></li>
										<li><a href="products.jsp">新百伦</a></li>
										<li><a href="products.jsp">乔丹</a></li>
								</ul>
							</li>					
						</ul>
					</div>
	<form id="form1" name="form1" method="post" action="goodsInfo.action">
  		&nbsp;商品类型：
  		<input name="goodsTypeID" type="text" id="goodsTypeID" />
  		<br />
  		<br />
  		商 品 ID：
  		<input name="goodsID" type="text" id="goodsID" />
  		<br />
  		<br />
  		商品名字：
  		<input name="goodsName" type="text" id="goodsName" />
  		<br />
  		<br />
  		<input type="submit" name="Submit" value="提交" />
	</form>
				
				
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
<!--//menu-->


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
	
	<p class="footer-class">&copy; 荆州市翀购网络有限公司版权所有</p>
	</div>
</div>

<!--//footer-->
</body>
</html>
