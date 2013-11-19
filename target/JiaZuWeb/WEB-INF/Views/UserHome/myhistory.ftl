[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function (){
		computeTextBoxWordsCount("#txtdesc", "#count1000");
		$("#f_history").submit(function(){
			if($("#txtdesc").val().length > 1000) {
				alert("最多输入1000个字");
				return false;
			}
			return true;
		});
	});
//-->
</script>
</head>
<body>
<form id="f_history" action="${base}/myhome/${currUid}/history" method="post">
<span class="txttop">家族渊源：</span>
[#if admintype > 0]
<textarea id="txtdesc" maxlength="1000" name="desc">${(bean.desc)!}</textarea>
[#else]
${(bean.desc)!}
[/#if]
<br class="clear" />
[#if msg??]
<div class="leftmsg">${msg}</div>
[/#if]
[#if admintype > 0]
<div class="historybtmbar">
<span class="gray">还能输入<span id="count1000">1000</span>个字</span>
<input class="btn2" type="submit" value="保存"/>
</div>
[/#if]
</form>
</body>
</html>