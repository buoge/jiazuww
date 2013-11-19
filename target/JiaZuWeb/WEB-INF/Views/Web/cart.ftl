[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.mycart" /]</title>
<meta name="Keywords" content="[@s.message "mycart.keyword" /]" />
<meta name="Description" content="[@s.message "mycart.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mycart.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		$("a[id='btnminus']").click(btnminusClickHandler);
		$("a[id='btnplus']").click(btnplusClickHandler);
		$("a.btndel").click(btndelClickHandler);
		$("a.linkdel").click(btndelAllClickHandler);
		$("#chkall").click(chkallClickHandler);
		$(".checkout").click(checkoutClickHandler);
	});
	
function btnminusClickHandler(){
	var i = $(this).next("#txtnum").val();
	if(i-- > 1) {
		$(this).next("#txtnum").val(i)
	}
	$("#f_cart").submit();
}

function btnplusClickHandler(){
	var i = $(this).prev("#txtnum").val();
	if($.isNumeric(i)) {
		i++;
	} else {
		i = 1;
	}
	$(this).prev("#txtnum").val(i);
	$("#f_cart").submit();
}


function btndelClickHandler() {
	$("#hduids").val($(":checkbox", $(this).parents("tr")).val());
	
	$("#f_cart").submit();
}
function btndelAllClickHandler() {
	var arr = new Array();
	var i = 0;
	$("input[name='chkuids']:checked").each(function(){
		arr[i++] = $(this).val();
	})
	$("#hduids").val(arr.join(","));
	$("#f_cart").submit();
}
function chkallClickHandler() {
	var chksize = $("input[name='chkuids']").size();
	var chkedsize = $("input[name='chkuids']:checked").size();
	if(chkedsize < chksize) {
		$("input[name='chkuids']").attr("checked", true);
		$(this).attr("checked", true);
	} else {
		$("input[name='chkuids']").attr("checked", false);
		$(this).attr("checked", false);
	}
}


function checkoutClickHandler() {
	var action = "${base}/mycart/update";
	$("#f_cart").attr("action", action);
	$("#f_cart").submit();
}
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="widebox">
	[#if list?? && (list?size) > 0]
	<form id="f_cart" action="${base}/mycart" method="post">
	<input id="hduids" name="uids" value="" type="hidden" />
	<input id="hdmethod" name="_method" value="delete" type="hidden" />
		<h2><span class="first here"><div class="bg"></div>1.我的购物车</span><span class="second">2.填写订单信息</span><span class="third">3.核对提交订单</span></h2>
		<h1>我的购物车</h1>
		<table>
		<thead><tr>
		<th width="60px"><input id="chkall" type="checkbox"  />&nbsp;<label for="chkall">全选</label> </th>
		<th width="100px">商品编号</th>
		<th width="400px">商品名称</th>
		<th width="80px">单价</th>
		<th width="100px">数量</th>
		<th width="60px">操作</th></tr></thead>
		<tbody>
			[#assign money = 0 /]
			[#list list as item]
			[#assign money = money + item.shopprice * item.number /]
			<tr>
				<td><input name="chkuids" value="${(item.uid)!}" type="checkbox" /></td>
				<td>${(item.sn)!}</td>
				<td class="txtlft ptop5">
				<a href="${base}/b2c/${(item.uid)!}"><img class="left" style="width:50px; height:50px;" src="${baseimg}${(item.littlethumb)!}" alt="${(item.name)!}" title="">
				&nbsp;${(item.name)!}
				</a>
				</td>
				<td>￥${(item.shopprice)!}</td>
				<td><a id="btnminus" class="goleft" href="javascript:void(0)"> </a><input id="txtnum" name="num${(item.uid)!}" value="${(item.number)!}" class="txtnum left" type="text"><a id="btnplus" class="goright" href="javascript:void(0)"></a></td>
				<td><a class="btndel" href="javascript:void(0)">删除</a></td>
			</tr>
			[/#list]
		</tbody>
		<tfoot><tr>
		<td colspan="2"><a class="linkdel" href="javascript:void(0)">删除选中的商品</a></td>
		<td colspan="4" class="txtrgt"><span class="red">${(list?size)!0}</span>件商品　　<span>总计(不含运费)：</span><span class="red em2">￥${money}</span></td>
		</tr></tfoot>
		</table>
		<div class="btnbox">
		<a class="gobuy" href="${base}/b2c">继续购物</a>
		<input class="checkout" type="button" value="确认无误，购买！" />
		</div>
	</form>
	[#else]
	<div class="emptybox">
		<div class="word">
			<h3>您的购物车还是空的，赶紧行动吧！您可以</h3>
			<p>我要&nbsp;<a href="${base}/b2c">马上购物</a></p>
			<p>如果您还未登陆，请&nbsp;<a href="${base}/login">马上登录</a></p>
		</div>
	</div>
	[/#if]
</div>
</div>
</body>
</html>