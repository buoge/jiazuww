/**
 * login页面表单验证
 */
$(function(){
	$("#name").blur(loginValidNameBlurHandler);
	$("#pwd").blur(loginValidPwdBlurHandler);
	
	$("#txtuserid").blur(registerValid_txtuserid_Handler);
	$("#txtpwd").blur(registerValid_txtpwd_Handler);
	$("#txtpwd2").blur(registerValid_txtpwd2_Handler);
	$("#txtemail").blur(registerValid_txtemail_Handler);
	$("#txtvalicode").blur(registerValid_txtvalicode_Handler);
	
	$("#f_login").submit(loginSubmitHandler);
	$("#f_register").submit(registerSubmitHandler);
});
function loginSubmitHandler() {
	var valid = true;
	if(!loginValidNameBlurHandler()) {
		if(valid) {
			$("#name").focus();
			valid = false;
		}
	}
	if(!loginValidPwdBlurHandler()) {
		if(valid) {
			$("#pwd").focus();
			valid = false;
		}
	}
	return valid;
}
function registerSubmitHandler() {
	var valid = true;
	if(!registerValid_txtuserid_Handler()) {
		if(valid) {
			$("#txtuserid").focus();
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
	if(!registerValid_txtemail_Handler()) {
		if(valid) {
			$("#txtemail").focus();
			valid = false;
		}
	}
	if(!registerValid_txtvalicode_Handler()) {
		if(valid) {
			$("#txtvalicode").focus();
			valid = false;
		}
	}
	if(!registerValid_aggreerule_Handler()) {
		if(valid) {
			valid = false;
		}
	}
	return valid;
}
/**
 * 登录验证函数
 * ===================================================
 */
function loginValidNameBlurHandler() {
	if($("#name").val().trim() == "") {
		$("#login_err_userid").removeClass("hd");
		return false;
	} else {
		$("#login_err_userid").addClass("hd");
	}
	return true;
}
function loginValidPwdBlurHandler() {
	if($("#pwd").val().trim() == "" || $("#pwd").val().trim().length < 6) {
		$("#login_err_pwd").removeClass("hd");
		return false;
	} else {
		$("#login_err_pwd").addClass("hd");
	}
	return true;
}
/**
 * 注册验证函数
 * ===================================================
 */
function registerValid_txtuserid_Handler() {
	if($("#txtuserid").val().trim() == "") {
		$("#register_err_txtuserid").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtuserid").addClass("hd");
	}
	if($("#txtuserid").val().length < 6 || $("#txtuserid").val().length > 30) {
		$("#register_err_txtuserid2").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtuserid2").addClass("hd");
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
		$("#register_err_txtemail").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtemail").addClass("hd");
	}
	return true;
}
function registerValid_txtvalicode_Handler() {
	if($("#txtvalicode").val().trim() == "") {
		$("#register_err_txtvalicode").removeClass("hd");
		return false;
	} else {
		$("#register_err_txtvalicode").addClass("hd");
	}
	return true;
}
function registerValid_aggreerule_Handler() {
	if($("#chkaggreerule").attr("checked") == "checked") {
		$("#register_err_chkaggreerule").addClass("hd");
	} else {
		$("#register_err_chkaggreerule").removeClass("hd");
		return false;
	}
	return true;
}
