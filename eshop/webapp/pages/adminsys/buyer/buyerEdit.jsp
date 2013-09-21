<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>buyerEdit</title>
</head>
<body>
<s:form action="/pages/adminsys/buyer/submitEdit.action" method="post">
	<s:hidden name="userBuyerModel.id" />
	<input type="hidden" value="userBuyerModel.id" name="id"  >
	<input name="userBuyerFilter.name" value='<s:property value="userBuyerModel.name" />' >
	<s:submit value="提交" />
</s:form>

	<a><s:property value="userBuyerModel.id"/></a><br>
edit
<s:debug></s:debug>
</body>
</html>