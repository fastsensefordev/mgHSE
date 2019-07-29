$(function(){
	let userTableOptions = {
			toolbar: '#toolbarDemo',
			defaultToolbar: ['filter', 'print'],
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
					"count": res.data.total, //解析数据长度
					"data": res.data.data //解析数据列表
				};
			},
			cols: [[
					{field:'id', title:'ID', hide: true},
					{field:'userTypeStr', title:'用户类型'},
					{field:'phone', title:'手机号'},
					{field:'userName', title:'账号'},
					{field:'createTime', title:'创建时间'},
					{field:'lastLoginTime', title:'最后更新时间',},
					{fixed: 'right', title:'操作', toolbar: '#operateButton',width: 150}
			]],
			
	};
	layui.use('table', function(){
		var userListTable = layui.table;
		userListTable.render(userTableOptions);

		//头工具栏事件
		userListTable.on('toolbar(userListTable)', function(obj){
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
		userListTable.on('tool(userListTable)', function(obj){
			let data = obj.data;
			//console.log(obj)
			if(obj.event === 'del'){
				layer.confirm('确认删除该用户吗?', function(index){
					$.ajax({  
						url:'user/deleteUser',  
						type:'post',      
						data: {
							userId: obj.data.id
						}, 
						dataType:'json',  
						success:function(data){  
							if (data.code == 200) {
								layer.msg("删除成功");
								obj.del();
								layer.close(index);
							}
						}  
					}); 
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
		$("#addUserTemplate input.layui-input").val("");//清空数据
		let addUserIndex = layer.open({
			id: "addUserModal",
			title:"新增用户",
			type: 1,
			area: ["520px","420px"],
			resize: false,
			move: false,
			btn: ['确定', '取消'],
			content: $('#addUserTemplate'), //这里content是一个普通的String
			btn1: function(){
				let phone = $("#addUserTemplate input[name='phone']").val();
				let userName = $("#addUserTemplate input[name='userName']").val();
				let password = $("#addUserTemplate input[name='password']").val();
				if (phone == undefined || phone == "" || phone.trim() == "") {
					layer.msg('手机号不能为空');
					return false;
				} else {
			        let reg = /^1[34578]\d{9}$/;
			        if (!reg.test(phone)) {
			        	layer.msg('手机号格式不正确');
						return false;
			        }
				}
				if (userName == undefined || userName == "" || userName.trim() == "") {
					layer.msg('账号不能为空');
					return false;
				} else {
					var nameReg = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){3,19}$/;
					if(!nameReg.test(userName)) { 
						layer.msg('账号只支持输入4-20个以字母开头、数字、“_”、“.”的字串！'); 
						return false; 
					} 
				}
				if (password == undefined || password == "" || password.trim() == "") {
					layer.msg('密码不能为空');
					return false;
				} else {
					let patrn = /^[0-9a-zA-Z_\@\\#\$\%\&\\*\\+\-]{6,12}$/;
					if(!patrn.test(password)) { 
						layer.msg('密码不符合格式要求，字符限制6-12个<br/>【字母、数字、@#$%&*_+-】'); 
						return false; 
					} 
				}
				let userType = $("#addUserTemplate select[name='userType']").val();
				let formParam = {
					user: {
						phone: phone,
						userName : userName,
						password: password,
						userType: userType
					}
				};
				$.ajax({  
					url:'user/addUser',  
					type:'post',      
					data: JSON.stringify(formParam), 
					contentType: "application/json; charset=utf-8",
					dataType:'json',  
					success:function(data){  
						if (data.code == 1002) {
							layer.msg(data.msg); 
							return false;
						} else if (data.code == 200) {
							layer.msg("添加成功"); 
							layer.close(addUserIndex);
							layui.table.reload("userListTable",userTableOptions);
						}
					}  
				});  
			},
			success: function(layero, index){
				$("#addUserTemplate select[name='userType']").val("1");
				layui.form.render('select');
			}
		});
		
	}

});