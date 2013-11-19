[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myorder" /]</title>
<meta name="Keywords" content="[@s.message "myorder.keyword" /]" />
<meta name="Description" content="[@s.message "myorder.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myorder.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/pages/order-1.0.1.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
window.baseimg = "${baseimg}";
$(function(){
	computeTextBoxWordsCount("#txtmemo", "#count200");
	$("a[id='btnminus']").click(btnminusClickHandler);
	$("a[id='btnplus']").click(btnplusClickHandler);
	$("#slprovince").change(changeSelectHandler);
	$("#slcity").change(changeSelectHandler);
});

function btnminusClickHandler(){
	var i = $(this).next("#txtnum").val();
	if(i-- > 1) {
		$(this).next("#txtnum").val(i)
	}
}

function btnplusClickHandler(){
	var i = $(this).prev("#txtnum").val();
	if($.isNumeric(i)) {
		i++;
	} else {
		i = 1;
	}
	$(this).prev("#txtnum").val(i)
}

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
	<h2><span class="first"><div class="bg"></div>1.我的购物车</span><span class="second here">2.填写订单信息</span><span class="third">3.核对提交订单</span></h2>
	<h1>填写订单信息</h1>
		<div class="box">
			<h3>收货人信息</h3>
			<dl class="dlbox">
				<dt>常用收货人信息<a class="right mrgt10 noline" href="" onclick="addAddressHandler()">添加</a></dt>
				[#list addressList as item]
				<dd><input name="address" value="${(item.uid)!}" id="rd${(item.uid)!}" [#if item_index == 0] checked="checked" [/#if] type="radio"  /><label for="rd${(item.uid)!}">${(item)!}</label>
				<a class="right mrgt10 noline" href="" onclick="deleteAddressHandler('${(item.uid)!}')">删除</a> <a class="right mrgt10 noline" href="" onclick="modifyAddressHandler('${(item.uid)!}')">修改</a></dd>
				[/#list]
			</dl>
			<dl id="f_address" class="dlform [#if addressList?size > 0] hd [/#if]">
				<dt><span class="red">*</span>收货人姓名：</dt>
				<dd><input id="txtconsignee" name="consignee" type="text" /> <span id="errconsignee" class="mlft10 red hd">请填写收货人姓名</span></dd>
				<dt><span class="red">*</span>省　　份：</dt>
				<dd>
					<select id="slprovince" name="province">
					<option value="0">请选择省份</option>
					[#list provinceList as item]
					<option value="${item.id}">${item.name}</option>
					[/#list]
					</select>
					<select id="slcity" name="city">
					<option value="0">请选择市</option>
					</select>
					<select id="sldistrict" name="district">
					<option value="0">请选择区</option>
					</select>
					<span id="errprovince" class="mlft10 red hd">请选择省</span>
					<span id="errcity" class="mlft10 red hd">请选择市</span>
					<span id="errdistrict" class="mlft10 red hd">请选择区</span>
				</dd>
				<dt><span class="red">*</span>乡镇街道：</dt>
				<dd><input id="txtaddress" name="address" class="long" type="text" /><span id="erraddress" class="mlft10 red hd">请填写乡镇街道的详细地址，以便送货</span></dd>
				<dt><span class="red">*</span>手机号码：</dt>
				<dd><input id="txttel" name="tel" type="text" />
				<span id="errtel" class="mlft10 red hd">请填写收货人的手机号</span>
				</dd>
				<dt><span class="red">*</span>邮政编码：</dt>
				<dd><input id="txtzipcode" name="zipcode" type="text" />
				<span id="errzipcode" class="mlft10 red hd">请填写邮政编码</span>
				</dd>
				<dt>E-mail：</dt>
				<dd><input id="txtemail" name="email" type="text" /></dd>
				<dt><input id="hdaction" name="" value="add" type="hidden" /></dt>
				<dd>
				<input id="btnaddress" onclick="saveAddressHandler()" type="button" class="btnsave" value="保存"  />&nbsp;&nbsp;&nbsp;
				<input id="btncancel" onclick="cancelAddressHandler()" type="button" class="btnsave" value="取消"  />
				</dd>
			</dl>
		</div>
		<div class="box">
			<h3>配送及支付方式</h3>
			<dl class="dlform">
				<dt><span class="red">*</span>配送方式：</dt>
				<dd>快递(<span class="red">${fee!0}元</span>)，偏远偏重商品按实际发货时的运费计算</dd>
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
				<td>${(item.number)!} <input id="txtnum" name="num${(item.uid)!}" value="${(item.number)!}" class="txtnum left" type="hidden"></td>
			</tr>
			[/#list]
			</table>
		</div>
		<div class="box">
			<h3>订单备注</h3>
			<textarea id="txtmemo" maxlength="200" style="width:500px; height:30px;" name="memo"></textarea><span class="red">(选填,最多还可输入<span id="count200">200</span>字)</span>
		</div>
		<div class="infor">
			<p>商品金额：${money}元</p>
			<p>+运费：${fee!0}元</p>
			<p>=应付总额：<span class="red">￥${(money + fee)!} 元</span></p>
			<br />
			<input class="btnfat" type="submit" onclick="$(this).addClass('hd')" value="提交订单" />
		</div>
	<br class="clear" />
	</div>
</form>
</div>
</body>
</html>