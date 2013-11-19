/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txtcontent").blur(txtcontentValidHandler);
	
	$("#f_event").submit(validSubmitHandler);
});
/**
 * 表单提交验证函数
 * ===================================================
 */
function validSubmitHandler() {
	var valid = true;
	if(!txtcontentValidHandler()) {
		if(valid) {
			$("#txtcontent").focus();
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
function txtcontentValidHandler() {
	if($("#txtcontent").val().trim() == "") {
		$("#err_txtcontent").removeClass("hd");
		return false;
	} else {
		$("#err_txtcontent").addClass("hd");
	}
	return true;
}

function uploadFileHandler() {
	if($("#file").val().trim() != "" && !isImageFile($("#file").val())) {
		return false;
	} else {
		return true;
	}
}
