[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>家族教育</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/right.css" media="screen" />
<script type="text/javascript" src="${base}/ckeditor/ckeditor.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--

$(function(){
	$("#f_form").submit(validSubmitHandler);
	CKEDITOR.replace('txtcontent',{
        toolbar : 'MyToolbar',
        skin : 'v2',
        filebrowserImageUploadUrl : "${base}/ckeditor/img",
        filebrowserFlashUploadUrl : "${base}/ckeditor/flash"
    });
    $("#cke_bottom_txtcontent").addClass("hd");
    $("#btnreset").click(function(){gourl('${base}/admin/doedu')});
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

function addclickhandler() {
	$("#addbox").toggleClass("hd");
}

//-->
</script>
</head>
<body>
	<div class="mybody">
		[#if !isedit??]
		<h2 class="bg1">查询</h2>
	    <div class="bg2"">
	    <form id="f_search" action="${base}/admin/doedu/search" method="get">
	    <ul class="searchbox">
	    	<li><label>标 题</label><input name="title" value="${title!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>推荐到首页</label>
	    		全部<input name="istop" checked="checked" value="" type="radio" />&nbsp;
		    	是<input name="istop" [#if istop == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
		    	否<input name="istop" [#if istop == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	</li>
	    </ul>
	    <ul class="searchbox">
	    <li><label>类型</label>
	    	全部<input name="type" checked="checked" value="" type="radio" />&nbsp;
	    	名门家教<input name="type" [#if type == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	专家理念<input name="type" [#if type == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    	家族教育<input name="type" [#if type == 2]checked="checked"[/#if]  value="2" type="radio" />&nbsp;
	    	教育教材<input name="type" [#if type == 3]checked="checked"[/#if]  value="3" type="radio" />&nbsp;
	    </li>
	    </ul>
	    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
	    </form>
	    </div>
	    <br /><br />
	    [/#if]
	
		[#if isedit??]
		<form id="f_form" action="${base}/admin/doedu/${bean.id}" method="post">
		<input id="hdid" name="id" value="${(bean.id)!}" type="hidden" />
		<input id="hdid" name="viewsday" value="${(bean.viewsday)!}" type="hidden" />
		[#else]
		<form id="f_form" action="${base}/admin/doedu" method="post">
		[/#if]
		<input id="hdauthor" name="author" value="管理员" type="hidden" />
		<h2 class="bg1"><a href="" onclick="addclickhandler()">添加</a></h2>
		<div id="addbox" class="[#if !bean??]hd[/#if]">
		    <div class="bg1"><label>标题</label><input id="txttitle" class="long" name="title" value="${(bean.title)!}" type="text" /><span class="red">*</span></div>
		    <div class="bg2"><label>分类</label>
		    名门家教<input class="" name="type"[#if (bean.type)!0 == 0] checked="checked"[/#if] value="0" type="radio" />&nbsp;&nbsp;
		    专家理念<input class="" name="type"[#if (bean.type)! == 1] checked="checked"[/#if] value="1" type="radio" />
		    </div>
		    <div class="bg1"><label class="left">内容</label><div class="left" style="width:700px;"><textarea id="txtcontent" style="width:500px; height:25px;" name="content">${(bean.content)!}</textarea></div><span class="red">*</span></div>
		    <div class="bg2"><label>是否推荐到首页</label>
		    <input id="chkisrecommend" name="isrecommend" value="true" title="是否推荐到首页" [#if (bean.isrecommend)!] checked="checked"[/#if] type="checkbox" class="chk">
		    </div>
		    <div class="bg2">
		    <label></label><input name="" value="提交" class="btn2" type="submit" />
		    &nbsp;&nbsp;<input id="btnreset" name="" value="取消" class="btn1" type="button" />
		    </div>
		 </div>
	    </form>
	    
		<h2 class="bg1">列表</h2>
		[#list list as item]
		<div class="bg${item_index % 2 + 1}">
		<span class="w15">
		<label><a href="${base}/admin/doedu/${item.id}?do=del">删除</a></label>
		</span>
		<a href="${base}/admin/doedu/${item.id}?do=edit">编辑</a>
		&nbsp;&nbsp;&nbsp;
		[#if item.isrecommend]
		<a href="${base}/admin/doedu/${item.id}?do=recommend&is=false">取消首页</a>
		[#else]
		<a href="${base}/admin/doedu/${item.id}?do=recommend&is=true">设置首页</a>
		[/#if]
		&nbsp;&nbsp;&nbsp;
		<span class="red">标题:</span>[${item.typeName}]
		<a href="${base}/edu/${item.type}/${item.id}" target="_blank">${item.title}</a>
		</div>
		[/#list]
		[@p.Pager pager /]
	</div>
</body>
</html>