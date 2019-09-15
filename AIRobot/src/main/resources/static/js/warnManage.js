layui.use(['layer', 'form','table'], function(){
	var layer = layui.layer;
	var warnListTable = layui.table;
	var tableFilter = layui.tableFilter;
	let loginUserRole = $("#loginUserInfo").attr("role");
	let loginUser = $("#loginUserInfo").text().trim();
	let warnTableOptions = {
			toolbar: '#deleteElarm',
			defaultToolbar: ['filter'],
			elem: '#warnListTable',
			url:'warn/getWarnList',
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

	};
	
	warnListTable.render(warnTableOptions);
	//3、定义一个tableFilter 挂载到 table 上
	var tableFilterIns = tableFilter.render({
	    'elem' : '#warnListTable',//table的选择器
	    'mode' : 'api',//过滤模式
	    'filters' : [{
	    	field: "alarmName",
	    	type: "checkbox",
	    	url: "warn/getAlarmNameList"
	    }],//过滤项配置
	    'done': function(filters){
	    	warnListTable.render(warnTableOptions);
	    }
	})	
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
		window.location.href = "warn/downloadAlarm";
	}

	 
	showImage = function(){
        $('[data-magnify]').Magnify({
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
            modalSize:[800,600],
            beforeOpen:function (obj,data) {
                console.log('beforeOpen')
            },
            opened:function (obj,data) {
                console.log('opened')
            },
            beforeClose:function (obj,data) {
                console.log('beforeClose')
            },
            closed:function (obj,data) {
                console.log('closed')
            },
            beforeChange:function (obj,data) {
                console.log('beforeChange')
            },
            changed:function (obj,data) {
                console.log('changed')
            }
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