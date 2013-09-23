jQuery(function (){
	var aInput = jQuery('#register input');
	for(var i=0;i<aInput.length;i++){
		aInput[i].onfocus = function (){
			jQuery(this).css({
				'border':'2px solid #fea336'
			});
		};
		aInput[i].onblur = function (){
			console.log(jQuery(this));
			jQuery(this).css({
				'border':'2px solid #333'
			});
		};
	};
});