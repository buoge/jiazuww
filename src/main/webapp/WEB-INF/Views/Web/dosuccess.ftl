[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}</title>
<meta name="Keywords" content="[@s.message "myordersuccess.keyword" /]" />
<meta name="Description" content="[@s.message "myordersuccess.description" /]" />
[#if activeResult?? && activeResult]
<meta http-equiv="Refresh" content="3; url=${base}/login" />
[#elseif !emailSendResult?? || !emailSendResult]
<meta http-equiv="Refresh" content="2; url=${base}/myhome" />
[/#if] 
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myorder.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/jquery/cookie/jquery.cookie.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
[#if !state?? || state != "1"]
	[#if sid??]
		$.cookie('sid', '${sid!}');
		//alert($.cookie('returnurl'));
		if($.cookie('returnurl') != null && $.cookie('returnurl') != "" ) {
			window.location.href = $.cookie('returnurl');
		}
	[/#if]
[/#if]
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="widebox">
	<h1></h1>
	<div class="box">
		<dl class="dlcharge">
			<dt>${title}</dt>
			<dd class="txtcen">
				[#if activeResult?? && activeResult]
					恭喜您，邮件激活成功！请返回<a href="${base}/login">登录页面重新登录！</a>
				[#elseif !emailSendResult?? || !emailSendResult]
					现在即将跳转到<a href="${base}/myhome">会员中心</a> ...
				[#else]
					您好，已成功发送激活邮件到您的注册邮箱，请登录您的邮箱激活账号。
				[/#if]
			</dd>
			<dt>&nbsp;</dt>
		</dl>
	</div>
	<div style="width: 70%; text-indent: 2em;">
		[#if !emailSendResult?? || !emailSendResult]
		若没有自动跳转，请点击以上链接
		[#else]
		[/#if]
	</div>
</div>
</div>
</body>
</html>