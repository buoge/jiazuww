$(function(){
	setBaseCssForInput();
	setImageTitleAlt();
	toggleMenu("#mainmenu a");
	setAnchorHref();
	window.onload = windowLoadHandler;
	IEHandler(9);
});

function windowLoadHandler() {
	if(!$.browser.msie || $.browser.version != 10) {
	$("img").each(function(){
		if (!isImageOk(this)) {
			var src404 = $(this).data("src404");
			$(this).data("src", $(this).attr("src"));
			if(typeof(src404) == "undefined") {
				$(this).hide();
			} else if(src404 == "") {
				$(this).addClass("hd");
			} else {
				$(this).attr("src", src404)
			}
			$(this).bind({load : function(){$(this).show();}});
		}
	});
	}
}

function IEHandler(v) {
	if($.browser.msie && $.browser.version <= v) {
		$("[maxlength]").bind("keyup blur", function(){
			if(/^[0-9]+$/.test($(this).attr("maxlength"))) {
				var len = parseInt($(this).attr("maxlength"), 10);
				if($(this).val().length > len) { 
					//alert('Maximum length exceeded: ' + len); 
					$(this).val($(this).val().substr(0, len)); 
					return false; 
		        }
			}
		});
	}
}

function setBaseCssForInput () {
	$("input:text").each(function(){
		$(this).addClass("txt");
	});
	$("input:password").each(function(){
		$(this).addClass("txt");
	});
	$("input:button").each(function(){
		$(this).addClass("btn");
	});
	$("input:submit").each(function(){
		$(this).addClass("btn");
	});
	$("input:radio").each(function(){
		$(this).addClass("radio");
	});
	$("input:checkbox").each(function(){
		$(this).addClass("chk");
	});
}

function setImageTitleAlt() {
	$("img").each(function(){
		$(this).attr("title",$(this).attr("alt"));
	});
}

function toggleMenu(id) {
	var path = window.location.pathname;
	var len = 0;
	var curr;
	var thiscurr;
	$(id).each(function(){
//		var charindex = $(this).attr("href").lastIndexOf("/") ;
//		var p = $(this).attr("href").slice(charindex + 1);
		var p = $(this).attr("href");
//		alert(path + "   |   " +$(this).attr("href"));
		//var regex = new RegExp("^" + p + ".*");
		if(path == p) {
			curr = this;
			thiscurr = this;
		} else if(path.indexOf(p) > -1) {
			if(p.length > len) {
				len = p.length;
				curr = this;
			}
		}
	})
	if(thiscurr == null) {
		thiscurr = curr;
	}
	$(thiscurr).addClass("here");
}
function resetScrollHeight() {
	var n=window.name;
    if(isNaN(n)){
        return;
    }
    $(document).scrollTop(n)
    window.onscroll=setScrollHeight;
}

function setAnchorHref() {
	$("a[href='']").each(function(){
		$(this).attr("href", "javascript:void(0)");
	})
}