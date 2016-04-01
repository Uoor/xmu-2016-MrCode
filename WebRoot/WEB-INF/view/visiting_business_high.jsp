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
    <div class="list-group-no">
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height: 290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/v_b_h1.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        浪漫春天
                    </div>
                    <div class="listitem-describation-body">
                        <p>不一样的尊贵享受</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$2000</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height:290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/v_b_h3.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        芙蓉私人会所
                    </div>
                    <div class="listitem-describation-body">
                        <p>尊贵服务，为您打造</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$2500</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special" >
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/v_b_h4.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        香榭私人会所
                    </div>
                    <div class="listitem-describation-body">
                        <p>香榭为您服务，只为宾至如归</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$1000</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('${rctx }/image/v_b_h2.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        帕兰朵酒吧
                    </div>
                    <div class="listitem-describation-body">
                        <p>这是一场盛宴</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$3000</span>
                    </div>
                </div>
            </div>
        </a>

    </div>
</div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
