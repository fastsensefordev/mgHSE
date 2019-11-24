(function() {
	var dangerChartConfig = {};
	function initDangerChart() {
		let sid = commonFuntion.getUrlParam("sid");
		let alarmId = $("#dangerChartBody").find("select.alarm-select").val();
		let name = $("#dangerChartBody option:selected").text();
		$("#dangerChartTopical").html(name);
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
						barData.push(data.data.data[i].count);
					}
					let totalNum = data.data.countNum;
					let alarmName = $("#dangerChartTopical").text().trim();
					
					$("#dangerNumItem .alarm-name").html(alarmName);
					$("#dangerNumItem .total-num-span").html(totalNum);
					
					let chartsNum = parseInt($("#safeNumItem .total-num-span").text()) 
								  + parseInt($("#illegalNumItem .total-num-span").text()) 
								  + parseInt($("#dangerNumItem .total-num-span").text());
					$("#chartsTotalNum").html(chartsNum);
				}
			}  
		});
		
		$.ajax({  
			url:'warn/getTotalByAid',  
			type:'post',      
			data: {
				alarmId: alarmId
			}, 
			async:false,
			dataType:'json',
			success:function(data){  
				if (data.code == 200) {
					let totalNum = data.data.countNum;
					let alarmName = $("#dangerChartTopical").text().trim();
					
					$("#dangerNumItem .alarm-name").html(alarmName);
					$("#dangerNumItem .total-num-span").html(totalNum);
					
					let chartsNum = parseInt($("#safeNumItem .total-num-span").text()) 
								  + parseInt($("#illegalNumItem .total-num-span").text()) 
								  + parseInt($("#dangerNumItem .total-num-span").text());
					$("#chartsTotalNum").html(chartsNum);
				}
			}  
		});
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let dangerOption = {
				xAxis : {
					type : 'category',
					boundaryGap : false,
					axisTick : {
						show : true,
						lineStyle : {
							color : [ '#354868' ],
							width : 1,
							type : 'solid'
						}
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
							fontSize : axisLabelFontSize,
						}
					},
					data : xAxisData
				},
				yAxis : [ {
					type : 'value',
					axisTick : {
						show : true,
						lineStyle : {
							color : [ '#354868' ],
							width : 1,
							type : 'solid'
						}
					},
					axisLine : {
						show : true,
						lineStyle : {
							color : [ '#354868' ],
							width : 1,
							type : 'solid'
						}
					},
					splitLine : {
						show : true,
						lineStyle : {
							color : [ '#354868' ],
							width : 1,
							type : 'solid'
						}
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : "#BDD8E7",
							fontSize : axisLabelFontSize,
						}
					}
				} ],
				series : [ {
					data : barData,
					type : 'line',
					symbolSize : 6,
					areaStyle : {
						normal : {
							color : new echarts.graphic.LinearGradient(0, 0, 0,
									2, [ {
										offset : 0,
										color : '#FCB609'
									}, {
										offset : 1,
										color : 'rgba(0,0,0,0)'
									} ]),
						}
					},
					itemStyle : {
						color : "#FCB609"
					}
				} ]
		};
		var dangerChart = echarts.init(document.getElementById('dangerChart'));
		dangerChart.setOption(dangerOption);
		dangerChart.resize();
	}
	
	dangerChartConfig.initDangerChart = function(){
		return initDangerChart();
	}

	$(window).resize(function(){
		initDangerChart();
	});
	
	window.dangerChartConfig = dangerChartConfig;
}());