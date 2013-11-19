$(function(){
	var mouseX = 0;		//鼠标移动的位置X
	var mouseY = 0;		//鼠标移动的位置Y
	var maxLeft = 0;	//最右边
	var maxTop = 0;		//最下边
	var markLeft = 0;	//放大镜移动的左部距离
	var markTop = 0;	//放大镜移动的顶部距离
	var perX = 0;	//移动的X百分比
	var perY = 0;	//移动的Y百分比
	var bigLeft = 0;	//大图要移动left的距离
	var bigTop = 0;		//大图要移动top的距离

	//改变放大镜的位置
	function updataMark($mark){
		//通过判断，让小框只能在小图区域中移动		
		if(markLeft<0){
			markLeft = 0;
		}else if(markLeft>maxLeft){
			markLeft = maxLeft;
		}
		if(markTop<0){
			markTop = 0;
		}else if(markTop>maxTop){
			markTop = maxTop;
		}
		//获取放大镜的移动比例，即这个小框在区域中移动的比例
		perX = markLeft/$(".zoom").outerWidth();
		perY = markTop/$(".zoom").outerHeight();
		bigLeft = -perX*$(".big").outerWidth();
		bigTop = -perY*$(".big").outerHeight();
		//设定小框的位置
		$mark.css({"left":markLeft,"top":markTop,"display":"block"});
	}
	//改变大图的位置
	function updataBig(){
		$(".big").css({"display":"block","left":bigLeft,"top":bigTop});
		$(".boxbig").css({"display":"block"});
	}
	//鼠标移出时
	function cancle(){
		$(".big").css({"display":"none"});
		$(".boxbig").css({"display":"none"});
		$(".mark").css({"display":"none"});
	}
	//鼠标小图上移动时
	function imgMouseMove(event){
		var $this = $(this);
		var $mark = $(this).children(".mark");
		//鼠标在小图的位置
		mouseX = event.pageX-$this.offset().left - $mark.outerWidth()/2;
		mouseY = event.pageY-$this.offset().top - $mark.outerHeight()/2;
		//最大值
		maxLeft =$this.width()- $mark.outerWidth();
		maxTop =$this.height()- $mark.outerHeight();
		markLeft = mouseX;
		markTop = mouseY;
		updataMark($mark);
		updataBig();
	}
	$(".zoom").bind("mousemove",imgMouseMove).bind("mouseleave",cancle);
})
