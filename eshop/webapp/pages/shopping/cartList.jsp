<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>我的购物车</title>
	<!-- begin cssStyle -->
	<link rel="stylesheet" href="<%=basePath %>css/reset.css" />
	<link rel="stylesheet" href="<%=basePath %>css/common.css" />
	<link rel="stylesheet" href="<%=basePath %>css/shopping.css" />
	<!-- end cssStyle -->
	<link rel="shortcut icon" href="favicon.ico" />
	<script type="text/javascript" src="<%=basePath %>js/jQuery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/buffalo/prototype.js"></script> 
	<script type="text/javascript" src="<%=basePath %>js/buffalo/buffalo.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/list.js"></script>
		
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/shopping.js"></script>

	<script type="text/javascript">
	var i=0;
	jQuery(document).ready(function(){
		jQuery("#productList a").click(function(){
			jQuery(this).parent().each(function() {
				var form = jQuery("#productForm")[i++];
				var id = form[0].value;
				var num = parseInt(form[1].value);
				jQuery.ajax({
					url : '<%=basePath %>shopping/saveOrderItem.action',
					type : 'post',
					dataType : 'json',
					data : {id: id, buyNum:num},
					timeout:2000,
					success : 
						function (data) {
						alert("成功加入购物车");
					}
				});
			});
		});
	});
	</script>
</head>
<body>
	<div id="header">
		<div>
			<h1><s:text name="com.eshop.header" /></h1>
			<h5><a href="javascript:void(0);" id = "cartList">&nbsp;我的购物车</a></h5>
			<h5>|</h5>
				<s:if test="#session.loginUser != null">
					<h5><a href="javascript:void(0);"  id = "">&nbsp;您好！&nbsp;<s:property value="#session.loginUser.name" />&nbsp;&nbsp;</a></h5>
				</s:if>
				<s:else>
			<h5><a href="pages/login.jsp" id="login">登&nbsp;&nbsp;录&nbsp;</a></h5>
			<h5>|</h5>
			<h5><a href="pages/register.jsp" id="login">注&nbsp;&nbsp;册&nbsp;</a></h5>
			</s:else>
		</div>
	</div>
	<div id="nav">
		<div>
			<h1><s:text name="com.eshop.name" /></h1>
			<ul>
				<li>
					<a href="main.jsp">首&nbsp;&nbsp;页</a>
				</li>
				<li>
					<a href="javascript:void(0);">活&nbsp;&nbsp;动</a>
				</li>
				<li>
					<a href="shopping/allProduct.action">全部商品</a>
					<ul id="list">
						<li>
							<a href="javascript:void(0);">美味的食品</a>
						</li>
						<li>
							<a href="javascript:void(0);">好喝的饮品</a>
						</li>
						<li>
							<a href="javascript:void(0);">必备日用品</a>
						</li>
						<li>
							<a href="javascript:void(0);">土豪送的礼品</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">关于我们</a>
				</li>
				<li>
				<form action="<%=basePath %>shopping/searchProduct.action" method="post" name="search">
				&nbsp;
				<input type="text" name="keyword" size="20" value="" onfocus="this.value=''"/>
				<span><input type="button"  onclick="document.search.submit();" value="搜索" class="search" id="btn"/></span>
				</form>
				</li>
			</ul>
		</div>
	</div>


	<div class="crumbs">
		<ul>
			<li>
				<span  class="active" ></span>
				查看购物车
			</li>
			<li>
				<span></span>
				确认订单地址
			</li>
			<li>
				<span></span>
				完成
			</li>
		</ul>		
	</div>
	<div id="cart">
		<ol>
			<li>商品</li>
			<li>单价</li>
			<li>数量</li>
			<li>优惠</li>
			<li>合计</li>
		</ol>
		<div class="cart">
			<ul>
				<s:if test="#session.cartList == null || #session.cartList.items == null || #session.cartList.items.size()<1">
					<li>
						<div align="center">亲，购物车还是空的喔...</div>
					</li>
				</s:if>
				<s:iterator value="#session.cartList.items" status="i" >
				<li>
					<form action="">
						<div class="name">
							<img src="<s:property value='imageurl' />" alt="" />
							<strong><s:property value='productName' /></strong>
						</div>
						<div class="price">
							￥<s:property value='price' />
						</div>
						<div class="count">
							<a href="javascript:void(0);">-</a>
							<input type="text" size="1" value="<s:property value='count' />" />
							<a href="javascript:void(0);">+</a>
						</div>
						<div class="discount">
							￥0
						</div>
						<div class="sum">
							￥ <span><s:property value='itempris' /></span> 
						</div>
					</form>
				</li>
				</s:iterator>
			</ul>
			<div id="sum">
				<form action="">
					商品总价:&nbsp;￥<span><s:property value="#session.cartList.totalPrice" /></span>
					<input type="button" value="结算"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>