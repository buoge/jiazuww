[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title!}</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/aboutus.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
$(function(){
	toggleMenu("#leftmenu a");
});
//-->
</script>
</head>
<body>
<div class="mybody">
<div class="bodyLeft">
	<div class="menu">
		<div class="top">${title!}</div>
		<ul id="leftmenu">
			<li>
				<a href="${base}/aboutus">关于我们</a>
			</li>
			<li>
				<a href="${base}/charge">充值服务</a>
			</li>
			<li>
				<a href="${base}/service">客服中心</a>
			</li>
			<li>
				<a href="${base}/hr">招贤纳士</a>
			</li>
			<li>
				<a href="${base}/legal">网站声明</a>
			</li>
			<li>
				<a href="${base}/help">帮助中心</a>
			</li>
		</ul>
	</div>
</div>
<div class="bodyRight">
	<div class="content">
		<div class="title">${title!}</div>
		${bean.content!}
	</div>
</div>

</div>
</body>
</html>