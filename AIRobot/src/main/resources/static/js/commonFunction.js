(function() {
	var commonFuntion = {};
	let chartConfig = {
		axisLabelFontSize : 14,
		barWidth : "26px",
		bgBarWidth : "20px"
	};
	function getChartConfig() {
		let windowWidth = $(window).width();
		if (windowWidth >= 3840) {
			chartConfig.axisLabelFontSize = 28;
			chartConfig.barWidth = "50px";
			chartConfig.bgBarWidth = "40px";
		} else {
			chartConfig.axisLabelFontSize = 14;
			chartConfig.barWidth = "26px";
			chartConfig.bgBarWidth = "20px";
		}
		return chartConfig;
	}
	
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r != null) return decodeURI(r[2]); return null; //返回参数值
	}
		
	commonFuntion.getChartConfig = function(){
		return getChartConfig();
	}
	commonFuntion.getUrlParam = function(name){
		return getUrlParam(name);
	}
	window.commonFuntion = commonFuntion;
}());