<#ftl strip_whitespace=true>
<#escape x as x?html]>
<#--
 * Public.ftl
 *
 * @author architect.bian
 * @since 1.0
 -->
<#--
 * 分页
 * pager 分页数据
 * @author architect.bian
 * @since 1.0
 -->
<#macro Pager pager>
<#if pager??>
<#if pager.listSize &gt;= pager.pageSize || pager.pageNumber! &gt; 1>
<div class="pagenum">
<ul>
<#if pager.pageNumber! &gt; 1>
<li><a class="last" href="?<#if request.getQueryString()??>${request.getQueryString()?split("num")[0]}&</#if>num=${pager.pageNumber - 1}">上一页</a></li>
<#else>
<li><a class="last" href="?<#if request.getQueryString()??>${request.getQueryString()}</#if>">上一页</a></li>
</#if>
<#if pager.listSize &gt;= pager.pageSize>
<li><a class="next" href="?<#if request.getQueryString()??>${request.getQueryString()?split("num")[0]}&</#if>num=${pager.pageNumber + 1}">下一页</a></li>
</#if>
</ul>
</div>
</#if>
</#if>
 </#macro>
 <#--
 * 大事记列表
 * candel 是否可删除
 * @author architect.bian
 * @since 1.0
 -->
<#macro EventList events candel=false isadmin=false>
<script type="text/javascript">
<!--
var me = {
avatar : '${baseimg}${(me.avatar)!""}',
name : '${(me.name)!}'
};
var base = '${base}';
$(function(){
	$(".imgbox").click(imgboxClickHandler);
	computeTextBoxWordsCount("#txtcomment", "#count150");
})
function imgboxClickHandler() {
	var img = $(this).children("img");
	var src = img.attr("src");
	img.attr("src", img.attr("lsrc"));
	img.attr("lsrc", src);
	$(this).toggleClass("big");
}

function commentsShow(obj) {
	<#if !me?? && !isadmin>
	alert("请先登录或注册");return;
	</#if>
	$(obj).parents(".block").children("#comments").toggleClass("hd");
}
//-->
</script>
<script type="text/javascript" src="${basejs}/js/pages/comment-1.0.0.js"></script>
	<#list events as event>
	<div class="box <#if event.recommend>top</#if>">
		<div class="author">
		<img src="${baseimg}${event.groupImg}" alt="" />
		</div>
		<div class="block">
			<div class="content">
				<span class="authorname">${event.groupName}：</span>
				<span class="event">${event.content}</span>
				<#if event.img??>
				<div class="imgbox"><img lsrc="${baseimg}${event.bigimg}" src="${baseimg}${event.img}" alt="" /></div>
				</#if>
			</div>
			<div class="info">
				<#if isadmin>
					<#if !event.recommend>
					<span><a href="${base}/admin/doevent/${event.uid}/top?top=true">置顶</a> | 
					</#if>
					<#if event.recommend>
					<span><a href="${base}/admin/doevent/${event.uid}/top?top=false">取消置顶</a> |
					</#if>
					<span><a href="${base}/admin/doevent/${event.uid}/del">删除</a> | </span>
				<#elseif candel && me.uid == event.useruid><span><a href="${base}/myhome/${currUid}/event/${event.uid}/del">删除</a> | </span>
				</#if>
				<a href="javascript:void(0)" onclick="commentsShow(this)">评论(${event.commentcount})</a> | ${event.createTime.toString("yyyy-MM-dd HH:mm:ss")} 来自：${event.userName}
			</div>
			<#if me?? || isadmin>
			<div id="comments" class="comments hd">
				<form id="f_comments" action="${base}/myhome/comment/${event.uid}" method="post">
				<#if !isadmin>
<script type="text/javascript">
<!--
$(function(){
	computeTextBoxWordsCount("#txtcomment${event.uid}", "#count150${event.uid}");
})
//-->
</script>
				<textarea id="txtcomment${event.uid}" maxlength="150" name="comment"></textarea>
				<br class="clear" />
				<div class="leftmsg hd">${msg}</div>
				<div class="btmbar">
				<span class="gray">还能输入<span id="count150${event.uid}">150</span>个字</span>
				<input id="btncomment" type="button" onclick="btnComment('#txtcomment${event.uid}')" value="" title="评论"/>
				</div>
				</#if>
				<br class="clear" />
					<div id="arglist">
					<#list event.comments as item>
						<div class="argument">
							<img class="headimg" src="${baseimg}${(item.user.avatar)!""}" alt="" />
							<div class="word">
								<#if item.useruid == (me.uid)!>
								<a onclick="deleteArgumentHandler(this, '${item.uid}')" class="delete right" href="javascript:void(0)">〤</a>
								</#if>
								<#if isadmin>
								<a onclick="deleteArgumentHandler(this, '${item.uid}', '${base}/admin/comment/${item.uid}')" class="delete right" href="javascript:void(0)">〤</a>
								</#if>
								<span class="name">${(item.user.name)!}&nbsp;</span>
								<span class="content">${(item.comment)!}</span>
							</div>
							<div class="date">${(item.time)!}</div>
						</div>
					</#list>
					</div>
					<br class="clear" />
				</form>
			</div>
			</#if>
		</div>
	</div>
	</#list>
</#macro>
<#macro CommenList uid comments>
<script type="text/javascript">
<!--
var me = {
avatar : '${baseimg}${(me.avatar)!""}',
name : '${(me.name)!}'
};
var base = '${base}';
$(function(){
	computeTextBoxWordsCount("#txtcomment", "#count150");
});
//-->
</script>
<script type="text/javascript" src="${basejs}/js/pages/comment-1.0.0.js"></script>
<div id="comments" class="comments">
	<form id="f_comments" action="${base}/myhome/comment/${uid}" method="post">
	<#if me??>
	<textarea id="txtcomment" maxlength="150" name="comment"></textarea>
	<br class="clear" />
	<div class="leftmsg hd">${msg}</div>
	<div class="btmbar">
		<span class="gray">还能输入<span id="count150">150</span>个字</span>
		<input id="btncomment" type="button" value="" title="评论"/>
	</div>
	<br />
	</#if>
	<div id="arglist">
	<#list comments as item>
		<div class="argument">
			<img class="headimg" src="${baseimg}${(item.user.avatar)!""}" alt="" />
			<div class="word">
				<#if item.useruid == (me.uid)!>
					<a onclick="deleteArgumentHandler(this, '${item.uid}')" class="delete right" href="javascript:void(0)">〤</a>
				</#if>
				<span class="name">${(item.user.name)!}</span>
				<span class="content">${(item.comment)!}</span>
			</div>
			<div class="date">${(item.time)!}</div>
		</div>
		</#list>
	</div>
	</form>
</div>
</#macro>
 <#--
 * 风土人情列表
 * candel 是否可删除
 * @author architect.bian
 * @since 1.0
 -->
<#macro CustomList customs candel=false>
	<ul>
	<#list customs as item>
		<li>
		<a href="${base}/custom/${item.uid}" title="${item.title}" target="_blank"><img src="${baseimg}${item.thumb}" alt="${item.title}" title="${item.title}"><label>${item.title}</label></a>
		<#if candel && me.uid == item.useruid>
		<span><a href="javascript:void(0)" title="注意：直接删除，不可恢复！" onclick="delHandler(this,'${base}/myhome/${currUid}/custom/${item.uid}/del')">删除</a></span>
		<#else>
		<span>${item.title}</span>
		</#if>
		</li>
	</#list>
	</ul>
</#macro>
 <#--
 * 用户头像列表
 * candel 是否可删除
 * @author architect.bian
 * @since 1.0
 -->
<#macro userHeadsList users>
	<#if users??>
	<ul class="heads">
		<#list users as item>
		<li>
			<label for="chkadd_${(item.useruid)!(item.uid)}">
				<div class="head1">
				<img src="${baseimg}${item.avatar}" style="width:50px; height:50px;" alt="${item.name}" title="${item.name}">
				<div class="tagbg"></div>
				<div class="tag">${item.name}</div>
				</div>
			</label>
			<div class="txtcen">
			<#if item.useruid??>
			<input id="chkadd_${item.useruid}" name="select" value="${item.useruid}" title="将${item.name}邀请加入到本家族" type="checkbox" />
			<#else>
			<input id="chkadd_${item.uid}" name="select" value="${item.uid}" title="将${item.name}邀请加入到本家族" type="checkbox" />
			</#if>
			</div>
		</li>
		</#list>
	</ul>
	</#if>
</#macro>
 <#--
 * 家族列表
 * candel 是否可删除
 * @author architect.bian
 * @since 1.0
 -->
<#macro JiazuList list isadmin=false>
	<#list list as item>
	<div class="verticallist">
		<form action="${base}/myhome/jiazu" method="post">
		<input id="hduid" name="uid" value="${(item.uid)!}" type="hidden" />
		<img class="jiazuhead" src="${baseimg}${(item.logo)!"/imgs/default/noimg130_130.gif"}" alt="" title="">
		<dl>
			<dt>${(item.name)!} <#if isadmin && item.owner == me.uid><a href="javascript:void(0)" onclick="modifyHandler(this)">[修改]</a></#if></dt>
			<#if item.owner == me.uid>
			<dt class="hd"><input id="txtname" name="name" value="${(item.name)!}" class="size12 bold" type="text" /> <input class="btn2 btn" type="submit" value="保存"> <input class="btn2 btn" onclick="cancelModifyHandler(this)" type="button" value="取消"></dt>
			</#if>
			<dd class="content">${(item.brief)!}</dd>
			<dd class="btmbar">
				<#if isadmin>
					<#if item.owner != me.uid>
					<a href="${base}/myhome/jiazu/${(item.uid)!}/quit" onclick="return quitConfirmHandler()">[退出]</a>
					</#if>
					<a href="${base}/myhome/${(item.uid)!}/member">[查看成员]</a>
					<#if item.owner == me.uid>
					<a href="${base}/myhome/jiazu/${(item.uid)!}/del" onclick="return delConfirmHandler()">[删除]</a>
					</#if>
				<#else>
				<a href="${base}/myhome/${(item.uid)!}/add">[我要加入]</a>
				</#if>
			</dd>
		</dl>
		</form>
	</div>
	</#list>
</#macro>
 <#--
 * b2c产品列表
 * @author architect.bian
 * @since 1.0
 -->
<#macro listB2CProds list ishotshow=false>
<#list list as item>
	<#if item.type == 1>
	<div class="prod">
		<div class="imgbox"><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /></a></div>
		<div class="left"><label class="price">${item.shopprice}</label>元</div>
		<div class="right"><label class="formerprice">${item.marketprice}</label>元</div>
		<br class="clear" />
		<a href="${base}/b2c/${item.uid}"><h3>${item.name}</h3></a>
		<p>已有${item.buyercount}人购买</label>
	</div>
	<#elseif item.type == 0>
	<div class="book">
		<div class="imgbox"><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /></div>
		<p>会员价：<span>￥${item.shopprice}</span></p>
		<a href="${base}/b2c/${item.uid}"><h3>${item.name}</h3></a>
		<div class="recommend">
			${item.brief}
		</div>
	</div>
	<#elseif item.type == 2>
	<div class="prod">
		<div class="imgbox"><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /></a></div>
		<div class="left"><label class="price">${item.shopprice}</label>元</div>
		<div class="right"><label class="formerprice">${item.marketprice}</label>元</div>
		<br class="clear" />
		<a href="${base}/b2c/${item.uid}"><h3>${item.name}</h3></a>
		<p>已有${item.buyercount}人购买</label>
	</div>
	<#elseif item.type == 3>
		<#if ishotshow>
			<div class="prod">
				<div class="imgbox"><a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="" /></a></div>
				<div class="left"><label class="price">${item.shopprice}</label>元</div>
				<div class="right"><label class="formerprice">${item.marketprice}</label>元</div>
				<br class="clear" />
				<a href="${base}/b2c/${item.uid}"><h3>${item.name}</h3></a>
				<p>已有${item.buyercount}人购买</label>
			</div>
		<#else>
			<li><a href="${base}/b2c/${item.uid}"><h3>${item.name}</h3><span class="price">￥${item.shopprice}</span><span class="formerprice">￥${item.marketprice}</span></a></li>
		</#if>
	</#if>
</#list>
</#macro>
</#escape>

