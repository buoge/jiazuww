[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myevent-1.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myjisi.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function() {
		$(".box").mouseover(function() {
			$(this).addClass("hover");
		});
		$(".box").mouseout(function() {
			$(this).removeClass("hover");
		});
		computeTextBoxWordsCount("#txtcontent", "#count200");
	});
//-->
</script>
</head>
<body>
[#list list as item]
<div class="box">
	[#if (item.name)?? && (item.name?length > 0) && (item.status == 0)]
	<div class="block">
		<div class="author">
			<img src="${baseimg}${item.avatar!"/imgs/default/noimg50_50.gif"}" alt="${item.name}" title="${item.name}">
		</div>
		<div class="content">
			<span class="authorname">${item.name}：</span> <span class="event">
			${item.introduce}
			</span>
			<div class="date">
				诞辰：${item.birthday}
			</div>
		</div>
	</div>
	[/#if]
	
	[#if (item.name2)?? && (item.name2?length > 0) && (item.status2 == 0)]
	<div class="block">
		<div class="author">
			<img src="${baseimg}${item.avatar2!"/imgs/default/noimg50_50.gif"}" alt="${item.name2}" title="${item.name2}">
		</div>
		<div class="content">
			<span class="authorname">${item.name2}：</span> <span class="event">
			${item.introduce2}
			</span>
			<div class="date">
				诞辰：${item.birthday2}
			</div>
		</div>
	</div>
	[/#if]
	<form id="f_jisi" action="${base}/jisi/${item.uid}" method="post">
	<div class="left">
		选择缅怀音乐：
		<select id="sltmusic" name="musicpath">
			<option value ="">请选择</option>
			[#list musiclist as item]
				<option value ="${item.path}">${item.name}</option>
			[/#list]
		</select>
	</div>
	<div class="right">
		<input id="btndel" class="btn1 btn" type="submit" value="缅怀">
	</div>
	</form>
</div>
[/#list]
[@p.Pager pager /]
</body>
</html>