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
		<div class="widebox">
			<div class="leftbox">
				<h2>//家族文化产品<span class="tag">共${cultureProdAmount}个商品</span></h2>
				<a href="${base}/b2c/1" class="more">更多</a>
				<div class="block">
					[@p.listB2CProds cultureProds /]
				</div>
			</div>
			<div class="vline hd">　</div>
			<div class="rightbox">
				<div class="left" style="width:472px;">
				<h2>//书籍<span class="tag">共${booksAmount}个商品</span></h2>
				<a href="${base}/b2c/0" class="more">更多</a>
				<div class="block" style="width:472px;">
					[@p.listB2CProds books /]
					<br class="clear" />
				</div>
				</div>
				<div class="left" style="width:472px;">
				<h2>//教具<span class="tag">共${eduToolsAmount}个商品</span></h2>
				<a href="${base}/b2c/2" class="more">更多</a>
				<div class="block" style="width:462px;">
					[@p.listB2CProds eduTools /]
				</div>
				</div>
				<div class="left" style="width:472px;">
				<h2>//软件<span class="tag">共${softwares?size}个商品</span></h2>
				<a href="${base}/b2c/3" class="more">更多</a>
				<div class="block">
					<div class="list">
						<ol class="software">
						[@p.listB2CProds softwares /]
						</ol>
					</div>
				</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
</body>
</html>