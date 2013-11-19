[#ftl]
[#compress]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}[@s.message "titlesuffix" /]</title>
[#include "/WEB-INF/FtlLib/Admin/BaseDecorators/BaseHead.ftl" /]
<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/right.css" media="screen" />
${head}
[#include "/WEB-INF/FtlLib/Admin/BaseDecorators/BaseJs.ftl" /]
</head>
<body>
	<div class="body">
		<div id="headarea">
			<div class="mybody">
			    <div class="left">${title}</div>
			    <div class="right">当前管理员：admin　<a href="${base}/admin/j_security_logout">退出</a></div>
			</div>
		</div>
		<div id="bodyarea">
			<div class="mybody">
				${body}
			</div>
		</div>
		<div id="footarea">
			<div class="mybody">
			    <div class="block">
			    <hr />
			    <p class="txtcen">Copyright www.jiazuww.com All Right Reserved家族旺旺,版权所有.</p>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>
[/#compress]