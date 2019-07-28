$(function(){
	layui.config({
		base: 'static/assets/'
	}).extend({
		treetable: 'treetable-lay/treetable'
	}).use(['treetable'], function () {
		var treetable = layui.treetable;
		 // 渲染表格
	    treetable.render({
	        treeColIndex: 1,          // treetable新增参数
	        treeSpid: 0,             // treetable新增参数
	        treeIdName: 'id',       // treetable新增参数
	        treePidName: 'pid',     // treetable新增参数
	        treeDefaultClose: true,   // treetable新增参数
	        treeLinkage: true,        // treetable新增参数
	        elem: '#table1',
	        url: 'template/getTemplateList',
	        cols: [[
	            {type: 'numbers'},
	            {field: 'templateName', title: '链接名称'},
	            {field: 'href', title: '链接'},
	            {field: 'createTime', title: '创建时间'},
	            {title: '操作',
	             templet: function(d){
	            	if (d.isParent) {
	            		return '<a class="layui-btn layui-btn-xs table-btn" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>'
	      					  +'<a class="layui-btn layui-btn-danger layui-btn-xs table-btn" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>';
	            	} else {
	            		return '';
	            	}
				 }}
	        ]]
	    });
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
	});
});