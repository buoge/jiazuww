[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>缅怀音乐</title>
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

function addclickhandler() {
	$("#f_addform").toggleClass("hd");
}


function delConfirmHandler() {
	var msg = "您确定要删除吗？删除不可恢复！";
	if (confirm(msg)==true){
		return true;
	}else{
		return false; 
	}
	return false;
}
//-->
</script>
</head>
<body>
	<div class="mybody">
	
		[#if !editbean??]
		<form id="f_jisi" action="${base}/admin/dojisimusic" method="post" enctype="multipart/form-data">
		<h2 class="bg1">添加缅怀音乐</h2>
		<div class="bg2"><label>名称</label><input id="txtname" name="name" value="" type="text" /></div>
		<div class="bg1"><label>缅怀音乐</label><input id="music" type="file" name="music"><span class="red">(最大10M,mp3格式）</div>
		<div class="bg2"><label></label><input name="" value="添加" class="btn2" type="submit" /></div>
		</form>
		[/#if]
	    
		<h2 class="bg1">祭品列表</h2>
		<table class="list">
			<thead><tr>
			<th width="200px">音乐</th>
			<th width="100px">操作</th></tr></thead>
			<tbody>
			[#list list as item]
				<tr>
					<td><a href="${base}${(item.path)!}" target="_blank"> ${(item.name)!}</a></td>
					<td>
					<a href="${base}/admin/dojisimusic/${(item.uid)!}/del" onclick="return delConfirmHandler()" >删除</a>
					</td>
				</tr>
			[/#list]
			</tbody>
		</table>
	    
	    
	</div>
</body>
</html>