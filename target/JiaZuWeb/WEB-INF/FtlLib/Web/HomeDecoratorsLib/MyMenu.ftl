[#ftl]
<div class="menu">
	<ul id="homemenu">
		[#if currUid??]
		<li><a href="${base}/myhome/${currUid}"> &gt;我的家族</a></li>
		[#else]
		<li><a href="${base}/myhome"> &gt;我的家族</a></li>
		[/#if]
		[#if currUid??]
		<li><a href="${base}/myhome/${currUid}/logo"> &gt;族徽</a></li>
		<li><a href="${base}/myhome/${currUid}/brief"> &gt;族训</a></li>
		<li><a href="${base}/myhome/${currUid}/history"> &gt;渊源</a></li>
		<li><a href="${base}/myhome/${currUid}/zupu"> &gt;族谱</a></li>
		<li><a href="${base}/myhome/${currUid}/jisi"> &gt;缅怀</a></li>
		<li><a href="${base}/myhome/order"> &gt;订单中心</a></li>
		<li><a href="${base}/myhome/${currUid}/edu"> &gt;教育</a></li>
		<li><a href="${base}/myhome/${currUid}/event"> &gt;大事记</a></li>
		<li><a href="${base}/myhome/${currUid}/custom"> &gt;风土人情</a></li>
		<li><a href="${base}/myhome/${currUid}/member"> &gt;家族成员</a></li>
		<li><a href="${base}/myhome/${currUid}/wish"> &gt;祝福墙</a></li>
		[#else]
		<li><a href="javascript:void(0)"> &gt;族徽</a></li>
		<li><a href="javascript:void(0)"> &gt;族训</a></li>
		<li><a href="javascript:void(0)"> &gt;渊源</a></li>
		<li><a href="javascript:void(0)"> &gt;族谱</a></li>
		<li><a href="javascript:void(0)"> &gt;缅怀</a></li>
		<li><a href="${base}/myhome/order"> &gt;订单中心</a></li>
		<li><a href="javascript:void(0)"> &gt;教育</a></li>
		<li><a href="javascript:void(0)"> &gt;大事记</a></li>
		<li><a href="javascript:void(0)"> &gt;风土人情</a></li>
		<li><a href="javascript:void(0)"> &gt;家族成员</a></li>
		<li><a href="javascript:void(0)"> &gt;祝福墙</a></li>
		[/#if]
		<li><a href="${base}/myhome/account"> &gt;个人账户</a></li>
		<li><a href="${base}/myhome/c2c"> &gt;互通有无</a></li>
		<li><a href="${base}/myhome/msg"> &gt;留言板</a></li>
		<li><a href="${base}/myhome/jiazu"> &gt;家族管理</a></li>
	</ul>
</div>