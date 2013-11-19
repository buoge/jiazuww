[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myaccount-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/jquery/ui/jquery.ui.base.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/jquery/ui/jquery.ui.theme.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function (){
		$(".datepicker").datepicker({
			yearRange : "c-90:c+1",
            changeMonth: true,
            changeYear: true
        });
	});
//-->
</script>
</head>
<body>
<div class="block">
	[#if msg??]
	<span class="red">${msg}</span>
	[/#if]
	<h2>我要修改密码：</h2>
	<form id="f_pwd" action="${base}/myhome/pwd" method="post">
		<div><label for="txtoldpwd">原密码：<span class="red">*</span></label><input id="txtoldpwd" name="oldpassword" type="password" /></div>
		<span id="register_err_txtoldpwd" class="red mlft150 hd">请输入至少6位字符的密码</span>
		[#if (valid.oldpassword)??]
		<span class="red mlft150">${valid.oldpassword}</span>
		[/#if]
		<div><label for="txtpwd">[@s.message "user.pwd" /]：<span class="red">*</span></label><input id="txtpwd" name="password" type="password" /></div>
		<span id="register_err_txtpwd" class="red mlft150 hd">请输入至少6位字符的密码</span>
		[#if (valid.password)??]
		<span class="red mlft150">${valid.password}</span>
		[/#if]
		<div><label for="txtpwd2">[@s.message "user.pwd2" /]：<span class="red">*</span></label><input id="txtpwd2" name="password2" type="password" /></div>
		<span id="register_err_txtpwd2" class="red mlft150 hd">请输入确认密码，确保跟密码一致</span>
		<span id="register_err_txtpwd22" class="red mlft150 hd">确认密码与密码不一致</span>
		[#if (valid.password2)??]
		<span class="red mlft150">${valid.password2}</span>
		[/#if]
		<div class="accountbtmbar">
		<input class="btn3" type="submit" value="修改"/>
		</div>
	</form>
</div>
<div class="block">
	[#if msg2??]
	<span class="red">${msg2}</span>
	[/#if]
	<h2>我要修改个人资料：</h2>
	<form id="f_infor" action="${base}/myhome/account" method="post" enctype="multipart/form-data">
		<input name="avatar" value="${(me.avatar)!}" type="hidden" />
		<input name="original" value="${(me.original)!}" type="hidden" />
		<div><label for="txtname">用户名：</label>${(me.userid)!}</div>
		<div class="rltv">
		<label for="txtavatar">头像：</label>
		<input id="file" type="file" name="file">
		<img class="abs" style="left:450px; top:-50px; width:300px;" data-src404="" src="${baseimg}${me.original}" />
		</div>
		<div>
			<label for="txtaccount">账户余额：</label>${me.account} &nbsp;&nbsp;&nbsp;&nbsp;<a target="_blank" href="${base}/b2c/dd2a9f0a6c0f4a0f8c432154ef285788">我要充值</a>
			<!--
			&nbsp;&nbsp;&nbsp;&nbsp;
			<form id="f_charge" action="${base}/myhome/charge" method="post">
			请输入充值金额：<input id="txtchargemoney" name="chargemoney" class="txtwidth60" type="text" />
			<input class="btn2 hd" type="submit" value="充值"/>
			</form>-->
		</div>
		<div><label>性别：</label>
			<input style="float:none;" type="radio" id="man" [#if me.gender == 0] checked="checked"[/#if] value="0" name="gender" />男&nbsp;<input style="float:none;" type="radio" [#if me.gender == 1] checked="checked"[/#if] id="lady" value="1" name="gender" />女
		</div>
		<div class="hd"><label for="txtrealname">真实姓名：</label><input id="txtrealname" value="${(me.realname)!}" name="realname" type="text" /></div>
		<div><label for="txtbirthday">生日：</label><input id="txtbirthday" class="datepicker" value="${(me.birthday)!}" name="birthday" type="text" /></div>
		<div><label for="txtemail">Email：<span class="red">*</span></label><input id="txtemail" value="${(me.email)!}" name="email" type="text" />
		<span id="err_txtemail" class="red mlft150 hd">请正确输入您的邮箱</span>
		</div>
		<div><label for="txtphone">手机：</label><input id="txtphone" value="${(me.phone)!}" name="phone" type="text" /></div>
		<div class="hd"><label for="txtmobile">电话：</label><input id="txtmobile" value="${(me.mobile)!}" name="mobile" type="text" /></div>
		
		<div class="accountbtmbar">
		<input class="btn2" type="submit" value="保存"/>
		</div>
	</form>
</div>
</body>
</html>