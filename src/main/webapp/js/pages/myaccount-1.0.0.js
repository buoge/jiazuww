/**
 * login页面表单验证
 */
$(function(){
	$("#txtoldpwd").blur(registerValid_txtoldpwd_Handler);
	$("#txtpwd").blur(registerValid_txtpwd_Handler);
	$("#txtpwd2").blur(registerValid_txtpwd2_Handler);
	
	$("#f_pwd").submit(pwdSubmitHandler);
	$("#f_infor").submit(inforSubmitHandler);
});
function pwdSubmitHandler() {
	var valid = true;
	if(!registerValid_txtoldpwd_Handler()) {
		if(valid) {
			$("#txtoldpwd").focus();
			valid = false;
		}
	}
	if(!registerValid_txtpwd_Handler()) {
		if(valid) {
			$("#txtpwd").focus();
			valid = false;
		}
	}
	if(!registerValid_txtpwd2_Handler()) {
		if(valid) {
			$("#txtpwd2").focus();
			valid = false;
		}
	}
	return valid;
}

function inforSubmitHandler(){
	var valid = true;
	if(!registerValid_txtemail_Handler()) {
		if(valid) {
			$("#txtemail").focus();
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
 * 注册验证函数
 * ===================================================
 */
function registerValid_txtoldpwd_Handler() {
	if($("#txtoldpwd").val().trim() == "" || $("#txtoldpwd").val().trim().length < 6) {
		$("#register_err_txtoldpwd").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtoldpwd").addClass("hd");
	}
	return true;
}
function registerValid_txtpwd_Handler() {
	if($("#txtpwd").val().trim() == "" || $("#txtpwd").val().trim().length < 6) {
		$("#register_err_txtpwd").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtpwd").addClass("hd");
	}
	return true;
}
function registerValid_txtpwd2_Handler() {
	if($("#txtpwd2").val().trim() == "") {
		$("#register_err_txtpwd2").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtpwd2").addClass("hd");
	}
	if($("#txtpwd2").val().trim() != $("#txtpwd").val().trim()) {
		$("#register_err_txtpwd22").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtpwd22").addClass("hd");
	}
	return true;
}
function registerValid_txtemail_Handler() {
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if($("#txtemail").val().trim() == "" || !reg.test($("#txtemail").val().trim())) {
		$("#err_txtemail").removeClass("hd");
		return false;
	} else {
		$("#err_txtemail").addClass("hd");
	}
	return true;
}
function uploadFileHandler() {
	if(!isImageFile($("#file").val())) {
		return false;
	} else {
		return true;
	}
}

