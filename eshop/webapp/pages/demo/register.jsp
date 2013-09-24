<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>注册</title>
</head>
<body>

<form action="<%=path %>/pages/commonsys/register.action" method="post">

<input name="userBuyer.name" type="text" >
<input name="userBuyer.email" type="text" >
<input name="userBuyer.password" type="password" >
<input type="submit" value="提 交" >
	
</form>
<s:actionmessage/>
</body>
</html>