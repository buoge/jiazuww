[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.custom" /]</title>
<meta name="Keywords" content="[@s.message "custom.keyword" /]" />
<meta name="Description" content="[@s.message "custom.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/custom.css" media="screen" />
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
			<h2>//风土人情 <span style="font-size: 12px;">>置顶图</span></h2>
			<div class="imgsblock">
			[@p.CustomList topCustoms false /]
			</div>
		</div>
		<div class="imgsblock">
			[@p.CustomList customList false /]
			[@p.Pager pager /]
		</div>
	</div>
	<br class="clear" /><br class="clear" /><br class="clear" />
</div>
</body>
</html>