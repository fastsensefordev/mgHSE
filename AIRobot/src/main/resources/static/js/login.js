$(function(){
	layui.use('layer',function () { 
		layui.use('form', function(){
		});
		initAccount();//记住账号
		$("#loginBtn").on("click",function(){
			let userName = $("#LAY-user-login-username").val();
			let password = $("#LAY-user-login-password").val();
			if (userName == undefined || userName == "" || userName.trim() == "") {
				layer.msg('账号不能为空');
				return false;
			}
			if (password == undefined || password == "" || password.trim() == "") {
				layer.msg('密码不能为空');
				return false;
			}
			let remeber = $("#LAY-user-remeber").prop("checked");
			if (remeber) {
				localStorage.setItem("userName", userName);
				localStorage.setItem("password", password);
			}
			$.ajax({  
				url:'loginBy',  
				type:'post',      
				data: {
					"userName": userName,
					"password": password
				}, 
				dataType:'json',  
				success:function(data){  
					if (data.code == 1005 || data.code == 401) {
						layer.msg(data.msg); 
						return false;
					} else if (data.code == 200) {
						window.location.href = "index";
					}
				}  
			});  
		});
		/**
		 * 找回密码
		 */
		$("#forgetPassword").on("click",function(){
			$("#forgetPasswordTemplate input").val("");
			let addUserIndex = layer.open({
				id: "forgetPasswordModal",
				title:"忘记密码",
				type: 1,
				area: ["460px","340px"],
				resize: false,
				move: false,
				btn: ['确定', '取消'],
				content: $('#forgetPasswordTemplate'), //这里content是一个普通的String
				btn1: function(){
					let userName = $("#forgetPasswordTemplate input[name='userName']").val();
					let adminKey = $("#forgetPasswordTemplate input[name='adminKey']").val();
					let password = $("#forgetPasswordTemplate input[name='password']").val();
					if (userName == undefined || userName == "" || userName.trim() == "") {
						layer.msg('账号不能为空');
						return false;
					}
					if (adminKey == undefined || adminKey == "" || adminKey.trim() == "") {
						layer.msg('超级密码不能为空');
						return false;
					}
					if (password == undefined || password == "" || password.trim() == "") {
						layer.msg('新密码不能为空');
						return false;
					} else {
						let patrn = /^[0-9a-zA-Z_\@\\#\$\%\&\\*\\+\-]{6,12}$/;
						if(!patrn.test(password)) { 
							layer.msg('密码不符合格式要求，字符限制6-12个<br/>【字母、数字、@#$%&*_+-】'); 
							return false; 
						} 
					}
					let formParam = {
						userName: userName,
						adminKey: adminKey,
						password: password
					}
					$.ajax({  
						url:'user/retrievePassword',  
						type:'post',      
						data: JSON.stringify(formParam), 
						contentType: "application/json; charset=utf-8",
						dataType:'json',  
						success:function(data){  
							if (data.code == 1005 || data.code == 401) {
								layer.msg(data.msg); 
								return false;
							} else if (data.code == 200) {
								layer.msg("重置成功"); 
								layer.close(addUserIndex);
							}
						}  
					});  
					
				},
				success: function(layero, index){
					
				}
			});
		});
		/**
		 * 记住账号
		 */
		function initAccount() {
			var userName = localStorage.getItem("userName");
			var password = localStorage.getItem('password');
			if (userName != null && userName != undefined) {
				$("#LAY-user-login-username").val(userName);
			}
			if (password != null && password != undefined) {
				$("#LAY-user-login-password").val(password);
			}
		}
	});
});