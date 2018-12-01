<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>我的购物车</title>
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
						<a>
						<h3> <div >
							<span></span></div>
							<img/></h3>
						</a>
						<p><a></a></p>
					</div>	
			</div>
				
				<div class="col-sm-4 logo">
					<a href="main/main.jsp"><img src="images/logo.png" alt=""></a>	
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
				      <li><a  href="#">男装</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>服装style</h4>
									<ul>
										<li><a href="products.jsp">佩奇T恤</a></li>
										<li><a href="products.jsp">小红帽</a></li>
										<li><a href="products.jsp">西部牛仔</a></li>
										<li><a href="products.jsp">专业装</a></li>
										<li><a href="products.jsp">社会装</a></li>										
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋袜Style</h4>
									<ul>
										<li><a href="products.jsp">老北京</a></li>
										<li><a href="products.jsp">黄球孩</a></li>
										<li><a href="products.jsp">长征鞋</a></li>
										<li><a href="products.jsp">花花袜</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>酷炫Style</h4>
									<ul>
										<li><a href="products.jsp">李宁</a></li>
										<li><a href="products.jsp">耐克</a></li>
										<li><a href="products.jsp">阿迪</a></li>
										<li><a href="products.jsp">新百伦</a></li>
										<li><a href="products.jsp">乔丹</a></li>
									</ul>	
								</div>
							</div>
						  </div>
						</div>
					</li>
					
				    <li class="grid"><a  href="#">	女装</a>
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
										<li><a href="products.jsp">休闲</a></li>
										<li><a href="products.jsp">浪</a></li>
										<li><a href="products.jsp">稳</a></li>
										<li><a href="products.jsp">校园女神</a></li>
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>流行Style</h4>
									<ul>
										<li><a href="products.jsp">前卫</a></li>
										<li><a href="products.jsp">中卫</a></li>
										<li><a href="products.jsp">后卫</a></li>
										<li><a href="products.jsp">门将</a></li>
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
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide"> </div>
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
<!---->
<div class="container">
	<div class="check-out">
		<h1>购物车清单</h1>
		<a href="#" class=" to-buy">从购物车移除</a>
    	    <table >
		  <tr>
			<th>商品</th>
			<th>数量</th>		
			<th>价格</th>
			<th>信息</th>
			<th>总价</th>
			<th>移除</th>
		  </tr>
		  <tr>
			<td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>
			
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$100.00</td>
			<td>FREE SHIPPING</td>
			<td>$100.00</td>
			<td> <input type="checkbox" name="category" /> </td>
		  </tr>
		  <tr>
		  <td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce1.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium ) </p>
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$200.00</td>
			<td>FREE SHIPPING</td>
			<td>$200.00</td>
			<td> <input type="checkbox" name="category" /> </td>
		  </tr>
		  <tr>
		  <td class="ring-in"><a href="single.html" class="at-in"><img src="images/ce2.jpg" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="1" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}"></td>		
			<td>$150.00</td>
			<td>FREE SHIPPING</td>
			<td>$150.00</td>
			<td> <input type="checkbox" name="category" /> </td>
		  </tr>
	</table>
	</div>
	<a href="#" class=" to-buy" >购买</a>	
	<div class="clearfix"> </div>
    </div>
</div>
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
