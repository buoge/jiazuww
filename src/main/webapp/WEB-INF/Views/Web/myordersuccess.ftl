[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myordersuccess" /]</title>
<meta name="Keywords" content="[@s.message "myordersuccess.keyword" /]" />
<meta name="Description" content="[@s.message "myordersuccess.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myorder.css" media="screen" />
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
	<h2 style="margin-left:100px;"><span class="first"><div class="bg"></div>1.我的购物车</span><span class="second">2.填写订单信息</span><span class="third">3.核对提交订单</span><span class="fourth here">4.支付成功</span></h2>
	<h1></h1>
	<div class="box">
		<dl class="dlcharge">
			<dt>您的订单状态</dt>
			[#if ordersn??]
			<dd>${msg}</dd>
			<dd>
				订单号是：<span class="red">${ordersn!}</span>&nbsp;&nbsp;&nbsp;
				已支付金额：<span class="red">${totalprice!0}</span>元&nbsp;&nbsp;&nbsp;
			</dd>
			[#else]
			<dd>
			${msg}
			</dd>
			[/#if]
			<!--
			<dt>还差一步，使用支付宝在线支付</dt>
			<dd class="mtop10">
				<a href=""><img src="imgs/webimgs/alipay.gif" alt="" /> </a>
			</dd>
			-->
			
		</dl>
	</div>
	<div style="width: 70%; text-indent: 2em;">
	如您在支付过程中遇到任何问题，请点击<a href="${base}/service">[@s.message "customerservice" /]</a>联系客服，谢谢！
	</div>
</div>
</div>
</body>
</html>