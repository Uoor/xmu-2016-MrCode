/**
 * Created by 燕晶 on 2016/3/19.
 */
//设置侧边栏
  $(function() {
        $('nav#menu').mmenu({
         /*   extensions	: [ 'effect-slide-menu', 'pageshadow' ],
            searchfield	: true,
            counters	: true,*/
            navbars		: [
                {
                    position	: 'top'
                }, {
                    position	: 'bottom',
                    content		: [ '<a href="http://mmenu.frebsite.nl">Visit website</a>' ]
                }
            ]
        });
    });
   $(function(){
       $(".mm-search").remove();
       $(".mm-title").text("首页");
       $(".mm-navbar-bottom").hide();
   });
//设置放大镜的属性
   $(function(){
	   
    $('.image_bigger').each(function(){
    	$(this).okzoom({
            width: 200,
            height: 200,
            round: true,
            background: "#fff",
            backgroundRepeat: "repeat",
            shadow: "0 0 5px #000",
            border: "1px solid black"
        });
    });
 });
//当选择的时间没有合适的房间的时候就提示重新选择时间
$(function(){
	var tempfloor=$(".hotel-floor").length;
	if(tempfloor==0){
		  var txt = "没有符合所选时间的房间，请重新选择！";
	      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	}
});
//当还没有选房的时候就把选房列表隐藏起来
$(function(){
    $("#image_bigger_div").hide();
});

