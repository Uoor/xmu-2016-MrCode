<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><%@ include file="/common/common.jsp" %>
    <title>我的联系人</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--bootstrap-->
    <link type="text/css"  rel="stylesheet" href="${rctx }/css/static.css">
    <!--提示框插件-->
    <script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">

</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">我的联系人</span>
        <a href="index.html"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <nav id="menu">
        <ul>
            <li class="menu-li-head"><a href="hotel.html">酒店入住 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="information.html">完善信息 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="hotel.html">房间管理 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="groom.html">猜你喜欢 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="restaurant.html">餐馆美食 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="visiting.html">游玩攻略 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="traffic.html">交通指南 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="aboutus.html">关于我们 <i class="fa fa-angle-double-right"></i></a></li>
        </ul>
    </nav>

</div>
<div class="content">
    <div class="paying_information add_friends_list" >
        <!--<div class="paying_content">-->
            <!--<span class="paying_title">支付押金:</span><span class="paying_num">200</span>元-->
        <!--</div>-->
        <div class="paying_content" id="add_friends_list_member">
            <div class="panel panel-info" id="add_friends_list">
                <div class="panel-heading">
                    <h3 class="panel-title">联系人列表</h3>
                </div>
               <c:forEach items="${contsList}" var="contsList">
                <div class="panel-body" >
                    <i class="fa fa-pencil search-style" data-target="#rewrite_friends${contsList.id }" data-toggle="modal" ></i>
                    <span class="add_friends_name">${contsList.name }</span>
                    <a class='fa fa-times times-style' href="${ctx}/customer/delLinkman?id=${contsList.id} "></a>
                    
                    <!-- 模态框（Modal）修改联系人 -->
                    <div class="modal fade" id="rewrite_friends${contsList.id }" tabindex="-1" role="dialog"
				         aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 100px;">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close"
				                            data-dismiss="modal" aria-hidden="true">
				                        &times;
				                    </button>
				                    <h4 class="modal-title">
				                        修改联系人信息
				                    </h4>
				                </div>
				                 <form action = "${ctx }/customer/editLinkman?id=${contsList.id}" method = "post">
				                <div class="modal-body">
				                    <div class="order-item-hotel-name">
				                       <span>姓名：</span> 
				                       <input class="login-in-input add_friends_input" id="rewrite_friends_phone" name= "name" value=" ${contsList.name }">
				                    </div>
				                    <div class="order-item-hotel-name">
				                        <span class="add_friends_phone">电话：</span>
				                         <input class="login-in-input add_friends_input" id="rewrite_friends_phone" name= "phoneNumber" value=" ${contsList.phoneNumber }">
				                   
				                    </div>
				                    <div class="order-item-hotel-name">
				                        <span>证件号：</span> 
				                        <input class="login-in-input add_friends_input"  id="rewrite_friends_id" name= "identityCard" value = "${contsList.identityCard }">
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
				                        <a href="orderstep3.html" class="modal-default">取消</a>
				                    </button>
				                    <button type="submit" class="btn btn-primary"  aria-hidden="true">
				                        <a class="modal-right">确定</a>
				                    </button>
				                </div>
				                </form>
				            </div><!-- /.modal-content -->
				        </div><!-- /.modal -->
				    </div>
                </div>
               </c:forEach>
            </div>
        </div>
        <div class="control-group add_friends_now">
            <button class="login-now add_friends_now_word" data-toggle="modal" data-target="#add_friends">添加联系人</button>
        </div>
    </div>
    <!-- 模态框（Modal添加联系人 -->
    <div class="modal fade" id="add_friends" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 100px;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">
                        添加联系人
                    </h4>
                </div>
                <form action = "${ctx }/customer/addLinkman" method = "post">
                <div class="modal-body">
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="姓名" name="userName" id="friends_name"/>
                    </div>
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="电话" name="phoneNumber" id="friends_phone">
                    </div>
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="身份证" name="identityCard" id="friends_id">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                        <a href="orderstep3.html" class="modal-default">取消</a>
                    </button>
                    <button type="submit" class="btn btn-primary" id="confirm_button" >
                        	确定
                    </button>
                </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    
    
    

</div>
<div class="footer">
    <p class="footer-bottom">
        <a href="index.html">首页</a>
        <span class="footer_vertical_line">|</span>
        <a href="groom.html">推荐</a>
        <span class="footer_vertical_line">|</span>
        <a href="management.html">管理</a>
        <span class="footer_vertical_line">|</span>
        <a href="aboutus.html">我们团队</a>

    </p>

</div>
<script>

$("#friends_phone").blur(function(){
	var phone = $("#friends_phone").val();
	if(!(/^1[3|4|5|8]\d{9}$/.test(phone))){
     alert("输入的手机号格式不正确");
     $("#friends_phone").focus();
   }
})
$("#confirm_button").click(function(){
	var name = null;
	name = $("#friends_name").val();
	var phone = $("#friends_phone").val();
	var id = $("#friends_id").val();
	alert(name);
	if(name==null||typeof(name)=="undefined" || name=="")
	{
    	alert("姓名不允许为空");
    	$("#friends_name").focus();
	}
	return false;
})

</script>
</body>
</html>