$(function(){
	layui.use('layer',function () { 
		/**
		 * 另存为模板
		 */
		$("#saveAsTemplate").on("click",function(){
			$("#saveTemplate input[name='templateName']").val("");
			let addUserIndex = layer.open({
				id: "saveTemplateModal",
				title: "保存模板",
				type: 1,
				area: ["460px","240px"],
				resize: false,
				move: false,
				btn: ['确定', '取消'],
				content: $('#saveTemplate'), //这里content是一个普通的String
				btn1: function(){
					let templateName = $("#saveTemplate input[name='templateName']").val();
					if (templateName == undefined || templateName == "" || templateName.trim() == "") {
						layer.msg('模板名称不能为空');
						return false;
					}
					let templateChildrens = [];
					templateChildrens.push({
						templateName: templateName + "未佩戴安全帽",
						href : "safeChart?aId=1"
					});
					templateChildrens.push({
						templateName: templateName + "行人非法闯入",
						href : "illegalChart?aId=2"
					});
					templateChildrens.push({
						templateName: templateName + "明火危险",
						href : "dangerChart?aId=3"
					});
					templateChildrens.push({
						templateName: templateName + "综合分析",
						href : "totalChart?aId=4"
					});
					let formParam = {
						template: {
							templateName: templateName,
							href: "dashboard?id="
						},
						childrens: templateChildrens
					};
					$.ajax({  
						url:'template/saveTemplate',  
						type:'post',      
						data: JSON.stringify(formParam), 
						contentType: "application/json; charset=utf-8",
						dataType:'json',  
						success:function(data){  
							if (data.code == 200) {
								layer.msg("保存成功");
								layer.close(addUserIndex);
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
		});
		
		
		$("#fullScreen").on("click",function(){
			if ($(this).hasClass("max-full")) {
				fullScreen($(".dashboard .content-body-detail")[0]);
				$(this).removeClass("max-full");
				$(this).addClass("min-full");
			} else {
				$(this).removeClass("min-full");
				$(this).addClass("max-full");
				exitFullScreen($(".dashboard .content-body-detail")[0]);
			}
		});
	
		function fullScreen(el) {
			var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen,
			wscript;
			if(typeof rfs != "undefined" && rfs) {
				rfs.call(el);
				return;
			}
			if(typeof window.ActiveXObject != "undefined") {
				wscript = new ActiveXObject("WScript.Shell");
				if(wscript) {
					wscript.SendKeys("{F11}");
				}
			}
		}
	
		//退出全屏
		function exitFullScreen(el) {
			var el= document,
			cfs = el.cancelFullScreen || el.webkitCancelFullScreen || el.mozCancelFullScreen || el.exitFullScreen,
			wscript;
	
			if (typeof cfs != "undefined" && cfs) {
				cfs.call(el);
				return;
			}
	
			if (typeof window.ActiveXObject != "undefined") {
				wscript = new ActiveXObject("WScript.Shell");
				if (wscript != null) {
					wscript.SendKeys("{F11}");
				}
			}
		}
	});
});