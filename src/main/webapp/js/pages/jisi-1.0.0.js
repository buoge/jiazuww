/**
 * 祭祀页面脚本
 */
$(function(){
	initAnimate();//初始化动画
	initState();//初始化状态，如事件等等
});

function initAnimate() {
	fogAnimate();
	fogAnimate2();
	var time = 0;
	$("#window").animate({}, 0, function(){
		$("#bg").animate({width: "1764px", height: "900px", left: "-420px", top: "-200px", opacity: "1"}, time += 9000);
		$("#heads").animate({width: "160px", height: "100px", top: "150px", left: "405px", opacity: "0.1"}, 9000, function(){
			$("#heads").animate({opacity: "1"}, 6000);
			$("#heads .head h2").slideDown(6000, function(){$("#censer").removeClass("hd");});
//			$("#floor1 ul #censer").delay(3000).animate({opacity: "1"}, 3000);
			$("#floor1 ul li").delay(3000).animate({opacity: "1"}, 5000, function() {
				$("#censer .sm1").removeClass("hd");
				$("#censer .sm2").removeClass("hd");
				$("#censer .sm3").removeClass("hd");
				$("#floor2").removeClass("hd");
				$("#floor2").animate({opacity: "1"}, 1000);
			});
		});
	});
	time += 6000;
	$("#introcontainer").delay(time).animate({top:"5px"}, 3000);
	time += 3000;
	$("#controllcontainer").delay(time).animate({opacity: "0.3"}, 1000);
	$("#flowersbox").delay(time).animate({bottom: "5px"}, 6000);
	time += 6000;
	$("#register").delay(time).animate({opacity: "1"}, 3000);
	$("#charge").delay(time).animate({opacity: "1"}, 3000);
	$("#jisilog").delay(time).animate({top:"10px"}, 1000);
	$("#jisilogeventlayer").delay(time).animate({opacity: "0.01"}, 1000, function(){$("#jisilogeventlayer").attr("flag",true)});
	time += 1000;
	$("#welcome").delay(time).animate({height:"300px"}, 30000).animate({height:"0",opacity: "0"}, 9000);
	time += 9000;
//	$("#floor1 ul #censer .body").delay(time).animate({height:"0px"}, 3000);
//	$("#floor1 ul li.candle .body").delay(time).animate({height:"0px"}, 3000);
	
//	$("#bg").stop(true, true);
//	$("#heads").stop(true, true);
//	$("#introcontainer").stop(true, true);
//	$("#controllcontainer").stop(true, true);
//	$("#flowersbox").stop(true, true);
//	$("#register").stop(true, true);
	
}

function fogAnimate() {
	var flag = $("#fog").attr("flag") == "true" ? false : true;//是否向左移动
	if(flag) {
		$("#fog").animate({left:"-1600px"}, 100000, fogAnimate);
	} else {
		$("#fog").animate({left:"100px"}, 100000, fogAnimate);
	}
	$("#fog").attr("flag", flag);
}
function fogAnimate2() {
	var flag = $("#fog2").attr("flag") == "true" ? false : true;//是否向左移动
	if(flag) {
		$("#fog2").animate({left:"-1600px"}, 100000, fogAnimate2);
	} else {
		$("#fog2").animate({left:"600px"}, 100000, fogAnimate2);
	}
	$("#fog2").attr("flag", flag);
}


function initState() {
	$(".topbar").click(function(){
		var flag = $(this).attr("flag") == "true" ? false : true;//点击后展开与否
		var obj = $(this).next(".bodybox");
		obj.stop();
		if(flag) {
			obj.animate({height: "455px"}, 15000);
		} else {
			obj.animate({height: "0px"}, 9000);
		}
		$(this).attr("flag", flag);
	});
	$("#jisilogeventlayer").mouseover(jisilogeventlayermouseoverHandler);
	$("#jisilogeventlayer").mouseout(jisilogeventlayermouseoutHandler);
}
	function jisilogeventlayermouseoverHandler(){
		if($(this).attr("flag") == "true") {
			$("#jisilog").stop();
			$("#jisilog").animate({height: "150px"}, 1000);
		}
	}
	function jisilogeventlayermouseoutHandler(){
		if($(this).attr("flag") == "true") {
			$("#jisilog").stop();
			$("#jisilog").animate({height: "30px"}, 1000);
		}
	}
function senserClickHandler() {
	$("#floor1 ul #censer .head").removeClass("hd");
	$("#floor1 ul #censer .body").removeClass("hd");
	var json = {jisiuid: jisiuid};
	$.get(getNoCachePath("/jisi/censer"), json, function(data) {
		if(data) {
		} else {
		}
	});
}

function candleClickHandler() {
	$("#floor1 ul li.candle .head").removeClass("hd");
	var json = {jisiuid: jisiuid};
	$.get(getNoCachePath("/jisi/candle"), json, function(data) {
		if(data) {
		} else {
		}
	});
}

function flowersClickHandler(uid) {
	var json = {uid : uid, jisiuid: jisiuid};
	$.get(getNoCachePath("/jisi/flower"), json, function(data) {
		if(data) {
			var li_list = $("#floor2 .row ul li");
			var row;
			if(li_list.length < 6) {
				row = $("#floor2 .row ul");
			} else {
				row = $("#floor2 .row2 ul");
			}
			var node_li = '<li><img src="' + baseimg + data.img + '" title="' + data.name + '" /></li>';
			row.append(node_li);
		} else {
			$("#msgbox").removeClass("hd").fadeTo(0, 1).delay(2000).fadeTo(2000, 0, function(){$(this).addClass("hd")});
		}
	});
	
}