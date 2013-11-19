[#ftl]
<!--[if IE 6]>
  <script type="text/javascript" src="${basejs}/js/png/DD_belatedPNG_0.0.8a-min.js"></script>
  <script>
    DD_belatedPNG.fix('div,img,a,ul,li,p,input,h1,h2,h3,h4,h5,span');
    //设置hover属性
  </script>
  
<![endif]-->
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		scrollup("scrollnotice",30,8,8000,null,null);
		
		$("#addbookmarkhref").click(function(){
			try {
				window.external.addFavorite('http://www.jiazuww.com/','家族旺旺');
			} catch(e) {}
			return false;
		});
		$("#sethomehref").click(function(){
			try {
				this.style.behavior='url(#default#homepage)';
				this.setHomePage('http://www.jiazuww.com/');
			} catch(e) {}
			return false;
		});
		
		initPageVariables();
	});
	
	function initPageVariables() {
		var msg = "${alertmsg!}";
		if(msg != "") {
			alert(msg);
		}
	}
//-->
</script>