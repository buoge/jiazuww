[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/rule.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	
//-->
</script>
</head>
<body>
<fieldset>
	<legend class="title">${bean.title}</legend>
	<div class="container">
		${bean.content}
	</div>
</fieldset>
</body>
</html>