[#ftl]
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
			<h2 class="bgb2c1">围观区<span style="margin-left: 20px; font-size: 12px;">${onlineUsersCount}</span></h2>
			<div class="block">
				[#list c2cTopList as item]
				<ul class="ul1">
					<li><a href="${base}/c2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /> </a></li>
					<li><div class="left">${item.newrate}成新</div><div class="right"><span class="ff9800 bold">${item.price}</span>元</div></li>
				</ul>
				[/#list]
			</div>
		</div>
		<div class="box">
			<h2 class="bgb2c2">
			布告区
			<a href="${base}/c2c/01" class="more">更多</a>
			</h2>
			<div class="block">
				[#list c2cProdList as item]
				<ul class="ul2">
					<li class="left"><span class="c900 bold">[${item.typeName}]</span>&nbsp;&nbsp;<a href="${base}/c2c/${item.uid}">${item.name}</a>&nbsp;<span class="ff9800 bold">${item.price}元</span></li>
					<li class="right">${item.address}&nbsp;<span class="gray">${item.date}</span></li>
				</ul>
				[/#list]
			</div>
		</div>
		<div class="box">
			<h2 class="bgb2c3">
			公益区
			<a href="${base}/c2c/2" class="more">更多</a>
			</h2>
			<div class="block">
				[#list c2cCharityList as item]
				<ul class="ul3">
					<li class="left"><a href="${base}/c2c/${item.uid}"><img src="${baseimg}${item.thumb}" data-src404="${baseimg}/imgs/default/noimg130_130.gif" alt="" /> </a></li>
					<li class="right"><a href="${base}/c2c/${item.uid}">${item.name}</a>
					<p class="gray">时间：${item.date}</p></li>
				</ul>
				[/#list]
			</div>
		</div>
	</div>
</div>
</body>
</html>