[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/mycustom-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mycustom.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	<h2>我要上传家乡风貌：</h2>
	<form id="f_custom" action="${base}/myhome/${currUid}/custom" method="post" enctype="multipart/form-data">
		<input name="useruid" value="${(me.uid)!}" type="hidden" />
		<div><span>名称：<span class="red">*</span></span><input id="txttitle" name="title" value="" maxlength="30" class="long" type="text" />&nbsp;&nbsp;<span id="err_txttitle" class="red hd">请输入不多于30字的名称</span></div>
		<div><span class="txttop">描述：<span class="red">&nbsp;</span></span><textarea id="txtdesc" maxlength="200" name="desc"></textarea></div>
		<div><span>照片：<span class="red">*</span></span><input id="file" type="file" name="file" />&nbsp;<input class="btn1" type="submit" value="上传"/></div>
	</form>
</div>
<br /><br />
<div class="block imgsblock">
<h2>本家族已上传的风土人情：</h2>
[@p.CustomList customList true /]
[@p.Pager pager /]
</div>
</body>
</html>