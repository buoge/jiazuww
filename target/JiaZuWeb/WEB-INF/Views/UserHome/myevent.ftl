[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myevent-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myevent.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function() {
		$(".box").mouseover(function() {
			$(this).addClass("hover");
		});
		$(".box").mouseout(function() {
			$(this).removeClass("hover");
		});
		computeTextBoxWordsCount("#txtcontent", "#count200");
	});
//-->
</script>
</head>
<body>
<div class="block">
[#if msg??]
<div class="red">${msg}</div>
[/#if]
<h2>记录我们家族的大事：</h2>
	<form id="f_event" action="${base}/myhome/${currUid}/event" method="post" enctype="multipart/form-data">
		<input name="groupImg" value="${(bean.headimg)!}" type="hidden" />
		<input name="groupName" value="${(bean.name)!}" type="hidden" />
		<input name="useruid" value="${(me.uid)!}" type="hidden" />
		<input name="userName" value="${(me.name)!((me.userid)!"none")}" type="hidden" />
		<input name="type" value="0" type="hidden" />
		<input name="status" value="1" type="hidden" />
		<span class="txttop">大事记：</span><textarea id="txtcontent" maxLength="200" name="content"></textarea>
		<br class="clear" />
		<div id="err_txtcontent" class="txtrgt red mrgt60 hd"><span class="red">请输入不多于200字的大事记</span></div>
		附&nbsp;&nbsp;图：<input id="file" type="file" name="file" />
		<br class="clear" />
		<div class="historybtmbar">
		<label for="chkshare">公开&nbsp;</label><input id="chkshare" name="ispublic" title="家族成员之外的会员是否可见" checked="checked" type="checkbox" />&nbsp;&nbsp;&nbsp;
		<span class="gray">还能输入<span id="count200">200</span>个字</span>
		<input class="btn2" type="submit" value="保存"/>
		</div>
	</form>
</div>
[@p.EventList list true /]
[@p.Pager pager /]
</body>
</html>