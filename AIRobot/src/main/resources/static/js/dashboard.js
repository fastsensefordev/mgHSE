$(function(){

	initSafeChart();
	initIllegalChart();
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
					    fontSize: 14,
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
									 color: "#BDD8E7"
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
										 color: "#BDD8E7"
									}
								}
							}
						],
						series : [{
									name:'数据',
									type:'bar',
									barWidth: '26px',
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
									barWidth: '20px',
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
	};
	
	function initIllegalChart() {
		let illegalOption = {
				title: {
					show: true,
					text: "// 行人非法闯入 //",
					x: "center",
					padding: [25,0,20,0],
					textStyle: {
					    fontSize: 18,
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
							color: "#BDD8E7"
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
								 color: "#BDD8E7"
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
	}

});