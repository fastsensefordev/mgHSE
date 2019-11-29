$(function(){
	let id = commonFuntion.getUrlParam("id");
	if (id != null && id != undefined) {
		let iframeURL = "dashboard?type=edit&id="+id;
		$("#dashboardContent").attr("src",iframeURL);
	}
});