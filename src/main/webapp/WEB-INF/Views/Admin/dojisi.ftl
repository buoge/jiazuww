[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>缅怀管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/right.css" media="screen" />
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
	if($("#txthref").val().trim() == "") {
		if(valid) {
			$("#txthref").focus();
			valid = false;
		}
	}
	return valid;
}

function addclickhandler() {
	$("#f_addform").toggleClass("hd");
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
	
		[#if !editbean??]
		<form id="f_jisi" action="${base}/admin/dojisi" method="post" enctype="multipart/form-data">
		<h2 class="bg1">缅怀配置</h2>
		<div class="bg2"><label>缅怀默认ID</label><input id="txtuid" name="memberuid" value="${(bean.member.uid)!}" type="text" /><span class="red">(前台的缅怀页显示谁的缅怀）</span></div>
		<div class="bg1"><label>点香时间</label><input id="txtcenserDuration" name="censerDuration" value="${(bean.censerDuration)!100}" type="text" /><span class="red">(以分钟为单位）</span></div>
		<div class="bg2"><label>蜡烛时间</label><input id="txtcandleDucration" name="candleDucration" value="${(bean.candleDucration)!100}" type="text" /><span class="red">(以分钟为单位）</span></div>
		<div class="bg1"><label>缅怀音乐</label><input id="music" type="file" name="music"><span class="red">(留空则不改变音乐）</div>
		<div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
		</form>
		[/#if]
		
		[#if editbean??]
		<form id="f_editform" action="${base}/admin/dojisi/${editbean.id}" method="post" enctype="multipart/form-data">
		<input id="hduid" name="uid" value="${(editbean.uid)!}" type="hidden" />
		<input name="thumb" value="${(editbean.thumb)!}" type="hidden" />
		<input name="img" value="${(editbean.img)!}" type="hidden" />
		<input name="bigimg" value="${(editbean.bigimg)!}" type="hidden" />
		<input name="original" value="${(editbean.original)!}" type="hidden" />
		<input name="status" value="${(editbean.status)!}" type="hidden" />
		[#else]
		<h2 class="bg1"><a href="" onclick="addclickhandler()">添加祭品</a></h2>
		<form id="f_addform" class="hd" action="${base}/admin/dojisi/add" method="post" enctype="multipart/form-data">
		[/#if]
	    <div class="bg2"><label>名称</label><input id="txtname" name="name" value="${(editbean.name)!}" type="text" /><span class="red">*</span></div>
	    <div class="bg2"><label>价格</label><input id="txtprice" name="price" value="${(editbean.price)!1}" type="text" /><span class="red">*</span></div>
	    <div class="bg2"><label>排序值</label><input id="txtprice" name="sortorder" value="${(editbean.sortorder)!0}" type="text" /><span class="red">*</span></div>
	    <div class="bg2"><label>持续时间</label><input id="txtduration" name="duration" value="${(editbean.duration)!60}" type="text" /><span class="red">*(以分钟为单位）</span></div>
	    <div class="bg1"><label>是否免费</label>
	    <input id="chkisfree" name="free" value="true" title="是否免费" [#if (editbean.free)!] checked="checked"[/#if] type="checkbox" class="chk">
	    </div>
	    <div class="bg1"><label>图片(1:1)</label>
	    <input id="file" type="file" name="file"><span class="red">*</span>
	    [#if (editbean.thumb)??]
	    <img src="${baseimg}${(editbean.thumb)!}" />
	    [/#if]
	    </div>
	    <div class="bg2"><label></label><input name="" value="提交" class="btn2" type="submit" /></div>
	    </form>
	    
		<h2 class="bg1">祭品列表</h2>
		<table class="list">
			<thead><tr>
			<th width="60px">名称</th>
			<th width="60px">价格</th>
			<th width="60px">排序值</th>
			<th width="60px">持续时间</th>
			<th width="80px">是否免费</th>
			<th width="200px">图片</th>
			<th width="100px">操作</th></tr></thead>
			<tbody>
			[#list list as item]
				<tr>
					<td>${(item.name)!}</td>
					<td>${(item.price)!}</td>
					<td>${(item.sortorder)!}</td>
					<td>${(item.duration)!}</td>
					<td>[#if (item.free)!]免费[#else]不免费[/#if]</td>
					<td><img src="${baseimg}${(item.thumb)!}" /></td>
					<td>
					<a href="${base}/admin/dojisi/${(item.uid)!}" >编辑</a>&nbsp;&nbsp;
					<a href="${base}/admin/dojisi/${(item.uid)!}/del" onclick="return delConfirmHandler()" >删除</a>
					</td>
				</tr>
			[/#list]
			</tbody>
		</table>
	    
	    
	</div>
</body>
</html>