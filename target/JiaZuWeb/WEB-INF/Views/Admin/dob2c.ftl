[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>文化产品管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/imgblocks.css" media="screen" />
<script type="text/javascript" src="${base}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${basejs}/js/admin/ajaximgblocks-1.0.0.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
	CKEDITOR.replace('txtdesc',{
        toolbar : 'MyToolbar',
        skin : 'v2',
        filebrowserImageUploadUrl : "${base}/ckeditor/img",
        filebrowserFlashUploadUrl : "${base}/ckeditor/flash"
    });
    $("#cke_bottom_txtcontent").addClass("hd");
    $("#btnreset").click(function(){
		$("#addbox").addClass("hd");
	});
});

function validSubmitHandler() {
	var valid = true;
	if($("#txtname").val().trim() == "") {
		if(valid) {
			$("#txtname").focus();
			valid = false;
		}
	}
	return valid;
}

function addclickhandler() {
	$("#addbox").toggleClass("hd");
}

function picaddHandler() {
	var html = '<input type="file" name="file" />';
	$("#pics").append(html);
}

//-->
</script>
</head>
<body>
	<div class="mybody">
		
		[#if !bean??]
		<h2 class="bg1">查询</h2>
	    <div class="bg2"">
	    <form id="f_search" action="${base}/admin/dob2c/search" method="get">
	    <ul class="searchbox">
	    	<li><label>名称</label><input name="name" value="${name!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>商品编号</label><input name="sn" value="${sn!}" class="txtwidth150" value="" type="text" /></li>
	    </ul>
	    <ul class="searchbox">
	    	<li><label>置顶</label>
	    		全部<input name="istop" checked="checked" value="" type="radio" />&nbsp;
		    	是<input name="istop" [#if istop == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
		    	否<input name="istop" [#if istop == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	</li>
	    	<li><label>推荐到首页</label>
	    		全部<input name="isbest" checked="checked" value="" type="radio" />&nbsp;
		    	是<input name="isbest" [#if isbest == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
		    	否<input name="isbest" [#if isbest == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	</li>
	    </ul>
	    <ul class="searchbox">
	    <li><label>分类</label>
	    	全部<input name="type" checked="checked" value="" type="radio" />&nbsp;
	    	书籍<input name="type" [#if type == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	文化产品<input name="type" [#if type == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    	教具<input name="type" [#if type == 2]checked="checked"[/#if]  value="2" type="radio" />&nbsp;
	    	软件<input name="type" [#if type == 3]checked="checked"[/#if]  value="3" type="radio" />&nbsp;
	    	金币<input name="type" [#if type == 4]checked="checked"[/#if]  value="4" type="radio" />&nbsp;
	    </li>
	    </ul>
	    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
	    </form>
	    </div>
	    <br /><br />
	    [/#if]
		
		[#if bean??]
		<form id="f_form" action="${base}/admin/dob2c/${bean.id}" method="post" enctype="multipart/form-data">
		<input name="uid" value="${(bean.uid)!}" type="hidden" />
		<input name="catuid" value="${(bean.catuid)!}" type="hidden" />
		<input name="sn" value="${(bean.sn)!}" type="hidden" />
		<input name="littlethumb" value="${(bean.littlethumb)!}" type="hidden" />
		<input name="thumb" value="${(bean.thumb)!}" type="hidden" />
		<input name="createTime" value="${(bean.createTime.toString("yyyy-MM-dd HH:mm:ss"))!}" type="hidden" />
		[#else]
		<form id="f_form" action="${base}/admin/dob2c" method="post" enctype="multipart/form-data">
		[/#if]
		<input id="hdauthor" name="author" value="管理员" type="hidden" />
		<h2 class="bg1"><a href="" onclick="addclickhandler()">添加</a></h2>
		<div id="addbox" class="[#if !bean??]hd[/#if]">
		    <div class="bg1"><label>名称</label><input id="txtname" class="long" name="name" value="${(bean.name)!}" type="text" /><span class="red">*</span></div>
		    <div class="bg2"><label>分类</label>
		    书籍<input class="" name="type"[#if (bean.type)!0 == 0] checked="checked"[/#if] value="0" type="radio" />&nbsp;&nbsp;
		    文化产品<input class="" name="type"[#if (bean.type)! == 1] checked="checked"[/#if] value="1" type="radio" />&nbsp;&nbsp;
		    教具<input class="" name="type"[#if (bean.type)! == 2] checked="checked"[/#if] value="2" type="radio" />&nbsp;&nbsp;
		    软件<input class="" name="type"[#if (bean.type)! == 3] checked="checked"[/#if] value="3" type="radio" />&nbsp;&nbsp;
		    金币<input class="" name="type"[#if (bean.type)! == 4] checked="checked"[/#if] value="4" type="radio" />&nbsp;&nbsp;
		    </div>
		    <div class="bg1"><label>数量</label><input class="short" name="number" value="${(bean.number)!0}" type="text" /><span class="red">*</span></div>
		    <div class="bg2"><label>重量</label><input class="short" name="weight" value="${(bean.weight)!0}" type="text" /><span class="red">*</span></div>
		    <div class="bg1"><label>市场价</label><input class="short" name="marketprice" value="${(bean.marketprice)!0}" type="text" /><span class="red">*</span></div>
		    <div class="bg2"><label>折扣价</label><input class="short" name="shopprice" value="${(bean.shopprice)!0}" type="text" /><span class="red">*</span></div>
		    <div class="bg1"><label>邮费(统一15元)</label>15 <input class="short" name="shippingfee" readonly="readonly" value="15" type="hidden" /><span class="red hd">*</span></div>
		    <div class="bg2"><label>关键词</label><input class="" name="keywords" value="${(bean.keywords)!}" type="text" /></div>
		    <div class="bg1"><label>推荐语</label><input class="" name="brief" value="${(bean.brief)!}" type="text" /><span class="red">*(书籍必填)</span></div>
		    <div class="bg2"><label class="left">详细描述</label>
		    <div class="left" style="width:700px;">
		    <textarea id="txtdesc" style="width:500px; height:25px;" name="desc">${(bean.desc)!}</textarea>
		    </div><span class="red">*</span></div>
		    <div class="bg1"><label>排序值</label><input class="short" name="sortorder" value="${(bean.sortorder)!0}" type="text" /></div>
		    <div class="bg2"><label>是否上架</label>
		    <input id="chkisonsale" name="isonsale" value="true" title="是否上架" [#if !bean?? || (bean.onsale)!] checked="checked"[/#if] type="checkbox" class="chk">
		    </div>
		    <div class="bg1"><label>是否新品</label>
		    <input id="chkisnew" name="isnew" value="true" title="是否上架" [#if !bean?? || (bean.new)!] checked="checked"[/#if] type="checkbox" class="chk">
		    </div>
		    <div class="bg2"><label>是否置顶</label>
		    <input id="chkistop" name="istop" value="true" title="是否置顶" [#if !bean?? || (bean.top)!] checked="checked"[/#if] type="checkbox" class="chk">
		    </div>
		    <div class="bg1"><label>是否热销</label>
		    <input id="chkishot" name="ishot" value="true" title="是否热销" [#if !bean?? || (bean.hot)!] checked="checked"[/#if] type="checkbox" class="chk">
		    (教育教材是否显示)
		    </div>
		    <div class="bg2"><label>是否推荐到首页</label>
		    <input id="chkisbest" name="isbest" value="true" title="是否推荐到首页" [#if (bean.best)!] checked="checked"[/#if] type="checkbox" class="chk">
		    </div>
		    <div class="bg1"><label>首页显示方式</label>
		    不显示<input id="rdshowtypenone" name="showtype" value="-1" title="不显示" checked="checked" type="radio" class="chk">&nbsp;&nbsp;
		    文字链接显示<input id="rdshowtypetxt" name="showtype" value="0" title="文本" [#if (bean.showtype)! == 0] checked="checked"[/#if] type="radio" class="chk">&nbsp;&nbsp;
		    图片显示<input id="rdshowtypeimg" name="showtype" value="1" title="文本" [#if (bean.showtype)! == 1] checked="checked"[/#if] type="radio" class="chk">&nbsp;&nbsp;
		    <span class="red">（若图片显示,请确保首张图片长宽1:1）</span>
		    </div>
		    <div class="bg2"><label>评分</label><input id="txtrate" class="short" name="rate" value="${(bean.rate)!0}" type="text" /></div>
		    <div class="bg1"><label>已售出</label><input id="txtsellcount" class="short" name="sellcount" value="${(bean.sellcount)!0}" type="text" /></div>
		    <div class="bg2"><label>买家数量</label><input id="txtbuyercount" class="short" name="buyercount" value="${(bean.buyercount)!0}" type="text" /></div>
		    <div class="bg1"><label>点击量</label><input id="txtclickcount" class="short" name="clickcount" value="${(bean.clickcount)!0}" type="text" /></div>
		    <div class="bg2 table" style="width:100%;"><label>添加图片</label><a href="" onclick="picaddHandler()">添加更多</a>
		    	[#if bean?? && bean.galleries?? && (bean.galleries)?size > 0]
		    	<ul class="imgsblock">
		    		[#list bean.galleries as item]
					<li>
						<a href="${baseimg}${item.bigimg}" title="${item.title}" target="_blank"><img src="${baseimg}${item.img}" style="width:150px; height:120px;"><label> </label></a>
						<span>
						<a href="" onclick="updateHandler(this,'${base}/admin/gallery/${item.uid}/default')">设为默认</a>
						<a href="" title="注意：直接删除，不可恢复！" onclick="delHandler(this,'${base}/admin/gallery/${item.uid}/del')">删除</a></span>
					</li>
					[/#list]
				</ul>
				[/#if]
			    <div id="pics" class="mlft150 table clear">
			    	<input type="file" name="file" />
			    	<input type="file" name="file" />
			    	<input type="file" name="file" />
			    </div>
		    </div>
		    <div class="bg1">
		    <label></label><input name="" value="提交" class="btn2" type="submit" />
		    &nbsp;&nbsp;<input id="btnreset" name="" value="取消" class="btn1" type="button" />
		    </div>
	    </div>
	    </form>
	    
	    <div class="bg1"><label></label></div>
	    
		<h2 class="bg1">列表</h2>
		[#list list as item]
		<div class="bg${item_index % 2 + 1}">
		<span class="w15">
		<label><a href="${base}/admin/dob2c/${item.uid}?do=del" onclick="return deleteConfirmHandler();">删除</a></label>
		</span>
		<a href="${base}/admin/dob2c/${item.uid}?do=edit">编辑</a>
		&nbsp;&nbsp;&nbsp;
		<span class="red">商品名:</span>[${item.typeName}] <a href="${base}/b2c/${item.uid}" target="_blank"> ${item.name}</a></div>
		[/#list]
		[@p.Pager pager /]
	</div>
</body>
</html>