[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>互通有无管理</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myc2c-1.0.0.js"></script>
<script type="text/javascript" src="${base}/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myhome.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">
.block {margin-left:30px;}
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
	
function addclickhandler() {
	$("#f_c2c").removeClass("hd");
}
//-->
</script>
</head>
<body>
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	
	
	[#if !editbean??]
	<h2 class="bg1">查询</h2>
    <div class="bg2"">
    <form id="f_search" action="${base}/admin/doc2c/search" method="get">
    <ul class="searchbox">
    	<li><label>标题</label><input name="name" value="${name!}" class="txtwidth150" value="" type="text" /></li>
    	<li><label>联系人</label><input name="contactname" value="${contactname!}" class="txtwidth150" value="" type="text" /></li>
    </ul>
    <ul class="searchbox">
    	<li><label>置顶</label>
    		全部<input name="istop" checked="checked" value="" type="radio" />&nbsp;
	    	是<input name="istop" [#if istop == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    	否<input name="istop" [#if istop == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
    	</li>
    	<li><label>状态</label>
    		全部<input name="status" checked="checked" value="" type="radio" />&nbsp;
	    	进行中<input name="status" [#if status == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    	结束<input name="status" [#if status == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
    	</li>
    </ul>
    <ul class="searchbox">
    <li><label>分类</label>
    	全部<input name="type" checked="checked" value="" type="radio" />&nbsp;
    	出售<input name="type" [#if type == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
    	求购<input name="type" [#if type == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
    	公益<input name="type" [#if type == 2]checked="checked"[/#if]  value="2" type="radio" />&nbsp;
    </li>
    </ul>
    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
    </form>
    </div>
    <br /><br />
    [/#if]
	
	
	[#if editbean??]
	<h2>请编辑！</h2>
	<form id="f_c2c" action="${base}/admin/doc2c/${editbean.uid}/edit" method="post" enctype="multipart/form-data">
	<input name="littlethumb" value="${(editbean.littlethumb)!}" type="hidden" />
	<input name="thumb" value="${(editbean.thumb)!}" type="hidden" />
	<input name="bigthumb" value="${(editbean.bigthumb)!}" type="hidden" />
	<input name="img" value="${(editbean.img)!}" type="hidden" />
	<input name="originalimg" value="${(editbean.originalimg)!}" type="hidden" />
	[#else]
	<h2><a href="" onclick="addclickhandler()">我要发布公益信息：</a></h2>
	<form id="f_c2c" class="hd" action="${base}/admin/doc2c" method="post" enctype="multipart/form-data">
	[/#if]
	<div><span>标题：</span><input id="txttitle" name="name" value="${(editbean.name)!}" class="long" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txttitle" class="red hd">请输入不多于30字的标题</span></div>
	<div><span>类型：</span>
	<input id="txtcharity" name="type" checked="checked" value="2" type="radio" />公益&nbsp;
	<span class="red">*</span>&nbsp;<span id="err_type" class="red hd">请选择供求类型</span></div>
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
	<h2>围观区列表：</h2>
	<div class="content">
		<ul class="edulist">
			[#list c2cTopList as item]
			<li>
			[#if item.status == 1]
			[进行中]
			[#elseif item.status == 0]
			[结束]
			[/#if]
			[${item.typeName}]<a href="${base}/c2c/${item.uid}" target="_blank"><h3>${item.name}</h3><span>${item.date}</span></a>
			<span id="action">
			<a href="${base}/c2c/${item.uid}" target="_blank">[查看]</a>
			<a href="${base}/admin/doc2c/${item.uid}/topcancel">[取消置顶]</a>
			[#if item.type == 2]
			<a href="${base}/admin/doc2c/${item.uid}/edit">[编辑]</a>
			[/#if]
			[#if item.status == 1]
			<a href="${base}/admin/doc2c/${item.uid}/disable">[结束]</a>
			[#elseif item.status == 0]
			<a href="${base}/admin/doc2c/${item.uid}/enable">[取消结束]</a>
			[/#if]
			<a href="${base}/admin/doc2c/${item.uid}/del" onclick="return delConfirmHandler()">[删除]</a>
			</span></li>
			[/#list]
		</ul>
	<h2>已发布供求列表：</h2>
	<div class="content">
		<ul class="edulist">
			[#list c2cList as item]
			<li>
			[#if item.status == 1]
			[进行中]
			[#elseif item.status == 0]
			[结束]
			[/#if]
			[${item.typeName}]<a href="${base}/c2c/${item.uid}" target="_blank"><h3>${item.name}</h3><span>${item.date}</span></a>
			<span id="action">
			<a href="${base}/c2c/${item.uid}" target="_blank">[查看]</a>
			<a href="${base}/admin/doc2c/${item.uid}/top">[置顶]</a>
			[#if item.type == 2]
			<a href="${base}/admin/doc2c/${item.uid}/edit">[编辑]</a>
			[/#if]
			[#if item.status == 1]
			<a href="${base}/admin/doc2c/${item.uid}/disable">[结束]</a>
			[#elseif item.status == 0]
			<a href="${base}/admin/doc2c/${item.uid}/enable">[取消结束]</a>
			[/#if]
			<a href="${base}/admin/doc2c/${item.uid}/del" onclick="return delConfirmHandler()">[删除]</a>
			</span></li>
			[/#list]
		</ul>
			[@p.Pager pager /]
	</div>
</div>
</body>
</html>