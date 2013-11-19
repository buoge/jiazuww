[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myhome-1.0.0.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
[#if !currUid??]
<div class="red">温馨提示：您还未创建或申请加入一个家族，请先创建家族或者申请加入一个家族</div>
[/#if]
<form id="f_create" action="${base}/myhome/jiazu/create" method="post">
<div class="search"><label for="txtcreatename">我要创建家族</label>&nbsp;&nbsp;<input id="txtcreatename" name="name" value="" class="long gray" type="text" />&nbsp;&nbsp;<input class="btnwhite" type="submit" value="创建家族" /> <span id="create_err_txtcreatename" class="red hd">请输入不多于8个字的家族名</span></div>
</form>
<form id="f_add" action="${base}/myhome/jiazu/list" method="post">
<div class="search"><label for="txtaddname">申请加入家族</label>&nbsp;&nbsp;<input id="txtaddname" name="name" class="long gray" type="text" />&nbsp;&nbsp;<input class="btnwhite" type="submit" value="查找家族" /> <span id="add_err_txtaddname" class="red hd">请输入您要查找的家族名</span></div>
</form>
[#if currUid??]
<div class="block">
	<h2>家族渊源：</h2>
	<div class="content">
	[#if (bean.desc)?length > 0]
	${(bean.desc)!}
	[#else]
	<div  style="line-height:100px; text-align:center;">您还未填写家族渊源，请添加<a href="${base}/myhome/${currUid}/history">渊源</a></div>
	[/#if]
	</div>
</div>
<div class="block">
	<h2>族谱：</h2>
	<div class="content">
		
	</div>
</div>
[/#if]
</body>
</html>