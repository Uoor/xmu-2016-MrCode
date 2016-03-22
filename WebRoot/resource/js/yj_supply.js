/**
 * Created by 燕晶 on 2016/3/2.
 */
<!---------渐隐-------->
$(document).ready(function(){
    <!--调用Luara示例-->
    $(".example").luara({width:"500",height:"334",interval:4000,selected:"seleted"});

});
<!---------渐隐 -------->

<!---------上滑-------->
$(document).ready(function(){
    <!--调用Luara示例-->
    $(".example1").luara({width:"500",height:"334",interval:5000,selected:"seleted",deriction:"top"});

});
<!---------上滑-------->

<!--------左滑-------->
$(document).ready(function(){
    <!--调用Luara示例-->
    $(".example2").luara({width:"500",height:"334",interval:4500,selected:"seleted",deriction:"left"});

});
<!---------左滑-------->

/*---------------------带左右箭头的轮播--------------------*/
$(document).ready(function(e) {
    var unslider04 = $('#b04').unslider({
            dots: true
        }),
        data04 = unslider04.data('unslider');

    $('.unslider-arrow04').click(function() {
        var fn = this.className.split(' ')[1];
        data04[fn]();
    });
});

/*---------------------带左右箭头的轮播--------------------*/
