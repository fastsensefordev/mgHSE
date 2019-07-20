$(function(){
	layui.use('table', function(){
		var table = layui.table;
		table.render({
			 toolbar: '#toolbarDemo',
			elem: '#userListTable',
			url:'user/getUserList',
			page: true,
			response: {
				statusCode: 200 //规定成功的状态码，默认：0
			},
			parseData: function(res){ //res 即为原始返回的数据
				return {
					"code": res.code, //解析接口状态
					"msg": res.msg, //解析提示文本
					"count": 10, //解析数据长度
					"data": res.data.data //解析数据列表
				};
			},
			cols: [[
					 {type: 'checkbox', width: 100, align: "left"}
					,{field:'id', title:'ID', hide: true}
					,{field:'userTypeStr', title:'用户类型'}
					,{field:'userName', title:'用户名', edit: 'text'}
					,{field:'createTime', title:'创建时间'}
					,{field:'lastLoginTime', title:'最后更新时间',}
					,{fixed: 'right', title:'操作', toolbar: '#operateButton',width: 150}
			]],
			
		});

		//头工具栏事件
		table.on('toolbar(userListTable)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
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
		table.on('tool(userListTable)', function(obj){
			var data = obj.data;
			//console.log(obj)
			if(obj.event === 'del'){
				layer.confirm('真的删除行么', function(index){
					obj.del();
					layer.close(index);
				});
			} else if(obj.event === 'edit'){
				layer.prompt({
					formType: 2
					,value: data.userName
				}, function(value, index){
					obj.update({
						userName: value
					});
					layer.close(index);
				});
			}
		});
	});
	/**
	 * 新增用户模态框
	 */
	function addUser() {
		layer.open({
			id: "addUserModal",
			title:"新增用户",
			type: 1,
			area: ["500px","340px"],
			resize: false,
			move: false,
			btn: ['确定', '取消'],
			content: $('#addUserTemplate') //这里content是一个普通的String
		});
	}

});