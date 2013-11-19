[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/mymember-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mymember.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		$("#btnSearch").click(function(){
			$("#hdaction").val("list");
		});
		$("#btnAdd").click(function(){
			$("#hdaction").val("add");
		});
		
		$("#msglink").click(function(){
			$("#msgblock").removeClass("hd");
		});
		$("#dellink").click(function(){
			var msg = "您确定要删除吗？删除不可恢复！";
			if (confirm(msg)==true){
				$("#hdaction2").val("del");
				$("#f_member2").submit();
			}
		});
		$("#adminlink").click(function(){
			$("#hdaction2").val("setadmin");
			$("#f_member2").submit();
		});
		$("#canceladminlink").click(function(){
			$("#hdaction2").val("canceladmin");
			$("#f_member2").submit();
		});
	});
	
	function sendMsgHandler() {
		if($("#txtmsg").val().trim() == "") {
			alert("请填写您要发布的信息！");
			$("#txtmsg").focus();
			return false;
		} else {
			$("#hdaction2").val("sendmsg");
			$("#f_member2").submit();
		}
	}
//-->
</script>
</head>
<body>
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	<h2>查找并添加会员：</h2>
	<form id="f_member" action="${base}/myhome/${currUid}/member" method="post">
	<input id="hdaction" name="action" value="" type="hidden" />
	<div><span>查找：</span><input id="txtname" name="name" value="${name!}" class="long" type="text" />&nbsp;<span class="red">*</span>&nbsp;<span id="err_txtname" class="red hd">请输入您要查找的用户姓名或者用户ID</span></div>
	<div class="memberbtmbar">
	<input id="btnSearch" class="btn2" type="submit" onclick="return txtnameValidHandler()" value="查找"/>
	<input id="btnAdd" class="btn3" type="submit" onclick="return chkboxValidHandler()" value="添加"/>
	</div>
	[#if resultList??]
		[#if resultList?size > 0]
		<div>
			[@p.userHeadsList resultList /]
		</div>
		[#else]
		<br />
		<div class="red">没有查找到相关会员！</div>
		[/#if]
	[/#if]
	</form>
</div>
<br /><br />
<div class="block">
	<h2>家族成员：</h2>
	<form id="f_member2" action="${base}/myhome/${currUid}/member" method="post">
	<input id="hdaction2" name="action" value="" type="hidden" />
	<input id="hdtitle" name="title" value="${(me.name)!((me.userid)!"none")!}发来的信息" type="hidden" />
	<table id="mymembers">
		<thead>
			<tr>
			<th colspan="2">
				<div id="msgblock" class="hd">
					<span class="txttop">信息：</span><textarea id="txtmsg" name="msg"></textarea>
					<input class="btn2" type="button" onclick="sendMsgHandler()" value="发送"/>
					</div>
					<div id="dolink">
					<a id="msglink" href="javascript:void(0)">发信息</a>
					[#if admintype > 0]
					<a id="dellink" href="javascript:void(0)">删除</a>
					<a id="adminlink" href="javascript:void(0)">设为管理员</a>
					<a id="canceladminlink" href="javascript:void(0)">取消管理员</a>
					[/#if]
				</div>
			</th>
			</tr>
		</thead>
		<tr>
			<td class="columnname">管 理 员：</td>
			<td style="width:700px">
				[@p.userHeadsList adminList /]
			</td>
		</tr>
		<tr>
			<td class="columnname">家族成员：</td>
			<td>
				[@p.userHeadsList userList /]
			</td>
		</tr>
	</table>
				[@p.Pager pager /]
	</form>
</div>
</body>
</html>