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
		computeTextBoxWordsCount("#txtbrief", "#count150");
		$("#f_brief").submit(function(){
			if($("#txtbrief").val().length > 150) {
				alert("最多输入150个字");
				return false;
			}
			return true;
		});
	});
	
//-->
</script>
</head>
<body>

<form id="f_brief" action="${base}/myhome/${currUid}/brief" method="post">
<span class="txttop">家族族训：</span>
[#if admintype > 0]
<textarea id="txtbrief" maxlength="150" name="brief">${(bean.brief)!}</textarea>
[#else]
${(bean.brief)!}
[/#if]
<a class="mrgt120 bold" href="http://www.jiazuww.com/b2c/5d1af939f44d4381908e197288818938">我需要毛笔字族训<float:right></a>
<br class="clear" />
[#if msg??]
<div class="leftmsg">${msg}</div>
[/#if]
[#if admintype > 0]
<div class="briefbtmbar">
<span class="gray">还能输入<span id="count150">150</span>个字</span>
<input class="btn2" type="submit" value="保存"/>
</div>
[/#if]
</form>
</body>
</html>