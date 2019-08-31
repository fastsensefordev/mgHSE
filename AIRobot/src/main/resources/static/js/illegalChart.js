(function() {
	
	var illegalChartConfig = {};
	
	function initIllegalChart() {
		let alarmId = $("#illegalChartBody").find("select.alarm-select").val();
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
					let alarmName = $("#illegalChartTopical").text().trim();
					
					$("#illegalNumItem .alarm-name").html(alarmName);
					$("#illegalNumItem .total-num-span").html(totalNum);
					
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
		let illegalOption = {
				xAxis: {
					type: 'category',
					boundaryGap: false,
					axisTick: {
						show: true,
						lineStyle: {
							 color: ['#354868'],
							 width: 1,
							 type: 'solid'
						}
					},
					axisLine: {
						show: false,
					},
					splitLine: {
						show: false,
					},
					axisLabel: {
						show: true,
						textStyle: {
							color: "#BDD8E7",
							fontSize: axisLabelFontSize,
						}
					},
					data: xAxisData
				},
				yAxis: [
					{
						type : 'value',
						axisTick: {
							show: true,
							lineStyle: {
								 color: ['#354868'],
								 width: 1,
								 type: 'solid'
							}
						},
						axisLine: {
							show: true,
							lineStyle: {
								 color: ['#354868'],
								 width: 1,
								 type: 'solid'
							}
						},
						splitLine: {
							show: true,
							lineStyle: {
								 color: ['#354868'],
								 width: 1,
								 type: 'solid'
							}
						},
						axisLabel: {
							show: true,
							textStyle: {
								 color: "#BDD8E7",
								 fontSize: axisLabelFontSize,
							}
						}
					}
				],
				series: [{
					data: barData,
					type: 'line',
					symbolSize: 6,
					areaStyle: {normal: {
						color: new echarts.graphic.LinearGradient(0, 0, 0, 2, [{
							offset: 0,
							color: '#3B9B66'
						}, {
							offset: 1,
							color: 'rgba(0,0,0,0)'
						}]),
					}},
					itemStyle: {
						color: "#5CED7B"

					}
				}]
		};
		var illegalChart = echarts.init(document.getElementById('illegalChart'));
		illegalChart.setOption(illegalOption);
		illegalChart.resize();
	}

	illegalChartConfig.initIllegalChart = function(){
		return initIllegalChart();
	}
//	$(window).resize(function(){
//		initIllegalChart();
//	});
	window.illegalChartConfig = illegalChartConfig;
}());