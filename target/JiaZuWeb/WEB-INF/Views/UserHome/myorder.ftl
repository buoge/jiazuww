[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myordercenter.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
function delConfirmHandler() {
	var msg = "您确定要删除吗？删除不可恢复！";
	if (confirm(msg)==true){
		return true;
	}else{
		return false; 
	}
	return false;
}
//-->
</script>
</head>
<body>
[#if msg??]
<div class="red">${msg}</div><br />
[/#if]
<div class="block">
	<h2>我的订单列表：</h2>
	<table>
		<thead><tr>
		<th width="60px">订单编号</th>
		<th width="200px">订单商品</th>
		<th width="80px">总金额</th>
		<th width="100px">下单时间</th>
		<th width="100px">订单状态</th>
		<th width="100px">操作</th></tr></thead>
		<tbody>
		[#list list as item]
			<tr>
				<td>${(item.ordersn)!}</td>
				<td class="txtlft ptop5">
				[#list item.details as detail]
				<a href="${base}/b2c/${(detail.b2cuid)!}" target="_blank"><img class="left" style="width:50px; height:50px;" src="${base}${(detail.b2clittlethumb)!}" alt="${(detail.b2cname)!}" title=""></a>
				[/#list]
				</td>
				<td>￥${(item.getLastTotalprice())!0}</td>
				<td>${(item.createTime.toString("yyyy-MM-dd HH:mm:ss"))!}</td>
				<td>
				[#if item.refundStatusName??]
				${(item.refundStatusName)!}
				[#else]
				${(item.orderstatusName)!}
				[/#if]
				</td>
				<td>
				<a href="${base}/orderview/${(item.uid)!}" target="_blank">查看</a>
				[#if item.orderstatus == -1 || item.orderstatus == 3 || item.orderstatus == 0]
				<a href="${base}/myhome/order/${(item.uid)!}/del" onclick="return delConfirmHandler()">删除</a>
				[/#if]
				[#if item.orderstatus == -1 ]
					<form id="f_order" action="${base}/myhome/order/${(item.uid)!}/pay" method="post">
						<input id="btnconfirm" class="btn2 btn mtop5" type="submit" value="马上付款">
					</form>
				[#else]
					<div class="txtcen">
					<a href="https://www.alipay.com/" title="请登录支付宝进行订单操作" target="_blank">登录支付宝</a>
					</div>
				[/#if]
				[#--
				[#if item.orderstatus == 2 ]
					<form id="f_order" action="${base}/myhome/order/${(item.uid)!}" method="post">
						<input id="btnconfirm" class="btn2 btn mtop5" type="button" onclick="alert('请直接登录您的支付宝对本订单确认收货！');gourl('https://www.alipay.com/')" value="确认收货">
					</form>
				[/#if]
				--]
				</td>
			</tr>
		[/#list]
		</tbody>
		<tfoot class="hd">
		<tr>
		<td colspan="7" class="txtrgt">
		未付款订单：<span class="red">12</span>&nbsp;&nbsp;
		已完成订单：<span class="red">30</span>&nbsp;&nbsp;
		订单总数：<span class="red">30</span>&nbsp;&nbsp;
		</td>
		</tr></tfoot>
		</table>
		[@p.Pager pager /]
</div>
</body>
</html>