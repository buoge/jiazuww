String.prototype.trim = function() {
	return this.replace(/^\s*|\s*$/g, "");
}
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()	// 毫秒
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
function setScrollHeight() {
	window.name = document.documentElement.scrollTop + document.body.scrollTop;
}
function gourl(url) {
	window.location.href = url;
}
function forbiddenIframe() {
	if(top.location !== self.location){
		top.location.href = self.location.href;
	}
}
function deleteConfirmHandler() {
	var msg = "您确定要删除吗？";
	return confirm(msg);
}
function computeTextBoxWordsCount(txtid, countid) {
	var len = $(countid).html();
	$(txtid).bind("keyup", (function(){
//		alert(len);
//		alert($(txtid).val().length);
//		alert(len - $(txtid).val().length);
		$(countid).html(len - $(txtid).val().length);
	}));
	$(txtid).trigger("keyup");
}
function isImageFile(path) {
	if(path == "" || /(jpg|gif|png)$/i.test(path)) {
		return true;
	} else {
		return false;
	}
}
function isImageOk(img) {
    // During the onload event, IE correctly identifies any images that
    // weren't downloaded as not complete. Others should too. Gecko-based
    // browsers act like NS4 in that they report this incorrectly.
    if (!img.complete) {
        return false;
    }
    // However, they do have two very useful properties: naturalWidth and
    // naturalHeight. These give the true size of the image. If it failed
    // to load, either of these should be zero.
    if (typeof img.naturalWidth != "undefined" && img.naturalWidth == 0) {
        return false;
    }
    // No other way of checking: assume it's ok.
    return true;
}
function rememberWindowUrl() {
	$.cookie('returnurl', window.location.href, {path:'/'});
}
function getNoCachePath(path) {
	return path + "?s=" + new Date().Format("ssS");
}