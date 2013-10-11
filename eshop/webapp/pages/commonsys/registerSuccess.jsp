<%@page import="org.springframework.context.annotation.Import"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>注册成功</title>
</head>
<body>
		<a>恭喜您注册成功，请尽快登录注册邮箱完成邮箱验证！正在为您跳转...&nbsp;&nbsp;&nbsp;&nbsp; <font size="20" color="black" id="timer">5</font></a>
	
		<script type="text/javascript">
	//	setInterval("show()", 1000);
		var k=5;
	    var t = 6000;
		var timer = setInterval(function show(){
		    var tdtime = document.getElementById("timer");
			tdtime.innerHTML = k;
			k--;
	    	t -= 1000;
			if(t == 0){
				window.location.href='<%=basePath%>welcome.action';
				clearInterval(timer);
			}
		}, 1000);
		</script>
</body>
</html>