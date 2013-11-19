[#ftl]
[#escape x as x?html] 
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
		<div class="lftbox">
			<h3 class="bold">${bean.title}</h3>
			<h4>${bean.desc}</h4>
			<a class="imgbig" href=""><img src="${baseimg}${bean.img}" alt="" /></a>
			<p style="text-align:right;"><span class="pink">${(bean.user.name)!}</span>创建于${bean.date} &nbsp;&nbsp;&nbsp;&nbsp;点击数：${bean.clickcount}</p>
		</div>
		<div class="rgtbox">
			[#if me?? || bean.comments?size != 0]
			[@p.CommenList bean.uid bean.comments /]
			[/#if]
			[@p.Pager pager /]
		</div>
	</div>
	<br class="clear" /><br class="clear" /><br class="clear" />
</div>
</body>
</html>
[/#escape]