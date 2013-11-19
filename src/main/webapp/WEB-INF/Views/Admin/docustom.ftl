[#ftl]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"] /]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>风土人情管理</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/imgblocks.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/admin/ajaximgblocks-1.0.0.js"></script>
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
		<h2 class="bg1">TOP列表</h2>
		<div class="bg2 table" style="width:100%;">
    	<ul class="imgsblock">
    		[#list topCustoms as item]
			<li>
				<a href="${base}/custom/${item.uid}" title="${item.title}" target="_blank"><img src="${baseimg}${item.thumb}" style="width:180px; height:150px;"><label> </label></a>
				<span>
				<a href="" title="注意：直接删除，不可恢复！" onclick="delHandler(this,'${base}/admin/docustom/${item.uid}/del')">删除</a>
				<a href="${base}/admin/docustom/${item.uid}/topcancel" title="">取消置顶</a>
				</span>
			</li>
			[/#list]
		</ul>
		</div>
		<br /><br /><br />
		<h2 class="bg1">列表</h2>
		<div class="bg2 table" style="width:100%;">
    	<ul class="imgsblock">
    		[#list customList as item]
			<li>
				<a href="${base}/custom/${item.uid}" title="${item.title}" target="_blank"><img src="${baseimg}${item.thumb}" style="width:180px; height:150px;"><label> </label></a>
				<span>
				<a href="" title="注意：直接删除，不可恢复！" onclick="delHandler(this,'${base}/admin/docustom/${item.uid}/del')">删除</a>
				<a href="${base}/admin/docustom/${item.uid}/top" title="">置顶</a>
				</span>
			</li>
			[/#list]
		</ul>
		</div>
	</div>
</body>
</html>