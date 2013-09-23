<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>demos</title>
	<script type="text/javascript" src="js/jQuery.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="<%=basePath %>js/buffalo/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath %>js/buffalo/buffalo.js"></script>
</head>
<body>
<!-- begin of 验证码demo -->
<script type="text/javascript">
jQuery(function () {  
    //点击图片更换验证码
    jQuery("#Verify").click(function(){
    	jQuery(this).attr("src","pages/commonsys/SecurityCodeImageAction.action?timestamp="+new Date().getTime());
    });
});
</script>
<img src="pages/commonsys/SecurityCodeImageAction.action" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/>
<!-- end of 验证码demo -->

<!-- begin of ajax验证 -->

<input id="username" name="name" onblur="hasName()" type="text">

<script type="text/javascript">
/* 	$("#username").blur(function(){
		$.ajax({
			url:"pages/commonsys/hasuser.action",
			data:$("#username").val() ,
			dataType:"text",
			callback:function(data){
				if(data == "true"){
					alert("true");
					return true;
				}else{
					alert("false");
					return false;
				}
			}
		});
	}); */
</script>

<!-- end of ajax验证 -->

<script type="text/javascript">
 
 var endPoint = "<%=request.getContextPath()%>/bfapp";  
   var buffalo = new Buffalo(endPoint);  
   <%--    	 $("#username").blur(function(){
    //第一个参数是调用业务的方法，第二个是参数列表，用[]括起来，第三个是回调接口，  
    //需要调用的都可以写在这个函数中  
    buffalo.remoteCall("userBuyerServiceAjax.hasUser", [$("#username").val()], function(reply){
    	if(reply.getResult()){
    		alert("success");
    	}
    	alert(reply);  
    });  
   });  --%>
   
    function hasName(){
	    //第一个参数是调用业务的方法，第二个是参数列表，用[]括起来，第三个是回调接口，  
	    //需要调用的都可以写在这个函数中  
    	alert(jQuery("#username").val());
	    buffalo.remoteCall("userBuyerServiceAjax.hasUser", [$("username").value], function(reply){
	    	if(reply.getResult()){
	    		alert("success");
	    	}
	    	alert(reply);  
	    }); 
	   
   };
  </script> 


</body>
</html>