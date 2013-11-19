[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/mywish-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mywish.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.draggable.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
$(function(){
	computeTextBoxWordsCount("#txtcontent", "#count150");
	$("#f_wish").submit(function(){
		if($("#txtcontent").val().length > 150) {
			alert("最多输入150个字");
			return false;
		}
		return true;
	});
});
	var zindex = 0;
	var maxwidth = 750;
	var minwidth = -150;
	var maxheight = 550;
	var minheight = -150;
	$(function(){
		$(".wall dl").each(function(){
			$(this).addClass("bg" + parseInt(7 * Math.random()));
			$(this).css("z-index", zindex++);
			$(this).css("top", parseInt(maxheight * Math.random()));
			$(this).css("left", parseInt(maxwidth * Math.random()));
		});
	});
	$(function(){
		$(".wall dl").draggable({
			drag : function(event, ui) {
				if(ui.position.left > maxwidth || ui.position.left < minwidth || ui.position.top < minheight || ui.position.top > maxheight) {
					throw "Out of bounds";
				}
			},
		});
		$(".wall dl").mousedown(function() {
			$(this).css("z-index", zindex++);
		});
		$(".close").click(function() {
			$(this).parents("dl").addClass("hd");
		});
	});
//-->
</script>
</head>
<body>
<div class="block">
[#if msg??]
<div class="red">${msg}</div>
[/#if]
	<h2>共有${(list?size)!0}条祝福，赶快来送祝福吧：</h2>
	<form id="f_wish" action="${base}/myhome/${currUid}/wish" method="post">
		<input name="groupuid" value="${(bean.uid)!}" type="hidden" />
		<input name="groupname" value="${(bean.name)!}" type="hidden" />
		<input name="useruid" value="${(me.uid)!}" type="hidden" />
		<input name="name" value="${(me.name)!((me.userid)!"none")!}" type="hidden" />
		<span class="txttop">祝福语：</span><textarea id="txtcontent" maxlength="150" name="wish"></textarea><span class="red">&nbsp;*</span><span id="err_txtcontent" class="red hd">&nbsp;请输入不多于150字的祝福语</span>
		<br class="clear" />
		<div class="wishbtmbar">
		<span>还能输入<span id="count150">150</span>个字</span>
		<input class="pinkbtn" type="submit" value="发送祝福"/>
		</div>
	</form>
</div>
<br /><br />
<div class="block">
	<h2>祝福墙：</h2>
	<div class="wall">
		[#list list as item]
		<dl>
		<dt><h5>${(item.name)}的祝福</h5><a class="close" href="javascript:void(0)">〤</a></dt>
		<dd>${(item.wish)}
		</dd>
		<dd class="footer">${(item.date)}</dd>
		</dl>
		[/#list]
	</div>
</div>
</body>
</html>