var List = {
	1: ['饼干/糕点','糖果/巧克力','方便速食','坚果/蜜饯','肉/豆制品'],
	2: ['水','碳酸饮料','功能饮料','茶/咖啡饮料','牛奶乳品','果汁'],
	3: ['插线板','雨伞','纸制品','美容洗护','清洁/收纳'],
	4: ['明信片','书签','挂件/饰品','包包包包',''],
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