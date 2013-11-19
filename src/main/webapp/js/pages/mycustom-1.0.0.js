/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txttitle").blur(txttitleValidHandler);
	
	$("#f_custom").submit(validSubmitHandler);
});
function delHandler(obj,path) {
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
/**
 * 表单提交验证函数
 * ===================================================
 */
function validSubmitHandler() {
	var valid = true;
	if(!txttitleValidHandler()) {
		if(valid) {
			$("#txttitle").focus();
			valid = false;
		}
	}
	if(!uploadFileHandler()) {
		if(valid) {
			alert("请上传jpg/png/gif格式的图像文件");
			valid = false;
		}
	}
	return valid;
}
/**
 * 表单提交验证函数
 * ===================================================
 */
function txttitleValidHandler() {
	if($("#txttitle").val().trim() == "") {
		$("#err_txttitle").removeClass("hd");
		return false;
	} else {
		$("#err_txttitle").addClass("hd");
	}
	return true;
}

function uploadFileHandler() {
	if($("#file").val().trim() == "" || !isImageFile($("#file").val())) {
		return false;
	} else {
		return true;
	}
}