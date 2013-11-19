[#ftl]
[#compress]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}[@s.message "titlesuffix" /]</title>
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseHead.ftl" /]
${head}
[#include "/WEB-INF/FtlLib/Web/BaseDecorators/BaseJs.ftl" /]
</head>
<body>
	<div class="body">
		[#include "/WEB-INF/FtlLib/Web/HeadArea.ftl" /]
		<div id="bodyarea">
			<div class="mybodybga">
			<div class="mybodybgb">
			<div class="mybody">
				${body}
			</div>
			</div>
			</div>
		</div>
		[#include "/WEB-INF/FtlLib/Web/FootArea.ftl" /]
	</div>
</body>
</html>
[/#compress]