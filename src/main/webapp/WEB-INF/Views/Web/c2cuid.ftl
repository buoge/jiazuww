[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.c2c" /]</title>
<meta name="Keywords" content="[@s.message "c2c.keyword" /]" />
<meta name="Description" content="[@s.message "c2c.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/c2cuid.css" media="screen" />
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
		<h1><span>(${(bean.typeName)!"默认"})</span>${(bean.name)!""}</h1>
		<ul>
			<li><label>联系人：</label><span>${(bean.contactname)!}</span></li>
			<li><label>价格：</label><span>${(bean.price)!0}元</span></li>
			<li><label>联系电话：</label><span>${(bean.telephone)!}</span></li>
			<li><label>QQ/MSN：</label><span>${(bean.qq)!}</span></li>
			<li><label>地址：</label><span>${(bean.address)!}</span></li>
		</ul>
		<div class="desc">
			[#if bean.img?? && bean.img != ""]
				<img src="${baseimg}${bean.img}" />
			[/#if]
			${(bean.desc)!}
		</div>
	</div>
</div>
</body>
</html>