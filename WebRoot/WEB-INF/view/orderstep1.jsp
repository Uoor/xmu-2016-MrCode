<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>选择房间</title>
    <!--引入放大镜功能所需的文件-->
    <script src='${rctx }/js/okzoom.js'></script>
    <!--提示框插件-->
    <script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">
    <script type="text/javascript" src='${rctx }/js/choose_room.js'></script>
    <style>
        .modal-open{
            overflow: scroll;
        }
        .modal-body{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">选择房间</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>
</div>
<div class="content choose-floor" >
    <div class="choose-floor-div" style="display: flex;">
        <c:forEach items="${frMap }" var="item">
	        <div class="hotel-floor col-xs-6">
	            <a type="radio" data-toggle="modal" class="choose-style " href="#show_room_${item.key.id }">
		            <span class="floor-style">
		                <i class="fa fa-building building-style"></i>
		            </span>
		            <span class="floor-num" id="f3">
		                ${item.key.floorNumber }楼
		            </span>
	            </a>
	        </div>
	        
	        <!-- 模态框展示房间 -->
	        <div class="modal fade" id="show_room_${item.key.id }" tabindex="-1" role="dialog"
	             aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 40px;position: absolute;margin-bottom: 50px">
	            <div class="modal-dialog">
	                <div class="modal-content" style=”margin-bottom:50px”>
	                    <div class="modal-header">
	                        <button type="button" class="close"
	                                data-dismiss="modal" aria-hidden="true">
	                            &times;
	                        </button>
	                        <h4 class="modal-title">
	                            房间展示
	                        </h4>
	                    </div>
	                    <div class="modal-body" class="image_bigger_contain">
	                        <div >
	                            <img id='${item.key.id }' class="image_bigger" src="${rctx }${item.key.planUrl}" >
	                        </div>
	                        <div class="click_for_bigger">
	                            <i class="fa fa-hand-o-up"></i>点击图片即可放大图片
	                        </div>
	                        <div class="paying_content">
	                            <div class="panel panel-info">
	                                <div class="panel-heading">请选择房间
	                                </div>
	                                <div class="panel-body choose-room-panel-body" >
	                                    <c:forEach items="${item.value }" var="room">
	                                    	<p class="choose-room-span col-xs-4">
	                                    		<label>
	                                    			<input type="checkbox" class="choose_room_input" value="${room.id }">
	                                    			<span class="choose-room-checkbox">${room.roomNumber }</span>	                                    			
	                                    		</label>
	                                    	</p>
	                               		</c:forEach>     
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="modal-footer">
	                        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
	                            <a class="modal-right" onclick="add_room()">确定</a>
	                        </button>
	                    </div>
	                </div><!-- /.modal-content -->
	            </div><!-- /.modal -->
	        </div>
        </c:forEach>
    </div>

    <div class="image_bigger_style" style="display: none" id="image_bigger_div">
        <div class="paying_content remember-room" id="choosen_room_list">
            <div class="panel panel-info" id="panel-body">
                <div class="panel-heading">
                    <h3 class="panel-title">已选房间</h3>
                </div>
                <!--<div class="panel-body" >-->
                    <!--<span >304</span>-->
                    <!--<span onclick="delete_room(this)"><i class="fa fa-times times-style"></i></span>-->
                <!--</div>-->
                <!--<div class="panel-body">-->
                    <!--<span >405</span>-->
                    <!--<span onclick="delete_room(this)"><i class="fa fa-times times-style"></i></span>-->
                <!--</div>-->
                <!--<div class="panel-body">-->
                    <!--<span >506</span>-->
                    <!--<span onclick="delete_room(this)"><i class="fa fa-times times-style"></i></span>-->
                <!--</div>-->
            </div>
        </div>
        <div class="control-group next_step  choose-room-next-step" id="choose-room-next-step">
            <button class="login-now" style="background-color:#33ccff"><a href="javascript:;" class="next_step_color">下一步</a></button>
        </div>
    </div>


</div>
<%@ include file="footer.jsp" %>

<script type="text/javascript">
	var ids = new Array();
	//设置选择房间页面的js
	//用来把选择的房间添加到已选房间的列表中
	function add_room(){
		ids=[];
		$("#panel-body").html('<div class="panel-heading"><h3 class="panel-title">已选房间</h3></div>');
		 
		$(":checked").each(function(){
			var temp=$(this);//获得当前的其中一个的input
			var room_number=$(this).next().html();//获得房间号
			var room_id=$(this).val();//获得房间的id值
			
			$("#panel-body").append(" <div class='panel-body' ><span class='room_value_find'>"+room_number+"</span> " +
			      "<i class='fa fa-times times-style' param='"+room_id+"' onclick='delete_number(this)'></i> </div>");
			ids.push(room_id);
		});
		var room_list=$("#panel-body").children().length;
		if(room_list>1){
			 $("#image_bigger_div").show();
		}
	}
	//用来把点击叉叉时删除房间
	function delete_number(e){
		var id = $(e).attr("param");
		alert("do");
		for(var i in ids){
			if(ids[i]==id){
				ids.splice(i, 1);
				break ;
			}
		}
		var room_number=$(e).prev().html();
		$(e).parent().remove();
		var room_list=$("#panel-body").children().length;
		if(room_list<=1){
			 $("#image_bigger_div").hide();
		}
		
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
</script>
</body>
</html>