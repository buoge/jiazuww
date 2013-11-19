/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txtname").blur(txtnameValidHandler);
	
	$("#f_member").submit(validSubmitHandler);
	$("#f_member2").submit(validSubmitHandler2);
});
/**
 * 表单提交验证函数
 * ===================================================
 */
function validSubmitHandler() {
	if($("#hdaction").val() == "list") {
		var valid = true;
		if(!txtnameValidHandler()) {
			if(valid) {
				$("#txtname").focus();
				valid = false;
			}
		}
		return valid;
	}
}
function validSubmitHandler2() {
	var valid = true;
	if(!chkboxValidHandler2()) {
		if(valid) {
			alert("请选择成员");
			valid = false;
		}
	}
	return valid;
}
/**
 * 表单提交验证函数
 * ===================================================
 */
function txtnameValidHandler() {
	if($("#txtname").val().trim() == "") {
		$("#err_txtname").removeClass("hd");
		return false;
	} else {
		$("#err_txtname").addClass("hd");
	}
	return true;
}
function chkboxValidHandler() {
	if($("#f_member input:checkbox:checked").length == 0) {
		alert("请选择要添加到本家族的会员");
		return false;
	}
	return true;
}

function chkboxValidHandler2() {
	if($("#f_member2 input:checkbox:checked").length == 0) {
		return false;
	}
	return true;
}
