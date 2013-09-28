<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<%@ page import="com.base.framwork.util.ClientMacUtil" %>
<html>
<head>
<base href="<%=basePath%>">
<title>mainIndex</title>
</head>
<body>
<a href="<%=path %>/pages/adminsys/buyer/list.action">进入用户管理</a><br>
login success!

<%
String smac = "";
String sip = request.getHeader("x-forwarded-for");   
if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
    sip = request.getHeader("Proxy-Client-IP");   
}   
if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
    sip = request.getHeader("WL-Proxy-Client-IP");   
}   
if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
    sip = request.getRemoteAddr();   
}
ClientMacUtil umac = new ClientMacUtil(sip);
smac = umac.GetRemoteMacAddr();
%>
<br>
<input value=<%=sip %>><br>
<input value=<%=smac %> name="userMacAddr" size="20" style="width:150px" readonly="yes">

</body>
</html>