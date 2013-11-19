var music_src;
jQuery.fn.extend({
	playMusic: function(src) {
		music_src = src;
		initMusic();
		$(this).click(controlClickHandler);
	}
});

function initMusic() {
	if($.browser.msie) {
		$("bgsound").attr("src", music_src);
	} else {
		$("audio").attr("src", music_src);
	}
}

function controlClickHandler(){
	if($(this).attr("class").indexOf("play") < 0) {
		if($.browser.msie) {
			$("bgsound").attr("src", "");
		} else {
			document.getElementsByTagName("audio")[0].pause();
		}
	} else {
		if($.browser.msie) {
			initMusic();
		} else {
			document.getElementsByTagName("audio")[0].play();
		}
	}
	
	$(this).toggleClass("play");
}