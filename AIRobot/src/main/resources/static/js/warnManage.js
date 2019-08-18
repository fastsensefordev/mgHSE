$(function(){
	let loginUserRole = $("#loginUserInfo").attr("role");
	let loginUser = $("#loginUserInfo").text().trim();
	let warnTableOptions = {
			toolbar: '#toolbarDemo',
			defaultToolbar: ['filter', 'print','exports'],
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
					{field:'id', title:'ID', hide: true},
					{field:'alarmName', title:'报警类型'},
					{field:'server', title:'报警地址'},
					{field:'takePic1', title:'图片'},
					{field:'alarmTime', title:'报警时间'},
					{fixed: 'right', title:'操作',width: 150,templet:function(d){
						let editTemp = '<a class="layui-btn layui-btn-xs table-btn" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>';
						let delTemp = '<a class="layui-btn layui-btn-danger layui-btn-xs table-btn" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>';
						let operateTemp = "";
						if (loginUserRole == 0) { //超级管理员 可以管理所有人的权限
							operateTemp = editTemp + delTemp;
						} else { //普通用户，管理自己
							if (d.userName == loginUser || d.phone == loginUser) {
								operateTemp = editTemp + delTemp;
							}
						}
						return operateTemp;
					}}
			]],
			
	};
	layui.use('table', function(){
		var warnListTable = layui.table;
		warnListTable.render(warnTableOptions);

		//头工具栏事件
		warnListTable.on('toolbar(userListTable)', function(obj){
			let checkStatus = userListTable.checkStatus(obj.config.id);
			switch(obj.event){
				case 'getCheckData':
					var data = checkStatus.data;
					layer.alert(JSON.stringify(data));
					break;
				case 'getCheckLength':
					var data = checkStatus.data;
					layer.msg('选中了：'+ data.length + ' 个');
					break;
				case 'addUser':
					addUser();
					break;
			};
		});
		 //监听行工具事件
		warnListTable.on('tool(userListTable)', function(obj){
			let data = obj.data;
			if(obj.event === 'del'){
				layer.confirm('确认处理该报警吗?', function(index){
					$.ajax({  
						url:'warn/dealAlarmById',  
						type:'post',      
						data: {
							userId: obj.data.id
						}, 
						dataType:'json',  
						success:function(data){  
							if (data.code == 200) {
								layer.msg("处理成功");
								layer.close(index);
							}
						}  
					}); 
				});
			} 
		});
	});
		

});