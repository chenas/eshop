<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>buyerlist</title>
</head>
<body>
<table>
<s:iterator value="#request.pageList.list" status="i">
<tr>
<%-- <a href="<%=path %>/pages/adminsys/buyer/intoEdit.action?id=<s:property value='id'/>">进入编辑</a><br> --%>
	<td><a><s:property value="name"/></a>&nbsp;&nbsp;&nbsp;</td>
	<td><s:property value="email" />&nbsp;&nbsp;&nbsp;</td>
	<td><s:if test="isValidate == 1">已验证</s:if><s:else>未验证</s:else></td>
</tr>
</s:iterator>
</table>
<s:debug></s:debug>
</body>
</html>