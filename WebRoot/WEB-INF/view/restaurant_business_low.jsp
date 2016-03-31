<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
      <title>美食诱惑</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
      <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">美食诱惑</span>
        <a href="index.html"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group-no">
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height: 290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/r_b_l1.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                       八婆婆
                    </div>
                    <div class="listitem-describation-body">
                        <p>好吃，停不下</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$20</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height:290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/r_b_l3.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        乐烤鱼
                    </div>
                    <div class="listitem-describation-body">
                        <p>好吃，停不下</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$40</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special" >
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/r_b_l4.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        陌陌闽菜馆
                    </div>
                    <div class="listitem-describation-body">
                        <p>好吃，停不下</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$50</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/r_b_l2.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        小鱼川菜馆
                    </div>
                    <div class="listitem-describation-body">
                        <p>好吃，停不下</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$80</span>
                    </div>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
