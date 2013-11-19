/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txttitle").blur(txttitleValidHandler);
	
	$("#f_edu").submit(eduValidSubmitHandler);
});
/**
 * 表单提交验证函数
 * ===================================================
 */
function eduValidSubmitHandler() {
	var valid = true;
	if(!txttitleValidHandler()) {
		if(valid) {
			$("#txttitle").focus();
			valid = false;
		}
	}
	if(!txtcontentValidHandler()) {
		if(valid) {
			$("#txtcontent").focus();
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
	if($("#txttitle").val().trim() == "" || $("#txttitle").val().trim().length > 30) {
		$("#err_txttitle").removeClass("hd");
		return false;
	} else {
		$("#err_txttitle").addClass("hd");
	}
	return true;
}
function txtcontentValidHandler() {
//	if($("#txtcontent").val().trim() == "") {
	if(CKEDITOR.instances.txtcontent.getData().trim() == "") {
		$("#err_txtcontent").removeClass("hd");
		return false;
	} else {
		$("#err_txtcontent").addClass("hd");
	}
	return true;
}
