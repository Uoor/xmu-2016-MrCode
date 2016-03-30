<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>猜你喜欢</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">猜你喜欢</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

     <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>

        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${rctx }/image/food1.jpg" alt="..." class="carsousel-image">
            </div>
            <div class="item">
                <img src="${rctx }/image/groom1.jpg" alt="..." class="carsousel-image">
            </div>
            <div class="item">
                <img src="${rctx }/image/food2.jpg" alt="..." class="carsousel-image">
            </div>
     
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- example_04 end -->
    <div class="list-group"  href="#" >

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
  <%@ include file="footer.jsp" %>

</body>
</html>