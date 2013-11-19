[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>族谱简介管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
});

function validSubmitHandler() {
	var valid = true;
	if($("#txtcontent").val().trim() == "") {
		if(valid) {
			$("#txtcontent").focus();
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
		<form id="f_form" action="${base}/admin/content/dozupu" method="post">
		<input name="id" value="${(bean.id)!}" type="hidden" />
		<h2 class="bg2">族谱简介</h2>
	    <div class="bg1"><label>内容</label>
	    <textarea id="txtcontent" style="width:700px; height:150px;" name="content">${(bean.content)!}</textarea><span class="red">*</span>
	    </div>
	    <div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
	    </form>
	</div>
</body>
</html>