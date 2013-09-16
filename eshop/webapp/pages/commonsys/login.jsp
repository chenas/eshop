<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>login</title>
</head>
<body>
用户名或密码错误<br>
<s:form action="/pages/common/login.action" method="post">
	<s:textfield name="name" label="用户名：" />
	<s:password name="password" label="密   码" />
	<s:submit value="登录" />
	
</s:form>

</body>
</html>