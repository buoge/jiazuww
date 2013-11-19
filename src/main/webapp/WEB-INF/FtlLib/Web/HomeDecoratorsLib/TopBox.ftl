[#ftl]
<div class="topbox">
	<img class="jiazuhead" src="${baseimg}${(bean.logo)!"/imgs/default/noimg130_130.gif"}" alt="" />
	<div class="topinfo">
		<dl>
			<dt>${(bean.name)!}家族动态：</dt>
			<dd>最新教育：<span class="c900"><a href="[#if currUid??]${base}/myhome/${currUid}/edu[/#if]">${newEduCount!0}</a></span></dd>
			<dd>最新大事：<span class="c900"><a href="[#if currUid??]${base}/myhome/${currUid}/event[/#if]">${newEventCount!0}</a></span></dd>
			<dd>家族成员：<span class="c900"><a href="[#if currUid??]${base}/myhome/${currUid}/member[/#if]">${jiazuMemberCount!0}</a></span></dd>
		</dl>
		<dl>
			<dt>我的最新动态：</dt>
			<dd>未读信息：<span class="c900"><a href="${base}/myhome/msg">${newMsgCount!}</a></span></dd>
			<dd>账户余额：<span class="c900"><a href="${base}/myhome/account">${(me.account)!}</a></span></dd>
		</dl>
	</div>
</div>
<div class="bar">
	<h2 class="left">族训</h2>
	<div class="right">
	<p>${(bean.brief)!}&nbsp;</p>
	</div>
</div>