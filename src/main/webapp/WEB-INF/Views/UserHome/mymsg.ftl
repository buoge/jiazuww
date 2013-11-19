[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mymsg.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
	});
	
	function replyHandler(obj) {
		$(obj).parent("div").next(".sendblock").toggleClass("hd");
	}
	
	function sendHandler(obj) {
		if($(obj).parent("form").children("textarea").val().trim() == '') {
			alert("内容不能为空");
			$(obj).parent("form").children("textarea").focus();
			return false;
		} else {
			$(obj).parent("form")[0].submit();
		}
	}
	
//-->
</script>
</head>
<body>
<div class="block">
	<h2>我的留言列表：</h2>
	<table class="msgblock">
	[#list list as item]
		<tr><td>
			<div class="head1">
				<img src="${baseimg}${(item.user.avatar)!""}" alt="${(item.user.name)!""}" title="${(item.user.name)!""}">
				<div class="tagbg"></div>
				<div class="tag">${(item.user.name)!""}</div>
			</div>
			<div class="msg"  style="display:table">
				${(item.msg)!""}
			</div>
			<div class="doaction" style="width:60px;">
				<a href="" onclick="replyHandler(this)">回复</a>
				<a href="${base}/myhome/msg/${(item.uid)!}/del">删除</a>
			</div>
			<div class="sendblock hd">
				<form id="f_msg" action="${base}/myhome/msg/${(item.useruidfrom)!}" method="post">
				<span class="txttop">回复：</span>
				<textarea id="txtmsg" style="height:23px; width:500px;" name="msg"></textarea>
				<input class="btn2" type="button" onclick="sendHandler(this)" value="发送"/>
				</form>
			</div>
			</td>
		</tr>
	[/#list]
	[@p.Pager pager /]
	</table>
</div>
</body>
</html>