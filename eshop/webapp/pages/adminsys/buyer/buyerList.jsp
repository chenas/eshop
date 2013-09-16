<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>buyerlist</title>
</head>
<body>

<s:iterator value="#request.pageList.list" status="i">
<a href="<%=path %>/pages/adminsys/buyer/intoEdit.action?id=<s:property value='id'/>">进入编辑</a><br>
	<a><s:property value="name"/></a><br>
</s:iterator>
<s:debug></s:debug>
</body>
</html>