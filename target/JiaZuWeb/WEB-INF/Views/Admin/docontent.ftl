[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<script type="text/javascript" src="${base}/ckeditor/ckeditor.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
	CKEDITOR.replace('txtcontent',{
        toolbar : 'MyToolbar',
        skin : 'v2',
        filebrowserImageUploadUrl : "${base}/ckeditor/img",
        filebrowserFlashUploadUrl : "${base}/ckeditor/flash"
    });
    $("#cke_bottom_txtcontent").addClass("hd");
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
		<form id="f_form" action="${base}/admin/content/${type}" method="post">
			<input name="id" value="${(bean.id)!}" type="hidden" />
			<h2 class="bg2">${title}</h2>
			<div style="width:800px;">
		    	<textarea id="txtcontent" style="width:700px; height:150px;" name="content">${(bean.content)!}</textarea><span class="red">*</span>
		    </div>
	    	<div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
	    </form>
	</div>
</body>
</html>