[#ftl]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.message "title.myhome" /]</title>
<meta name="Keywords" content="[@s.message "myhome.keyword" /]" />
<meta name="Description" content="[@s.message "myhome.description" /]" />
<script type="text/javascript" src="${basejs}/js/pages/myzupu-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/tree/jquery.treeview.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/tree/jquery.treeview.edit.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/tree/jquery.treeview.async.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<!--[if lt IE 9]>
<script src="${basejs}/js/excanvas.js">//</script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/myzupu.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/jquery/tree/jquery.treeview.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/jquery/ui/jquery.ui.base.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/jquery/ui/jquery.ui.theme.css" media="screen" />
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
	$(function(){
		initTree();
		$("#btnadd").click(function(){$("#hdaction").val("add")});
		$("#btndel").click(function(){$("#hdaction").val("del")});
		$("#btnmodify").click(function(){$("#hdaction").val("edit")});
		$("#btnsave").click(function(){$("#hdaction").val("save")});
		$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
		$(".datepicker").datepicker({
			yearRange : "c-90:c+1",
            changeMonth: true,
            changeYear: true
        });
        draw();
	});
	
	function initTree() {
		$("#tree").treeview({
			url: "${base}/api/myhome/${currUid}/zupu",
			ajax: {
				data: {
					"action": function() {
						return "init";
					}
				},
				type: "post",
				error:ajaxErrorHandler,
				complete:ajaxCompleteHandler
			}
		});
	}
	
	function ajaxErrorHandler(XMLHttpRequest, textStatus, errorThrown) {
		alert(textStatus);
		alert(errorThrown);
	}
	var curr;
	function ajaxCompleteHandler() {
		curr = $("#root");
		$("#tree li span").click(function() {
			$("#hdselected").val($(this).parent("li").attr("id"));
			if(curr != null) {
				curr.removeClass("here");
			}
			curr = $(this);
			$(this).addClass("here");
		});
		$("#root").click(function() {
			$("#hdselected").val($(this).parent("li").attr("id"));
			if(curr != null) {
				curr.removeClass("here");
			}
			curr = $(this);
			$(this).addClass("here");
		});
		
	}
	
	function draw() {
		var canvas = document.getElementById('cv');
		canvas.setAttribute("width", $(".tree ul").width());
		canvas.setAttribute("height", $(".tree ul").height());
		if (typeof(G_vmlCanvasManager) != 'undefined') { // ie IE
			G_vmlCanvasManager.initElement(canvas);
        }
		if (canvas.getContext){
			var ctx = canvas.getContext('2d');
			
			var cvleft = $("#cv").offset().left;
			var cvtop = $("#cv").offset().top;
			$("[data-p]").each(function(){
				var p = $(this).data("p");
				if(p != null && p != "ancestor") {
					var centop_x = $(this).offset().left - cvleft + $(this).width() / 2;
					var centop_y = $(this).offset().top - cvtop;
					var p_x = $("#" + p).offset().left - cvleft + $("#" + p).width() / 2;
					var p_y = $("#" + p).offset().top - cvtop + $("#" + p).height();
					ctx.beginPath();
					ctx.arc(centop_x, centop_y,3,0,Math.PI*2,true);
					ctx.fill();
					ctx.beginPath();
					ctx.moveTo(centop_x, centop_y);
					ctx.lineTo(p_x, p_y);
					ctx.stroke();
					
				}
			});
			
		}
	}
//-->
</script>
</head>
<body>
[#if admintype! > 0]
<div class="block">
	[#if msg??]<span class="red">${msg}</span>[/#if]
	<h2>我要管理家族谱：(请先选中左侧某一辈级，然后可编辑/删除当前辈级，或在当前节点下添加子辈)</h2>
	<div class="editblock">
		<div class="left">
			<ul class="treebox">
				<li class="hasChildren collapsable lastCollapsable"><span id="root" class="here">祖先</span>
					<ul id="tree">
						<li><span class="placeholder">&nbsp;</span></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="right">
			<form id="f_zupu" action="${base}/myhome/${currUid}/zupu" method="post" enctype="multipart/form-data">
			[#if editbean??]
				<input id="hduid" name="uid" value="${(editbean.uid)!}" type="hidden">
			[/#if]
			<input id="hdselected" name="selecteduid" value="root" type="hidden">
			<input id="hdaction" name="action" value="" type="hidden">
			<input id="hdgender" name="gender" value="1" type="hidden">
			<input id="hdgender2" name="gender2" value="0" type="hidden">
			<table class="left">
				<thead>
					<tr>
						<td colspan="2">男士</td>
					</tr>
				</thead>
				<tbody>
				<tr class="hd">
					<td class="txtrgt">会员ID：</td><td><input id="txtuseruid" class="txtwidth150" name="useruid" value="${(editbean.useruid)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">姓名：<span class="red">*</span></td><td><input id="txtname" maxlength="4" class="txtwidth150" name="name" value="${(editbean.name)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">生日：</td><td><input id="txtbirthday" class="txtwidth150 datepicker" maxlength="10" name="birthday" value="${(editbean.birthday)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">生平：</td>
					<td><textarea id="txtintroduce" style="height:39px; width:150px;" maxlength="150" name="introduce">${(editbean.introduce)!}</textarea></td>
				</tr>
				<tr>
					<td class="txtrgt">头像：</td><td><input id="file" class="file" type="file" name="file" />
					<br /><img src="${baseimg}${(editbean.avatar)!}" style="width:40px; height:40px;" />(80像素x80像素)
					</td>
				</tr>
				<tr>
					<td class="txtrgt">状态：</td>
					<td>
					<input id="exist" onclick="$('#dierow').addClass('hd');$('#dierow input').val('');" name="status" checked="checked" value="1" type="radio" class="radio"><label for="exist">在世</label>
					<input id="away" onclick="$('#dierow').removeClass('hd')" name="status" [#if (editbean.status)! == 0] checked="checked" [/#if] value="0" type="radio" class="radio"><label for="away">已故</label>
					</td>
				</tr>
				<tr id="dierow" class="[#if !(editbean.dieday)?? || editbean.dieday?length == 0]hd[/#if]">
					<td class="txtrgt">去世日期：</td>
					<td>
					<input id="txtdieday" class="txtwidth150 datepicker" maxlength="10" name="dieday" value="${(editbean.dieday)!}" type="text" />
					</td>
				</tr>
				<tr>
					<td class="txtcen" colspan="2">
						
					</td>
				</tr>
				</tbody>
			</table>
			<table class="right">
				<thead>
					<tr>
						<td colspan="2">女士</td>
					</tr>
				</thead>
				<tbody>
				<tr class="hd">
					<td class="txtrgt">会员ID：</td><td><input id="txtuseruid2" class="txtwidth150" name="useruid2" value="${(editbean.useruid2)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">姓名：<span class="red">*</span></td><td><input id="txtname2" maxlength="4" class="txtwidth150" name="name2" value="${(editbean.name2)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">生日：</td><td><input id="txtbirthday2" class="txtwidth150 datepicker" maxlength="10" name="birthday2" value="${(editbean.birthday2)!}" type="text" /></td>
				</tr>
				<tr>
					<td class="txtrgt">生平：</td>
					<td><textarea id="txtintroduce2" style="height:39px; width:150px;" maxlength="150" name="introduce2">${(editbean.introduce2)!}</textarea></td>
				</tr>
				<tr>
					<td class="txtrgt">头像：</td><td>
					<input id="file2" class="file" type="file" name="file2" />
					<br /><img src="${baseimg}${(editbean.avatar2)!}" style="width:40px; height:40px;" />(80像素x80像素)
					</td>
				</tr>
				<tr>
					<td class="txtrgt">状态：</td>
					<td>
					<input id="exist2" onclick="$('#dierow2').addClass('hd');$('#dierow2 input').val('');" name="status2" checked="checked" value="1" type="radio" class="radio"><label for="exist2">在世</label>
					<input id="away2" onclick="$('#dierow2').removeClass('hd')" name="status2" [#if (editbean.status2)! == 0] checked="checked" [/#if] value="0" type="radio" class="radio"><label for="away2">已故</label>
					</td>
				</tr>
				<tr id="dierow2" class="[#if !(editbean.dieday2)?? || editbean.dieday2?length == 0]hd[/#if]">
					<td class="txtrgt">去世日期：</td>
					<td>
					<input id="txtdieday2" class="txtwidth150 datepicker" maxlength="10" name="dieday2" value="${(editbean.dieday2)!}" type="text" />
					</td>
				</tr>
				<tr>
					<td class="txtcen" colspan="2">
						
					</td>
				</tr>
				</tbody>
			</table>
			<br /><br />
			<div class="txtrgt">
				[#if editbean??]
				<input id="btncancel" class="btn2 btn" type="button" onclick="gourl('${base}/myhome/${currUid}/zupu')" value="取消">
				<input id="btnsave" class="btn2 btn" type="submit" value="保存">
				[#else]
				<input id="btnmodify" class="btn2 btn" type="submit" value="编辑">
				<input id="btnadd" class="btn2 btn" type="submit" value="添加">
				<input id="btndel" class="btn3 btn" type="submit" value="删除">
				[/#if]
			</div>
			</form>
		</div>
	</div>
</div>
[/#if]
<br /><br />
<div class="block">
	<h2>家族谱：
	<a href="${base}/html/${currUid}/zupu" target="_blank">查看所有</a>&nbsp;&nbsp;&nbsp;
	<a href="http://www.jiazuww.com/b2c/c115d517ab0c476bb8c6735d48e1684c" target="_blank">我需要设计族徽</a>&nbsp;&nbsp;&nbsp;
	<a href="http://www.jiazuww.com/b2c/52a342b3a98445e7881e5379365f3e18" target="_blank">我需要制作族谱</a>&nbsp;&nbsp;&nbsp;
	<a href="http://www.jiazuww.com/b2c/5d1af939f44d4381908e197288818938" target="_blank">我需要毛笔字族训</a>
	</h2>
	<div class="container">
		<div class="content">
			<div class="sliderbar hd"><p>${(zupu.name)!}的家族谱</p></div>
			<div class="article hd">
				<h3 class="">族训：${(zupu.brief)!}</h3>
				<img src="${baseimg}${(zupu.logo)!}" alt="家族标" />
				<span class="summary">
				   <p>${(zupu.desc)!}</p>
				</span>
			</div>
			
			<div class="tree" style="display:block; width:750px; overflow: auto; overflow-y:hidden">
				<canvas id="cv" class="" width="9999px" ></canvas>
				${resphtml}
			</div>
<script type="text/javascript">
<!--
	$(function(){
		$(".tree").height($(".tree").children().height() + 200);
		resetLeftBranchWidth();
		resetRightBranchWidth();
	});
-->
</script>
			</div>
	</div>
</div>

</body>
</html>