$(function(){
	initImgCenter();
	initClock();
	safeChartConfig.initSafeChart();
	illegalChartConfig.initIllegalChart();
	dangerChartConfig.initDangerChart();
	totalChartConfig.initComplexChart01();
	totalChartConfig.initComplexChart02();
	
	$(window).resize(function(){
		$("body").find("div.select-content").hide();
	});
	
	function initImgCenter() {
		$.ajax({  
			url:'user/getImgCenter',  
			type:'post',      
			data: {}, 
			dataType:'json',  
			success:function(data){  
				if (data.code == 200 && data.data.imgPath != null) {
					$("#imgCenter").attr("src",data.data.imgPath);
				}
			}  
		});  
	}
	
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
	/**
	 * 点击打开算法id
	 */
	$(".icon-switch").on("click",function(e){
		let alarmId = $(this).parent().attr("alarmid");
		let parentId = $(this).parent().attr("id");
		e.stopPropagation();
		let left = $(this).offset().left;
		let top = $(this).offset().top;
		$("body").find("div.select-content").remove();
		$.ajax({  
			url:'warn/getAlarmList',  
			type:'post',      
			data: {}, 
			dataType:'json',  
			success:function(data){  
				if (data.code == 200) {
					let selectIContent = 
						"<div class='select-content' pid='"+parentId+"'><div class='select-title'>请选择一种算法</div><ul>";
					for (var i = 0; i < data.data.list.length; i++) {
						let alarmId = data.data.list[i].alarmId;
						let alarmName = data.data.list[i].alarmName;
						let server = data.data.list[i].server;
						selectIContent += "<li title='"+alarmName+"' id='"+alarmId+"'>"+ alarmName +"</li>";
					}
					selectIContent += "</ul></div>";
					$("body").append(selectIContent);
					$("body .select-content li[id='"+alarmId+"']").addClass("active");
					$("div.select-content").css({
						left: left - 160,
						top: top + 30
					});
				}
			}  
		});  
		
	});
	
	/**
	 * 选择算法
	 */
	$("body").on("click",".select-content li",function(){
		let alarmId = $(this).attr("id");
		let pid = $(this).parents(".select-content").attr("pid");
		$("#"+pid).attr("alarmid",alarmId);
		$("body").find("div.select-content").hide();
	});
	
	$("body").on("click",function(e){
		var target  = $(e.target);
		if(target.closest(".select-content").length == 0){
			$("body").find("div.select-content").hide();
		}　
	});
	//文件上传
	$("#upload-file").on("change",function(){
		let file = $(this).val();
		var formData = new FormData();
		formData.append("file",$("#upload-file")[0].files[0]);
		$.ajax({
	           type:"POST",
	           url: "user/uploadImg",
	           data:formData,
	           dataType:"json",
	           mimeType:"multipart/form-data",
	           cache:false,
	           processData:false,
	           contentType:false,
	           success:function(data){
					if (data.code == 200 && data.data.imgPath != null) {
						$("#imgCenter").attr("src",data.data.imgPath);
					}
		       }

		});
	});
});