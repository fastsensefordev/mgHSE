$(function(){
	//获取登录信息
    var role = $("#loginUserInfo").attr("role");
    var loginUser = $("#loginUserInfo").text().trim();
    if(loginUserRole!='role_deploy'&&loginUserRole!='role_all'){
	    $("#addDept").hide();
		$("#delDept").hide();
    }else{
	    $("#addDept").show();
	    $("#delDept").show();
	}
    //zTree配置信息
	var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};
    //zTree方法
	function beforeRemove(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("deptContent");
		zTree.selectNode(treeNode);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	}
	function onRemove(e, treeId, treeNode) {
		console.log(treeNode.name);
	}
	function beforeEditName(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("deptContent");
		zTree.selectNode(treeNode);
		zTree.editName(treeNode);
		return false;
	}
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length == 0) {
			var zTree = $.fn.zTree.getZTreeObj("deptContent");
			zTree.cancelEditName();
			alert("节点名称不能为空.");
			return false;
		}
		return true;
	}
	function onRename(e, treeId, treeNode, isCancel) {
		console.log(treeNode.name);
	}
	function showRemoveBtn(treeId, treeNode) {
		return true;
	}
	function showRenameBtn(treeId, treeNode) {
		return true;
	}

	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj("deptContent");
			zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
			return false;
		});
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	function selectAll() {
		var zTree = $.fn.zTree.getZTreeObj("deptContent");
		zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
	}
	//数据获取
	var zNodes =[
	 			{ id:1, pId:0, name:"父节点 1", open:true},
	 			{ id:11, pId:1, name:"叶子节点 1-1"},
	 			{ id:12, pId:1, name:"叶子节点 1-2"},
	 			{ id:13, pId:1, name:"叶子节点 1-3"},
	 			{ id:2, pId:0, name:"父节点 2", open:true},
	 			{ id:21, pId:2, name:"叶子节点 2-1"},
	 			{ id:22, pId:2, name:"叶子节点 2-2"},
	 			{ id:23, pId:2, name:"叶子节点 2-3"},
	 			{ id:3, pId:0, name:"父节点 3", open:true},
	 			{ id:31, pId:3, name:"叶子节点 3-1"},
	 			{ id:32, pId:3, name:"叶子节点 3-2"},
	 			{ id:33, pId:3, name:"叶子节点 3-3"}
	 		];
	 function getzTreeData(keyword){
		   var zNodes=[];
		   let param = {
				   title : keyword
				};
		   $.ajax({  
				url:'dept/getzTreeData',  
				type:'post',      
				data: JSON.stringify(param), 
				async: false,
				contentType: "application/json; charset=utf-8",
				dataType:'json',  
				success:function(data){  
					if (data.code == 200 && data.data.data) {
						zNodes=data.data.data;
						if(role=='role_deploy'||role=='role_all'){
							$("#addDept").hide();
							$("#delDept").show();
						}
					} else if (data.code == 200) {
						if(role=='role_deploy'||role=='role_all'){
							$("#addDept").show();
							$("#delDept").hide();
						}
					}
				}  
			});   
		   return zNodes;
	   }
	//初始化
	$.fn.zTree.init($("#deptContent"), setting, zNodes);
	
		 layui.use('tree', function(){
			   var loginUserRole = $("#loginUserInfo").attr("role");
			   var loginUser = $("#loginUserInfo").text().trim();
			   if(loginUserRole!='role_deploy'&&loginUserRole!='role_all'){
				    $("#addDept").hide();
					$("#delDept").hide();
			   }else{
				    $("#addDept").show();
				    $("#delDept").show();
			   }
			   var tree = layui.tree;
			   function getTreeData(role,keyword){
				   var deptData=[];
				   let param = {
						   title : keyword
						};
				   $.ajax({  
						url:'dept/getTreeData',  
						type:'post',      
						data: JSON.stringify(param), 
						async: false,
						contentType: "application/json; charset=utf-8",
						dataType:'json',  
						success:function(data){  
							if (data.code == 200 && data.data.data) {
								deptData=data.data.data;
								if(role=='role_deploy'||role=='role_all'){
									$("#addDept").hide();
									$("#delDept").show();
								}
							} else if (data.code == 200) {
								if(role=='role_deploy'||role=='role_all'){
									$("#addDept").show();
									$("#delDept").hide();
								}
							}
						}  
					});   
				   return deptData;
			   }
			   function operateFun(obj){
				   let type = obj.type; //得到操作类型：add、edit、del
			       let data = obj.data; //得到当前节点的数据
			       let elem = obj.elem; //得到当前节点元素
			    	//Ajax 操作
			       let id = data.id; //得到节点索引
			    	if(type === 'add'){ //增加节点
			    		addTreeData(id);
			    	} else if(type === 'update'){ //修改节点
			    		let deptName=elem.find('.layui-tree-txt').html().trim();
			    		console.log(elem.find('.layui-tree-txt').html()); //得到修改后的内容
			    		updateTreeData(id,deptName);
			    	} else if(type === 'del'){ //删除节点
			    		deleteTreeData(id);  
			    	};
			   }
			   function addTreeData(pId){
					let addTreeIndex = layer.open({
						id: "addTreeModal",
						title:"新增部门",
						type: 1,
						area: ["460px","280px"],
						resize: false,
						move: false,
						btn: ['确定', '取消'],
						content: $('#addTreeTemplate'), //这里content是一个普通的String
						btn1: function(){
							let deptName = $("#addTreeTemplate input[name='deptName']").val();
							if (deptName == undefined || deptName == "" || deptName.trim() == "") {
								layer.msg('部门名称不能为空');
								return false;
							}
							let formParam = {
								pId : pId,
								deptName : deptName
							};
							$.ajax({  
								url:'dept/addDeptTree',  
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
										layer.close(addTreeIndex);
										initDeptTree(loginUserRole);
									}
								}  
							});  
						},
						success: function(layero, index){
						}
					});
			   }
			   function updateTreeData(id,deptName){
				   let formParam = {
						id : id,
						deptName : deptName
					};
					$.ajax({  
						url:'dept/updateDeptTree',  
						type:'post',      
						data: JSON.stringify(formParam), 
						contentType: "application/json; charset=utf-8",
						dataType:'json',  
						success:function(data){  
							if (data.code == 1002) {
								layer.msg(data.msg); 
								return false;
							} else if (data.code == 200) {
								layer.msg("修改成功"); 
								initDeptTree(loginUserRole);
							}
						}  
					}); 
			   }
			   function deleteTreeData(id){
				   let formParam = {
						id : id
					};
				   layer.confirm('确认删除该部门吗?', function(index){
					   $.ajax({  
							url:'dept/deleteDeptTree',  
							type:'post',      
							data: JSON.stringify(formParam), 
							contentType: "application/json; charset=utf-8",
							dataType:'json',  
							success:function(data){  
								if (data.code == 1002) {
									layer.msg(data.msg); 
									return false;
								} else if (data.code == 200) {
									layer.msg("删除成功"); 
									layer.close(index);
									initDeptTree(loginUserRole);
								}
							}  
						});
					})
					 
			   }
			   function setNode(obj){
				   console.log(obj.data); //得到当前点击的节点数据
				   console.log(obj.state); //得到当前节点的展开状态：open、close、normal
				   console.log(obj.elem); //得到当前节点元素
				   console.log(obj.data.children); //当前节点下是否有子节点
			   }
			   function initDeptTree(role,keyword){
				   var editTab=(role=='role_deploy'||role=='role_all')?['add', 'update', 'del']:[];
				   //渲染
				    var deptTree = tree.render({
				      elem: '#deptContent'  //绑定元素
				     ,edit: editTab //操作节点的图标
				     ,id: 'deptTree'
				     ,showCheckbox: false  //是否显示复选框
				     ,customOperate:true//节点操作自定义
				     ,operate: function(obj){operateFun(obj);}
				     ,data: getTreeData(role,keyword)
				      ,spread: function (obj) {console.log(obj.data);}
				     ,click: function(obj){debugger;setNode(obj);}
				    });
			   }
//			   initDeptTree(loginUserRole);
			   
	    /**
	     * 搜索
	     */
	    $('#btn-search').click(function () {
	    	var keyword = $('#edt-search').val();
	    	initDeptTree(loginUserRole,keyword);
	    });
	    $("#addDept").on("click",function(){
	    	let addDeptIndex = layer.open({
				id: "addDeptModal",
				title:"新增组织架构",
				type: 1,
				area: ["460px","280px"],
				resize: false,
				move: false,
				btn: ['确定', '取消'],
				content: $('#addDeptTemplate'), //这里content是一个普通的String
				btn1: function(){
					let rootName = $("#addDeptTemplate input[name='rootName']").val();
					if (rootName == undefined || rootName == "" || rootName.trim() == "") {
						layer.msg('公司名称不能为空');
						return false;
					}
					let formParam = {
						deptName : rootName
					};
					$.ajax({  
						url:'dept/initialDeptRoot',  
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
								layer.close(addDeptIndex);
								initDeptTree(loginUserRole);
							}
						}  
					});  
				},
				success: function(layero, index){
				}
			});
	    });
	    
		
	    
	    $("#delDept").on("click",function(){
	    	//var checkData = tree.getChecked('deptTree');//获取复选框数据
	    	layer.confirm('确认删除所有组织架构吗?', function(index){
				$.ajax({  
					url:'dept/deleteDeptForChecked',  
					type:'post',      
					data: {
					}, 
					dataType:'json',  
					success:function(data){  
						if (data.code == 200) {
							layer.msg("删除成功");
							layer.close(index);
						}
					}  
				}); 
			})
	    });
			
	});
});