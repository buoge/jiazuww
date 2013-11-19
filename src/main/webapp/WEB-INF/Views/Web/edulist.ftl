[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.edu" /]</title>
<meta name="Keywords" content="[@s.message "edu.keyword" /]" />
<meta name="Description" content="[@s.message "edu.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/edu.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
<div class="leftbox">
	<h2>${typeName}</h2>
	<ul class="list">
		[#if type == 3]
		[#list list as item]
		<li><h3><a href="${base}/b2c/${item.uid}">${item.name}</a></h3><span class="right">[${item.date}]</span></li>
		[/#list]
		[#else]
		[#if list?? && list?size > 0]
			[#list list as item]
			<li><h3><a href="${base}/edu/${type}/${item.id}">${item.title}</a></h3><span class="right">[${item.date}]</span></li>
			[/#list]
		[#else]
			<h3 class="tip">没有搜索到结果</h3>
		[/#if]
		[/#if]
	</ul>
	[#if pager??]
	[@p.Pager pager /]
	[/#if]
</div>
<div class="rightbox">
	[#list bookList as item]
	<ul>
		<li><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" title="${item.name}" /></a></li>
		<li><a href="${base}/b2c/${item.uid}">${item.name}</a></li>
		<li>约￥<span class="red">${item.shopprice}</span></li>
	</ul>
	[/#list]
</div>
</body>
</html>