$(function(){
	$("input[id='btncomment']").click(btncommentClickHandler);
})
function btncommentClickHandler(){
	btnComment("#txtcomment");
}
var errmsg = "提交错误，请联系管理员！";
function btnComment(id){
	if($(id).val().trim() == "") {
		alert("请填写评论");
		return false;
	}
	var form = $(id).parents("form");
	var json = form.serializeJson();
	var path = form.attr("action");
	$(id, form).val("");
	$(id).trigger("keyup");
	var argcontainer = $("#arglist", $(id).parents("form"));
	$.ajax({
		url:path,
		type:"post",
		data:json,
		dataType:"json",
		success:ajaxSuccessHandler,
		error:ajaxErrorHandler,
		complete:ajaxCompleteHandler
	});
	function ajaxSuccessHandler(data) {
		if(data) {
			var html = '<div class="argument"><img class="headimg" src="' + me.avatar + '" alt="" /><div class="word">';
			html += '<a onclick="deleteArgumentHandler(this, \'' + data.uid + '\')" class="delete right" href="javascript:void(0)">〤</a>';
			html += '<span class="name">' + me.name + '</span><span class="content">';
			html += json.comment;
			html += '</span></div><div class="date">刚刚</div></div>';
			argcontainer.prepend(html);
		} else {
			alert(errmsg);
		}
	}
	function ajaxErrorHandler() {
		alert(errmsg);
	}
	function ajaxCompleteHandler() {}
}

function deleteArgumentHandler(obj, uid, url) {
	if(uid != null && uid.length > 0) {
		var path = base + "/myhome/comment/" + uid;
		if(url) {
			path = url;
		}
		var json = {};
		$.ajax({
			url:path,
			type:"delete",
			data:json,
			dataType:"json",
			success:ajaxSuccessHandler,
			error:ajaxErrorHandler,
			complete:ajaxCompleteHandler
		});
		function ajaxSuccessHandler(data) {
			if(data) {
				$(obj).parents(".argument").remove();
			} else {
				alert(errmsg);
			}
		}
		function ajaxErrorHandler() {
			alert(errmsg);
		}
		function ajaxCompleteHandler() {}
	}
}