(function() {
	var totalChartConfig = {};
	
	function initComplexChart() {
		let alarmids = $("#totalChartContent").attr("alarmids");
		let sid = commonFuntion.getUrlParam("sid");
		let templateName = "";
		let alarmIdObj = null;
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
						alarmIdObj = JSON.parse(data.data.template.alarmId);
						templateName = data.data.template.templateName;
						console.log(alarmIdObj)
						alarmids = alarmIdObj.safeAlarmId + "," + alarmIdObj.illegalAlarmId + "," + alarmIdObj.dangerAlarmId;
						console.log(alarmids)
					}
				}  
			});  
		}
		let xAxisData = [];
		let colorData = ["#0695EB","#31C557","#FD7270"];
		let barData = [];
		let pieData = [];
		$.ajax({  
			url:'warn/getTotalChart',  
			type:'post',      
			data: {
				alarmIds: alarmids
			}, 
			async:false,
			dataType:'json',
			success:function(data){  
				if (data.code == 200) {
					for (var i = 0; i < data.data.data.length; i++) {
						xAxisData.push(data.data.data[i].alarmName);
						barData.push({
							value: data.data.data[i].count,
							itemStyle:{
					        	color: colorData[i]
					        }
						});
						pieData.push({
							name: data.data.data[i].alarmName,
							value: data.data.data[i].count,
							itemStyle:{
					        	color: colorData[i]
					        }
						});
					}
				}
			}  
		});
		
		let axisLabelFontSize = commonFuntion.getChartConfig().axisLabelFontSize;
		let barWidth = commonFuntion.getChartConfig().barWidth;
		let bgBarWidth = commonFuntion.getChartConfig().bgBarWidth;
		let complexOption01 = {
				tooltip : {
					trigger: 'axis',
					axisPointer : { 
						type : 'shadow'
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
					data : xAxisData,
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
								data: barData
							}
						]
		};
		
		var complexChart01 = echarts.init(document.getElementById('complexChart01'));
		complexChart01.setOption(complexOption01);
		complexChart01.resize();
		
		let complexOption02 = {
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
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
							data:pieData
						}
					]
		};
		var complexChart02 = echarts.init(document.getElementById('complexChart02'));
		complexChart02.setOption(complexOption02);
		complexChart02.resize();
	}

	totalChartConfig.initComplexChart = function(){
		initComplexChart();
	}
//	$(window).resize(function(){
//		initComplexChart01();
//		initComplexChart02();
//	});
	
	window.totalChartConfig = totalChartConfig;
	
}());