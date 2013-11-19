[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.c2c" /]</title>
<meta name="Keywords" content="[@s.message "c2c.keyword" /]" />
<meta name="Description" content="[@s.message "c2c.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/c2c.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="widebox">
	<div class="box">
		[#if type == "01"]
			<h2 class="bgb2c2">
			布告区
			</h2>
		[#elseif type == "2"]
			<h2 class="bgb2c3">
			公益区
			</h2>
		[#else]
			
		[/#if]
		<div class="block">
			[#if list?? && list?size > 0]
				[#list list as item]
				<ul class="ul2">
					<li class="left"><span class="c900 bold">[${item.typeName}]</span>&nbsp;&nbsp;<a href="${base}/c2c/${item.uid}">${item.name}</a>&nbsp;[${(item.galleries.size)!0}图]&nbsp;
					[#if type == "01"]
					<span class="ff9800 bold">${item.price}元</span>
					[/#if]
					</li>
					<li class="right">${item.address}&nbsp;<span class="gray">${item.date}</span></li>
				</ul>
				[/#list]
				[#if pager??]
				[@p.Pager pager /]
				[/#if]
			[#else]
				<h3 class="tip">没有搜索到结果</h3>
			[/#if]
		</div>
	</div>
	</div>
</div>
</body>
</html>