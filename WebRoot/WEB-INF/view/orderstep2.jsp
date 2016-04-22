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
	            <div class="order-item room" param="${room.id }">
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
                        <a href="javascript:;" class="modal-default notDeposit">否</a>
                    </button>
                    <button type="button" class="btn btn-primary">
                        <a href="javascript:;" class="modal-right deposit">是</a>
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
                            <a href="#" class="modal-default">取消</a>
                        </button>
                        <button type="button" class="btn btn-primary" aria-hidden="true">
                            <a class="modal-right"  onclick="add_friends()">确定</a>
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
</div>
  <%@ include file="footer.jsp" %>

</body>
<script type="text/javascript">
	var room = new Array();
	var contactor = new Array();
	//提交订单
	$(".submit-now").click(function(){
		room =[];
		contactor=[];
		$(".room").each(function(){
			room.push($(this).attr("param"));
			contactor.push($(this).find(".friends_list").val());
		})
		var temp = new Array();
		for(var i in contactor){
			if(temp[contactor[i]]!=1){
				temp[contactor[i]] = 1;
			}else{
				swal("一个人只能选择一个房间");
				return false;
			}
		}
		//判断此身份证是否已订房
		var flag = true;
		$(".friends_list").each(function(){
			var cid = $(this).val();
			var thiz = this;
			$.ajax({
		    	async : false,
		    	type : "POST",
				url : "${ctx}/order/checkID?cid="+cid,
				dataType : "json",
				success : function(result) {
					if (result == "0") {
						swal($(thiz).find("option:selected").html()+"在相应时间已订房,请不要重复预订");
						flag = false;
					}
				}
		    })
			return flag;
		})
		return flag;
	})
	
	//判断此身份证是否已添加
	function isExist(){
		var id = $("#friends_idCard").val();
		var flag = false;
		$.ajax({
	    	async : false,
	    	type : "POST",
			url : "${ctx}/customer/isExist",
			dataType : "json",
			data : {
				idCard: id
			},
			success : function(result) {
				if (result == "1") {
					flag = true;
				}
			}
	    })
	    return flag;
	}
	$("#friends_idCard").blur(function(){
		if(isExist()){
			swal("此身份证已存在");
		}
	})
	
	//设置在填写了联系人的信息以后能够把信息加入到下拉框中
	function add_friends(){
	    var name=$("#friends_name").val();
	    var phone=$("#friends_phone").val();//获取手机号
	    var id = $("#friends_idCard").val();
	    if(isExist()){
	    	swal("此身份证已添加为联系人，请不要重复");
	    	return ;
	    }
	    $.ajax({
	    	async : false,
	    	type : "POST",
			url : "${ctx}/order/addContactor",
			dataType : "json",
			data : {
				name : name, phone:phone, idCard: id
			},
			success : function(result) {
				if (result == "0") {
					swal("添加失败，请重试");
				}else{
					swal("添加成功");
					$("#create_friends").modal("hide");
					$(".friends_list").append("<option value='"+result+"'>"+name+"</option>");
				}
			}
	    })
	}
	//判断此身份证是否已订房
	$(".friends_list").change(function(){
		var cid = $(this).val();
		$.ajax({
	    	async : false,
	    	type : "POST",
			url : "${ctx}/order/checkID?cid="+cid,
			dataType : "json",
			success : function(result) {
				if (result == "0") {
					alert("此用户在相应时间已订房");
				}
			}
	    })
	})
	//不在线支付押金
	$(".notDeposit").click(function(){
		location.href="${ctx}/order/toFifth?room="+room+"&contactor="+contactor;
	})
	//在线支付押金
	$(".deposit").click(function(){
		location.href="${ctx}/order/toFourth?room="+room+"&contactor="+contactor;
	})
</script>
</html>