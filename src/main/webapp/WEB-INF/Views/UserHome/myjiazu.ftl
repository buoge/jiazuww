[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
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
	
	function quitConfirmHandler() {
		var msg = "您确定要退出吗？";
		if (confirm(msg)==true){
			return true;
		}else{
			return false; 
		}
		return false;
	}
	function delConfirmHandler() {
		var msg = "您确定要删除吗？删除后家族内所有信息将删除";
		if (confirm(msg)==true){
			return true;
		}else{
			return false; 
		}
		return false;
	}
	
	function modifyHandler(obj) {
		$(obj).parent("dt").addClass("hd");
		$(obj).parent("dt").next("dt").removeClass("hd");
	}
	
	function cancelModifyHandler(obj) {
		$(obj).parent("dt").addClass("hd");
		$(obj).parent("dt").prev("dt").removeClass("hd");
	}
//-->
</script>
</head>
<body>
[#if !currUid??]
<div class="red">温馨提示：您还未创建或申请加入一个家族，请先创建家族或者申请加入一个家族</div>
[/#if]
<div class="block">
	<h2>创建或加入家族：</h2>
<form id="f_create" action="${base}/myhome/jiazu/create" method="post">
<div class="search"><label for="txtcreatename">我要创建家族</label>&nbsp;&nbsp;<input id="txtcreatename" name="name" value="" class="long gray" type="text" />&nbsp;&nbsp;<input class="btnwhite" type="submit" value="创建家族" /> <span id="create_err_txtcreatename" class="red hd">请输入不多于8个字的家族名</span></div>
</form>
<form id="f_add" action="${base}/myhome/jiazu/list" method="post">
<div class="search"><label for="txtaddname">申请加入家族</label>&nbsp;&nbsp;<input id="txtaddname" value="${query}" name="name" class="long gray" type="text" />&nbsp;&nbsp;<input class="btnwhite" type="submit" value="查找家族" /> <span id="add_err_txtaddname" class="red hd">请输入您要查找的家族名</span></div>
</form>
</div>
[#if resultList??]
	[#if resultList?size > 0]
	<div class="content">
	[@p.JiazuList resultList false /]
	</div>
	[#else]
		没有搜索到结果！
	[/#if]
[/#if]
[#if currUid??]
<div class="block">
	<h2>家族管理：</h2>
	<div class="content">
		[@p.JiazuList list true /]
		[@p.Pager pager /]
	</div>
</div>
[/#if]
</body>
</html>