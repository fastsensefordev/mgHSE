(function() {
	var dangerChartConfig = {};
	function initDangerChart() {
		let alarmId = $("#dangerChartBody").attr("alarmid");
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
				}
			}  
		});
		
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let dangerOption = {
				title : {
					show : true,
					text : "// 行人非法闯入 //",
					x : "center",
					padding : [ 25, 0, 20, 0 ],
					textStyle : {
						fontSize : axisLabelFontSize,
						color : '#0795EB'
					},
				},
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
	initDangerChart();
	dangerChartConfig.initDangerChart = function(){
		return initDangerChart();
	}

	$(window).resize(function(){
		initDangerChart();
	});
	window.dangerChartConfig = dangerChartConfig;
}());