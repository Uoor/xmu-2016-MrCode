<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
      <title>交通指南</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
     <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">交通指南</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->巴黎
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$5000</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h2.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->厦门
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$4000</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h3.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->石家庄
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$1000</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h4.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->旧金山
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$15000</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h5.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->济南
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$2800</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_b_h6.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    北京->重庆
                </div>
                <div class="listitem-describation-body">
                    <p>飞机票</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$8000</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
