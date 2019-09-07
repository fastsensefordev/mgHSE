(function() {
	var safeChartConfig = {};
	/**
	 * 安全帽图表渲染初始化
	 */
	function initSafeChart() {
		let sid = commonFuntion.getUrlParam("sid");
		let alarmId = $("#safeChartBody").find("select.alarm-select").val();
		if (sid != null && sid != undefined) {
			$.ajax({  
				url:'template/getTemplateById',  
				type:'post',      
				data: {
					id: sid
				}, 
				async:false,
				dataType:'json',  
				success:function(data){  
					if (data.code == 200 && data.data.template != null) {
						alarmId = JSON.parse(data.data.template.alarmId);
						templateName = data.data.template.templateName;
						console.log(alarmId)
					}
				}  
			});  
		}
		let xAxisData = [];
		let barData = [];
		let maxData = [];
		let colorData = ["#0C6DB4","#0C6DB4","#9B7A24","#732D9C","#7F222F","#B55B21","#B55B21"];
		$.ajax({  
			url:'warn/getEchartsByAid',  
			type:'post',      
			data: {
				alarmId: alarmId
			}, 
			async:false,
			dataType:'json',
			success:function(data){  
				if (data.code == 200) {
					for (var i = 0; i < data.data.data.length; i++) {
						xAxisData.push(data.data.data[i].time);
						let dataObj = {
							value: data.data.data[i].count,
							itemStyle : {
								color : colorData[i]
							}
						};
						barData.push(dataObj);
						let maxObj = {
							value: data.data.maxCount,
							itemStyle : {
								color : "#071D45"
							}
						};
						maxData.push(maxObj);
					}
				}
				let totalNum = data.data.countNum;
				let alarmName = $("#safeChartTopical").text().trim();
					
				$("#safeNumItem .alarm-name").html(alarmName);
				$("#safeNumItem .total-num-span").html(totalNum);
				
				let chartsNum = parseInt($("#safeNumItem .total-num-span").text()) 
							  + parseInt($("#illegalNumItem .total-num-span").text()) 
							  + parseInt($("#dangerNumItem .total-num-span").text());
				$("#chartsTotalNum").html(chartsNum);
			}  
		});
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let safeOption = {
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' |
							// 'shadow'
					}
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				xAxis : [ {
					type : 'category',
					data : xAxisData,
					axisTick : {
						show : false
					},
					axisLine : {
						show : false,
					},
					splitLine : {
						show : false,
					},
					axisLabel : {
						show : true,
						interval: 0,//全部显示
						textStyle : {
							color : "#BDD8E7",
							fontSize : axisLabelFontSize
						}
					}
				}, {
					type : 'category',
					axisTick : {
						show : false
					},
					axisLine : {
						show : false,
					},
					splitLine : {
						show : false,
					}
				} ],
				yAxis : [ {
					type : 'value',
					axisTick : {
						show : false
					},
					axisLine : {
						show : false,
					},
					splitLine : {
						show : false,
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : "#BDD8E7",
							fontSize : axisLabelFontSize
						}
					}
				} ],
				series : [ {
					name : '数据',
					type : 'bar',
					barWidth : barWidth,
					xAxisIndex : 0,
					zlevel : 1,
					data : barData
				}, {
					name : '数据',
					type : 'bar',
					barWidth : bgBarWidth,
					xAxisIndex : 1,
					zlevel : 0,
					data : maxData
				} ]
		};
		var safeChart = echarts.init(document.getElementById('safeChart'));
		safeChart.setOption(safeOption);
		safeChart.resize();
	}

	safeChartConfig.initSafeChart = function(){
		return initSafeChart();
	}
	
/*	$(window).resize(function() {
		initSafeChart();
	});*/
	
	window.safeChartConfig = safeChartConfig;
}());