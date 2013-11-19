[#ftl]
[#compress]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>404${title}[@s.message "titlesuffix" /]</title>
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseHead.ftl" /]
${head}
<meta http-equiv="Refresh" content="600; url=${base}/" /> 
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myorder.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/jquery/cookie/jquery.cookie.js"></script>
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseJs.ftl" /]
</head>
<body>
	<div class="body">
		[#include "/WEB-INF/FtlLib/Web/HeadArea.ftl" /]
		<div id="bodyarea">
			<div class="mybodybga">
			<div class="mybodybgb">
			<div class="mybody">
				<div class="mybody">
					<div class="widebox">
					<div class="box">
						<div class="txtcen"><img src="${base}/imgs/default/404.jpg" /></div>
					</div>
					<div style="width: 70%; text-indent: 2em;">
						正在跳转到首页。。。
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
