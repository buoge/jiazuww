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
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/commonstyle.css" media="screen" />

<link rel="stylesheet" type="text/css" href="${basecss}/css/admin/login.css" media="screen" />
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
	forbiddenIframe();
//-->
</script>
</head>
<body bgproperties="fixed">
<div id="headarea"></div>
<div id="bodyarea">
<div class="mybody">
	<div class="login">
        <div class="left"></div>
        <div class="right">
        [#if SPRING_SECURITY_LAST_EXCEPTION??]
        <div class="errlogin">用户名或密码错误！</div>
        [/#if]
        <form id="f_login" action="${base}/admin/j_security_check" method="post">
            <ul>
            <li><label for="txtusername">用户名：</label><input id="txtusername" name="j_username" style="width:240px;" type="text" value=""  /></li>
            <li><label for="txtpwd">密　码：</label><input id="txtpwd" name="j_password" type="password" style="width:240px;" value=""  /></li>
            <li><input class="btn1 mlft150" type="submit" value="登录"/></li>
            </ul>
         </form>
        </div>
    </div>
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
</body>
</html>