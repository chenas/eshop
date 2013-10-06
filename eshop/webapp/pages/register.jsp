<%@page import="org.springframework.context.annotation.Import"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>E-shop</title>
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
	<script type="text/javascript" src="<%=basePath %>js/register.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/index.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/pagelist.js"></script>
	<script type="text/javascript">
	var endPoint = "<%=request.getContextPath()%>/bfapp";
	var buffalo = new Buffalo(endPoint);
	//判断用户名是否已被注册
	function hasName() {
		// 第一个参数是调用业务的方法，第二个是参数列表，用[]括起来，第三个是回调接口，
		// 需要调用的都可以写在这个函数中
		buffalo.remoteCall("userBuyerServiceAjax.hasUser",
				[ $("username").value ],
				function(reply) {
					if (reply.getResult()) 
					{
						// alert("用户名已存在");
						//Todd Mark
						jQuery('#errorUserName').removeClass();
						jQuery('#errorUserName').addClass('wrong');
						jQuery('#submitBtn').attr('disabled', true);
						return false;
					} else {
						//Todd Mark
						jQuery('#errorUserName').removeClass();
						jQuery('#errorUserName').addClass('success');
						jQuery('#submitBtn').attr('disabled', false);
						return true;
					}

				});
	};
	function hasEmail() {
		 //邮箱是否已经被注册 existEmail
		buffalo.remoteCall("userBuyerServiceAjax.hasEmail",
				[ $("mail").value ],
				function(reply) {
					if (reply.getResult()) 
					{
						// alert("该邮箱已被注册");
						//Todd Mark
						jQuery('#errorMail').html('<span></span>该邮箱已被注册');
						jQuery('#errorMail').removeClass();
						jQuery('#errorMail').addClass('wrong');
						jQuery('#submitBtn').attr('disabled', true);
						return false;
					} else {
						 //邮箱是否真实存在
						buffalo.remoteCall("userBuyerServiceAjax.existEmail",
								[ $("mail").value ],
								function(reply) {
									if (reply.getResult()) 
									{
										//Todd Mark
										jQuery('#errorMail').removeClass();		
										jQuery('#errorMail').addClass('success');
										jQuery('#errorMail').html('<span></span>');
										jQuery('#submitBtn').attr('disabled', false);
										return true;
									} else {
										// alert("该邮箱不可用");
										//Todd Mark
										jQuery('#errorMail').html('<span></span>该邮箱不可用');
										jQuery('#errorMail').removeClass();
										jQuery('#errorMail').addClass('wrong');
										jQuery('#submitBtn').attr('disabled', true);
										return false;
									}
								});
						return true;
					}
				});
	};

	</script>
</head>
<body>
	<div id="header">
		<div>
			<h1><s:text name="com.eshop.header" /></h1>
			<h5>
				<a href="shopping/cartList.action" >&nbsp;我的购物车</a>
			</h5>
			<h5>|</h5>
			<h5>
				<a href="pages/login.jsp" id="login">登&nbsp;&nbsp;录&nbsp;</a>
			</h5>
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
				<span><input type="button"  onclick="document.search.submit();" value="搜索" class="search" class="btn"/></span>
				</form>
				</li>
			</ul>
		</div>
	</div>
	<div id="register">
		<form action="<%=basePath %>pages/commonsys/register.action" method="post" >
			<label for="username">
				登录名&rarr;<input id="username" name="name" onblur="hasName()" value="<s:property value="name" />" type="text" />
			</label>
			<label for="mail">
				邮箱&rarr;<input id="mail" name="email" onblur="hasEmail()" value="<s:property value="email" />"  type="text" />
			</label>
			<label for="passWord">
				密码&rarr;<input id="password" name="password" value="<s:property value="password" />" type="password" />
			</label>
			<label for="confimPassWord">
				密码确认&rarr; <input id="password2" name="password2" type="password" />
			</label>
			<label for="valiate">
				验证码&rarr; <img src="pages/commonsys/SecurityCodeImageAction.action" id="Verify"  style="cursor:hand;" alt="看不清，换一张" />
				<input id="valiate" name="securityCode" type="text" />
			</label>
			<input type="submit" value="提交"  class="btn" id="submitBtn"  />
		</form>
		<div>
			<p id="errorUserName" class="normal">
				<span></span><font color="red"><s:fielderror fieldName="name"/></font>
			</p>
			<p id="errorMail" class="normal">
				<span></span><font color="red"><s:fielderror fieldName="email"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="password"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="password2"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="securityCode"/></font>
			</p>
		</div>
	</div>
</body>
</html>