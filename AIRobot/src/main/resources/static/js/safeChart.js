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
	
	initSafeChart();
	
	$(window).resize(function(){
		initSafeChart();
	});
	
	/**
	 * 安全帽
	 */
	function initSafeChart() {
		let safeOption = {
				title: {
					show: true,
					text: "单位：次数",
					x: "right",
					textStyle: {
					    fontSize: axisLabelFontSize,
					    color: '#ECECEE'
					}  
				},
				tooltip : {
					trigger: 'axis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis : [{
							type : 'category',
							data : ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
							axisTick: {
								show: false
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
									 fontSize: axisLabelFontSize
								}
							}
						},
						{
							type : 'category',
							axisTick: {
								show: false
							},
							axisLine: {
								show: false,
							},
							splitLine: {
								show: false,
							}
						}
					],
					yAxis : [{
								type : 'value',
								axisTick: {
									show: false
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
										 fontSize: axisLabelFontSize
									}
								}
							}
						],
						series : [{
									name:'数据',
									type:'bar',
									barWidth: barWidth,
									xAxisIndex: 0,
									zlevel: 1,
									data:[{
								        value : 150,
								        itemStyle:{
								        	color: "#0C6DB4"
								        } 
								    }, {
								        value : 150,
								        itemStyle:{
								        	color: "#0C6DB4"
								        }
								    }, {
								        value : 80,
								        itemStyle:{
								        	color: "#9B7A24"
								        }
								    }, {
								        value : 34,
								        itemStyle:{
								        	color: "#732D9C"
								        }
								    }, {
								        value : 39,
								        itemStyle:{
								        	color: "#7F222F"
								        }
								    }, {
								        value : 21,
								        itemStyle:{
								        	color: "#B55B21"
								        }
								    }, {
								        value : 20,
								        itemStyle:{
								        	color: "#B55B21"
								        }
								    }]
								},
								{
									name:'数据',
									type:'bar',
									barWidth: bgBarWidth,
									xAxisIndex: 1,
									zlevel: 0,
									data:[{
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        } 
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    },{
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        } 
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }, {
								        value : 400,
								        itemStyle:{
								        	color: "#071D45"
								        }
								    }]
								}
							]
		};
		var safeChart = echarts.init(document.getElementById('safeChart'));
		safeChart.setOption(safeOption);
		safeChart.resize();
	};

});