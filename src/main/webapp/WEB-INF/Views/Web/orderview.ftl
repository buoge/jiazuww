[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myorder" /]</title>
<meta name="Keywords" content="[@s.message "myorder.keyword" /]" />
<meta name="Description" content="[@s.message "myorder.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myorder.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
$(function(){
});


 [#if msg??]
 alert("${msg}");
 [/#if]
//-->
</script>
</head>
<body>
<div class="mybody">
<form method="post" action="${base}/myorder">
	<div class="widebox">
	<h1 style="border:0;">订单信息</h1>
		<div class="box">
			<h3>地址信息</h3>
			<dl class="dlbox">
				<dd>
				${(order.address)!} ${(order.tel)!} ${(order.consignee)!}
				</dd>
			</dl>
		</div>
		<div class="box">
			<h3>配送及支付方式</h3>
			<dl class="dlform">
				<dt><span class="red">*</span>配送方式：</dt>
				<dd>快递(<span class="red">${fee!0}元</span>)</dd>
				<dt>支付方式：</dt>
				<dd><input type="radio" name="payid" value="0" checked="checked" /><label>支付宝</label></dd>
			</dl>
		</div>
		<div class="box">
			<h3>商品清单</h3>
			<table>
			<thead><tr>
			<th width="100px">商品编号</th>
			<th width="400px">商品名称</th>
			<th width="80px">单价</th>
			<th width="100px">数量</th>
			</thead>
			[#list list as item]
			<tr>
				<td>
				<input id="hduid" name="uids" value="${(item.uid)!}" type="hidden" />
				${(item.sn)!}</td>
				<td class="txtlft ptop5">
				<a href="${base}/b2c/${(item.uid)!}"><img style="width:50px; height:50px;" class="left" src="${base}${(item.littlethumb)!}" alt="${(item.name)!}" title="">
				${(item.name)!}
				</a>
				</td>
				<td>￥${(item.shopprice)!}</td>
				<td>${(item.number)!}</td>
			</tr>
			[/#list]
			</table>
		</div>
		<div class="box">
			<h3>订单备注</h3>
			<div>${order.memo!}</div>
		</div>
		<div class="infor">
			<p>商品金额：${money}元</p>
			<p>+运费：${fee!0}元</p>
			[#if minusprice > 0]
			<p>-优惠：${minusprice!0}元</p>
			[/#if]
			<p>=应付总额：<span class="red">￥${(money - minusprice + fee)!} 元</span></p>
			<br />
		</div>
	<br class="clear" />
	</div>
</form>
</div>
</body>
</html>