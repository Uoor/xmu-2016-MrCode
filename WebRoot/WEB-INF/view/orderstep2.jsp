<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>生成订单</title>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css">
    <!--设置下拉框-->
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">生成订单</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

     <%@ include file="header.jsp" %>

</div>
<div class="content" >
    <div>
    <h3 class="create-order-title">基本信息</h3>
    <div class="create-order">
        <div class="order-item">
            <div class="order-item-hotel-name">
                <span class="order-item-title">门店:</span>
                <span class="choosen-hotel-name">${roomtype.hotel.name }</span>
            </div>
            <div class="order-item-hotel-name">
                <span class="order-item-title">房型:</span>
                <span class="choosen-hotel-name">${roomtype.typeName }</span>
            </div>
            <div class="order-item-hotel-num">
                <span clas="order-item-title">预定天数：</span>
                <span class="choosen-hotel-num">${days }</span>天
            </div>
            <div class="order-item-hotel-num">
                <span clas="order-item-title">总价：</span>
                <span class="choosen-hotel-num">${total }</span>元
            </div>
        </div>
    </div>
    </div>
    <div>
        <h3 class="create-order-title">预定信息</h3>
        <!--设置外面的虚线框-->
        <div class="create-order">
            <!--设置里面的内容-->
            <c:forEach items="${rooms }" var="room">
	            <div class="order-item">
	                <div class="order-item-hotel-name">
	                    <span class="order-item-title">房号:</span>
	                    <span class="choosen-hotel-name">${room.roomNumber }</span>
	                </div>
	                <div class="order-item-hotel-name">
	                    <span class="order-item-title">入住时间:</span>
	                    <span class="choosen-hotel-name"><fmt:formatDate value="${begin }" pattern="yyyy-MM-dd"/></span>
	                </div>
	                <div class="order-item-hotel-name">
	                    <span class="order-item-title">离房时间:</span>
	                    <span class="choosen-hotel-name"><fmt:formatDate value="${end }" pattern="yyyy-MM-dd"/></span>
	                </div>
	                <div class="order-item-hotel-name">
	                    <span class="order-item-title">选择入住人员:</span>
	                    <!--<div class="order-item-hotel-name">-->
	                        <!--<input class="login-in-input" placeholder="姓名"/>-->
	                    <!--</div>-->
	                    <!--<div class="order-item-hotel-name">-->
	                        <!--<input class="login-in-input" placeholder="电话">-->
	                    <!--</div>-->
	                    <label>
	                    <select class="friends_list">
	                        <option value="0">本人</option>
	                        <c:forEach items="${contactors }" var="contactor">
	                        	<option value="${contactor.id }">${contactor.name }</option>
	                        </c:forEach>
	                    </select>
	                    </label>
	                    <button class="create_new" data-target="#create_friends" data-toggle="modal"><i class="fa fa-plus-circle create_new_i"></i>新建</button>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
    <div class="order-submit" data-toggle="modal" data-target="#paying">
        <button class="submit-now">提交订单</button>
    </div>

    <!-- 模态框（Modal）判断是否要提交订单 -->
    <div class="modal fade" id="paying" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 200px;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        提示
                    </h4>
                </div>
                <div class="modal-body">
                    是否立即缴纳押金
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default">
                        <a href="orderstep4.html" class="modal-default">否</a>
                    </button>
                    <button type="button" class="btn btn-primary">
                        <a href="orderstep3.html" class="modal-right">是</a>
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="create_friends" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 40px;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title">
                            联系人信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="姓名" id="friends_name"/>
                        </div>
                        <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="电话" id="friends_phone">
                        </div>
                        <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="身份证号" id="friends_idCard">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                            <a href="orderstep3.html" class="modal-default">取消</a>
                        </button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
                            <a class="modal-right"  onclick="add_friends(this)">确定</a>
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
</div>
  <%@ include file="footer.jsp" %>

</body>
<script type="text/javascript">
	
	//设置在填写了联系人的信息以后能够把信息加入到下拉框中
	function add_friends(e){
	    var name=$("#friends_name").val();
	    var phone=$("#friends_phone").val();//获取手机号
	    if(name!=''){
	    $(".friends_list").append("<option>"+name+"</option>");
	    }
	}
	
</script>
</html>