[#ftl]
<div class="menu" style="height:280px;">
[#list b2ctxtTop as item]
	<a href="${base}/b2c/${item.uid}">${item.name}</a>
[/#list]
</div>
<div class="prods">
[#list b2cimgTop as item]
<a href="${base}/b2c/${item.uid}"><img src="${baseimg}${item.thumb}" alt="${item.name}" /><h4>${item.name}</h4></a>
[/#list]
</div>