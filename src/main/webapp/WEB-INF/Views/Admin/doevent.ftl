[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>大事记管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/event.css" media="screen" />
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
	return valid;
}

//-->
</script>
</head>
<body>
	<div class="mybody">
		<h2 class="bg1">列表</h2>
		[#if list?? && list?size > 0]
			[@p.EventList list true true /]
		[#else]
			<h3 class="tip">没有搜索到结果</h3>
		[/#if]
		[@p.Pager pager /]
	</div>
</body>
</html>