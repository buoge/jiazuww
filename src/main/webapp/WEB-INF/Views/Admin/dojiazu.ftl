[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>家族列表管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<style type="text/css" media="screen" title="Jiazuww style">
.verticallist {clear: both; display: table; margin-top:6px; width:850px;}
.verticallist dl { margin: 9px auto auto auto; float: right; width: 700px;}
.verticallist dl dt { font-size: 1.2em; font-weight: bold;}
.verticallist dl dt a { font-size: 12px; font-weight: normal;}
.verticallist dl dd {}
.verticallist dl dd.content {min-height: 80px;}
.verticallist dl dd.btmbar {text-align: right;}
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
	    <form id="f_form" action="${base}/admin/dojiazu/search" method="get">
	    <ul class="searchbox">
	    	<li><label>家族名</label><input name="name" value="${name!}" class="txtwidth150" value="" type="text" /></li>
	    </ul>
	    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
	    </form>
	    </div>
	    <br /><br />
		<h2 class="bg1">列表</h2>
		[#list list as item]
		<div class="verticallist">
			<form action="${base}/admin/dojiazu" method="post">
				<input id="hduid" name="uid" value="${item.uid}" type="hidden">
				<img class="jiazuhead" src="${baseimg}${(item.logo)!"/imgs/default/noimg130_130.gif"}" alt="" title="">
				<dl>
				<dt>${(item.name)!} &nbsp;&nbsp;&nbsp;&nbsp;家庭成员数：${item.memberCount}&nbsp;&nbsp;&nbsp;&nbsp;总金额：${item.totalMoney}</dt>
				<dd class="content">${(item.brief)!}</dd>
				<dd class="btmbar">
				<a href="${base}/html/${(item.uid)!}/zupu" target="_blank" onclick="">[查看族谱]</a>
				[#if item.status == 0]
				<a href="${base}/admin/dojiazu/${(item.uid)!}/active" onclick="">[恢复]</a>
				[#else]
				<a href="${base}/admin/dojiazu/${(item.uid)!}/disable" onclick="return deleteConfirmHandler()">[删除]</a>
				[/#if]
				<a class="hd" href="${base}/admin/dojiazu/${(item.uid)!}/del" onclick="return deleteConfirmHandler()">[删除]</a>
				</dd>
				</dl>
			</form>
		</div>
		[/#list]
		[@p.Pager pager /]
	</div>
</body>
</html>