var List = {
	1: ['图书','音像','数字商品','音像','图书','音像','数字商品','音像'],
	2: ['数字商品','数字商品','数字商品','数字商品'],
	3: ['家居','家具','家装','厨具','图书','音像','数字商品','音像'],
	4: ['音像音像','音像音像','音像音像','音像','音像'],
	5: ['数字商品','音像','图书','厨具','图书','音像','数字商品','音像'],
	6: ['数字商品','音像','图书']
};

function addItem(aLi)
{
	for(var i=0;i<aLi.length;i++){
		var oDiv = document.createElement('div');
		for(var j=0;j<List[i+1].length;j++){
			// console.log(List[i+1].length)
			var oA = '<a href="javascript:void(0);">'+
				List[i+1][j] + 
					'</a>';
			oDiv.innerHTML += oA;
		};
		aLi[i].appendChild(oDiv);
	};
};

function initPage()
{
	//index.html
	var aLi = jQuery('#list li');
	if(aLi[0]){
		// console.log('当前页面的一级列表数为：' + aLi.length);
		addItem(aLi);
	};
	//allProducts.html
	var aLiSide = jQuery('#sideBar li');
	if(aLiSide[0]){
		addItem(aLiSide);
	};
};



addEvent(window, 'load', initPage);