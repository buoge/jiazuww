[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>缅怀${title}</title>
<meta name="Keywords" content="[@s.message "mycart.keyword" /]" />
<meta name="Description" content="[@s.message "mycart.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/jisi.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/libs/disablesave-1.0,0.js"></script>
<script type="text/javascript" src="${basejs}/js/libs/norightclick-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/libs/music-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/pages/jisi-1.0.0.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		$("#playctrl").playMusic("${baseimg}${music}");
	});
	var baseimg = "${baseimg}";
	var jisiuid = "${jisiuid}";
//-->
</script>
</head>
<body>
<div id="music" class="">
	<bgsound id='sound' src='' autostart='true' loop='infinite' />
	<audio id="sound" class="hd" controls="controls" autoplay='autoplay'>
		<source src="" type="audio/mpeg">
	</audio>
</div>
<div class="mybody">
	<div id="window">
		<img id="bg" src="${baseimg}/imgs/jisi/bg.jpg" />
		<div id="heads" class="">
			[#if (member.name)?? && (member.name?length > 0) && (member.status == 0)]
			<div class="head" [#if !((member.name2)?? && (member.name2?length > 0) && (member.status2 == 0))]style="left:20%;"[/#if]>
				<img src="${baseimg}${member.avatar}" title="${member.name}" />
				<h2>${member.name}</h2>
			</div>
			[/#if]
			[#if (member.name2)?? && (member.name2?length > 0) && (member.status2 == 0)]
			<div class="head" [#if !((member.name)?? && (member.name?length > 0) && (member.status == 0))]style="left:20%;"[/#if]>
				<img src="${baseimg}${member.avatar2}" title="${member.name2}" />
				<h2>${member.name2}</h2>
			</div>
			[/#if]
		</div>
		<div id="jisilog">
			<h2>祭奠记录板</h2>
			[#list viewers as item]
			<p><label>${item.name!}</label><span>${item.createTime.toString("yyyy-MM-dd")}&nbsp;</span></p>
			[/#list]
		</div>
		
		
		[#if !me??]
		<a id="register" href="${base}/login" title="我要祭祀"></a>
		[#else]
		<a id="charge" href="${base}/b2c/dd2a9f0a6c0f4a0f8c432154ef285788" target="_blank" title="我要祭祀"></a>
		[/#if]
		<div id="controllcontainer">
			<a id="playctrl" class="" href="" title="音乐播放|暂停"></a>
		</div>
		
		<div id="flowersbox">
		<div class="bg"></div>
		<ul>
			<li onclick="senserClickHandler()">
				<img src="${baseimg}/imgs/jisi/senser_40_40.png" title="" />
				<label>上香</label>
				<span class="del">1家族币</span>
				<div class="free"></div>
			</li>
			<li onclick="candleClickHandler()">
				<img src="${baseimg}/imgs/jisi/candle_40_40.png" title="" />
				<label>点烛</label>
				<span class="del">1家族币</span>
				<div class="free"></div>
			</li>
			[#list list as item]
			<li onclick="flowersClickHandler('${item.uid}')">
				<img src="${baseimg}${item.thumb}" title="${item.name}" />
				<label>${item.name}</label>
				<span [#if item.free]class="del"[/#if]>${item.price}族币</span>
				[#if item.free]
				<div class="free"></div>
				[/#if]
			</li>
			[/#list]
		 <ul>
		</div>
		
		<div id="floor1">
			<ul class="">
				<li id="candle1" class="candle">
					<div class="head [#if leftCandlePercent < 0]hd[/#if]"><img src="${baseimg}/imgs/jisi/fire.gif" /></div>
					<div class="body"></div>
					<div class="foot"></div>
				</li>
				<li id="censer">
					<div class="head [#if leftCenserPercent < 0]hd[/#if]">
					<div class="sm1 hd">
					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0"
					width="8" height="20" id="冒烟" align="middle">
					<param name="allowScriptAccess" value="sameDomain" />
					<param name="allowFullScreen" value="false" />
					<param name="movie" value="${baseimg}/imgs/jisi/smoke.swf" /><param name="quality" value="high" /><param name="wmode" value="transparent" />
					<embed src="${baseimg}/imgs/jisi/smoke.swf" quality="high" wmode="transparent" width="8" height="20" name="冒烟" align="middle" allowScriptAccess="sameDomain" allowFullScreen="false" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" />
					</object>
					</div>
					<div class="sm2 hd">
					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0"
					width="10" height="30" id="冒烟" align="middle">
					<param name="allowScriptAccess" value="sameDomain" />
					<param name="allowFullScreen" value="false" />
					<param name="movie" value="${baseimg}/imgs/jisi/smoke.swf" /><param name="quality" value="high" /><param name="wmode" value="transparent" />
					<embed src="${baseimg}/imgs/jisi/smoke.swf" quality="high" wmode="transparent" width="10" height="30" name="冒烟" align="middle" allowScriptAccess="sameDomain" allowFullScreen="false" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" />
					</object>
					</div>
					<div class="sm3 hd">
					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0"
					width="8" height="20" id="冒烟" align="middle">
					<param name="allowScriptAccess" value="sameDomain" />
					<param name="allowFullScreen" value="false" />
					<param name="movie" value="${baseimg}/imgs/jisi/smoke.swf" /><param name="quality" value="high" /><param name="wmode" value="transparent" />
					<embed src="${baseimg}/imgs/jisi/smoke.swf" quality="high" wmode="transparent" width="8" height="20" name="冒烟" align="middle" allowScriptAccess="sameDomain" allowFullScreen="false" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" />
					</object>
					</div>
					</div>
					<div class="body [#if leftCenserPercent < 0]hd[/#if]"></div>
					<div class="foot"></div>
				</li>
				<li id="candle2" class="candle">
					<div class="head [#if leftCandlePercent < 0]hd[/#if]"><img src="${baseimg}/imgs/jisi/fire.gif" /></div>
					<div class="body"></div>
					<div class="foot"></div>
				</li>
			</ul>
		</div>
		<div id="floor2" class="hd">
			<div class="row">
				<ul>
					[#list flowers as item]
						[#if item_index < 6]
							<li><img src="${baseimg}${item.img}" title="${item.name}" /></li>
						[/#if]
					[/#list]
				</ul>
			</div>
			<div class="row2">
				<ul>
					[#list flowers as item]
						[#if item_index > 5]
							<li><img src="${baseimg}${item.img}" title="${item.name}" /></li>
						[/#if]
					[/#list]
				</ul>
			</div>
			</div>
		
		<div id="fog" class="fog hd"></div>
		
		
		<div id="introcontainer">
			[#if (member.name2)?? && (member.name2?length > 0) && (member.status2 == 0)]
			<div class="introbox">
				<div class="topbar"></div>
				<div class="bodybox">
					<div class="content">
						<h1>${member.name2}的生平简介</h1>
						<p>${member.introduce2?html}</p>
					</div>
				</div>
				<div class="footbar"></div>
			</div>
			[/#if]
			[#if (member.name)?? && (member.name?length > 0) && (member.status == 0)]
			<div class="introbox">
				<div class="topbar"></div>
				<div class="bodybox">
					<div class="content">
						<h1>${member.name}的生平简介</h1>
						<p>${member.introduce?html}</p>
					</div>
				</div>
				<div class="footbar"></div>
			</div>
			[/#if]
		</div>
		
		<div id="fog2" class="fog hd"></div>
		
		<div id="jisilogeventlayer"></div>
		
		<div id="welcome">
			<div class="box">
				<div class="bg"></div>
				<div class="content">
				<p>
				${article}
				</p>
				</div>
			</div>
		</div>
		
		<div id="msgbox" class="hd">
			<div class="msgcontainer">
			<div class="whitebg"></div>
			<div class="tip">对不起，您当前的家族币不足，请先<a href="${base}/b2c/${url}" target="_blank">充值或购买家族币</a>！</div>
			</div>
		</div>
		
	</div>
</div>
</body>
</html>