/**
 * 页面的跳转
 * 
 * 分类
 */
var pageNo = 0;
var totalPage = 0;
jQuery(document).ready(function(){
	pageNo = parseInt(jQuery("#pageNo").val()); //当前页
	var htmStr = jQuery("#totalPage").html();
	var ar = htmStr.split("&nbsp;");
	totalPage = parseInt(ar[1]);
	
	//上一页
	jQuery("#pre").click(function(){
		if(parseInt(pageNo) == 1) return;
		else if(parseInt(pageNo) >1){
			pageNo--;
			jQuery("#pageNo").attr('value', pageNo);
			document.pageFrm.submit();
		}
	});

	//下一页
	jQuery("#next").click(function(){
		if(parseInt(pageNo) == parseInt(totalPage)) return;
		else if(parseInt(pageNo) < parseInt(totalPage)){
			pageNo++;
			jQuery("#pageNo").attr('value', pageNo);
			document.pageFrm.submit();
		}
	});

	//调到第几页
	jQuery("#forward").click(function(){
		if(jQuery("#tempageNo").val() > totalPage){
			return;
		}else{
			document.pageFrm2.submit();
		}
	});
	
});