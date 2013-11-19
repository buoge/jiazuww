[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>家族搜索</title>
<meta name="Keywords" content="[@s.message "mycart.keyword" /]" />
<meta name="Description" content="[@s.message "mycart.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/search.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">
h2 {font-size: 1.2em; line-height:30px; border-bottom: 1px dashed #999; margin-bottom: 6px;}
</style>
<script type="text/javascript">
<!--
//-->
</script>
</head>
<body>
<div class="block">
<h2>搜索列表：</h2>
	<!--
	<ul class="list hd">
		<li><h3><a href="/jiazu/edu//4">家族教育：家教的鼻祖是孔子——三人行必有吾师</a></h3><span class="right">[2012-08-19]</span></li>
	</ul>
	-->
	[#if list?? && list?size > 0]
	<ul class="list">
		[#list list as item]
			<li><h3><a href="${base}${item.href}">${item.title}</a></h3></li>
		[/#list]
	</ul>
	[#else]
		<h3 class="tip">没有搜索到结果</h3>
	[/#if]
		
	</div>
</div>
</body>
</html>