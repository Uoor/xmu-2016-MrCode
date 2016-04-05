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



//以下是orderstep1.jsp中原来的js
var ids = new Array();
//设置选择房间页面的js
//用来把选择的房间添加到已选房间的列表中
function add_room(){
	ids=[];
	$("#panel-body").html('<div class="panel-heading"><h3 class="panel-title">已选房间</h3></div>');
	$(".choose_room_input").each(function(){
		var temp=$(this);//获得当前的其中一个的input
		var choosen=$(this).prop("checked");//判断是否被选中
		var room_number=$(this).next().html();//获得房间号
		if(choosen==true){//如果被选中的话就要判断是不是已经在已选房间中，是的话就不能添加，不是的话就要添加到已选房间中
			
			 var room_id=$(this).val();//获得房间的id值
			
			 $("#panel-body").append(" <div class='panel-body' ><span class='room_value_find'>"+room_number+"</span> " +
		        "<i class='fa fa-times times-style' param='"+room_id+"' onclick='delete_number(this)'></i> </div>");
			 ids.push(room_id);
			 
		}
	});
	var room_list=$("#panel-body").children().length;
	if(room_list>1){
		 $("#image_bigger_div").show();
	}
}
//用来把点击叉叉时删除房间
function delete_number(e){
	var id = $(e).attr("param");
	for(var i in ids){
		if(ids[i]==id){
			ids.splice(i, 1);
			return ;
		}
	}
	$(e).parent().remove();
	var room_list=$("#panel-body").children().length;
	if(room_list<=1){
		 $("#image_bigger_div").hide();
	}
	var room_number=$(e).prev().html();
	$(".choose-room-checkbox").each(function(){
		var tempnum=$(this).html();
	    if(tempnum===room_number){
	    	$(this).prev().attr("checked",false);
	    }
	});
}
$(".next_step_color").click(function(){
	if(ids.length*"${days}">"${validCount}"){
		swal("您的团购券只有${validCount}张，已选了${days}天，请重新选择房间");	
	}else{
		location.href="${ctx}/order/toThird?ids="+ids;
	}
});
