[#ftl]
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
<div class="box famous">
	<div class="topbar">
		<h2>门家教</h2><div class="more"><a href="${base}/edu/0">More</a></div>
	</div>
	<ol>
		[#list famousList as item]
		<li [#if item_index < 3]class="red"[/#if]><a href="${base}/edu/0/${item.id}">${item.title}</a></li>
		[/#list]
	</ol>
</div>
<div class="box professional">
	<div class="topbar">
		<h2>家理念</h2><div class="more"><a href="${base}/edu/1">More</a></div>
	</div>
	<ol>
		[#list professionalList as item]
		<li [#if item_index < 3]class="red"[/#if]><a href="${base}/edu/1/${item.id}">${item.title}</a></li>
		[/#list]
	</ol>
</div>
<div class="box home">
	<div class="topbar">
		<h2>族家教</h2><div class="more"><a href="${base}/edu/2">More</a></div>
	</div>
	<ol>
		[#list homeList as item]
		<li [#if item_index < 3]class="red"[/#if]><a href="${base}/edu/2/${item.id}">${item.title}</a></li>
		[/#list]
	</ol>
</div>
<div class="box edubooks">
	<div class="topbar">
		<h2>育教材</h2><div class="more"><a href="${base}/edu/3">More</a></div>
	</div>
	<div class="container">
	[#list bookList as item]
	<ul>
		<li><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" title="${item.name}" /></a></li>
		<li><a href="${base}/b2c/${item.uid}">${item.name}</a></li>
		<li>约￥<span class="red">${item.shopprice}</span></li>
	</ul>
	[/#list]
	</div>
</div>

</body>
</html>