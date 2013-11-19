[#ftl]
[#import "/WEB-INF/FtlLib/Public.ftl" as p]
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>[@s.messageArgs "title.b2cuid", [(bean.name)!] /]</title>
<meta name="Keywords" content="[@s.message "b2cuid.keyword" /]" />
<meta name="Description" content="[@s.message "b2cuid.description" /]" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/default/b2cdetail.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${basecss}/css/zoom.css" media="screen" />
<script type="text/javascript" src="${basejs}/js/zoom-1.0.0.js"></script>
<script type="text/javascript" src="${basejs}/js/jquery/cookie/jquery.cookie.js"></script>
<style type="text/css" media="screen" title="Jiazuww style">

</style>
<script type="text/javascript">
<!--
$(function(){
	$("#goleft").click(function(){
		SliderClickHandler("thumbrow",62,-1,10,false);
	});
	$("#goright").click(function(){
		SliderClickHandler("thumbrow",62,1,10,false);
	});
	$(".littlepics a").click(galleryClickHandler);
	$("a[id='btnminus']").click(btnminusClickHandler);
	$("a[id='btnplus']").click(btnplusClickHandler);
	$(".btnbuy").click(btnbuyClickHandler);
	$(".btnaddcard").click(btnaddcardClickHandler);
});

function galleryClickHandler() {
	$("#img").attr("src", $("img", this).attr("bsrc"));
	$("#largeimg").attr("src", $("img", this).attr("lsrc"));
}

function btnminusClickHandler(){
	var i = $(this).next("#txtnum").val();
	if(i-- > 1) {
		$(this).next("#txtnum").val(i)
	}
}

function btnplusClickHandler(){
	var i = $(this).prev("#txtnum").val();
	if($.isNumeric(i)) {
		i++;
	} else {
		i = 1;
	}
	$(this).prev("#txtnum").val(i)
}


function btnbuyClickHandler() {
	var i = $("#txtnum").val();
	if($.isNumeric(i)) {
	} else {
		$("#txtnum").val(1);
	}
	
}
function btnaddcardClickHandler() {
	var action = "${base}/mycart";
	$("#f_buy").attr("action", action);
	$("#f_buy").submit();
	[#if !me??]
	rememberWindowUrl();
	[/#if]
}


function windowLoadHandler() {
	$("img").each(function(){
		if (!isImageOk(this)) {
			var src404 = $(this).data("src404");
			$(this).data("src", $(this).attr("src"));
			if(typeof(src404) == "undefined") {
				//$(this).hide();
			} else if(src404 == "") {
				//$(this).addClass("hd");
			} else {
				$(this).attr("src", src404)
			}
			$(this).bind({load : function(){$(this).show();}});
		}
	});
}
//-->
</script>
</head>
<body>
<div class="mybody">
	<div class="boxs">
		<div class="widebox">
				<h2>//家族文化产品<span class="tag hd">&gt; 分类</span></h2>
				<div class="boxbody">
				<h1>${(bean.name)!}</h1>
				<div class="product">
					<div class="preview">
						<div class="bigpic">
							<div class="zoom">
							<span class="mark"></span>
							<img id="img" src="${baseimg}${(bean.galleries[0].img)!"/imgs/default/nopic.gif"}" alt="" />
							</div>
							<div class="boxbig" style="display:none;"><div class="big">
							<img id="largeimg" src="${baseimg}${(bean.galleries[0].bigimg)!"/imgs/default/nopic.gif"}" alt="" /></div></div>
						</div>
						<div class="picsbar">
							<a id="goleft" class="goleft" href="javascript:void(0)"></a>
							<div class="littlepics" style="position:relative">
							<table id="thumbrow"><tr>
							[#list bean.galleries! as item]
							<td>
							<a href="javascript:void(0)"><img bsrc="${baseimg}${item.img}" lsrc="${baseimg}${item.bigimg}" src="${baseimg}${item.thumb}" alt="" /> </a>
							</td>
							[/#list]
							</tr></table>
							</div>
							<a id="goright" class="goright" href="javascript:void(0)"></a>
						</div>
					</div>
					<div class="infobox">
						<div class="info">
						<p>商品编号：<span class="uuid">${bean.sn}</span></p>
						<p>价　　格：<span class="formerprice">${bean.marketprice}</span>元</p>
						<p>折扣价格：<span class="price">${bean.shopprice}</span>元</p>
						<p>
						<span class="left">商品评分：</span>
						<span class="scorebg"><span style="width: ${bean.rate * 12}px" class="score"></span></span><label>${bean.rate}分 | <a href="#comment">${(bean.commentscount)!0}条评价</a></label>
						</p>
						<p>已售出：${bean.sellcount}件 </p>
						</div>
						<div>
						<form id="f_buy" action="${base}/buy" method="post">
							<input name="uid" value="${(bean.uid)!}" type="hidden" />
							<p><span class="left">我要买：</span><a id="btnminus" class="goleft" href="javascript:void(0)"> </a><input id="txtnum" name="num" class="txtnum left" type="text" value="1" /><a id="btnplus" class="goright" href="javascript:void(0)"></a> </p>
							<br class="clear" /><br class="clear" />
							<p><input class="btnbuy" type="submit" value="立即购买" title="立即购买" /> <input class="btnaddcard" title="加入购物车" type="button" value="" /> </p>
						</form>
						</div>
					</div>
				</div>
				<div class="introduce">
					<h2>商品介绍</h2>
					<div>
						${bean.desc}
					</div>
				</div>
				<div id="comment" class="argue">
					<h2>商品评价</h2>
					[#if me?? || bean.comments?size != 0]
					[@p.CommenList bean.uid bean.comments /]
					[/#if]
					[@p.Pager pager /]
				</div>
				<br /><br />
				<div class="pagenum hd">
				<ul>
				<li><a class="last" href="">上一页</a></li>
				<li><a class="here" href="">1</a></li>
				<li><a class="" href="">2</a></li>
				<li><a class="" href="">3</a></li>
				<li><a class="next" href="">下一页</a></li>
				</ul>
				</div>
				</div>
		</div>
		<div class="clear"></div>
	</div>
</div>