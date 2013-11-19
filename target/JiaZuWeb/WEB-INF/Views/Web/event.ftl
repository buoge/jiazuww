[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.event" /]</title>
<meta name="Keywords" content="[@s.message "event.keyword" /]" />
<meta name="Description" content="[@s.message "event.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/event.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="boxs">
	[#if list?? && list?size > 0]
		[@p.EventList list /]
	[#else]
		<h3 class="tip">没有搜索到结果</h3>
	[/#if]
	[#if pager??]
	[@p.Pager pager /]
	[/#if]
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
	</div>
</div>
</body>
</html>