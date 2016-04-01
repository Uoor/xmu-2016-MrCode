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
        <a href="index.html"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_v_h1.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    烟岚度
                </div>
                <div class="listitem-describation-body">
                    <p>景色迷人，令人流连忘返</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$300</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_v_h2.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    揽月溪
                </div>
                <div class="listitem-describation-body">
                    <p>景色迷人，令人流连忘返</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$350</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_v_h3.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    缕月云开
                </div>
                <div class="listitem-describation-body">
                    <p>景色迷人，令人流连忘返</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$400</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/v_v_h4.jpg')">
            </div>
            <div class="listitem-info">
                <div class="listitem-describation-title">
                    山高水长
                </div>
                <div class="listitem-describation-body">
                    <p>景色迷人，令人流连忘返</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$400</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_v_h1.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    琼楼玉宇
                </div>
                <div class="listitem-describation-body">
                    <p>风景秀丽，江山大好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$200</span>
                </div>
            </div>
        </a>
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/t_v_h2.jpg');margin-bottom: 50px">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    云踪
                </div>
                <div class="listitem-describation-body">
                    <p>风景秀丽，江山大好</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">$250</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
