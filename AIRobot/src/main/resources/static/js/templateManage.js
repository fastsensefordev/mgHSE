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
	        treeSpid: -1,             // treetable新增参数
	        treeIdName: 'd_id',       // treetable新增参数
	        treePidName: 'd_pid',     // treetable新增参数
	        treeDefaultClose: true,   // treetable新增参数
	        treeLinkage: true,        // treetable新增参数
	        elem: '#table1',
	        url: 'ip/getTable',
	        cols: [[
	            {type: 'numbers'},
	            {field: 'id', title: 'IP类型'},
	            {field: 'name', title: 'IP地址'},
	            {field: 'sex', title: '录入者'},
	            {field: 'pid', title: '操作'},
	        ]]
	    });
	});
});