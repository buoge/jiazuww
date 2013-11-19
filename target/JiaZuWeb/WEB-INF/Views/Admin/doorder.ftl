[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
});

function validSubmitHandler() {
	var valid = true;
	if($("#txttitle").val().trim() == "") {
		if(valid) {
			$("#txttitle").focus();
			valid = false;
		}
	}
	return valid;
}

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
	<div class="mybody">
		<h2 class="bg1">查询</h2>
	    <div class="bg2"">
	    <form id="f_form" action="${base}/admin/doorder/search" method="get">
	    <ul class="searchbox">
	    	<li><label>编 号</label><input name="ordersn" value="${ordersn!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>会员ID</label><input name="userid" value="${userid!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>会员姓名</label><input name="username" value="${username!}" class="txtwidth150" value="" type="text" /></li>
	    </ul>
	    <ul class="searchbox">
	    <li><label>订单状态</label>
	    	全部<input name="orderstatus" checked="checked" value="-2" type="radio" />&nbsp;
	    	待付款<input name="orderstatus" [#if orderstatus == -1]checked="checked"[/#if]  value="-1" type="radio" />&nbsp;
	    	待发货<input name="orderstatus" [#if orderstatus == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    	已发货<input name="orderstatus" [#if orderstatus == 2]checked="checked"[/#if]  value="2" type="radio" />&nbsp;
	    	成功<input name="orderstatus" [#if orderstatus == 3]checked="checked"[/#if]  value="3" type="radio" />&nbsp;
	    	退款成功<input name="orderstatus" [#if orderstatus == 0]checked="checked"[/#if]  value="0" type="radio" />
	    	(订单处于退款中的状态请支付宝查询)
	    	</li>
	    </ul>
	    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
	    </form>
	    </div>
	    <br /><br />
	    <h2 class="bg1">列表：</h2>
	    <br />
		<table class="list">
			<thead><tr>
			<th width="60px">会员ID</th>
			<th width="60px">会员姓名</th>
			<th width="60px">订单编号</th>
			<th width="200px">订单商品</th>
			<th width="80px">总金额</th>
			<th width="80px">优惠金额</th>
			<th width="100px">下单时间</th>
			<th width="100px">订单状态</th>
			<th width="100px">操作</th></tr></thead>
			<tbody>
			[#list list as item]
				<tr>
					<td>${(item.userid)!}</td>
					<td>${(item.username)!}</td>
					<td>${(item.ordersn)!}</td>
					<td class="txtlft ptop5">
					[#list item.details as detail]
					<a href="${base}/b2c/${(detail.b2cuid)!}" target="_blank"><img class="left" style="width:50px; height:50px;" src="${base}${(detail.b2clittlethumb)!}" alt="${(detail.b2cname)!}" title=""></a>
					[/#list]
					</td>
					<td>￥${(item.getLastTotalprice())!0}</td>
					<td>
					[#if item.orderstatus == -1 ]
					<form id="f_minusprice" action="${base}/admin/doorder/${(item.uid)!}/minusprice" method="post">
						<input type="text" class="txtwidth60" name="minusprice" value="${(item.minusprice)!0}" />
						<input id="btnminusprice" class="btn2 btn mtop5" type="submit" value="修改">
					</form>
					[#else]
						${(item.minusprice)!0}
					[/#if]
					</td>
					<td>${(item.createTime.toString("yyyy-MM-dd HH:mm:ss"))!}</td>
					<td>
					[#if item.refundStatusName??]
					${(item.refundStatusName)!}
					[#else]
					${(item.orderstatusName)!}
					[/#if]
					</td>
					<td>
					<a href="${base}/orderview/${(item.uid)!}?admin=true" target="_blank">查看</a>
					<a href="${base}/admin/doorder/${(item.uid)!}/del" onclick="return delConfirmHandler()">删除</a>
					[#if item.orderstatus == 1 ]
						<div class="txtcen">
							<a href="https://www.alipay.com/" title="请登录支付宝进行订单操作" target="_blank">登录支付宝</a>
						</div>
						[#--
						<form id="f_order" action="${base}/admin/doorder/${(item.uid)!}" method="post">
							<input id="btnconfirm" class="btn2 btn mtop5" type="submit" value="发货">
						</form>
						--]
					[/#if]
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
				</tr>
			</tfoot>
		</table>
		[@p.Pager pager /]
	</div>
</body>
</html>