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
                <div class="panel-body" >
                    <i class="fa fa-pencil search-style" data-target="#rewrite_friends" data-toggle="modal" onclick="change_name(this)"></i>
                    <span class="add_friends_name">张三</span>
                    <i class='fa fa-times times-style' onclick='delete_room(this)'></i>
                </div>
                <div class="panel-body">
                    <i class="fa fa-pencil search-style" data-target="#rewrite_friends" data-toggle="modal" onclick="change_name(this)"></i>
                    <span class="add_friends_name">莱斯</span>
                    <i class='fa fa-times times-style' onclick='delete_room(this)'></i>
                </div>
                <div class="panel-body">
                    <i class="fa fa-pencil search-style" data-target="#rewrite_friends" data-toggle="modal" onclick="change_name(this)"></i>
                    <span class="add_friends_name">李四</span>
                    <i class='fa fa-times times-style' onclick='delete_room(this)'></i>
                </div>
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
                <div class="modal-body">
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="姓名" id="friends_name"/>
                    </div>
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="电话" id="friends_phone">
                    </div>
                    <div class="order-item-hotel-name">
                        <input class="login-in-input" placeholder="身份证" id="friends_id">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                        <a href="orderstep3.html" class="modal-default">取消</a>
                    </button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
                        <a class="modal-right"  onclick="add_friends_2(this)">确定</a>
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <!-- 模态框（Modal）修改联系人 -->
    <div class="modal fade" id="rewrite_friends" tabindex="-1" role="dialog"
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
                <div class="modal-body">
                    <div class="order-item-hotel-name">
                       <span>姓名：</span> <span  id="rewrite_friends_name">张三</span>
                    </div>
                    <div class="order-item-hotel-name">
                        <span class="add_friends_phone">电话：</span> <input class="login-in-input add_friends_input" placeholder="18805606123" id="rewrite_friends_phone">
                    </div>
                    <div class="order-item-hotel-name">
                        <span>证件号：</span> <input class="login-in-input add_friends_input" placeholder="43534645645687852355" id="rewrite_friends_id">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                        <a href="orderstep3.html" class="modal-default">取消</a>
                    </button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
                        <a class="modal-right">确定</a>
                    </button>
                </div>
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

</body>
</html>