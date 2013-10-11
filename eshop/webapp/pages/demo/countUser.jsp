
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>application</title>
</head>

<body>
	<%!Integer number;//

	synchronized void numberVisiter() {
		ServletContext application = getServletContext();
		Integer num = (Integer) application.getAttribute("count");
		if (num == null)//如果是第一个访问者
		{
			num = new Integer(1);
			application.setAttribute("count", num);
		} else {
			num = new Integer(num.intValue() + 1);
			application.setAttribute("count", num);
		}
	}%>
	<%
		if (session.isNew()) {
			numberVisiter();
			Integer number = (Integer) application.getAttribute("count");
		}
	%>

	<p>
		<font size="2" color="blue">简单的页面访问计数器</font>
	</p>
	<p>
		<font size="2" color="#000000"> 欢迎访问此页面，您是<%=number%>个访问用户
		</font>
	</p>
</body>
</html>
