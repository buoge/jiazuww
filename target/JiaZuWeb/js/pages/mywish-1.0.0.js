/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txtcontent").blur(txtcontentValidHandler);
	
	$("#f_wish").submit(validSubmitHandler);
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
