$(function(){
	totalChartConfig.initComplexChart();
	
	setInterval(initAlarm,60*60*1000);//1小时执行一次
	
	function initAlarm() {
		let now = new Date();
		console.log("initComplexChart 刷新一次" + now);
		totalChartConfig.initComplexChart();
	}
	$("#fullScreen").on("click",function(){
		if ($(this).hasClass("max-full")) {
			fullScreen($(".dashboard .content-body-detail")[0]);
			$(this).removeClass("max-full");
			$(this).addClass("min-full");
		} else {
			$(this).removeClass("min-full");
			$(this).addClass("max-full");
			exitFullScreen($(".dashboard .content-body-detail")[0]);
		}
	});
	
	function fullScreen(el) {
		var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen,
		wscript;
		if(typeof rfs != "undefined" && rfs) {
			rfs.call(el);
			return;
		}
		if(typeof window.ActiveXObject != "undefined") {
			wscript = new ActiveXObject("WScript.Shell");
			if(wscript) {
				wscript.SendKeys("{F11}");
			}
		}
	}

	//退出全屏
	function exitFullScreen(el) {
		var el= document,
		cfs = el.cancelFullScreen || el.webkitCancelFullScreen || el.mozCancelFullScreen || el.exitFullScreen,
		wscript;

		if (typeof cfs != "undefined" && cfs) {
			cfs.call(el);
			return;
		}

		if (typeof window.ActiveXObject != "undefined") {
			wscript = new ActiveXObject("WScript.Shell");
			if (wscript != null) {
				wscript.SendKeys("{F11}");
			}
		}
	}
	
});