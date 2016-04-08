<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
      <title>商品购买</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
      <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">商品购买</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group"  href="#" >
        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/good001.jpg')">
            </div>

            <div class="listitem-info">
                <div class="listitem-describation-title">
                    精致牙刷家庭套装
                </div>
                <div class="listitem-describation-body">
                    <p>著名牙刷品牌</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">20元/套</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/good002.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    健康长寿杯
                </div>
                <div class="listitem-describation-body">
                    <p>保温持久</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">88元/个</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/good003.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    浴巾毛巾两件套
                </div>
                <div class="listitem-describation-body">
                    <p>柔和不刺激</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">30元/套</span>
                </div>
            </div>
        </a>

        <a class="list-group-item"  href="#">
            <div class="listitem-image" style="background-image: url('${rctx }/image/good004.jpg')">
            </div>


            <div class="listitem-info">
                <div class="listitem-describation-title">
                    精美公主镜
                </div>
                <div class="listitem-describation-body">
                    <p>金属拉丝打造</p>
                </div>
                <div class="listitem-buttom">
                    <span class="listitem-money">26元/个</span>
                </div>
            </div>
        </a>

    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>

