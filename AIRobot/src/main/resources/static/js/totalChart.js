(function() {
	var totalChartConfig = {};
	
	function initComplexChart01() {
		let alarmId = $("#illegalChartBody").attr("alarmid");
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
//						xAxisData.push(data.data.data[i].time);
//						barData.push(data.data.data[i].count);
					}
				}
			}  
		});
		
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let complexOption01 = {
//				title: {
//					show: true,
//					text: "单位：次数",
//					x: "right",
//					textStyle: {
//						fontSize: axisLabelFontSize,
//					    color: '#ECECEE'
//					}  
//				},
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
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let complexOption02 = {
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
//				legend: {
//					x : 'center',
//					y : 'bottom',
//					data:['未佩戴安全帽','行人非法闯入','明火危险','人员聚集'],
//					textStyle: {
//						color: "#A9C2D3",
//						fontSize: axisLabelFontSize,
//					}
//				},
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

	totalChartConfig.initComplexChart01 = function(){
		return initComplexChart01();
	}
	
	totalChartConfig.initComplexChart02 = function(){
		return initComplexChart02();
	}
	
	initComplexChart01();
	initComplexChart02();
	
	$(window).resize(function(){
		initComplexChart01();
		initComplexChart02();
	});
	
	window.totalChartConfig = totalChartConfig;
	
}());