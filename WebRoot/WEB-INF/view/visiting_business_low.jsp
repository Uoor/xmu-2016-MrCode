<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>旅游攻略</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">旅行攻略</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_b_l1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    蓝天大卖场
                </div>
                <div class="listitem-describation-body">
                    <p>这里的东西很全，很实惠</p>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_b_l2.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    汇源卖场
                </div>
                <div class="listitem-describation-body">
                    <p>这里的东西很全，很实惠</p>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_b_l3.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    园玉宇卖场
                </div>
                <div class="listitem-describation-body">
                    <p>这里的东西很全，很实惠</p>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_b_l4.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    手机大卖场
                </div>
                <div class="listitem-describation-body">
                    <p>这里的东西很全，很实惠</p>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_b_l5.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    元门关
                </div>
                <div class="listitem-describation-body">
                    <p>环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$30</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_v_l2.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    青山公园
                </div>
                <div class="listitem-describation-body">
                    <p>空气清新，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">免费</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
