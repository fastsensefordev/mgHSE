$(function(){
	layui.use('layer',function () { 
		$("#forgetPassword").on("click",function(){
			$("#addUserTemplate input.layui-input").val("");//清空数据
			let addUserIndex = layer.open({
				id: "forgetPasswordModal",
				title:"忘记密码",
				type: 1,
				area: ["460px","320px"],
				resize: false,
				move: false,
				btn: ['确定', '取消'],
				content: $('#forgetPasswordTemplate'), //这里content是一个普通的String
				btn1: function(){
					
				},
				success: function(layero, index){
				}
			});
		});
	});
});