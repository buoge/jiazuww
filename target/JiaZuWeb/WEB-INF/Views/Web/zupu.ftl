[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.zupu" /]</title>
<meta name="Keywords" content="[@s.message "zupu.keyword" /]" />
<meta name="Description" content="[@s.message "zupu.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/zupu.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		scrollup("zupuNews",56,8,3000,null,null);
		
		setLoginBox();
	});
	
	var guideword_txtuserid = "";
	function setLoginBox() {
		$("#txtuserid").val(guideword_txtuserid);
		$("#txtuserid").focus(txtFocusHandler);
		$("#txtuserid").blur(txtUseridBlurHandler);
	}
	function txtUseridBlurHandler() {
		if($("#txtuserid").val().trim() == "") {
			$(this).val(guideword_txtuserid);
			$(this).addClass("gray");
		}
	}
	
	function txtFocusHandler() {
		if($(this).val().trim() == guideword_txtuserid) {
			$(this).val('');
			$(this).removeClass("gray");
		}
	}
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="boxs">
		<div class="leftbox">
			<h2>已创建族谱：<span class="red">${zuPuCount}</span>个</h2>
			<div class="block" style="height:375px;overflow:hidden;">
				<h3>族谱动态</h3>
				<div class="content" style="overflow:hidden;">
					<div id="zupuNews">
					[#list zuPuNews as news]
					<div class="event">
						<img class="groupimg" style="width:50px; height:50px;" src="${baseimg}${news.headimg}" alt="" />
						<ul>
						<li>
							<span class="title">${news.title}</span>
							<span class="date">${news.time}</span>
						</li>
						<li>
							家族名：<span class="brown">${news.author}</span>
						</li>
						</ul>
					</div>
					[/#list]
					</div>
				</div>
			</div>
			<div class="block">
				<h3>已创建族谱</h3>
				<div class="list">
					<ul>
						[#list zuPuLatest as zupu]
						<li><span class="name">${zupu.name}</span><span class="date">${zupu.time}</span></li>
						[/#list]
					</ul>
				</div>
			</div>
		</div>
		<div class="rightbox">
			<h2 class="bggrown">登录家族旺旺</h2>
			<div class="block">
				<div class="login">
					<div class="form">
					<form id="f_login" action="login" target="_self" method="post">
					<input id="txtuserid" class="gray" name="userid" value="" type="text" />
					<input id="txtpwd" class="gray" name="password" value="" title="请输入密码" type="password" />
					<input value="" type="submit" />
					</form>
					</div>
					<input class="register" onclick="gourl('${base}/login')" type="button" value="立即注册家族旺旺" />
				</div>
			</div>
			<h2 class="bgred">族谱介绍</h2>
			<div class="block">
				<div class="article">
					<img src="${baseimg}${(intro.titleimg)!}" alt="${(intro.title)!}" />
					<p class="content">
					${(intro.content)!}
					</p>
					[#if me??]
						[#if currUid??]
						<input class="btncreate" type="button" onclick="gourl('${base}/myhome/${currUid}/zupu')" value="我要创建" />
						[#else]
						<input class="btncreate" type="button" onclick="gourl('${base}/myhome')" value="我要创建" />
						[/#if]
					[#else]
					<input class="btncreate" type="button" onclick="gourl('${base}/login')" value="我要创建" />
					[/#if]
					<br class="clear" />
				</div>
			</div>
		</div>
		[#include "/WEB-INF/FtlLib/Web/JiaZuTree.ftl" /]
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
		<br class="clear" />
	</div>
</div>
</body>
</html>