var region = {};
function changeSelectHandler() {
	var select = $(this).next("select");
	$("option[value!='0']",  $(this).nextAll()).remove();
	var pid = $(this).val();
	if (pid > 0) {
		if(region[pid] != null) {
			var data = region[pid];
			for(var i in data) {
				var obj = data[i];
				var option = "<option value='" + obj.id + "'>" + obj.name + "</option>";
				select.append(option);
			}
			if(select.attr("select") != "") {
				select.val(select.attr("select"));
			}
			if(select.attr("id") == "slcity") {
				setTimeout('$("#slcity").trigger("change")', 1);
			}
		} else {
			var path = window.baseimg + "/api/region/" + pid;
			$.ajax({
						url : path,
						type : "get",
						data : "",
						dataType : "json",
						success : ajaxSuccessHandler,
						error : ajaxErrorHandler,
						complete : ajaxCompleteHandler
					});
			function ajaxSuccessHandler(data) {
				if (data) {
					region[pid] = data;
					for(var i in data) {
						var obj = data[i];
						var option = "<option value='" + obj.id + "'>" + obj.name + "</option>";
						select.append(option);
					}
					if(select.attr("select") != "") {
						select.val(select.attr("select"));
					}
					if(select.attr("id") == "slcity") {
						select.trigger("change");
					}
				} else {
					alert(errmsg);
				}
			}
		}
	}
}

var errmsg = "操作失败，请联系网站管理员！";
var json = {};
function ajaxErrorHandler(XMLHttpRequest, textStatus, errorThrown) {
//	alert(textStatus);
//	alert(errorThrown);
	alert(errmsg);
}
function ajaxCompleteHandler() {
}

function clearAddressForm() {
	$("#f_address input[type='text']").val("");
	$("#f_address select").val("0");
	$("#f_address select").removeAttr("select");
}

function cancelAddressHandler() {
	$("#f_address").addClass("hd");
	clearAddressForm();
	$("#hdaction").val("");
	json = {};
}

function addAddressHandler() {
	$("#f_address").removeClass("hd");
	clearAddressForm();
	$("#hdaction").val("add");
	$("#btnaddress").val("添加");
	json = {};
}
function modifyAddressHandler(uid) {
	var path = window.baseimg + "/api/address/" + uid + "?time=" + new Date();
	json = {};
	$.ajax({
				url : path,
				type : "get",
				data : json,
				dataType : "json",
				success : ajaxSuccessHandler,
				error : ajaxErrorHandler,
				complete : ajaxCompleteHandler
			});
	function ajaxSuccessHandler(data) {
		if (data) {
			json = data;
			$("#f_address").removeClass("hd");
			$("#txtconsignee").val(data.consignee);
			$("#slprovince").val(data.province);
			$("#slprovince").attr("select", data.province);
			$("#slprovince").trigger("change");
			$("#slcity").val(data.city);
			$("#slcity").attr("select", data.city);
			$("#sldistrict").val(data.district);
			$("#sldistrict").attr("select", data.district);
			$("#sldistrict").attr("select", data.district);
			$("#txtaddress").val(data.addressExact);
			$("#txttel").val(data.tel);
			$("#txtzipcode").val(data.zipcode);
			$("#txtemail").val(data.email);
			$("#hdaction").val("");
		} else {
			alert(errmsg);
		}
	}
}

function deleteAddressHandler(uid) {
	var msg = "您确定要删除吗？删除不可恢复！";
	if (!confirm(msg)) {
		return;
	}
	var path = window.baseimg + "/api/address/" + uid;
	json = {};
	$.ajax({
				url : path,
				type : "delete",
				data : json,
				dataType : "json",
				success : ajaxSuccessHandler,
				error : ajaxErrorHandler,
				complete : ajaxCompleteHandler
			});
	function ajaxSuccessHandler(data) {
		if (data) {
			$("#rd" + uid).parents("dd").remove();
		} else {
			alert(errmsg);
		}
	}
}

function saveAddressHandler() {
	if ($("#hdaction").val() == "add") {
		json = {};
		json.type = 1;
		json.method = "add";
	} else {
		delete json.method;
	}
	var path = window.baseimg + "/api/address";
	
	$("span[id^='err']").addClass("hd");
	if($("#txtconsignee").val().trim() != "") {
		json.consignee = $("#txtconsignee").val();
	} else {
		$("#errconsignee").removeClass("hd");
		return;
	}
	if($("#slprovince").val().trim() > 0) {
		json.province = $("#slprovince").val();
	} else {
		$("#errprovince").removeClass("hd");
		return;
	}
	if($("#slcity").val().trim() > 0) {
		json.city = $("#slcity").val();
	} else {
		$("#errcity").removeClass("hd");
		return;
	}
	if($("#sldistrict").val().trim() > 0) {
		json.district = $("#sldistrict").val();
	} else {
		$("#errdistrict").removeClass("hd");
		return;
	}
	if($("#txtaddress").val().trim() != "") {
		json.address = $("#slprovince option:selected").text()
				+ $("#slcity option:selected").text()
				+ $("#sldistrict option:selected").text() + " "
				+ $("#txtaddress").val();
	} else {
		$("#erraddress").removeClass("hd");
		return;
	}
	if($("#txttel").val().trim() != "") {
		json.tel = $("#txttel").val();
	} else {
		$("#errtel").removeClass("hd");
		return;
	}
	if($("#txtzipcode").val().trim() != "") {
		json.zipcode = $("#txtzipcode").val();
	} else {
		$("#errzipcode").removeClass("hd");
		return;
	}
	json.email = $("#txtemail").val();
	
	$.ajax({
				url : path,
				type : "post",
				data : json,
				dataType : "json",
				success : ajaxSuccessHandler,
				error : ajaxErrorHandler,
				complete : ajaxCompleteHandler
			});
	function ajaxSuccessHandler(data) {
		if (data) {
			if (json.method == "add") {
				var html = '<dd><input name="address" value="'
						+ data.uid
						+ '" id="rd'
						+ data.uid
						+ '" checked="checked" type="radio" class="radio"><label for="rd'
						+ data.uid
						+ '">'
						+ data.address
						+ ' '
						+ data.tel
						+ ' '
						+ data.consignee
						+ '</label><a class="right mrgt10 noline" href="javascript:void(0)" onclick="deleteAddressHandler(\''
						+ data.uid + '\')">删除</a> <a class="right mrgt10 noline" href="javascript:void(0)" onclick="modifyAddressHandler(\''
						+ data.uid + '\')">修改</a></dd>';
				$(".dlbox input:checked").removeAttr("checked");
				$(".dlbox").append(html);
			} else {
//				alert($("#rd" + json.uid).next("label").html());
				$("#rd" + json.uid).next("label").text(data.response);
			}
			clearAddressForm();
			$("#f_address").addClass("hd");
		} else {
			alert(errmsg);
		}
	}
}
