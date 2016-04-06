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
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_b_h1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    森隆饭庄
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享880/位</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_b_h2.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                   聚贤楼
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享1080/位</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_b_h3.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    凯旋西餐厅
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享880/位</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/r_b_h4.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    龙门阵饭庄
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享999/位</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/h_v_h_1.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    美丽园
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享888/位</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/h_v_h_2.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    齐天楼
                </div>
                <div class="listitem-describation-body">
                    <p>味道很棒，环境很好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">奢华尊享800/位</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
