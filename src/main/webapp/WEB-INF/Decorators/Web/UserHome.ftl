[#ftl]
[#compress]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}[@s.message "titlesuffix" /]</title>
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseHead.ftl" /]
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myhome.css" media="screen" />
${head}
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseJs.ftl" /]
<script type="text/javascript">
<!--
	$(function(){
		toggleMenu("#homemenu a");
		$("#homemenu a").click(function(){
			window.name = 360;
			});
		resetScrollHeight();
	});
//-->
</script>
</head>
<body>
	<div class="body">
		[#include "/WEB-INF/FtlLib/Web/HeadArea.ftl" /]
		<div id="bodyarea">
			<div class="mybodybga">
			<div class="mybodybgb">
			<div class="mybody">
				<div class="widebox">
					[#include "/WEB-INF/FtlLib/Web/HomeDecoratorsLib/TopBox.ftl" /]
					<div class="bodybox">
						<h1>会员中心
						<form id="f_search" action="${base}/myhome/search" method="get" style="display:inline;">
						<p>家族搜索：<input class="long" name="s" value="${searchtext!}" type="text" /> <input class="btnwhite" type="submit" value="搜索" /> </p>
						</form>
						</h1>
						<div class="menu2">
						<ul>
						<li><h3>我的家族：</h3></li>
						[#list jiazuList! as item]
						<li><a [#if item.uid == currUid!user.groupuid] class="here" [/#if] href="${base}/myhome/${item.uid}">${item.name}</a></li>
						[/#list]
						</ul>
						</div>
						<div class="menu2bottom"></div>
						[#include "/WEB-INF/FtlLib/Web/HomeDecoratorsLib/MyMenu.ftl" /]
						<div class="mycontainer">
							${body}
							<br />
							<br />
							<br />
						</div>
					</div>
				</div>
			</div>
			</div>
			</div>
		</div>
		[#include "/WEB-INF/FtlLib/Web/FootArea.ftl" /]
	</div>
</body>
</html>
[/#compress]