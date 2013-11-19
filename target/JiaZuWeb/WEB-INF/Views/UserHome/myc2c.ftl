[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myc2c-1.0.0.js"></script>
<script type="text/javascript" src="${base}/ckeditor/ckeditor.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function() {
		$(".edulist li").mouseover(function() {
			$(this).addClass("hover");
		});
		$(".edulist li").mouseout(function() {
			$(this).removeClass("hover");
		});
		CKEDITOR.replace('txtcontent',{
	        toolbar : 'MyToolbarForUser',
	        skin : 'v2',
	        filebrowserImageUploadUrl : "${base}/ckeditor/img",
	        filebrowserFlashUploadUrl : "${base}/ckeditor/flash"
	    });
	    $("#cke_bottom_txtcontent").addClass("hd");
		//var editor_data = CKEDITOR.instances.txtcontent.getData();
		//alert(editor_data);
		/*
		$("#publish").click(function(){
			if($("#f_edu").attr("class").indexOf("hd") > -1) {
				$(this).text("取消发布>>");
				$("#f_edu").removeClass("hd");
			} else {
				$(this).text("我要发布>>");
				$("#f_edu").addClass("hd");
			}
		});*/
	});
	
	function delConfirmHandler() {
		var msg = "您确定要删除吗？删除不可恢复！";
		if (confirm(msg)==true){
			return true;
		}else{
			return false; 
		}
		return false;
	}
	
	function disableConfirmHandler() {
		var msg = "您确定要结束吗？结束不可恢复！";
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
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	[#if editbean??]
	<h2>请编辑！</h2>
	<form id="f_c2c" action="${base}/myhome/c2c/${editbean.uid}/edit" method="post" enctype="multipart/form-data">
	<input name="littlethumb" value="${(editbean.littlethumb)!}" type="hidden" />
	<input name="thumb" value="${(editbean.thumb)!}" type="hidden" />
	<input name="bigthumb" value="${(editbean.bigthumb)!}" type="hidden" />
	<input name="img" value="${(editbean.img)!}" type="hidden" />
	<input name="originalimg" value="${(editbean.originalimg)!}" type="hidden" />
	[#else]
	<h2>我要发布供求信息：</h2>
	<form id="f_c2c" action="${base}/myhome/c2c" method="post" enctype="multipart/form-data">
	[/#if]
	<div><span>标题：</span><input id="txttitle" name="name" value="${(editbean.name)!}" class="long" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txttitle" class="red hd">请输入不多于30字的标题</span></div>
	<div><span>类型：</span><input id="txtsell" name="type" [#if (editbean.type)! == 0] checked="checked" [/#if] value="0" type="radio" />转让&nbsp;<input id="txtbuy" name="type" [#if (editbean.type)! == 1] checked="checked" [/#if] value="1" type="radio" />求购&nbsp;<span class="red">*</span>&nbsp;<span id="err_type" class="red hd">请选择供求类型</span></div>
	<div><span>地址：</span><input id="txtaddress" name="address" value="${(editbean.address)!}" class="long" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txtaddress" class="red hd">请输入不多于30字的详细地址</span></div>
	<div class="table rltv">
		<span class="txttop left">内容：</span>
		<div class="left" style="width:700px;">
		<textarea id="txtcontent" name="desc">${(editbean.desc)!}</textarea>
		</div>
		<span class="red txtbtm">&nbsp;*</span>
	</div>
	<div id="err_txtcontent" class="txtrgt mrgt60 hd"><span class="red">请输入内容</span></div>
	<div><span>照&nbsp;&nbsp;&nbsp;片：</span><input id="file" type="file" name="file">
	[#if editbean?? && editbean.littlethumb != ""]
		<br />
		<img src="${baseimg}${editbean.littlethumb}" />
	[/#if]
	</div>
	<div><span>联系人：</span><input id="txtcontactname" name="contactname" value="${(editbean.contactname)!}" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txtcontactname" class="red hd">请输入不多于6字的联系人</span></div>
	<div><span>电&nbsp;&nbsp;&nbsp;话：</span><input id="txttelephone" name="telephone" value="${(editbean.telephone)!}" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txttelephone" class="red hd">请正确输入联系电话</span></div>
	<div><span>价&nbsp;&nbsp;&nbsp;格：</span><input id="txtprice" class="txtwidth60" name="price" value="${(editbean.price)!}" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txtprice" class="red hd">请输入价格</span></div>
	<div class="edubtmbar">
	<input class="btnorange mlft150" type="submit" value="立即发布"/>
	</div>
	</form>
</div>
<br /><br />
<div class="block">
	<h2>已发布供求列表：</h2>
	<div class="content">
		<ul class="edulist">
			[#list c2cList as item]
			<li><a href="${base}/c2c/${item.uid}" target="_blank"><h3>${item.name}</h3><span>${item.date}</span></a>
			<span id="action"><a href="${base}/c2c/${item.uid}" target="_blank">[查看]</a>
			<a href="${base}/myhome/c2c/${item.uid}/edit">[编辑]</a>
			<a href="${base}/myhome/c2c/${item.uid}/disable" onclick="return disableConfirmHandler()">[结束]</a>
			<a href="${base}/myhome/c2c/${item.uid}/del" onclick="return delConfirmHandler()">[删除]</a>
			</span></li>
			[/#list]
		</ul>
	</div>
	<h2>已结束供求列表：</h2>
	<div class="content">
		<ul class="edulist">
			[#list c2cDisableList as item]
			<li><a href="${base}/c2c/${item.uid}" target="_blank"><h3>${item.name}</h3><span>${item.date}</span></a>
			<span id="action"><a href="${base}/c2c/${item.uid}" target="_blank">[查看]</a>
			</span></li>
			[/#list]
		</ul>
	</div>
</div>
</body>
</html>