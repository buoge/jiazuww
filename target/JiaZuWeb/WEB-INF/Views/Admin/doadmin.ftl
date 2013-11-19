[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/right.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_admin").submit(validSubmitHandler);
});

function validSubmitHandler() {
	var valid = true;
	if($("#txtuserid").val().trim() == "") {
		if(valid) {
			$("#txtuserid").focus();
			valid = false;
		}
	}
	if($("#txtpwd").val().trim() == "") {
		if(valid) {
			$("#txtpwd").focus();
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
		<h2 class="bg1">管理员列表</h2>
		[#list list as item]
		<div class="bg${item_index % 2 + 1}"><label>${item.userid}</label><a href="${base}/admin/doadmin/${item.uid}?do=del">删除</a></div>
		[/#list]
	    <div class="bg1"><label></label></div>
		[@security.authorize ifAnyGranted="ROLE_ADMIN"]
		<form id="f_admin" action="${base}/admin/doadmin" method="post">
		<h2 class="bg1">添加管理员</h2>
	    <div class="bg2"><label>登录ID</label><input id="txtuserid" class="txtbox" name="userid" type="text" /><span class="red">*</span></div>
	    <div class="bg1"><label>密码</label><input id="txtpwd" class="txtbox" name="password" type="text" /><span class="red">*</span></div>
	    <div class="bg1"><label>email</label><input class="txtbox" name="email" type="text" /></div>
	    <div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
		[/@security.authorize]
	</div>
</body>
</html>