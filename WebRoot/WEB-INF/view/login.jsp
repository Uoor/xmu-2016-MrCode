<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/common/common.jsp" %>
    <title>登录</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--设置页面的样式-->
    <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css"/>
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
        <span class="header-word">登录</span>
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
    <form class="form-style" action="${ctx }/customer/login" method="post">
        <div class="control-group input-top" style="margin-top:50px">
         <input type="text" name="loginName" class="login-in-input" placeholder="请输入手机号/邮箱/登录名">
        </div>
        <div class="control-group">
         <input type="password" name="password" class="login-in-input" placeholder="请输入密码">
        </div>
        <div class="control-group">
            <div class="wrap-words">
                <label class="check-remember fl">
                    <input type="checkbox"><span class="checkbox-word">记住账号</span>
                </label>

                    <span class="forget-password">忘记密码？</span>

            </div>
        </div>
        <div class="control-group">
            <button class="login-now" type="submit">立即登录</button>
        </div>
        <div class="control-group">
            <span class="no-login-word">还没账号？</span>
            <span class="no-login-href">立即注册</span>
        </div>
    </form>
</div>
<div class="footer">
    <p class="footer-bottom">
        <a href="${ctx }/customer/toIndex">首页</a>
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