[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>热门搜索管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/right.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
});

function validSubmitHandler() {
	var valid = true;
	if($("#txttitle").val().trim() == "") {
		if(valid) {
			$("#txttitle").focus();
			valid = false;
		}
	}
	if($("#txthref").val().trim() == "") {
		if(valid) {
			$("#txthref").focus();
			valid = false;
		}
	}
	return valid;
}

//-->
</script>
</head>
<body>
	<div class="mybody">
		<h2 class="bg1">热门搜索列表</h2>
		[#list list as item]
		<div class="bg${item_index % 2 + 1}"><label><a href="${base}/admin/dohotsearch/${item.id}?do=del">删除</a></label>
		<span class="red">排序值:</span>${item.sortorder}
		<span class="red">名称:</span>${item.title}
		<span class="red">地址:</span>${item.originurl}
		</div>
		[/#list]
	    
	    <div class="bg1"><label></label></div>
	    
		<form id="f_form" action="${base}/admin/dohotsearch" method="post">
		<h2 class="bg1">添加热门搜索</h2>
	    <div class="bg2"><label>名称</label><input id="txttitle" name="title" type="text" /><span class="red">*</span></div>
	    <div class="bg2"><label>地址</label><input id="txthref" name="originurl" type="text" /><span class="red">*</span></div>
	    <div class="bg1"><label>排序值</label><input class="txtwidth60" name="sortorder" value="0" type="text" /></div>
	    <div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
	    </form>
	</div>
</body>
</html>