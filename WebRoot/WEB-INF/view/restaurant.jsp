<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><%@ include file="/common/common.jsp" %>
    <title>餐馆美食</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">餐馆美食</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <nav id="menu">
        <ul>
            <li class="menu-li-head"><a href="hotel.html">酒店入住 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="${ctx }/customer/perfectInformation">完善信息 <i class="fa fa-angle-double-right"></i></a></li>
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
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    香山寿司
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，观感诱人</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$20</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food2.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    清雅蛋糕
                </div>
                <div class="listitem-describation-body">
                    <p>甜而不腻，上好蛋糕</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$25</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food3.jpeg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    魔法黑森林
                </div>
                <div class="listitem-describation-body">
                    <p>好吃到无法想象</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$30</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food4.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    海派铜锣烧
                </div>
                <div class="listitem-describation-body">
                    <p>叮当猫爱上的，你也值得拥有</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$40</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food5.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    海洋餐馆
                </div>
                <div class="listitem-describation-body">
                    <p>蓝色格调，清新迷人</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$200</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/index3.jpg');margin-bottom: 50px">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    假日酒店
                </div>
                <div class="listitem-describation-body">
                    <p>专为度假准备，给你家的感觉</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$300</span>
                </div>
            </div>
        </a>

    </div>
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