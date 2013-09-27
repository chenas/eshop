function initPage()
{
	//index.html
	if(jQuery('#content')[0]){
		bannerRoll();
	};
	//productList.html
	if(jQuery('#sideBar')[0]){
		clickStyle();
		observerScroll();
	};
	if(jQuery('#products')[0]){
		validateStock();
	};
};

function bannerRoll()
{
	var count=0;
	var bLR=true;
	var oBan=jQuery('#content')[0];
	var oUl=oBan.getElementsByTagName('ul')[0];
	var aLi=oUl.getElementsByTagName('li');
	var left = oBan.getElementsByTagName('span')[0];
	var right = oBan.getElementsByTagName('span')[1];
	setInterval(function ()
	{
		oUl.style.width=1000*aLi.length+'px';
		bLR? count++ : count--;
		if(count >=aLi.length-1){
			count=aLi.length-1;
			bLR=false;
		}if(count <= 0){
			count=0;
			bLR=true;
		};
		checkCount(count);
		startMove(oUl, {left: -1000*count});
	},3000);
	addEvent(left, 'click', function (){
		count--;
		if(count <= 0){
			count = 0;
		};
		startMove(oUl, {left: -1000*count});
		checkCount(count);
	});
	addEvent(right, 'click', function (){
		count++;
		if(count >= aLi.length-1){
			count = aLi.length-1;
		};
		checkCount(count);
		startMove(oUl, {left: -1000*count});
	});
	function checkCount(count){
		var oDiv = oBan.getElementsByTagName('div')[0];
		var aLi = oDiv.getElementsByTagName('li');
		for(var i=0;i<aLi.length;i++){
			aLi[i].index = i;
			aLi[i].className = '';
		};
		aLi[count].className = 'active';
	};
};

function clickStyle()
{
	var btnLi = jQuery('#sideBar li');
	var aDiv = jQuery('#sideBar li div');
	for(var i=0;i<btnLi.length;i++){
		btnLi[i].index = i;
		btnLi[i].boolean = true;
		btnLi[i].onmouseover = function (){
			var _this = this;
			setTimeout(function (){
				if(_this.boolean){
					for(var j=0;j<aDiv.length;j++){
						aDiv[j].style.display = 'none';
					};
					aDiv[_this.index].style.display = 'block';
				}else{
					return false;
				};
			},200)
		};
		btnLi[i].onmouseout = function (){
			this.boolean = false;
		};
		btnLi[i].onmousemove = function (){
			this.boolean = true;
		};
	};
};

function validateStock()
{
	var aStock = jQuery('.details > span > strong');
	var oUp = jQuery('.details #up');
	var oDown = jQuery('.details #down');
	var aInput = jQuery('.details > div > input');
	for(var i=0;i<aStock.length;i++){
		aStock[i].index = i;
		oUp[i].index = i;
		oDown[i].index = i;
		aInput[i].index = i;
		//用于模拟最大库存，正式上线需删除随机数代码以免覆盖真实数据
		aStock[i].innerHTML = parseInt(Math.random()*10);
		oUp[i].onmousedown = function (){
			changeCount(this, '+');
		};
		oDown[i].onmousedown = function (){
			changeCount(this, '-');
		};
		aInput[i].onblur = function ()
		{
			var value = this.value;
			if(isNaN(value) || value > 20){
				this.value = 1;
				alert('请注意您输入的格式！')
			}
		};
	};
	function changeCount(obj, op){
		var nInput = parseInt(aInput[obj.index].value);
		var nStock = parseInt(aStock[obj.index].innerHTML);
		switch(op) {
			case '+':
				if(nInput >= nStock){
					return false;
				}else{
					aInput[obj.index].value++;
				}
				break;
			case '-':
				if(nInput <= 1){
					return false;
				}else{
					aInput[obj.index].value--;
				};
				break;
		};
	};
};

function observerScroll(){
	jQuery(window).scroll(function() {
		var nScroll = jQuery(document).scrollTop();
		var oProd = jQuery('#products');
		var sWidth = jQuery(window).width()-100;
		var oSide = jQuery('#sideBar');
		if(nScroll >= 400){
			oProd.show('slow').css({
				'position': 'absolute',
				'left': '100px',
				'width': sWidth
			});
			oSide.fadeOut('fast');
		};
		if(nScroll <= 400){
			oProd.css({
				'position': 'absolute',
				'left': '340px',
				'width': '1000px'
			});
			oSide.fadeIn('slow');
		};
	});
};

addEvent(window, 'load', initPage);