$(function(){
	let loginUserRole = $("#loginUserInfo").attr("role");
	let loginUser = $("#loginUserInfo").text().trim();
	let audioTableOptions = {
			toolbar: '#audioToolbar',
			defaultToolbar: ['filter'],
			elem: '#audioListTable',
			url:'address/getAudioList',
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
					{field:'alarmEn', title:'报警类型英文', hide: true},
					{field:'musicName', title:'报警描述'},
					{field:'musicPath', title:'报警文件路径'},
					{fixed: 'right', title:'操作',width: 150,templet:function(d){
						let operateTemplate = '<a class="layui-btn layui-btn-xs table-btn" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>';
						return operateTemplate;
					}}
			]],
			
	};
	layui.use('table', function(){
		var audioListTable = layui.table;
		audioListTable.render(audioTableOptions);
		 //监听行工具事件
		audioListTable.on('tool(audioListTable)', function(obj){
			let data = obj.data;
			//console.log(obj)
			if(obj.event === 'edit'){
				let alarmName = data.alarmName;
				let musicName = data.musicName;
				let musicPath = data.musicPath;
				let alarmEn = data.alarmEn;
				$("#updateMusicTemplate input[name='alarmName']").val(alarmName);
				$("#updateMusicTemplate input[name='musicName']").val(musicName);
				$("#updateMusicTemplate input[name='musicPath']").val(musicPath);
				let updateMusicModalIndex = layer.open({
					id: "updateeMusicModal",
					title:"编辑算法音乐",
					type: 1,
					area: ["520px","380px"],
					resize: false,
					move: false,
					btn: ['确定', '取消'],
					content: $('#updateMusicTemplate'), //这里content是一个普通的String
					btn1: function(){ 
						let alarmName = $("#updateMusicTemplate input[name='alarmName']").val();
						let musicName = $("#updateMusicTemplate input[name='musicName']").val();
						let musicPath = $("#updateMusicTemplate input[name='musicPath']").val();
						if (musicPath == undefined || musicPath == "" || musicPath.trim() == "") {
							layer.msg('音乐路径不能为空');
							return false;
						}
						let formParam = {
							id:data.id,
							alarmName:alarmName,
							alarmEn : alarmEn,
							musicName : musicName,
							musicPath: musicPath
						};
						$.ajax({  
							url:'address/updateMusic',  
							type:'post',      
							data: JSON.stringify(formParam), 
							contentType: "application/json; charset=utf-8",
							dataType:'json',  
							success:function(data){  
								if (data.code == 200) {
									layer.msg("更新成功"); 
									layer.close(updateMusicModalIndex);
									layui.table.reload("audioListTable",audioTableOptions);
								} else {
									layer.msg(data.msg); 
									return false;
								}
							}  
						});
					},
					success: function(layero, index){
						
					}
				});
			}
		});
	});

});