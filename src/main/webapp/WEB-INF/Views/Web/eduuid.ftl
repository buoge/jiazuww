[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${(bean.title)!}[@s.message "title.edu" /]</title>
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
	<h1>${(bean.title)!}</h1>
	<div class="content">
		${(bean.content)!}
	</div>
	<div class="foot">
		点击数：${(bean.clickcount)!}&nbsp;&nbsp;&nbsp;发布时间：${(bean.date)!}
	</div>
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