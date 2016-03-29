<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>选择房间</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="/common/common.jsp" %>
    <!--引入放大镜功能所需的文件-->
    <script src='${rctx }/js/okzoom.js'></script>
    <!--提示框插件-->
    <script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">
    <!--&lt;!&ndash;日期输入框&ndash;&gt;-->
    <!--<script src="js/bootstrap-datepicker.js"></script>-->
    <!--<script src="js/locales/bootstrap-datepicker.zh-CN.js"></script>-->
    <!--<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.min.css">-->
    <!--&lt;!&ndash;轮播,搜索，商品列表&ndash;&gt;-->
    <!--<link rel="stylesheet" type="text/css" href="css/yj_supply_css.css">-->
    <!--<script src="js/yj_supply.js"></script>-->
    <!--&lt;!&ndash;轮播&ndash;&gt;-->
    <!--&lt;!&ndash;前三种&ndash;&gt;-->
    <!--<script src="js/jquery.luara.0.0.1.min.js"></script>-->
    <!--&lt;!&ndash;第四种和第五种&ndash;&gt;-->
    <!--<script src="js/unslider.min.js"></script>-->


</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">选择房间</span>
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
<div class="content choose-floor" >
    <div class="choose-floor-div">
        <c:forEach items="${frMap }" var="item">
	        <div class="hotel-floor col-xs-6">
	            <input type="radio" class="choose-style " name="choose-floor" value="floor3" onclick="know_floor(this)">
	            <span class="floor-style">
	                <i class="fa fa-building building-style"></i>
	            </span>
	            <span class="floor-num" id="f3">
	               ${item.key.floorNumber }楼
	            </span>
	        </div>
        </c:forEach>
        <div class="hotel-floor col-xs-6">
            <input type="radio" class="choose-style " name="choose-floor" value="floor4" onclick="know_floor(this)">
            <span class="floor-style">
                <i class="fa fa-building building-style"></i>
            </span>
            <span class="floor-num" id="f4">
                四楼
            </span>
        </div>
        <div class="hotel-floor col-xs-6">
            <input type="radio" class="choose-style " name="choose-floor" value="floor5" onclick="know_floor(this)">
            <span class="floor-style">
                <i class="fa fa-building building-style"></i>
            </span>
            <span class="floor-num" id="f5">
                五楼
            </span>
        </div>
        <div class="hotel-floor col-xs-6">
            <input type="radio" class="choose-style " name="choose-floor" value="floor12" onclick="know_floor(this)">
            <span class="floor-style">
                <i class="fa fa-building"></i>
            </span>
            <span class="floor-num" id="f12">
                十二楼
            </span>
        </div>
    </div>
    <div class="image_bigger_style" style="display: none" id="image_bigger_div">
        <div class="image_bigger_contain">
            <img id="image_bigger" src="image/floor3.jpg">
        </div>
        <div class="click_for_bigger">
            <i class="fa fa-hand-o-up"></i>点击图片即可放大图片
        </div>
        <div class="paying_content">
            <div class="panel panel-info">
                <div class="panel-heading">请选择房间
                </div>
                <div class="panel-body choose-room-panel-body" >
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="301" onclick="add_room(this)"><span class="choose-room-checkbox">301</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="302" onclick="add_room(this)"><span class="choose-room-checkbox">302</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="303" onclick="add_room(this)"><span class="choose-room-checkbox">303</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="304" onclick="add_room(this)"><span class="choose-room-checkbox">304</span></label></p>
                </div>
                <div class="panel-body choose-room-panel-body">
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="305" onclick="add_room(this)"><span class="choose-room-checkbox">305</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="306" onclick="add_room(this)"><span class="choose-room-checkbox">306</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="307" onclick="add_room(this)"><span class="choose-room-checkbox">307</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="308" onclick="add_room(this)"><span class="choose-room-checkbox">308</span></label></p>
                </div>
                <div class="panel-body choose-room-panel-body">
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="309" onclick="add_room(this)"><span class="choose-room-checkbox">309</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="310" onclick="add_room(this)"><span class="choose-room-checkbox">310</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="311" onclick="add_room(this)"><span class="choose-room-checkbox">311</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="312" onclick="add_room(this)"><span class="choose-room-checkbox">312</span></label></p>
                </div>
                <div class="panel-body choose-room-panel-body">
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="313" onclick="add_room(this)"><span class="choose-room-checkbox">313</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="314" onclick="add_room(this)"><span class="choose-room-checkbox">314</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="315" onclick="add_room(this)"><span class="choose-room-checkbox">315</span></label></p>
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="316" onclick="add_room(this)"><span class="choose-room-checkbox">316</span></label></p>
                </div>

                <div class="panel-body choose-room-panel-body">
                    <p class="choose-room-span col-xs-3"><label><input type="checkbox" value="317" onclick="add_room(this)"><span class="choose-room-checkbox">317</span></label></p>
                </div>
            </div>
        </div>
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
        <div class="control-group next_step  choose-room-next-step">
            <button class="login-now"><a href="orderstep2.html" class="next_step_color">下一步</a></button>
        </div>
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