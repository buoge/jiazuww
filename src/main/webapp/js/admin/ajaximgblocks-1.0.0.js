/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	
});
function delHandler(obj,path) {
	if(!deleteConfirmHandler()) {
		return false;
	}
	var json = {};
	var errmsg = "删除失败，请联系网站管理员！";
	$.ajax({
		url:path,
		type:"get",
		data:json,
		dataType:"json",
		success:ajaxSuccessHandler,
		error:ajaxErrorHandler,
		complete:ajaxCompleteHandler
	});
	function ajaxSuccessHandler(data) {
		if(data) {
			$(obj).parents("li").remove();
		} else {
			alert(errmsg);
		}
	}
	function ajaxErrorHandler() {
		alert(errmsg);
	}
	function ajaxCompleteHandler() {}
}

function updateHandler(obj,path) {
	var json = {};
	var errmsg = "更新失败，请联系网站管理员！";
	$.ajax({
		url:getNoCachePath(path),
		type:"get",
		data:json,
		dataType:"json",
		success:ajaxSuccessHandler,
		error:ajaxErrorHandler,
		complete:ajaxCompleteHandler
	});
	function ajaxSuccessHandler(data) {
		if(data) {
			alert("设置成功");
		} else {
			alert(errmsg);
		}
	}
	function ajaxErrorHandler() {
		alert(errmsg);
	}
	function ajaxCompleteHandler() {}
}
