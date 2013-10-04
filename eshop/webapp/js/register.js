jQuery(function (){
	var aInput = jQuery('#register input');
	for(var i=0;i<aInput.length-1;i++){
		jQuery(aInput[i]).bind('focus', function (){
			jQuery(this).css({
				'border':'2px solid #fea336'
			});
		});
		jQuery(aInput[i]).bind('blur', function (){
			jQuery(this).css({
				'border':'2px solid #333'
			});
		});
	};
});