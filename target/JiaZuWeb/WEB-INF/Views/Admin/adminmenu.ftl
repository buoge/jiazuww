[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>※家族旺旺※</title>
<base target="_self" />
<meta name="Keywords" content="管理后台" />
<meta name="Description" content="管理后台" />
<meta name="robots" content="none" />
<meta name="googlebot" content="none" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/mainstyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/common.css" media="screen" />

<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/menu.css" media="screen" />
[#--<link rel="Shortcut Icon" href="css/ico16-16.ico" title="IE" />
<link rel="icon" href="css/ico.gif" type="image/gif" title="FF" />--]
<script type="text/javascript" src="${basejs}/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/myfun-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jslib-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/base-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/pages/common-1.0.0.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
$(function(){
	$("dl dt").click(menubarClickHandler);
	$("dd", $("dl[id!='dl1'][id!='dl2']")).addClass("hd");
});
function menubarClickHandler(){
	$("dd", $(this).parent("dl")).toggleClass("hd");
}

function resize_onclick(obj)
{
    if(obj.className=="expandleft")
    {
        top.document.getElementsByTagName("frameset")[0].cols="7,*";
        obj.className="collapseleft";
    }
    else
    {
        top.document.getElementsByTagName("frameset")[0].cols="205,*";
        obj.className="expandleft";
    }
}

//-->
</script>
</head>
<body>
<div id="headarea"></div>
<div id="bodyarea">
	<div class="mybody">
		<div class="expandleft" onclick="resize_onclick(this)" onmouseover="this.style.backgroundColor = '#D2D1D3'" onmouseout="this.style.backgroundColor=''"></div>
		<div class="left">
		    <dl id="dl1">
			    <dt onclick="showhidemenu(this)"><span>快捷通道</span><img src="${baseimg}/imgs/admin/top_level_ico2.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}" target="_blank"><img src="${baseimg}/imgs/admin/home.gif" /><span>返回前台</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/j_security_logout"><img src="${baseimg}/imgs/admin/exit.gif" /><span>退出</span></a></dd>
		    </dl>
		    <dl id="dl2">
			    <dt onclick="showhidemenu(this)"><span>系统管理</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/doadmin"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>管理员</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/donotice"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>最新公告</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dohotsearch"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>热门搜索</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dofriendlink"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>友情链接</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/20"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>找回密码</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/21"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>验证邮箱</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dologo"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>Logo管理</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dobanner"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>Banner管理</span></a></dd>
		    </dl>
		    <dl>
			    <dt><span>订单管理</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/doorder"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>订单列表</span></a></dd>
		    </dl>
		    <dl>
			    <dt><span>网站管理</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/doedu"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>教育</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/doevent"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>大事记</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dob2c"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>文化产品</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/docustom"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>风土人情</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/doc2c"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>互通有无</span></a></dd>
		    </dl>
		    <dl>
			    <dt><span>家族管理</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/dousers"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>会员列表</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dojiazu"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>家族列表</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dowish"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>祝福墙</span></a></dd>
		    </dl>
		    <dl>
			    <dt><span>缅怀管理</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/dojisi"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>缅怀管理</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/dojisimusic"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>缅怀音乐</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/9"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>缅怀开头语</span></a></dd>
		    </dl>
		    <dl>
			    <dt><span>关于我们</span><img src="${baseimg}/imgs/admin/top_level_ico1.gif" /></dt>
			    <dd><a target="rightpanel" href="${base}/admin/content/dozupu"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>族谱介绍</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/10"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>关于我们</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/11"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>充值服务</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/12"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>客服中心</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/13"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>招贤纳士</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/14"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>网站声明</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/15"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>帮助中心</span></a></dd>
			    <dd><a target="rightpanel" href="${base}/admin/content/2"><img src="${baseimg}/imgs/admin/mydocuments.gif" /><span>注册条款</span></a></dd>

		    </dl>
		</div>
	</div>
</div>
<div id="footarea">
</div>
</body>
</html>