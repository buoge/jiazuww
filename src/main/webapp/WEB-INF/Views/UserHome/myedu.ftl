[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myedu-1.0.0.js"></script>
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
//-->
</script>
</head>
<body>
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	[#if editbean??]
	<h2>请编辑！</h2>
	<form id="f_edu" action="${base}/myhome/${currUid}/edu/${editbean.id}/edit" method="post">
	<input name="id" value="${(editbean.id)!}" type="hidden" />
	[#else]
	<h2>我要发布：</h2>
	<form id="f_edu" action="${base}/myhome/${currUid}/edu" method="post">
	[/#if]
	<input name="author" value="${(me.name)!((me.userid)!"none")}" type="hidden" />
	<div><span>标题：</span><input id="txttitle" name="title" value="${(editbean.title)!}" maxlength="30" class="long" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txttitle" class="red hd">请输入不多于30字的标题</span></div>
	<div class="table rltv">
		<span class="txttop left">内容：</span>
		<div class="left" style="width:700px;">
		<textarea id="txtcontent" name="content">${(editbean.content)!}</textarea>
		</div>
		<span class="red txtbtm">&nbsp;*</span>
	</div>
	<div id="err_txtcontent" class="txtrgt mrgt60 hd"><span class="red">请输入内容</span></div>
	<div class="edubtmbar">
	<label for="chkshare">分享到网站&nbsp;</label><input id="chkshare" name="ispublic" value="1" title="家族成员之外的会员是否可见" [#if ((editbean.ispublic)!true)] checked="checked" [/#if] type="checkbox" />
	<input class="btn2 right" type="submit" value="保存"/>
	</div>
	</form>
</div>
<br /><br />
<div class="block">
	<h2>家族教育：</h2>
	<div class="content">
		<ul class="edulist">
			[#list homeList as item]
			<li><a href="${base}/edu/2/${item.id}" target="_blank"><h3>${item.title}</h3><span>作者：${item.author}</span></a>
			<span id="action"><a href="${base}/edu/2/${item.id}" target="_blank">[查看]</a>
			[#if me.uid == item.useruid]
			<a href="${base}/myhome/${currUid}/edu/${item.id}/edit">[编辑]</a>
			<a href="${base}/myhome/${currUid}/edu/${item.id}/del" onclick="return delConfirmHandler()">[删除]</a>
			[/#if]
			</span></li>
			[/#list]
		</ul>
		[@p.Pager pager /]
	</div>
</div>
</body>
</html>