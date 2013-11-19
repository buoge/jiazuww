/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#txttitle").blur(txttitleValidHandler);
	$("#txtaddress").blur(txtaddressValidHandler);
	$("#txtcontactname").blur(txtcontactnameValidHandler);
	$("#txttelephone").blur(txttelephoneValidHandler);
	$("#txtprice").blur(txtpriceValidHandler);
	$("input[name='type']:radio").click(genderValidHandler);
	
	$("#f_c2c").submit(eduValidSubmitHandler);
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
	if(!genderValidHandler()) {
		if(valid) {
			valid = false;
		}
	}
	if(!txtaddressValidHandler()) {
		if(valid) {
			$("#txtaddress").focus();
			valid = false;
		}
	}
	if(!txtcontactnameValidHandler()) {
		if(valid) {
			$("#txtcontactname").focus();
			valid = false;
		}
	}
	if(!txttelephoneValidHandler()) {
		if(valid) {
			$("#txttelephone").focus();
			valid = false;
		}
	}
	if(!txtpriceValidHandler()) {
		if(valid) {
			$("#txtprice").focus();
			valid = false;
		}
	}
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
function txttitleValidHandler() {
	if($("#txttitle").val().trim() == "" || $("#txttitle").val().trim().length > 30) {
		$("#err_txttitle").removeClass("hd");
		return false;
	} else {
		$("#err_txttitle").addClass("hd");
	}
	return true;
}
function genderValidHandler() {
	if($("input[name='type']:radio:checked").length == 0) {
		$("#err_type").removeClass("hd");
		return false;
	} else {
		$("#err_type").addClass("hd");
	}
	return true;
}
function txtaddressValidHandler() {
	if($("#txtaddress").val().trim() == "" || $("#txtaddress").val().trim().length > 30) {
		$("#err_txtaddress").removeClass("hd");
		return false;
	} else {
		$("#err_txtaddress").addClass("hd");
	}
	return true;
}
function txtcontactnameValidHandler() {
	if($("#txtcontactname").val().trim() == "" || $("#txtcontactname").val().trim().length > 6) {
		$("#err_txtcontactname").removeClass("hd");
		return false;
	} else {
		$("#err_txtcontactname").addClass("hd");
	}
	return true;
}
function txttelephoneValidHandler() {
	if($("#txttelephone").val().trim() == "" || $("#txttelephone").val().trim().length > 12) {
		$("#err_txttelephone").removeClass("hd");
		return false;
	} else {
		$("#err_txttelephone").addClass("hd");
	}
	return true;
}
function txtpriceValidHandler() {
	if($("#txtprice").val().trim() == "" || $("#txtprice").val().trim().length > 6 || isNaN($("#txtprice").val())) {
		$("#err_txtprice").removeClass("hd");
		return false;
	} else {
		$("#err_txtprice").addClass("hd");
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
function uploadFileHandler() {
	if($("input[name='img']").length > 0 && $("input[name='img']").val().trim() != "") {
		return true;
	}
	if(!isImageFile($("#file").val())) {
		return false;
	} else {
		return true;
	}
}