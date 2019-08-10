$(function(){

	initClock();
	
	safeChartConfig.initSafeChart();
	illegalChartConfig.initIllegalChart();
	dangerChartConfig.initDangerChart();
	totalChartConfig.initComplexChart01();
	totalChartConfig.initComplexChart02();
	
	$(window).resize(function(){
		$("body").find("div.select-content").hide();
	});

	function initClock() {
		var newTime = '';
		getLangDate();
	}

	function getLangDate(){
		var dateObj = new Date(); //表示当前系统时间的Date对象
		var year = dateObj.getFullYear(); //当前系统时间的完整年份值
		var month = dateObj.getMonth()+1; //当前系统时间的月份值
		var date = dateObj.getDate(); //当前系统时间的月份中的日
		var day = dateObj.getDay(); //当前系统时间中的星期值
		var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
		var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
		var hour = dateObj.getHours(); //当前系统时间的小时值
		var minute = dateObj.getMinutes(); //当前系统时间的分钟值
		var second = dateObj.getSeconds(); //当前系统时间的秒钟值
		var timeValue = "" +((hour >= 12) ? "PM" : "AM" ); //当前时间属于上午、晚上还是下午
		newTime = dateFilter(hour) + ":" + dateFilter(minute) + ":" + dateFilter(second);
		newDate = dateFilter(year) + "-" +dateFilter(month) + "-" + dateFilter(date) + " ";
		document.getElementById("nowTime").innerHTML = newTime;
		document.getElementById("nowDate").innerHTML = newDate + " " + week + " " + timeValue;
		setTimeout(getLangDate,1000);
	}

	function dateFilter(date){ //值小于10时，在前面补0
		if(date < 10){
			return "0" + date;
		}
		return date;
	}

	$(".icon-switch").on("click",function(e){
		e.stopPropagation();
		let left = $(this).offset().left;
		let top = $(this).offset().top;
		$("body").find("div.select-content").remove();
		let selectIContent = "<div class='select-content'>" +
		"<div class='select-title'>请选择一种算法</div>" +
		"<ul>" +
		"<li title='未佩戴安全帽次数</li>" +
		"<li title='行人非法闯入'>行人非法闯入</li>" +
		"<li title='明火危险'>明火危险</li>" +
		"</ul>" +
		"</div>";
		$("body").append(selectIContent);
		$("div.select-content").css({
			left: left - 160,
			top: top + 30
		})
	});

	$("body").on("click",function(e){
		var target  = $(e.target);
		if(target.closest(".select-content").length == 0){
			$("body").find("div.select-content").hide();
		}　
	});

});