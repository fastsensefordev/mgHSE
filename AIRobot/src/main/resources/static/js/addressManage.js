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
		        	{field: 'levelStr', title: '类别',align:"right",width:120},
		            {field: 'ipTypeStr', title: '服务器类型', templet: function(d){
		            	if (d.level == "1") {
		            		return d.ipTypeStr;
		            	} else {
		            		return "";
		            	}
		            },width:220},
		            {field: 'ip', title: '服务器地址',width:230,
		            	templet:function(d) {
		            	return "<a href='" + d.ip + "' target='_blank' class='link-item'>" + d.ip + "</a>";
		            }},
		            {field: 'area', title: '区域',width:200},
		            {field: 'cameraId', title: '摄像头ID'},
		            {field: 'location', title: '摄像头位置'},
		            {field: 'createUser', title: '创建者'},
		            {field: 'createTime', title: '创建时间',width:160},
		            {title: '操作',align:"right",width: 220,
		             templet: function(d){
		            	 let operateTemplate = "";
		            	 //算法服务类型才允许添加摄像头
		            	 if (d.ipType == 0 && (d.level == 1 || d.level ==2)) {
		            		 operateTemplate += '<a class="layui-btn layui-btn-xs table-btn" lay-event="add" mId="'+d.id+'" level="'+d.level+'"><i class="layui-icon">&#xe654;</i>新增</a>';
		            	 }
		            	 operateTemplate += '<a class="layui-btn layui-btn-danger layui-btn-xs table-btn" lay-event="edit" mId="'+d.id+'" level="'+d.level+'"><i class="layui-icon">&#xe642;</i>编辑</a>';
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
	    		layer.confirm('确认删除该地址吗?', function(index){
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
	    	} else if (layEvent == "add") {
	    		let level = $(this).attr("level");
	    		if (level == "1") {
	    			let addAddressIndex = layer.open({
						id: "addAreaModal",
						title:"新增区域",
						type: 1,
						area: ["360px","240px"],
						resize: false,
						move: false,
						btn: ['确定', '取消'],
						content: $('#addAreaTemplate'), //这里content是一个普通的String
						btn1: function(){
							let areaText =  $("#addAreaTemplate input[name='areaText']").val();
							if (areaText == undefined || areaText == "" || areaText.trim() == "") {
								layer.msg('区域不能为空');
								return false;
							}
							let formParam = {
								pid: mid,
								area: areaText
							};
							$.ajax({  
								url:'address/saveArea',  
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
	    		} else if (level=="2") {
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
 	    		
	    	} else {
	    		let level = $(this).attr("level");
	    		if (level == "1") {
	    			let ipText = $(this).parents("tr").find("td[data-field='ip'] .layui-table-cell").text();
	    			$("#editAddressTemplate input[name='ipText']").val(ipText);
	    			let editAddressIndex = layer.open({
						id: "editAddressTemplateModal",
						title:"编辑服务器",
						type: 1,
						area: ["360px","240px"],
						resize: false,
						move: false,
						btn: ['确定', '取消'],
						content: $('#editAddressTemplate'), //这里content是一个普通的String
						btn1: function(){
							let ipText =  $("#editAddressTemplate input[name='ipText']").val();
							if (ipText == undefined || ipText == "" || ipText.trim() == "") {
								layer.msg('地址不能为空');
								return false;
							}
							let formParam = {
								id: mid,
								ip: ipText
							};
							$.ajax({  
								url:'address/updateAddress',  
								type:'post',      
								data: JSON.stringify(formParam), 
								contentType: "application/json; charset=utf-8",
								dataType:'json',  
								success:function(data){  
									if (data.code == 200) {
										layer.msg("更新成功"); 
										layer.close(editAddressIndex);
										initTable();
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
	    		} else if (level == "2") {
	    			let areaText = $(this).parents("tr").find("td[data-field='area'] .layui-table-cell").text();
	    			$("#editAreaTemplate input[name='areaText']").val(areaText);
	    			let editAddressIndex = layer.open({
	    				id: "editAreaTemplateModal",
	    				title:"编辑区域",
	    				type: 1,
	    				area: ["360px","240px"],
	    				resize: false,
	    				move: false,
	    				btn: ['确定', '取消'],
	    				content: $('#editAreaTemplate'), //这里content是一个普通的String
	    				btn1: function(){
	    					let areaText =  $("#editAreaTemplate input[name='areaText']").val();
	    					if (areaText == undefined || areaText == "" || areaText.trim() == "") {
	    						layer.msg('区域不能为空');
	    						return false;
	    					}
	    					let formParam = {
    							id: mid,
    							area: areaText
	    					};
	    					$.ajax({  
	    						url:'address/updateAddress',  
	    						type:'post',      
	    						data: JSON.stringify(formParam), 
	    						contentType: "application/json; charset=utf-8",
	    						dataType:'json',  
	    						success:function(data){  
	    							if (data.code == 200) {
	    								layer.msg("更新成功"); 
	    								layer.close(editAddressIndex);
	    								initTable();
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
	    		} else {
	    			let cameraId = $(this).parents("tr").find("td[data-field='cameraId'] .layui-table-cell").text();
	    			let location = $(this).parents("tr").find("td[data-field='location'] .layui-table-cell").text();
	    			$("#editCameraTemplate input[name='cameraId']").val(cameraId);
					$("#editCameraTemplate input[name='location']").val(location);
	    			let editCameraIndex = layer.open({
						id: "editCameraTemplateModal",
						title:"编辑摄像头",
						type: 1,
						area: ["440px","320px"],
						resize: false,
						move: false,
						btn: ['确定', '取消'],
						content: $('#editCameraTemplate'), //这里content是一个普通的String
						btn1: function(){
							let cameraId =  $("#editCameraTemplate input[name='cameraId']").val();
							let location = $("#editCameraTemplate input[name='location']").val();
							if (cameraId == undefined || cameraId == "" || cameraId.trim() == "") {
								layer.msg('摄像头ID不能为空');
								return false;
							}
							if (location == undefined || location == "" || location.trim() == "") {
								layer.msg('摄像头位置不能为空');
								return false;
							}
							let formParam = {
								id: mid,
								cameraId: cameraId,
								location: location
							};
							$.ajax({  
								url:'address/updateAddress',  
								type:'post',      
								data: JSON.stringify(formParam), 
								contentType: "application/json; charset=utf-8",
								dataType:'json',  
								success:function(data){  
									if (data.code == 200) {
										layer.msg("更新成功"); 
										layer.close(editCameraIndex);
										initTable();
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