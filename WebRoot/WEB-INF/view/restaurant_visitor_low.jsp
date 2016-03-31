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
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_v_l1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    者者斋
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">￥60</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_v_l2.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    天天大排档
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$50</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_v_l3.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    妈妈乡
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$20</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_v_l4.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    冒菜馆
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$20</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_v_l5.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    阿姨家
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$30</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_b_l2.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    小明家
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$25</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>

