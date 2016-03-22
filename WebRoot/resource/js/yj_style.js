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
//设置上传图片的样式
$(function(){
    $("#demo").attr("style","width:100%");
    $(".convent_choice").attr("style","width:50%");
    $(".filePicker").attr("style","min-width:40px");
    $(".filePicker").text("选择");
    $(".webuploader_pick").hide();//把多图片上传隐藏
})

//根据不同的选择来选择是用上传图片还是直接填写

function changechoose(e){
    var choose_value= $(e).val();
    if(choose_value=="camera"){
        $("#demo").show();
        $("#choose-edit").hide();
    }
    else{
        $("#demo").hide();
        $("#choose-edit").show();
    }
}

//设置在填写了联系人的信息以后能够把信息加入到下拉框中
function add_friends(e){
    var name=$("#friends_name").val();
    var phone=$("#friends_phone").val();
    $(".friends_list").append("<option>"+name+"</option>");
}
