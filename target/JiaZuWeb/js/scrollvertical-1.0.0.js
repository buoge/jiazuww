/**
 * Description:This is a javascript for the scroll notice
 * author:architect.bian QQ:993017535 TEL：15300128809
 * creation time:2012-09-05
 * location:webbio.cn
 */

function scrollup(strobj,lh,speed,delay,strheadobj,arrheadtitle)
{
    var move=true;
    var t;//temp
    var sh;//standardheight
    var obj=document.getElementById(strobj);
    obj.innerHTML+=obj.innerHTML;
    obj.style.marginTop=0;
    if(strheadobj!=null)
    {
        var headobj = document.getElementById(strheadobj);
    }
    else
    {
        var headobj = null;
    }
    obj.onmouseover=function(){move=false;}
    obj.onmouseout=function(){move=true;}

    function start()
    {
        sh = obj.offsetHeight;
        obj.style.height = sh;
        //解决浏览器的标准问题
        if(move)
        {
            obj.style.marginTop=parseInt(obj.style.marginTop)-1+"px";//每次移动的像素，值越小越平滑越慢
            if(headobj!=null)
            {
                if(headobj.innerText==arrheadtitle[0])
                {
                    headobj.innerText=arrheadtitle[1];
                }
                else
                {
                    headobj.innerText=arrheadtitle[0];
                }
            }
        }
        t=setInterval(scrolling,speed);
    }

    function scrolling()
    {
        if(parseInt(obj.style.marginTop)%lh!=0)
        {
            obj.style.marginTop=parseInt(obj.style.marginTop)-1+"px";//每次移动的像素，值越小越平滑越慢
            if(Math.abs(parseInt(obj.style.marginTop))>=sh/2) obj.style.marginTop=0;
        }
        else
        {
            if(Math.abs(parseInt(obj.style.marginTop))>sh/2) obj.style.marginTop=0;
            clearInterval(t);
            setTimeout(start,delay);
        }
    }
    setTimeout(start,delay);
}