[#ftl]
<div id="headarea">
	<div class="mybody">
		<div class="container">
			<div class="toplinks">
				[#if me??]
				欢迎您，<a href="${base}/myhome" target="_self">${me.userid}</a> | <a href="${base}/myhome" target="_self">会员中心</a> | <a href="${base}/mycart?" target="_self">[@s.message "mycart" /]</a> | <a href="${base}/logout" target="_self">退出</a> | 
				[#else]
				<a href="${base}/login" target="_self">[@s.message "pleaselogin" /]</a> | <a href="${base}/login" target="_self">[@s.message "signinfree" /]</a> | <a href="${base}/mycart" target="_self">[@s.message "mycart" /]</a> | 
				[/#if]
				<a id="addbookmarkhref" title="" href="http://www.jiazuww.com" target="_self">[@s.message "addbookmark" /]</a> | <a id="sethomehref" title="" href="http://www.jiazuww.com" target="_self">[@s.message "sethomepage" /]</a> | <a href="${base}/help">[@s.message "helponline" /]</a>
			</div>
			<div class="logo left">
			[#if logo??]
				<img src="${baseimg}${logo.titleimg}" title="${logo.title}" width="140px" height="80px"  />
			[/#if]
			</div>
			<div class="logoassist left">&nbsp;</div>
			<div class="searchcontainer left">
				<div class="searchbox left">
				<form id="f_search" action="${base}/search" method="get">
					<ul>
						<li><input id="txtsearch" class="searchtxt" name="s" maxlength="18" value="${searchtext!}" type="text" /></li>
						<li><input id="hdtype" name="type" value="0" type="hidden">
						<div id="downlist" class="downlist">&nbsp;&nbsp;[@s.message "all" /]</div>
						<ol id="downlistchooser" class="downlistchooser hd">
							<li value="0">&nbsp;&nbsp;全部</li>
							<li value="1">&nbsp;&nbsp;教育</li>
							<li value="2">&nbsp;大事记</li>
							<li value="3">文化产品</li>
							<li value="4">互通有无</li>
						</ol>
						</li>
						<li style="padding-top: 1px;"><input id="btnsearch" class="search" type="submit" value="[@s.message "search" /]" /></li>
					</ul>
				</form>
				</div>
				<div class="searchtags left">[@s.message "searchhot" /]：
				[#list hotsearchList! as item]
				<a href="${base}${item.originurl}">${item.title}</a>
				[/#list]
				</div>
			</div>
			<br class="clear" />
			<div class="menu">
				<ul id="mainmenu">
					<li><a href="${base}/" target="_self">[@s.message "menu.home" /]</a></li>
					<li><a href="${base}/zupu">[@s.message "menu.zupu" /]</a></li>
					<li><a href="${base}/jisi">[@s.message "menu.jisi" /]</a></li>
					<li><a href="${base}/edu">[@s.message "menu.edu" /]</a><div class="new"></div></li>
					<li><a href="${base}/event">[@s.message "menu.event" /]</a></li>
					<li><a href="${base}/b2c">[@s.message "menu.b2b" /]</a></li>
					<li><a href="${base}/custom">[@s.message "menu.custom" /]</a></li>
					<li><a href="${base}/c2c">[@s.message "menu.b2c" /]</a><div class="new"></div></li>
				</ul>
			</div>
		</div>
		<div class="bar">
			<div class="container"><dl><dt class="bold">[@s.message "bulletin" /]：</dt><dd><div id="scrollnotice">
			[#list notices! as content]
			<h6>${(content.title)!}</h6>
			[/#list]
			</div></dd></dl></div>
		</div>
	</div>
</div>