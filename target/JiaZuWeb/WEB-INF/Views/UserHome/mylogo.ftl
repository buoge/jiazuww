[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		$("#f_fileupload").submit(uploadSubmitHandler);
	});
	
	function uploadSubmitHandler(){
		var valid = true;
		if(!uploadFileHandler()) {
			if(valid) {
				alert("请上传jpg/png/gif格式的图像文件");
				valid = false;
			}
		}
		return valid;
	}
	
	function uploadFileHandler() {
		if($("#file").val().trim() == "" || !isImageFile($("#file").val())) {
			return false;
		} else {
			return true;
		}
	}
//-->
</script>
</head>
<body>
[#if msg??]
<div class="red">${msg}</div>
[/#if]
[#if admintype > 0]
<form id="f_fileupload" action="${base}/myhome/${currUid}/logo" method="post" enctype="multipart/form-data">
请上传族徽(推荐150x150)：<input id="file" type="file" name="file" />&nbsp;<input class="btn1" type="submit" value="上传"/>
<a class="right mrgt150 bold" href="http://www.jiazuww.com/b2c/c115d517ab0c476bb8c6735d48e1684c">我需要设计服务</a>

</form>
[/#if]
<div class="mylogo">
<img src="${baseimg}${img}" title="" />
</div>
</body>
</html>