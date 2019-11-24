layui.use(['layer', 'form','table','laydate'], function(){
	var layer = layui.layer;
	var warnListTable = layui.table;
	var tableFilter = layui.tableFilter;
	var laydate = layui.laydate;
	var form = layui.form;
	let loginUserRole = $("#loginUserInfo").attr("role");
	let loginUser = $("#loginUserInfo").text().trim();
	let dateArea = null;
	let warnTableOptions = {
			toolbar: '#deleteElarm',
			defaultToolbar: [],
			elem: '#warnListTable',
			url:'warn/getWarnList',
			where: {
				date: null,
				alarmName: null
			},
			page: true,
			response: {
				statusCode: 200 //规定成功的状态码，默认：0
			},
			parseData: function(res){ //res 即为原始返回的数据
				return {
					"code": res.code, //解析接口状态
					"msg": res.msg, //解析提示文本
					"count": res.data.total, //解析数据长度
					"data": res.data.data //解析数据列表
				};
			},
			cols: [[
				{type: 'checkbox', fixed: 'left'},
				{field:'id', title:'ID', hide: true},
				{field:'alarmName', title:'报警类型'},
				{field:'server', title:'报警地址'},
				{field:'takePic1', title:'图片',templet:function(d){
					return "<a href='javascript:showImage()' data-magnify='gallery' data-src='"+d.takePic1+"' class='img-item'><img src='"+d.takePic1+"'/></a>";
				}},
				{field:'alarmTime', title:'报警时间'},
				{fixed: 'right', title:'操作',width: 150,templet:function(d){
					let delTemp = '<a class="layui-btn layui-btn-danger layui-btn-xs table-btn" lay-event="del"><i class="layui-icon">&#xe640;</i>处理</a>';
					let operateTemp = delTemp;
					if (d.isDelete == 1) {
						operateTemp = delDisabledTemp;
					}
					return operateTemp;
				}}
				]],
//				done: function(res, curr, count){
//					console.log("监听where:", this.where);
//					if (JSON.stringify(this.where) != "{}") {
//						tableFilterIns.reload();
//					}
//				}
	};
	
	warnListTable.render(warnTableOptions);
	
	laydate.render({
		elem: '#date-input',
		range: true,
		done: function(value, date){
		     console.log('你选择的日期是：' + value + '<br><br>获得的对象是' + JSON.stringify(date));
		     warnTableOptions.where.date = value;
		     dateArea = value;
		     warnListTable.render(warnTableOptions);
		}
	});
	
	initSelect();
	function initSelect() {
		let selectData = [];
		$.ajax({  
			url:'warn/getAlarmList',  
			type:'post',      
			data: {}, 
			dataType:'json',
			async: false,
			success:function(data){  
				if (data.code == 200) {
					let alarmName = data.data.list[0].alarmName;
					let optionHtml = "";
					for (var i = 0; i < data.data.list.length; i++) {
						selectData.push({
							name:data.data.list[i].alarmName ,
							value: data.data.list[i].alarmId
						});
					}
				}
			}  
		});
		
		alarmTypeSelect = xmSelect.render({
			el: '#alarmTypeSelect', 
			filterable: true,
			data: selectData,
			theme: {
				color: '#0695EB',
			},
			on: function(data){
				let arr = data.arr;
				let selectAlarmList = [];
				for (let con in arr) {
					selectAlarmList.push(arr[con].name);
				}
				warnTableOptions.where.alarmName = selectAlarmList.join(",");
				warnListTable.render(warnTableOptions);
			},
	    });
	}
	//3、定义一个tableFilter 挂载到 table 上
//	var tableFilterIns = tableFilter.render({
//	    'elem' : '#warnListTable',//table的选择器
//	    'mode' : 'api',//过滤模式
//	    'filters' : [{
//	    	field: "alarmName",
//	    	type: "checkbox",
//	    	url: "warn/getAlarmNameList"
//	    }]
//	})
	
	//头工具栏事件
	warnListTable.on('toolbar(warnListTable)', function(obj){
		let checkStatus = warnListTable.checkStatus(obj.config.id);
		switch(obj.event){
			case 'deleteElarm': 
				deleteAlarm(checkStatus.data) 
				break;
			case 'exportElarm': 
				exportAlarm();
				break;
			case 'dealwithData':
				dealwithData();
				break;
		};
	});
	//监听行工具事件
	warnListTable.on('tool(warnListTable)', function(obj){
		let data = obj.data;
		let delBtn = $(this);
		if ($(this).hasClass("disabled")) {
			return;
		}
		if(obj.event === 'del'){
			layer.confirm('确认处理该报警吗?', function(index){
				$.ajax({  
					url:'warn/dealAlarmById',  
					type:'GET',      
					data: {
						id: obj.data.id
					}, 
					dataType:'json',  
					success:function(data){  
						if (data.code == 200) {
							layer.msg("处理成功");
							console.log(obj);
							delBtn.addClass("disabled");
							layer.close(index);
						}
					}  
				}); 
			});
		} 
	});
	
	initErrorLog();
	/**
	 * 初始化任务日志
	 */
	function initErrorLog() {
		$.ajax({  
			url:'warn/getErrorLog',  
			type:'post',      
			data: {}, 
			async:false,
			dataType:'json',  
			success:function(data){  
				if (data.code == 200 && data.data.data != null) {
					$("#dealwithData").show();
					$(".warn-error").html("<marquee direction=left><i class='layui-icon layui-icon-speaker'></i> 温馨提示您："+data.data.data+"</marquee>");
				} else if (data.code == 200) {
					$("#dealwithData").hide();
				}
			}  
		}); 
	}
	
	function dealwithData() {
		var loadindex = layer.load(0, {shade: false});
		$.ajax({  
			url:'warn/dealWithToday',  
			type:'post',      
			data: {}, 
			dataType:'json',  
			success:function(data){  
				if (data.code == 200) {
					$("#dealwithData").hide();
					$(".warn-error").html("");
					layer.close(loadindex);	
					warnListTable.render(warnTableOptions);
				} else if (data.code == 500) {
					layer.close(loadindex);	
					initErrorLog();
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			　	layer.close(loadindex);	
			}
		}); 
	}
	/**
	 * 删除
	 */
	function deleteAlarm(data) {
		let idList = [];
		for (var i = 0; i < data.length; i++) {
			idList.push(data[i].id)
		}
		let formParam = {
				idList: idList
		};
		$.ajax({  
			url:'warn/batchAlarms',  
			type:'post',      
			data: JSON.stringify(formParam), 
			contentType: "application/json; charset=utf-8",
			dataType:'json',   
			success:function(data){  
				if (data.code == 200) {
					layer.msg("批量删除成功");
					layui.table.reload("warnListTable",warnTableOptions);
				}
			}  
		}); 
	}
	/**
	 * 导出
	 */
	function exportAlarm() {
		let arr = alarmTypeSelect.getValue();
		let selectAlarmList = [];
		for (let con in arr) {
			selectAlarmList.push(arr[con].name);
		}
		let selectAlarmName = selectAlarmList.join(",");
		console.log(selectAlarmName);
		console.log(dateArea);
		window.location.href = "warn/downloadAlarm?alarmName="+selectAlarmName+"&date="+dateArea;
	}
	 
	showImage = function(){
        $("body").find('[data-magnify]').Magnify({
            Toolbar: [
                'prev',
                'next',
                'rotateLeft',
                'rotateRight',
                'zoomIn',
                'actualSize',
                'zoomOut'
            ],
            keyboard:true,
            draggable:true,
            movable:true,
            modalSize:[800,600]
        });
    }
	
	// 获取图片真实高度
	function getImageWidth(url,callback){
	    var img = new Image();
	    img.src = url;
	    // 如果图片被缓存，则直接返回缓存数据
	    if(img.complete){
	        callback(img.width, img.height);
	    }else{
	        img.onload = function(){
	            callback(img.width, img.height);
	        }
	    }
	}

});