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
    <script src='${rctx }/js/yj_style.js'></script>
    <!--提示框插件-->
    <script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">
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
	                <div class="modal-content">
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
	                            <img id="image_bigger" src="${rctx }/image/floor3.jpg" >
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
	                            <a class="modal-right" onclick="add_room(this)">确定</a>
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
            <button class="login-now"><a href="orderstep2.html" class="next_step_color">下一步</a></button>
        </div>
    </div>


</div>
  <%@ include file="footer.jsp" %>
</body>
</html>