<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title>demos</title>
	<script type="text/javascript" src="<%=basePath %>js/jQuery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
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
<form action="">
<input id="username" name="name" onblur="hasName()" type="text">
</form>
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
<!-- 上传商品 -->
<form action="pages/commonsys/excelContent.action" method="post" enctype="multipart/form-data">
	<input type="file" name="fileExcel" size="50" />
	<input class="submit_txt" name="submit_excel" type="submit" id="submit_excel" value="上传"  />
</form>


<!-- 设置购物车数量 -->
<form action="shopping/addProduct.action" method="post" >
	<input name="id" type="hidden" value="43077e69-02c5-45e6-8205-330105a7c8ac"/>
	<input class="submit_txt" name="submit_excel" type="submit" id="submit_excel" value="提交"  />
</form>
<!-- 设置购物车数量 -->
<form action="shopping/decProduct.action" method="post" >
	<input name="id" type="hidden" value="43077e69-02c5-45e6-8205-330105a7c8ac"/>
	<input class="submit_txt" name="submit_excel" type="submit" id="submit_excel" value="提交dec"  />
</form>
<!-- 设置购物车数量 -->
<form action="shopping/setProduct.action" method="post" >
	<input name="id" type="hidden" value="43077e69-02c5-45e6-8205-330105a7c8ac"/>
	<label>购买数量</label><input name="buyNum" type="text" >
	<input class="submit_txt" name="submit_excel" type="submit" id="submit_excel" value="提交set"  />
</form>

</body>
</html>