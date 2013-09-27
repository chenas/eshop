<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<title>EShop</title>
	<!-- begin cssStyle -->
	<link rel="stylesheet" href="<%=basePath %>css/reset.css" />
	<link rel="stylesheet" href="<%=basePath %>css/common.css" />
	<link rel="stylesheet" href="<%=basePath %>css/index.css" />
	<!-- end cssStyle -->
	<link rel="shortcut icon" href="favicon.ico" />
	<script type="text/javascript" src="<%=basePath %>js/jQuery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/pagelist.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/list.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
	<script type="text/javascript">
	jQuery(document).ready(function(){
		  jQuery("#btn").click(function(){
				var input = jQuery("#search_input").val();
				if(input == null || input == "")
				{
					jQuery("#search_input").bind("onclick", function(){return false;});
				}else
					{
						document.search.submit();
					}
		    jQuery("p").slideToggle();
		  });
		  jQuery("#btn").dblclick(function(){
		    jQuery("#btn").click();
		  });
		});
	</script>
</head>
<body>
<!-- finished -->
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
				<input id="search_input" type="text" name="keyword" size="20" value="" onfocus="this.value=''"/>
				<span><input type="button"   value="搜索" class="search" id="btn"/></span>
				</form>
				</li>
			</ul>
		</div>
	</div>
	<div id="content">
		<ul>
			<s:iterator value="#request.pageList.list" status="i">
			<li>
				<img src="<s:property value='imageurl' />" alt="" />			
			</li>
			</s:iterator>
		</ul>
		<span class="left"></span>
		<span class="right"></span>
		<div>
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
</body>
</html>