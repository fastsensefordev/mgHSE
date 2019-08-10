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
	
	initClock();
	initSafeChart();
	initIllegalChart();
	initDangerChart();
	initComplexChart01();
	initComplexChart02();
	
	$(window).resize(function(){
		initSafeChart();
		initIllegalChart();
		initDangerChart();
		initComplexChart01();
		initComplexChart02();
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
	
	
	function initDangerChart() {
		let dangerOption = {
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
							color: '#FCB609'
						}, {
							offset: 1,
							color: 'rgba(0,0,0,0)'
						}]),
					}},
					itemStyle: {
						color: "#FCB609"
					}
				}]
		};
		var dangerChart = echarts.init(document.getElementById('dangerChart'));
		dangerChart.setOption(dangerOption);
		dangerChart.resize();
	}
	
	function initComplexChart01() {
		let complexOption01 = {
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
				xAxis : {
					type : 'category',
					data : ["未佩戴安全帽", "行人非法闯入", "明火危险", "人员聚集"],
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
								fontSize: axisLabelFontSize,
							}
						}
				},
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
								show: false,
								textStyle: {
									 color: "#BDD8E7",
									 fontSize: axisLabelFontSize,
								}
							}
						}
					],
					series : [{
								name:'数据',
								type:'bar',
								barWidth: barWidth,
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
							    }]
							}
						]
		};
		var complexChart01 = echarts.init(document.getElementById('complexChart01'));
		complexChart01.setOption(complexOption01);
		complexChart01.resize();
	};
	
	function initComplexChart02() {
		let complexOption02 = {
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					x : 'center',
					y : 'bottom',
					data:['未佩戴安全帽','行人非法闯入','明火危险','人员聚集'],
					textStyle: {
						color: "#A9C2D3",
						fontSize: axisLabelFontSize,
					}
				},
				calculable : true,
				series : [
					{
						name:'半径模式',
						type:'pie',
						radius : ['30%', '80%'],
						center : ['50%', '50%'],
						roseType : 'radius',
						label: {
							normal: {
								show: true,
								textStyle:{
									fontSize: axisLabelFontSize,
								}
							},

						},
						data:[
							{value:40, name:'未佩戴安全帽', itemStyle:{
								color: "#0695EB"
							}},
							{value:20, name:'行人非法闯入', itemStyle:{
								color: "#FD7270"
							}},
							{value:15, name:'明火危险', itemStyle:{
								color: "#FCB609"
							}},
							{value:25, name:'人员聚集', itemStyle:{
								color: "#31C557"
							}},

							]
					}
					]
		};
		var complexChart02 = echarts.init(document.getElementById('complexChart02'));
		complexChart02.setOption(complexOption02);
		complexChart02.resize();

	}
	

});