[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>会员列表管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
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
	return valid;
}

//-->
</script>
</head>
<body>
	<div class="mybody">
		[#if count??]
			 <ul class="searchbox">
		    	<li><label>总用户数</label>${count!0}</li>
		    	<li><label>&nbsp;</label></li>
		    	<li><label>总账户余额</label>${sum!0}元</li>
		     </ul>
			 <hr />
		[/#if]
		<h2 class="bg1">查询</h2>
	    <div class="bg2"">
	    <form id="f_form" action="${base}/admin/dousers/search" method="get">
	    <ul class="searchbox">
	    	<li><label>会员ID</label><input name="userid" value="${userid!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>姓名</label><input name="name" value="${name!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>Email</label><input name="email" value="${email!}" class="txtwidth150" value="" type="text" /></li>
	    	<li><label>手机</label><input name="mobile" value="${mobile!}" class="txtwidth150" value="" type="text" /></li>
	    </ul>
	    <ul class="searchbox">
	    <li><label>状态</label>
	    	全部<input name="status" checked="checked" value="" type="radio" />&nbsp;
	    	冻结<input name="status" [#if status == 0]checked="checked"[/#if]  value="0" type="radio" />&nbsp;
	    	正常<input name="status" [#if status == 1]checked="checked"[/#if]  value="1" type="radio" />&nbsp;
	    </li>
	    </ul>
	    <div class="bg2"><label></label><input name="" value="查询" class="btn2" type="submit" /></div>
	    </form>
	    </div>
	    <br /><br />
	    <h2 class="bg1">列表：</h2>
	    <br />
		<table class="list">
			<thead><tr>
			<th width="60px">会员ID</th>
			<th width="60px">姓名</th>
			<th width="60px">账户余额</th>
			<th width="60px">性别</th>
			<th width="100px">生日</th>
			<th width="100px">Email</th>
			<th width="100px">手机</th>
			<th width="100px">状态</th>
			<th width="100px">操作</th>
			</tr></thead>
			<tbody>
			[#list list as item]
				<tr>
					<td>${(item.userid)!}</td>
					<td>${(item.name)!}</td>
					<td>
					<form action="${base}/admin/dousers/${(item.uid)!}/updateaccount" method="post">
						<input type="text" class="txtwidth60" name="account" value="${(item.account)!0}" />
						<input class="btn2 btn mtop5" type="submit" value="修改">
					</form>
					</td>
					<td>${(item.genderName)!}</td>
					<td>${(item.birthday)!}</td>
					<td>${(item.email)!}</td>
					<td>${(item.mobile)!}</td>
					<td>
					[#if item.status == 1]
						<a href="${base}/admin/dousers/${(item.uid)!}/status/0">正常</a>
					[#else]
						<a href="${base}/admin/dousers/${(item.uid)!}/status/1">冻结</a>
					[/#if]
					</td>
					<td>
					<a href="${base}/admin/dousers/${(item.uid)!}/del">删除</a>
					</td>
				</tr>
			[/#list]
			</tbody>
		</table>
		[@p.Pager pager /]
	</div>
</body>
</html>