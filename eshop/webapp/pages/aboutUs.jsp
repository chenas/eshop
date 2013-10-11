<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>关于我们</title>
	<meta name="baidu-site-verification" content="5h4Yx0RLb5" />
	<meta name="Keywords" content="上理生活，usstlife，零食，校园购物，校园淘宝，学生超市，礼品" />
	<meta name="Description" content="
上理生活 USSTlife是上海理工大学勤工助学中心网络事业部搭建的校园电子商务平台，竭诚服务上理师生。" />
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
	
	<script type="text/javascript" src="<%=basePath %>js/pagelist.js"></script>
	<script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F901a05d7f349b8a0909a0a43560f9168' type='text/javascript'%3E%3C/script%3E"));
	</script>
</head>
<body>
	<div id="header">
		<div>
			<h1><s:text name="com.eshop.header" /></h1>
			<h5><a href="shopping/cartList.action"  >&nbsp;我的购物车</a></h5>
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
					<a href="pages/activity.jsp">活&nbsp;&nbsp;动</a>
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
					<a href="pages/aboutUs.jsp">关于我们</a>
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

	<div class="about">
		<img src="images/about.png" alt="" /><hr />
		<p>忙……木有时间介绍自己。团队的美女和直男们随时欢迎你的加入(^_^)</p>
	</div>
</body>
</html>