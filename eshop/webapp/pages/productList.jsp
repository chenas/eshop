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
	<script type="text/javascript" src="<%=basePath %>js/buffalo/prototype.js"></script> 
	<script type="text/javascript" src="<%=basePath %>js/buffalo/buffalo.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/list.js"></script>
		
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/pagelist.js"></script>

	<script type="text/javascript">
	var endPoint = "<%=request.getContextPath()%>/bfapp";
	var buffalo = new Buffalo(endPoint);
	var i=0;
	jQuery(document).ready(function(){
		jQuery("#productList a").click(function(){
			jQuery(this).parent().each(function() {
				var form = jQuery("#productForm")[i++];
				var id = form[0].value;
				var num = parseInt(form[1].value);
				saveOrderItem(id, num);
			});
		});
	});

	// 加入购物车
	function saveOrderItem(id, num) {
		// 第一个参数是调用业务的方法，第二个是参数列表，用[]括起来，第三个是回调接口，
		// 需要调用的都可以写在这个函数中
		var serviceMethod = "productViewServiceAjax.saveOrderItem";
		var params = [id, num];
		buffalo.remoteCall(
				serviceMethod,
				params,
				function(reply) {
					if (reply.getResult()) 
					{
						alert(reply.getResult());
					}

				});
	};

	</script>
</head>
<body>
	<div id="header">
		<div>
			<h1><s:text name="com.eshop.header" /></h1>
			<h5><a href="javascript:void(0);">&nbsp;我的购物车</a></h5>
			<h5>|</h5>
			<h5><a href="pages/login.jsp" id="login">登&nbsp;&nbsp;录&nbsp;</a></h5>
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
	<div id="productList">
		<s:iterator value="#request.pageList.list" status="i">
		<div class="details">
			<form action="index.jsp" id="productForm" method="post">
			<input type="hidden" name="id" value="<s:property value='id' />">
			<h1><s:property value='name' /></h1>
			<img src="<s:property value='imageBig' />" alt="" />
			<div class="info">
				￥ <strong><s:property value='price' /></strong>
				<h5 id="up">+</h5>
				<input type="text" value="1" name="inputNum" max="<s:property value='remainNumber' />" size="1"/>
				<h5 id="down">-</h5>
			</div>
			<span>库存量:<strong><s:property value='remainNumber' /></strong></span>
			<div class="add">
				<a href="javascript:void(0);">添加</a>
			</div>
			</form>
		</div>
		</s:iterator>
	</div><!-- end of productList div -->
		<div id="panelPage">
			<s:if test="keyword == null">
			<form action="<%=basePath %>shopping/allProduct.action" method="post" name="pageFrm">
			</s:if>
			<s:else>
			<form action="<%=basePath %>shopping/searchProduct.action" method="post" name="pageFrm">
			</s:else>
			<ul>
				<li>
					<!-- 搜索关键词 -->
					<s:if test="keyword != null">
					<input type="hidden" name="keyword" value="<s:property value="keyword"/>" >
					</s:if>
					<input type="hidden" name="productViewFilter.pageNo" id="pageNo" value="<s:property value="#request.pageList.pageNumber"/>" >
					<a id="pre" href="javascript:void(0);">上一页&lt;&lt;</a><!-- 上一页 -->
				</li>
				<li>
					<!-- 当前页 -->
					<a id="showPageNo" href="javascript:void(0);"><s:property value="#request.pageList.pageNumber"/></a>
				</li>
				<li>
					<a id="next" href="javascript:void(0);">&gt;&gt;下一页 </a><!-- 下一页 -->
				</li>
				<li>
					<a id="totalPage">共&nbsp;<s:property value="#request.pageList.totalPage" />&nbsp;页</a>
				</li>
				<li>
				</li>
				<li>
				</li>
			</ul>
			</form>
			<s:if test="keyword == null">
			<form action="<%=basePath %>shopping/allProduct.action" method="post" name="pageFrm2">
			</s:if>
			<s:else>
			<form action="<%=basePath %>shopping/searchProduct.action" method="post" name="pageFrm2">
			</s:else>
			<ul>
				<li>
					<!-- 搜索关键词 -->
					<s:if test="keyword != null">
					<input type="hidden" name="keyword" value="<s:property value="keyword"/>" >
					</s:if>
				</li>
				<li>
					<a href="javascript:void(0);"><input id="tempageNo" name="productViewFilter.pageNo" type="text" size="1"/>页</a>
				</li>
				<li>
					<a id="forward" href="javascript:void(0);">转到</a>
				</li>
			</ul>
			</form>
		</div><!-- end of panelPage div -->
	</div><!-- end of products div -->
</body>
</html>