/**
 * Description:This is a javascript for the scroll notice author:architect.bian
 * QQ:993017535 TEL：15300128809 creation time:2012-09-05 location:webbio.cn
 */
var slider = {};
slider.direct_left = true;
/*
 * 横向自动滚动
 */
function HorizontalSlider(blockid, width, step, speed, delay, headobjid,
		arrheadtitle) {
	var move = true;
	var t;// temp
	var sw;// standardwidth
	var obj = $("#" + blockid);
	// alert($("tr", obj).html());
	var html = $("tr", obj).html();
	$("tr", obj).html(html + html);
	// alert($("tr", obj).html());
	obj = obj[0];
	obj.style.marginLeft = 0;
	if (headobjid != null) {
		var headobj = document.getElementById(headobjid);
	} else {
		var headobj = null;
	}
	if (step == null || step == 0) {
		step = 1;
	}
	if (slider.direct_left) {
		step = step * -1;
	} else {
		step = step * 1;
		slider.direct_left = false;
	}
	// alert(step);
	obj.onmouseover = function() {
		move = false;
	}
	obj.onmouseout = function() {
		move = true;
	}

	function start() {
		sw = obj.offsetWidth;
		obj.style.width = sw;
		// 解决浏览器的标准问题
		if (move) {
			obj.style.marginLeft = parseInt(obj.style.marginLeft) + step + "px";// 每次移动的像素，值越小越平滑越慢
			// alert(obj.style.marginLeft);
			if (headobj != null) {
				if (headobj.innerText == arrheadtitle[0]) {
					headobj.innerText = arrheadtitle[1];
				} else {
					headobj.innerText = arrheadtitle[0];
				}
			}
		}
		t = setInterval(scrolling, speed);
	}

	function scrolling() {
		if (parseInt(obj.style.marginLeft) % width != 0) {
			obj.style.marginLeft = parseInt(obj.style.marginLeft) + step + "px";// 每次移动的像素，值越小越平滑越慢
			if (Math.abs(parseInt(obj.style.marginLeft)) >= sw / 2)
				obj.style.marginLeft = 0;
		} else {
			if (Math.abs(parseInt(obj.style.marginLeft)) > sw / 2)
				obj.style.marginLeft = 0;
			clearInterval(t);
			setTimeout(start, delay);
		}
	}
	setTimeout(start, delay);
}

/*
 * 横向滚动
 * blockid:滚动标签的Id
 * width:滚动一次的距离
 * step:每speed移动的距离，越小越平滑
 * speed:频率，越小移动的越快
 * 例：要移动width长度，按speed时间移动step长度，直到移动了width长度
 */
function SliderClickHandler(blockid, width, step, speed, iscircle) {
	var t;
	var sw;
	var obj = $("#" + blockid);
	obj = obj[0];
	if (typeof (iscircle) == "undefined") {
		iscircle = true;
	}
//	alert(iscircle);
	// alert(obj.outerHTML);
	// alert(obj.style);
	// alert(obj.style.marginLeft);
	if (step == null || step == 0) {
		step = -1;
	}
	// alert(obj.style.marginLeft + " " + step);
	if (obj.style.marginLeft == "") {
		obj.style.marginLeft = 0;
	}
	if (obj.style.marginLeft == "0px" && step > 0) {
		return;
	}
	if (!iscircle) {
		var rightdistance = obj.offsetParent.offsetWidth - obj.offsetWidth;
//		alert(obj.offsetParent.offsetWidth + " " + sw);
//		alert(rightlen + " " + obj.style.marginLeft + " " + step);
		if(rightdistance >= parseInt(obj.style.marginLeft) && step < 0) {
			return;
		}
	}
	function start() {
		sw = obj.offsetWidth;
		// alert(obj.offsetParent.offsetWidth);
		obj.style.width = sw;
		// 解决浏览器的标准问题
		obj.style.marginLeft = parseInt(obj.style.marginLeft) + step + "px";// 每次移动的像素，值越小越平滑越慢
		// alert(obj.style.marginLeft);
		
		t = setInterval(scrolling, speed);
	}

	function scrolling() {
		if (parseInt(obj.style.marginLeft) % width != 0) {
			obj.style.marginLeft = parseInt(obj.style.marginLeft) + step + "px";// 每次移动的像素，值越小越平滑越慢
			// if(Math.abs(parseInt(obj.style.marginLeft))>=sw/2)
			// obj.style.marginLeft=0;
		} else {
			if (iscircle && Math.abs(parseInt(obj.style.marginLeft)) > sw / 2){
				obj.style.marginLeft = 0;
			}
			clearInterval(t);
		}
	}
	start();
}
