[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看族谱</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta name="Copyright" content="©2012 JiaZuWW, All Right Reserved.jiazuww.com,Inc." />
<meta name="designby" content="architect.bian" />
<meta name="codeby" content="architect.bian" />
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<link rel="shortcut icon" href="${baseimg}/imgs/default/ico.ico" title="IE" />
<link rel="icon" type="image/gif" href="${baseimg}/imgs/ico.gif" title="FF" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mainstyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/commonstyle.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/myfun-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jslib-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/base-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myzupu.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/pages/myzupu-1.0.0.js"></script>
<!--[if lt IE 9]>
<script src="${basejs}/js/excanvas.js">//</script>
<![endif]-->
<style type="text/css" media="screen" title="Jiazuww style">
.tree ul {display:table;}
body {background:none;}
.body {margin:0;}
#bodyarea {padding-top:0;}
#bodyarea .mybody {width:100%;}
#bodyarea .widebox .container {width:100%;}
#bodyarea .widebox .container .content {width:100%;}
#bodyarea .widebox .container .content {margin:0;}
</style>
<script type="text/javascript">
<!--

$(function(){
	draw();
});

	function draw() {
		var canvas = document.getElementById('cv');
		canvas.setAttribute("width", $(".tree ul").width());
		canvas.setAttribute("height", $(".tree ul").height());
		if (typeof(G_vmlCanvasManager) != 'undefined') { // ie IE
			G_vmlCanvasManager.initElement(canvas);
        }
		if (canvas.getContext){
			var ctx = canvas.getContext('2d');
			
			var cvleft = $("#cv").offset().left;
			var cvtop = $("#cv").offset().top;
			$("[data-p]").each(function(){
				var p = $(this).data("p");
				if(p != null && p != "ancestor") {
					var centop_x = $(this).offset().left - cvleft + $(this).width() / 2;
					var centop_y = $(this).offset().top - cvtop;
					var p_x = $("#" + p).offset().left - cvleft + $("#" + p).width() / 2;
					var p_y = $("#" + p).offset().top - cvtop + $("#" + p).height();
					ctx.beginPath();
					ctx.arc(centop_x, centop_y,3,0,Math.PI*2,true);
					ctx.fill();
					ctx.beginPath();
					ctx.moveTo(centop_x, centop_y);
					ctx.lineTo(p_x, p_y);
					ctx.stroke();
					
				}
			});
			
		}
	}

//-->
</script>
</head>
<body>
<div class="body">
		<div id="bodyarea">
			<div class="">
			<div class="">

	<div class="mybody">
	<div class="widebox">
		<div class="block">
	<div class="container" style="overflow:visiable;">
		<div class="content" style="width:100%;">
			[#if !me??]
			<div class="sliderbar"><p>${(zupu.name)!}</p></div>
			<div class="article">
				<h3 class="">族训：${(zupu.brief)!}</h3>
				<a href="${baseimg}${(zupu.logooriginal)!}" target="_blank"><img src="${baseimg}${(zupu.logo)!}" alt="家族标" /></a>
				<span class="summary">
				   <p>${(zupu.desc)!}</p>
				</span>
			</div>
			[/#if]
			<div class="tree" style="display:table; width:100%; margin-left:50px;overflow: auto; overflow-y:hidden">
				<canvas id="cv" class="" width="9999px" ></canvas>
				${resphtml}
			</div>
<script type="text/javascript">
<!--
	$(function(){
		$(".tree").height($(".tree").children().height() + 200);
		resetLeftBranchWidth();
		resetRightBranchWidth();
	});
-->
</script>
			</div>
	</div>
	</div>
	</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>