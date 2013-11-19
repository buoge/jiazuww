/**
 * 搜索框功能
 * 
 */
$(function(){
	$("#downlist").click(downlistClickHandler);
	$("#downlistchooser li").click(downlistchooserClickHandler);
	$(".body").click(downlistchooserMouseoutHandler);
	$("#f_search").submit(searchSubmitHandler);
});

function downlistClickHandler() {
	$("#downlistchooser").removeClass("hd");
	if($.browser.msie) {
		event.cancelBubble=true;//for ie
	} else {
		event.stopPropagation();//for ff
	}
}

function downlistchooserClickHandler() {
	$("#hdtype").val($(this).attr("value"));
	$("#downlist").text($(this).text());
	$("#downlistchooser").addClass("hd");
}
function downlistchooserMouseoutHandler() {
	//$("#downlistchooser").addClass("hd");
}

function searchSubmitHandler() {
	var valid = true;
	if(!txtsearchBlurHandler()) {
		if(valid) {
			$("#txtsearch").focus();
			valid = false;
		}
	}
	return valid;
}

function txtsearchBlurHandler() {
	if($("#txtsearch").val().trim() == "") {
		return false;
	} else {
		return true;
	}
}