$(function(){
	
	var axisLabelFontSize = 14;
	let barWidth = "26px";
	let bgBarWidth = "20px";
	let windowWidth = $(window).width();
	if (windowWidth >= 3840) {
		axisLabelFontSize = 28;
		barWidth = "50px";
		bgBarWidth = "40px";
	}
	
	initIllegalChart();
	
	$(window).resize(function(){
		initIllegalChart();
	});
	
	function initIllegalChart() {
		let illegalOption = {
				title: {
					show: true,
					text: "// 行人非法闯入 //",
					x: "center",
					padding: [25,0,20,0],
					textStyle: {
						fontSize: axisLabelFontSize,
					    color: '#0795EB'
					},
					subtext: "单位：次数",
					subtextStyle: {
						 fontSize: 14,
						 color: '#ECECEE',
						 align: 'left',
						 baseline: 'top'
					}
				},
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
					data: ['6-08', '6-09', '6-10', '6-11', '6-12', '6-13', '6-14']
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
					data: [120, 130, 100, 140, 90, 260, 220],
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

});