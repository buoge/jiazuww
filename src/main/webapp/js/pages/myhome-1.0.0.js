/**
 * 会员中心Js 验证等等。。。
 */
var guideword_txtcreatename = "请输入家族名创建家族";
var guideword_txtaddname = "请输入要申请加入的家族名";
$(function(){
	$("#txtcreatename").val(guideword_txtcreatename);
	if($("#txtaddname").val().trim() == "") {
		$("#txtaddname").val(guideword_txtaddname);
	}
	$("#txtcreatename").focus(txtFocusHandler);
	$("#txtcreatename").blur(txtCreateNameBlurHandler);
	$("#txtaddname").focus(txtFocusHandler);
	$("#txtaddname").blur(txtaddnameBlurHandler);
	
	$("#f_create").submit(createSubmitHandler);
	$("#f_add").submit(addSubmitHandler);
});
function txtFocusHandler() {
	if($(this).val().trim() == guideword_txtcreatename || $(this).val().trim() == guideword_txtaddname) {
		$(this).val('');
		$(this).removeClass("gray");
	}
}
function txtCreateNameBlurHandler() {
	if($("#txtcreatename").val().trim() == "") {
		$(this).val(guideword_txtcreatename);
		$(this).addClass("gray");
	}
	$("#create_err_txtcreatename").addClass("hd");
}
function txtaddnameBlurHandler() {
	if($("#txtaddname").val().trim() == "") {
		$(this).val(guideword_txtaddname);
		$(this).addClass("gray");
	}
	$("#add_err_txtaddname").addClass("hd");
}
/**
 * 表单提交验证函数
 * ===================================================
 */
function createSubmitHandler() {
	var valid = true;
	if(!createValidNameBlurHandler()) {
		if(valid) {
			$("#txtcreatename").focus();
			valid = false;
		}
	}
	return valid;
}
function addSubmitHandler() {
	var valid = true;
	if(!addValid_txtaddname_Handler()) {
		if(valid) {
			$("#txtaddname").focus();
			valid = false;
		}
	}
	return valid;
}
/**
 * 创建家族验证函数
 * ===================================================
 */
function createValidNameBlurHandler() {
	if($("#txtcreatename").val().trim() == guideword_txtcreatename) {
		$("#create_err_txtcreatename").removeClass("hd");
		return false;
	} else {
		$("#create_err_txtcreatename").addClass("hd");
	}
	if($("#txtcreatename").val().trim() == "" && $("#txtcreatename").val().trim().length > 8) {
		$("#create_err_txtcreatename").removeClass("hd");
		return false;
	} else {
		$("#create_err_txtcreatename").addClass("hd");
	}
	return true;
}
/**
 * 申请加入验证函数
 * ===================================================
 */

function addValid_txtaddname_Handler() {
	if($("#txtaddname").val().trim() == "" || $("#txtaddname").val().trim() == guideword_txtaddname) {
		$("#add_err_txtaddname").removeClass("hd");
		return false;
	} else {
		$("#add_err_txtaddname").addClass("hd");
	}
	return true;
}
