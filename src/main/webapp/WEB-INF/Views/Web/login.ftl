[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "pleaselogin" /]</title>
<meta name="Keywords" content="[@s.message "user.login.keyword" /]" />
<meta name="Description" content="[@s.message "user.login.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/login.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/pages/login-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/cookie/jquery.cookie.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#txtuserid").blur(function () {
		var json = {userId : $(this).val()};
		$.get("isuserexist" + "?time=" + new Date(), json, function(data) {
			if(data) {
				$("#errexisted").removeClass("hd");
			} else {
				$("#errexisted").addClass("hd");
			}
		});
	});
	$("#txtemail").blur(function () {
		var json = {email : $(this).val()};
		$.get("isemailexist" + "?time=" + new Date(), json, function(data) {
			if(data) {
				$("#erremailexisted").removeClass("hd");
			} else {
				$("#erremailexisted").addClass("hd");
			}
		});
	});
	$("#imgvalid").click(function(){
		var strs = $(this).attr("src").split('?');
		$(this).attr("src", strs[0] + "?time=" + new Date());
	});
});

function resetPwdHandler() {
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if($("#getpwd_email").val().trim() == "" || !reg.test($("#getpwd_email").val().trim())) {
		alert("请正确输入注册时的邮箱地址");
		$("#getpwd_email").focus();
	} else {
		var json = {email : $("#getpwd_email").val().trim()};
		$.get("resetpwd", json, function(data) {
			if(data) {
				alert("重置成功，请查收您的邮箱用新密码登录");
			} else {
				alert("找回密码失败，请联系管理员");
			}
		});
	}
}
//-->
</script>
</head>
<body>
	<div class="mybody">
		<div class="title"><h1>[@s.message "user.login.title" /]</h1></div>
		<div class="container">
		<div class="login">
			<div class="mlft60">
				<form id="f_login" action="${base}/login" method="post">
				<div class="mtop30"><label for="name">[@s.message "user.userid" /]：</label><input class="txtfield" value="${(userid)!}" maxlength="100" type="text" name="${f_userid!"userid"}" id="name" /></div>
				<p id="login_err_userid" class="red mlft60 hd">请输入用户名</p>
				[#if (valid.useridneed)??]
				<p class="red mlft60">${valid.useridneed}</p>
				[/#if]
				<div><label for="pwd">[@s.message "user.pwd" /]：</label><input class="txtfield" value="" name="${f_pwd!"password"}" id="pwd" type="password" /></div>
				<p id="login_err_pwd" class="red mlft60 hd">请输入不少于6位字符的密码</p>
				[#if (valid.pwdneed)??]
				<p class="red mlft60">${valid.pwdneed}</p>
				[/#if]
				[#if (valid.loginfailed)??]
				<p class="red mlft60">${valid.loginfailed}</p>
				[/#if]
				<div class="mlft45 mtop20">
					<a class="getpwd mlft30" href="" onclick="$('#getpwd').removeClass('hd');$('#getpwd_email').focus()">[@s.message "user.login.forgetpwd?" /]</a>
					<input id="loginSubmit" class="loginbtn right mrgt30" type="submit" value="　" />
				</div>
				</form>
				<div class="line"></div>
				<div id="getpwd" class="hd">
					<dl>
						<dt style="font-size:1.1em;">重置密码</dt>
						<dd>&nbsp;</dd>
						<dd>请输入注册时的邮箱：</dd>
						<dd class="txtrgt"><input id="getpwd_email" value="" name="email" type="text" /></dd>
						<dd class="txtrgt"><input type="button" value="重置" onclick="resetPwdHandler()" class="btn3" /></dd>
					</dl>
				</div>
				<div class="tips hd">
				<p>[@s.messageArgs "user.login.onlineusers", [onlineUserNum!] /]</p>
				<p>[@s.messageArgs "user.login.createdjiazutrees", [jiaZuTreesNum!] /]</p>
				</div>
			</div>
		</div>
		<div class="separate"></div>
		<div class="register">
			<form id="f_register" action="register" method="post">
				<div><label for="txtuserid">[@s.message "user.userid" /]：<span class="red">*</span></label><input id="txtuserid" value="${(user.userid)!}" name="userid" type="text" /></div>
				<p id="register_err_txtuserid" class="err mlft150 hd">请填写用户名</p>
				<p id="register_err_txtuserid2" class="err mlft150 hd">用户名为6-30个字符</p>
				<p id="errexisted" class="err mlft150 hd">用户名已存在!</p>
				[#if (valid.userid)??]
				<p class="err mlft150">${valid.userid}</p>
				[/#if]
				<div><label for="txtpwd">[@s.message "user.pwd" /]：<span class="red">*</span></label><input id="txtpwd" name="password" type="password" /></div>
				<p id="register_err_txtpwd" class="err mlft150 hd">请输入至少6位字符的密码</p>
				[#if (valid.password)??]
				<p class="err mlft150">${valid.password}</p>
				[/#if]
				<div><label for="txtpwd2">[@s.message "user.pwd2" /]：<span class="red">*</span></label><input id="txtpwd2" name="password2" type="password" /></div>
				<p id="register_err_txtpwd2" class="err mlft150 hd">请输入确认密码，确保跟密码一致</p>
				<p id="register_err_txtpwd22" class="err mlft150 hd">确认密码与密码不一致</p>
				[#if (valid.password2)??]
				<p class="err mlft150">${valid.password2}</p>
				[/#if]
				<div><label for="txtemail">电子邮箱：<span class="red">*</span></label><input id="txtemail" value="${(user.email)!}" name="email" type="text" /></div>
				<p class="mlft150">(需用邮箱激活账号)</p>
				<p id="register_err_txtemail" class="err mlft150 hd">请正确输入电子邮箱</p>
				<p id="erremailexisted" class="err mlft150 hd">邮箱已存在</p>
				[#if (valid.email)??]
				<p class="err mlft150">${valid.email}</p>
				[/#if]
				<div class="hd"><label for="txtname">[@s.message "user.nickname" /]：</label><input id="txtname" value="${(user.name)!}" name="name" type="text" /></div>
				<div><label for="txtvalicode">[@s.message "validatecode" /]：<span class="red">*</span></label><input id="txtvalicode" name="validcode" class="txtwidth60" type="text" />&nbsp;&nbsp;<img id="imgvalid" title="看不清，换一张" class="validimg" src="${base}/v.jpg" /></div>
				<p id="register_err_txtvalicode" class="err mlft150 hd">[@s.message "user.login.val.validatecodecannotbeempty" /]</p>
				[#if (valid.validcode)??]
				<p class="err mlft150">${valid.validcode}</p>
				[/#if]
				<div><input id="chkaggreerule" name="aggreerule" class="checkbox mlft150 mtop8" value="true" checked="checked" type="checkbox"/><label for="chkaggreerule" style="width: auto;">&nbsp;&nbsp;[@s.message "user.register.agreement" /]<a href="${base}/rule/register" target="_blank">[@s.message "user.register.rule" /]</a></label></div>
				<p id="register_err_chkaggreerule" class="err mlft150 hd">用户协议必须同意</p>
				[#if (valid.aggreerule)??]
				<p class="err mlft150">${valid.aggreerule}</p>
				[/#if]
				<br class="clear" />
				<div><input id="registerSubmit" class="btnregister mlft150" type="submit" value="[@s.message "user.register.btnregister" /]" /></div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>