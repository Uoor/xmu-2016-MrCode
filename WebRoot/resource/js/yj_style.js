/**
 * Created by 燕晶 on 2016/3/19.
 */
//在是IPhone5的时候隐藏码先生
    window.onload = function()
    {
       var pheight= document.documentElement.clientHeight;
        if(pheight<=600){
            $(".footer-top").hide();
        }
    }
//设置侧边栏
    $(function() {
        $('nav#menu').mmenu({
            extensions	: [ 'effect-slide-menu', 'pageshadow' ],
            searchfield	: true,
            counters	: true,
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


//根据不同的选择来选择是用上传图片还是直接填写

function changechoose(e){
    var choose_value= $(e).val();
    if(choose_value=="camera"){
        $("#choose-picture").show();
        $("#choose-edit").hide();
    }
    else{
        $("#choose-picture").hide();
        $("#choose-edit").show();
    }
}

//设置在填写了联系人的信息以后能够把信息加入到下拉框中
function add_friends(e){
    var name=$("#friends_name").val();
    var phone=$("#friends_phone").val();
    $(".friends_list").append("<option>"+name+"</option>");
}

//设置房间管理页面的弹窗
$(function() {

    $("#send_back").click(function () {
        var txt = "您已退房成功，请到前台确认";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    });
    $("#wash").click(function(){
        var txt="您已预订衣物清洗服务";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    })
    $("#call").click(function(){
        var txt="您已呼叫总台，请稍候";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    })
    $("#clean").click(function(){
        var txt="您已预订房间清洁服务，请稍候";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    })
});


//设置放大镜的属性
$(function(){
    $('#image_bigger').okzoom({
        width: 200,
        height: 200,
        round: true,
        background: "#fff",
        backgroundRepeat: "repeat",
        shadow: "0 0 5px #000",
        border: "1px solid black"
    });
});

