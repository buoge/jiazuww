[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.index" /]</title>
<base target="_blank" />
<meta name="Keywords" content="[@s.message "index.keyword" /]" />
<meta name="Description" content="[@s.message "index.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/index.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	forbiddenIframe();
	$(function(){
		if($.browser.msie) {
			HorizontalSlider("sliderbox",960,20,10,15000,null,null);
			$("#goleft").click(function(){
				SliderClickHandler("sliderbox",960,-20,10)
			});
			$("#goright").click(function(){
				SliderClickHandler("sliderbox",960,20,10)
			});
			scrollup("jiazunews",72,8,1500,null,null);
		} else {
			HorizontalSlider("sliderbox",960,10,10,15000,null,null);
			$("#goleft").click(function(){
				SliderClickHandler("sliderbox",960,-10,10)
			});
			$("#goright").click(function(){
				SliderClickHandler("sliderbox",960,10,10)
			});
			scrollup("jiazunews",72,8,3000,null,null);
		};
		
		setLoginBox();
		
	});
	var guideword_txtuserid = "请输入用户名";
	function setLoginBox() {
		$("#txtuserid").val(guideword_txtuserid);
		$("#txtuserid").focus(txtFocusHandler);
		$("#txtuserid").blur(txtUseridBlurHandler);
		
		$("#f_login").submit(function(){
			$("#txtuserid").trigger("focus");
		});
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
	[#if bannerList?? && bannerList?size > 0]
	<div class="banner">
		<div class="sliderbox">
			<table id="sliderbox">
			<tr>
			[#list bannerList as item]
			<td class="box">
				<a href="${item.originurl}"><img style="width: 960px; height: 300px;" src="${baseimg}${item.originalimg}" alt="${item.title}" /></a>
			</td>
			[/#list]
			</tr>
			</table>
		</div>
		[#if !me??]
		<div class="loginpanel">
		<form id="f_login" action="login" target="_self" method="post">
			<div class="loginform">
				<br />
				<div><label>账　号：</label><input id="txtuserid" name="userid" type="text" class="gray" value="" /> </div>
				<div><label>密　码：</label><input type="password" name="password" value="" /> </div>
				<div><span class="hd"><input class="mlft90" type="checkbox" /> <label class="mlft3">30天自动登录</label></span></div>
				<div><input type="button" class="register" onclick="gourl('${base}/login')"  value="注册" /> <input class="login" type="submit" value="登录"  /> </div>
				<div class="txtrgt mrgt20 hd"><a href="#">忘记密码？</a></div>
			</div>
		</form>
		</div>
		[/#if]
		<div id="goleft" class="goleft"></div>
		<div id="goright" class="goright"></div>
	</div>
	[/#if]
	
	<div class="boxs">
	[#include "/WEB-INF/FtlLib/Web/JiaZuTree.ftl" /]
	<div class="widebox">
	<div class="leftbox">
			<h2 class="bggrown">家族教育</h2>
			<div class="block">
				<ul class="edulist">
					[#list eduTop as edu]
					<li><a href="${base}/edu/${edu.type}/${edu.id}">[${edu.typeName}]&nbsp;${edu.title}</a> <span class="hd">${edu.viewsday}</span></li>
					[/#list]
				</ul>
			</div>
			<h2 class="bgred">文化产品</h2>
			<div class="block">
				<div class="blockbody">
					[#include "/WEB-INF/FtlLib/Web/B2CProdBlock.ftl"]
				</div>
			</div>
	</div>
	<div class="rightbox">
		<h3>家族动态<span class="red hd">TOP6</span></h3>
		<div class="listblock" style="height:230px; overflow:hidden; display:block;">
			<div id="jiazunews" class="blockbody">
				[#list jiaZuNews as news]
				<div class="event">
					<img class="headimg" src="${baseimg}${news.headimg}" alt="" />
					<div class="word">
						<span class="name">${news.author}</span>
						<span class="news">${news.title}</span>
					</div>
					<div class="date">${news.time}</div>
				</div>
				[/#list]
			</div>
		</div>
		<h3 class="mtop20">风土人情<span class="red">TOP9</span></h3>
		<div class="imgsblock">
			[#list customTop as custom]
			<a href="${baseimg}/custom/${custom.uid}">
			<img src="${baseimg}${custom.littlethumb}" alt="${custom.title}" />
			<label>${custom.title}</label>
			</a>
			[/#list]
			<div class="more"><a href="${base}/custom">更多</a></div>
		</div>
		<h3 class="mtop20">爱心公益<span class="red hd">TOP8</span></h3>
		<div class="listblock">
			[#list charityTop as item]
				<ul class="ul3">
					<li class="left"><a href="${base}/c2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /> </a></li>
					<li class="right"><a href="${base}/c2c/${item.uid}">${item.name}</a>
					<p class="gray">时间：${item.date}</p></li>
				</ul>
			[/#list]
			<div class="more"><a href="${base}/c2c">更多</a></div>
		</div>
		<br class="clear" />
	</div>
	<br class="clear" />
	</div>
	<div class="widebox">
		<h2 class="bgred">互通有无</h2>
		<div class="block">
			<ul class="prodlist">
				[#list c2cBestList as prod]
				<li>
					<a href="${base}/c2c/${prod.uid}">
					<img src="${baseimg}${prod.bigthumb}" alt="${prod.name}" />
					<label>${prod.name}</label>
					</a>
					<p>￥<span>${prod.price}</span></p>
					<div class="left">${prod.newrate}成新</div><div class="right">${prod.address}</div>
				</li>
				[/#list]
			</ul>
		</div>
	</div>
	<div class="widebox">
		<h2 class="bggrown">友情链接</h2>
		<div class="block" style="height:auto !important;">
			<div class="imglinks">
				[#list imgFriendLinks as link]
				<a href="${link.originurl}"><img src="${baseimg}${link.titleimg}" alt="${link.title}" /></a>
				[/#list]
			</div>
			<div class="txtlinks">
				[#list txtFriendLinks as link]
				<a href="${link.originurl}">${link.title}</a>[#if link_has_next]&nbsp;|&nbsp;[/#if]
				[/#list]
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>