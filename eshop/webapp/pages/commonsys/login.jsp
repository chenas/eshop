<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>login</title>
	<script type="text/javascript" src="<%=basePath %>js/jQuery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
</head>
<body>
<script type="text/javascript">
jQuery(function () {  
    //点击图片更换验证码
    jQuery("#Verify").click(function(){
    	jQuery(this).attr("src","pages/commonsys/SecurityCodeImageAction.action?timestamp="+new Date().getTime());
    });
});
</script>
用户名或密码错误<br>
<s:form action="/pages/commonsys/login.action" method="post">
	<s:textfield name="name" label="用户名：" />
	<s:password name="password" label="密   码" />
	<s:submit value="登录" />
	
</s:form>
<img src="pages/commonsys/SecurityCodeImageAction" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/>
</body>
</html>