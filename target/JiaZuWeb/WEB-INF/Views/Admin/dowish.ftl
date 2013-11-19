[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>祝福墙管理</title>
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
	    <br /><br />
	    <h2 class="bg1">列表：</h2>
	    <br />
		<table class="list">
			<thead><tr>
			<th width="60px">家族名</th>
			<th width="60px">姓名</th>
			<th width="200px">祝福语</th>
			<th width="100px">日期</th>
			<th width="100px">操作</th></tr></thead>
			<tbody>
			[#list list as item]
				<tr>
					<td>${(item.groupname)!}</td>
					<td>${(item.name)!}</td>
					<td>${(item.wish)!}</td>
					<td>${(item.createTime.toString("yyyy-MM-dd HH:mm:ss"))!}</td>
					<td>
					<a href="${base}/admin/dowish/${(item.uid)!}/del">删除</a>
					</td>
				</tr>
			[/#list]
			</tbody>
		</table>
		[@p.Pager pager /]
	</div>
</body>
</html>