$(function(){
	layui.config({
		base: 'static/assets/'
	}).extend({
		treetable: 'treetable-lay/treetable'
	}).use(['treetable'], function () {
		initTable();
		function initTable() {
			var treetable = layui.treetable;// 渲染表格
		    treetable.render({
		        treeColIndex: 0,          // treetable新增参数
		        treeSpid: 0,             // treetable新增参数
		        treeIdName: 'id',       // treetable新增参数
		        treePidName: 'pid',     // treetable新增参数
		        treeDefaultClose: true,   // treetable新增参数
		        treeLinkage: true,        // treetable新增参数
		        elem: '#table1',
		        url: 'address/getAddressList',
		        cols: [[
//		            {type: 'numbers'},
		            {field: 'ipTypeStr', title: '服务器类型'},
		            {field: 'ip', title: '服务器地址'},
		            {field: 'cameraId', title: '摄像头ID'},
		            {field: 'location', title: '摄像头位置'},
		            {field: 'createUser', title: '创建者'},
		            {field: 'createTime', title: '创建时间'},
		            {title: '操作',align:"center",
		             templet: function(d){
		            	 let operateTemplate = "";
		            	 //算法服务类型才允许添加摄像头
		            	 if (d.ipType == 0) {
		            		 operateTemplate += '<a class="layui-btn layui-btn-xs table-btn" lay-event="edit" mId="'+d.id+'"><i class="layui-icon">&#xe654;</i>新增</a>';
		            	 }
		            	 operateTemplate += '<a class="layui-btn layui-btn-danger layui-btn-xs table-btn" lay-event="del" mId="'+d.id+'"><i class="layui-icon">&#xe640;</i>删除</a>';
		            	 return "<div class='operate-content'>"+ operateTemplate + "</div>";
		             }}
		        ]]
		    });
		}
	    /**
	     * 
	     */
	    $(".tree-table-content").on("click",".table-btn",function(){
	    	let mid = $(this).attr("mid");
	    	let layEvent = $(this).attr("lay-event");
	    	if (layEvent == "del") {
	    		layer.confirm('确认删除该模板吗?', function(index){
					$.ajax({  
						url:'address/deleteAddress',  
						type:'post',      
						data: {
							id: mid
						}, 
						dataType:'json',  
						success:function(data){  
							if (data.code == 200) {
								layer.msg("删除成功");
								layer.close(index);
								initTable();
							} else {
								layer.msg(data.msg);
								return false;
							}
						}  
					}); 
				});
	    	} else {
	    		let addAddressIndex = layer.open({
					id: "addUserModal",
					title:"新增摄像头",
					type: 1,
					area: ["440px","320px"],
					resize: false,
					move: false,
					btn: ['确定', '取消'],
					content: $('#addCameraTemplate'), //这里content是一个普通的String
					btn1: function(){
						let cameraId =  $("#addCameraTemplate input[name='cameraId']").val();
						let location = $("#addCameraTemplate input[name='location']").val();
						if (cameraId == undefined || cameraId == "" || cameraId.trim() == "") {
							layer.msg('摄像头ID不能为空');
							return false;
						}
						if (location == undefined || location == "" || location.trim() == "") {
							layer.msg('摄像头位置不能为空');
							return false;
						}
						let formParam = {
							pid: mid,
							cameraId: cameraId,
							location : location
						};
						$.ajax({  
							url:'address/saveCamera',  
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
									layer.close(addAddressIndex);
									initTable();
								}
							}  
						});  
					},
					success: function(layero, index){
						
					}
				});
	    	}
	    	
	    });
	    /**
	     * 搜索
	     */
	    $('#btn-search').click(function () {
	    	var keyword = $('#edt-search').val();
	    	var searchCount = 0;
	    	let serchFlag = false;
	    	$('#table1').next('.treeTable').find('.layui-table-body tbody tr td').each(function () {
	    		$(this).css('background-color', 'transparent');
	    		var text = $(this).text();
	    		if (keyword != '' && text.indexOf(keyword) >= 0) {
	    			$(this).css('background-color', 'rgba(250,230,160,0.5)');
	    			if (searchCount == 0) {
	    				treetable.expandAll('#auth-table');
	    				$('html,body').stop(true);
	    				$('html,body').animate({scrollTop: $(this).offset().top - 150}, 500);
	    			} else {
	    				serchFlag = true;
	    			}
	    			searchCount++;
	    		}
	    	});
	    	if (serchFlag) {
	    		 treetable.expandAll('#table1');
	    	}
	    	if (keyword == '') {
	    		layer.msg("请输入搜索内容");
	    	} else if (searchCount == 0) {
	    		layer.msg("没有匹配结果");
	    	}
	    });
	    $("#addAddress").on("click",function(){
	    	let addAddressIndex = layer.open({
				id: "addUserModal",
				title:"新增服务器",
				type: 1,
				area: ["440px","360px"],
				resize: false,
				move: false,
				btn: ['确定', '取消'],
				content: $('#addAddressTemplate'), //这里content是一个普通的String
				btn1: function(){
					let ipType =  $("#addAddressTemplate select[name='addressType']").val();
					let ip = $("#addAddressTemplate input[name='address']").val();
					if (ip == undefined || ip == "" || ip.trim() == "") {
						layer.msg('地址不能为空');
						return false;
					}
					let formParam = {
						ipType: ipType,
						ip : ip
					};
					$.ajax({  
						url:'address/saveAddress',  
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
								layer.close(addAddressIndex);
								initTable();
							}
						}  
					});  
				},
				success: function(layero, index){
					$("#addAddressTemplate select[name='userType']").val("1");
					layui.form.render('select');
				}
			});
	    });
			
	});
});