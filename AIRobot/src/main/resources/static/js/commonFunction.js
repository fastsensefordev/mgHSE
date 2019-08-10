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
		}
		return chartConfig;
	}
		
	commonFuntion.getChartConfig = function(){
		return getChartConfig();
	}
	window.commonFuntion = commonFuntion;
}());