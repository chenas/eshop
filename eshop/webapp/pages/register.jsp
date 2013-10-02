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
						//jQuery('#btn')[0].disabled = true;
						return false;
					} else {
						//Todd Mark
						jQuery('#errorUserName').removeClass();
						jQuery('#errorUserName').addClass('success');
					//	jQuery('#btn')[0].disabled = false;
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
						jQuery('#errorUserName').removeClass();
						jQuery('#errorMail').addClass('wrong');
					//	jQuery('#btn')[0].disabled = true;
						return false;
					} else {
						 //邮箱是否真实存在
						buffalo.remoteCall("userBuyerServiceAjax.existEmail",
								[ $("mail").value ],
								function(reply) {
									if (reply.getResult()) 
									{
										//Todd Mark
										jQuery('#errorUserName').removeClass();		
										jQuery('#errorMail').addClass('success');
									//	jQuery('#btn')[0].disabled = false;
										return true;
									} else {
										// alert("该邮箱不可用");
										//Todd Mark
										jQuery('#errorMail').html('<span></span>该邮箱不可用');
										jQuery('#errorUserName').removeClass();
										jQuery('#errorMail').addClass('wrong');
									//	jQuery('#btn')[0].disabled = true;
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
				<a href="javascript:void(0);" id = "cartList">&nbsp;我的购物车</a>
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
				<span><input type="button"  onclick="document.search.submit();" value="搜索" class="search" id="btn"/></span>
				</form>
				</li>
			</ul>
		</div>
	</div>
	<div id="register">
		<form action="<%=basePath %>pages/commonsys/register.action" method="post" >
			<label for="username">
				登录名&rarr;<input id="username" name="userBuyer.name" onblur="hasName()" value="<s:property value="userBuyer.name" />" type="text" />
			</label>
			<label for="mail">
				邮箱&rarr;<input id="mail" name="userBuyer.email" onblur="hasEmail()" value="<s:property value="userBuyer.email" />"  type="text" />
			</label>
			<label for="passWord">
				密码&rarr;<input id="password" name="userBuyer.password" value="<s:property value="userBuyer.password" />" type="password" />
			</label>
			<label for="confimPassWord">
				密码确认&rarr; <input id="password2" name="userBuyer.password2" type="password" />
			</label>
			<label for="valiate">
				验证码&rarr; <img src="pages/commonsys/SecurityCodeImageAction.action" id="Verify"  style="cursor:hand;" alt="看不清，换一张" />
				<input id="valiate" name="securityCode" type="text" />
			</label>
			<input type="submit" value="提交" id="btn"  />
		</form>
		<div>
			<p id="errorUserName" class="normal">
				<span></span><font color="red"><s:fielderror fieldName="userBuyer.name"/></font>
			</p>
			<p id="errorMail" class="normal">
				<span></span><font color="red"><s:fielderror fieldName="userBuyer.email"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="userBuyer.password"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="userBuyer.password2"/></font>
			</p>
			<p class="normal">
				<span></span><font color="red"><s:fielderror fieldName="securityCode"/></font>
			</p>
		</div>
	</div>
</body>
</html>