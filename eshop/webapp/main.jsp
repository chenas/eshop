<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<title>welcome</title>
	<s:text name="com.eshop.head.meta" />
	<s:text name="com.eshop.head.javascript" />
</head>
<body>
	<script type="text/javascript">
		window.location.href="<%=basePath%>welcome.action";
	</script>
</body>
</html>