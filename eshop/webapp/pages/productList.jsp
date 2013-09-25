<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>商品列表</title>
	<!-- begin cssStyle -->
	<link rel="stylesheet" href="<%=basePath %>css/reset.css" />
	<link rel="stylesheet" href="<%=basePath %>css/common.css" />
	<link rel="stylesheet" href="<%=basePath %>css/index.css" />
	<!-- end cssStyle -->
	<link rel="shortcut icon" href="favicon.ico" />
	<script type="text/javascript" src="<%=basePath %>js/jQuery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/list.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
</head>
<body>
	<div id="header">
		<div>
			<h1>NEKO Design</h1>
			<h5><a href="javascript:void(0);">&nbsp;我的购物车</a></h5>
			<h5>|</h5>
			<h5><a href="pages/login.jsp" id="login">登&nbsp;&nbsp;录&nbsp;</a></h5>
		</div>
	</div>
	<div id="nav">
		<div>
			<h1>Name</h1>
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

	<div id="sideBar">
		<div>
			<ul>
				<li>
					<a href="javascript:void(0);" class="active">美味的食品</a>
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
		</div>
	</div>
	
	<div id="products">
		<s:iterator value="#request.pageList.list" status="i">
		<div class="details">
			<h1><s:property value='name' /></h1>
			<img src="<s:property value='imageBig' />" alt="" />
			<div class="info">
				￥ <strong><s:property value='price' /></strong>
				<h5 id="up">+</h5>
				<input type="text" size="1" value="1" max="<s:property value='remainNumber' />"/>
				<h5 id="down">-</h5>
			</div>
			<span>库存量:<strong><s:property value='remainNumber' /></strong></span>
			<div class="add">
				<a href="javascript:void(0);">添加</a>
			</div>
		</div>
		</s:iterator>
	</div>
</body>
</html>