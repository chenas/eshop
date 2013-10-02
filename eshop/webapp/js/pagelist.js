/**
 * 页面的跳转
 * 
 */
var pageNo = 0;
var totalPage = 0;
jQuery(document).ready(function(){
	pageNo = parseInt(jQuery("#pageNo").val()); //当前页
	var htmStr = jQuery("#totalPage").html();
	if(htmStr != null){
		var ar = htmStr.split("&nbsp;");
		totalPage = parseInt(ar[1]);
	}
	
	//上一页
	jQuery("#pre").click(function(){
		if(parseInt(pageNo) == 1)
			return false;
		else if(parseInt(pageNo) >1){
			pageNo--;
			console.log(pageNo);
			jQuery("#pageNo").attr('value', pageNo);
			jQuery("#pageFrm").submit();
			//document.pageFrm.submit();
		}
	});

	//下一页
	jQuery("#next").click(function(){
		if(parseInt(pageNo) == parseInt(totalPage)) 
			return false;
		else if(parseInt(pageNo) < parseInt(totalPage)){
			pageNo++;
			jQuery("#pageNo").attr('value', pageNo);
			console.log(pageNo);
			jQuery("#pageFrm").submit();
			//document.pageFrm2.submit();
		}
	});

	//调到第几页
	jQuery("#forward").click(function(){
		if(jQuery("#tempageNo").val() > totalPage){
			return;
		}else{
			jQuery("#pageNo").attr('value', jQuery("#tempageNo").val());
			document.pageFrm2.submit();
		}
	});
	
	//转到购物车	
	jQuery("#cartList").click(function(){
			window.location.href = "shopping/cartList.action";
	});
	
	
});