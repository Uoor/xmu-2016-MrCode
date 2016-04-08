<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
      <title>送餐服务</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
      <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">送餐服务</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    日式料理虾籽卷
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">10元/份</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food2.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    港式嫩滑芒果布丁
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">18元/份</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food3.jpeg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    香草森林蛋糕
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">10元/份</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/food4.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    卡卡颂
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">16元/份</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/cookie3.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    夏日风情金桔柠檬
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">30元/份</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/cookie5.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    世界杯首胜啤酒
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">40元/扎</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>

