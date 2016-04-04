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

//设置房间管理页面的弹窗
$(function() {

    $("#send_back").click(function () {
        var txt = "您已退房成功，请到前台确认";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    });
    $("#wash").click(function(){
        var txt="您已预订衣物清洗服务";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    });
    $("#call").click(function(){
        var txt="您已呼叫总台，请稍候";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    });
    $("#clean").click(function(){
        var txt="您已预订房间清洁服务，请稍候";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    });
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

//当选择的时间没有合适的房间的时候就提示重新选择时间
$(function(){
	var tempfloor=$(".hotel-floor").length;
	if(tempfloor==0){
     swal("没有可选的房间，请重新选择时间");	
	}
});
//当还没有选房的时候就把选房列表隐藏起来
$(function(){
    $("#image_bigger_div").hide();
});

//在点击修改联系人的时候修改模态框中的姓名
function change_name(e){
    var name=$(e).siblings("span");
    var name_val=$(name).html();//获取联系人的名字，把名字填充到模态框之中
    $("#rewrite_friends_name").html(name_val);
}

//点击添加联系人的模态框的的确定的页面的时候在页面加上一个好友
function  add_friends_2(e){
    var name_val=$("#friends_name").val();
    var num= $(".add_friends_list").children().length;//获取当前add_friends_list类的孩子元素的个数
    if(num<=2){//当前好友列表没有值的时候
        $("#add_friends_list_member").show();
    }
    if(name_val!=''){
    $("#add_friends_list").append(" <div class='panel-body'> <i class='fa fa-pencil search-style' data-target='#rewrite_friends' data-toggle='modal' onclick='change_name(this)'></i>"+
        "<span class='add_friends_name'>"+name_val+"</span> <i class='fa fa-times times-style' onclick='delete_room(this)'></i> </div>")
    }else {
        var txt="名字不能为空值";
        window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
    }

}
//用来删除联系人
function delete_room(e){
    var room=$(e).parent();
    var room_val=$(e).siblings().html();//获得删除的房间的房间号
    $(room).remove();//把这个房间号从列表中删除
    var choosen_room_num= $("#panel-body").children().length;//判断房间数量是不是小于等于1，是的话隐藏房间列表
    if(choosen_room_num<=1){
        $("#choosen_room_list").hide();
    }
    var temp_room_num=$(".choose-room-checkbox").size();//获得当前页面的房间的数量
    for(var i=0;i<temp_room_num;i++){  //找到和删除的元素的值相同的checkbox让他的勾消失，使用户能够重新选择
        var tempobject=$(".choose-room-checkbox").eq(i);
        var tempvalue=tempobject.html();
        if(tempvalue==room_val){
          var inputobject=  $(tempobject).siblings();
            $(inputobject).attr("checked",false);
        }
    }

    var choosen_friends_num= $("#add_friends_list").children().length;//判断房间数量是不是小于等于1，是的话隐藏房间列表
    if(choosen_friends_num<=1){
        $("#add_friends_list_member").hide();
    }
}
