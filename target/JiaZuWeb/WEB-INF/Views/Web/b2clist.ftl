[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.b2c" /]</title>
<meta name="Keywords" content="[@s.message "b2c.keyword" /]" />
<meta name="Description" content="[@s.message "b2c.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/b2c.css" media="screen" />
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
		<div class="resultbox">
			<h1>商品列表</h1>
			<div class="resultlist">
				[#if type == 3]
					<ol class="software">
					[@p.listB2CProds list /]
					</ol>
				[#else]
					[#if list?? && list?size > 0]
						[@p.listB2CProds list /]
					[#else]
						<h3 class="tip">没有搜索到结果</h3>
					[/#if]
				[/#if]
				[#if pager??]
				[@p.Pager pager /]
				[/#if]
			</div>
		</div>
		<div class="hotbox">
			<h1>NO.1 销量明星</h1>
			<div class="hotlist">
				[@p.listB2CProds hotlist true /]
			</div>
		</div>
	</div>
</div>
</body>
</html>