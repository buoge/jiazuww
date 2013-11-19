/**
 * 会员中心Js 验证等等。。。
 */
$(function(){
	$("#f_zupu").submit(validSubmitHandler);
});
function resetLeftBranchWidth () {
	var lis = $(".tree ul li:gt(0)");
	for ( var i = 0; i < lis.length - 1; i++) {
		var branchs = $(".leftbranch", lis[i]);
		for ( var j = 0; j < branchs.length; j++) {
			var nextbranch = $(".leftbranch:eq(" + j + ")", lis[i+1]);
			if(nextbranch != null) {
				var ml = parseInt($(".leaf:first", branchs[j]).css("margin-left"));
				var wd = parseInt($(branchs[j]).width());
				var _ml = parseInt(nextbranch.css("margin-left"));
				var _wd = nextbranch.width();
				var _mr = 60;
				if(wd <= _wd + _ml) {
//					alert(wd + " " + _wd + "." + _ml);
//					alert(i + "" + j);
//					alert("" + ml + _ml + _mr * 2);
					$(".leaf:first", branchs[j]).css("margin-left", ml + _ml + _mr * 2);
				}
			}
		}
	}
}
function resetRightBranchWidth () {
	var lis = $(".tree ul li:gt(0)");
	for ( var i = 0; i < lis.length - 1; i++) {
		var branchs = $(".rightbranch", lis[i]);
		for ( var j = 0; j < branchs.length; j++) {
			var nextbranch = $(".rightbranch:eq(" + j + ")", lis[i+1]);
			if(nextbranch != null) {
				var ml = parseInt($(".leaf:first", branchs[j]).css("margin-right"));
				var wd = parseInt($(branchs[j]).width());
				var _ml = parseInt(nextbranch.css("margin-right"));
				var _wd = nextbranch.width();
				var _mr = 60;
				if(wd <= _wd + _ml) {
//					alert(wd + " " + _wd + "." + _ml);
//					alert(i + "" + j);
//					alert("" + ml + _ml + _mr * 2);
					$(".leaf:first", branchs[j]).css("margin-right", ml + _ml + _mr * 2);
				}
			}
		}
	}
}
/**
 * 表单提交验证函数
 * ===================================================
 */
function validSubmitHandler() {
	if($("#hdaction").val() == "del" || $("#hdaction").val() == "edit") {
		return true;
	}
	var valid = true;
	var isman = true;
	var islady = true;
	if($("#txtname").val().trim() != "" || $("#txtuseruid").val().trim() != "" || $("#file").val().trim() != "") {
		return validManHandler();
	} else {
		isman = false;
	}
	if($("#txtname2").val().trim() != "" || $("#txtuseruid2").val().trim() != "" || $("#file2").val().trim() != "") {
		return validWomanHandler();
	} else {
		islady = false;
	}
	if(!isman && !islady && $("#hdaction").val().trim() != "del") {
		alert("请填写您要添加族谱成员的姓名!");
		valid = false;
	}
	
	return valid;
}

function validManHandler() {
	var valid = true;
	if(!txtnameValidHandler()) {
		if(valid) {
			alert("请填写姓名");
			$("#txtname").focus();
			valid = false;
		}
	}
	if(!txtfileValidHandler()) {
		if(valid) {
			valid = false;
		}
	}
	return valid;
}

function validWomanHandler() {
	var valid = true;
	if(!txtname2ValidHandler()) {
		if(valid) {
			alert("请填写姓名");
			$("#txtname2").focus();
			valid = false;
		}
	}
	if(!txtfile2ValidHandler()) {
		if(valid) {
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
		return false;
	} else {
	}
	return true;
}
function txtname2ValidHandler() {
	if($("#txtname").val().trim() == "") {
		return false;
	} else {
	}
	return true;
}
function txtfileValidHandler() {
	if(!isImageFile($("#file").val())) {
		alert("请上传jpg/png/gif格式的图像文件");
		return false;
	} else {
		return true;
	}
	return true;
}
function txtfile2ValidHandler() {
	if($("#file").val().trim() == "") {
		alert("请上传头像");
		return false;
	} else {

		if(!isImageFile($("#file2").val())) {
			alert("请上传jpg/png/gif格式的图像文件");
			return false;
		} else {
			return true;
		}
	}
	return true;
}
