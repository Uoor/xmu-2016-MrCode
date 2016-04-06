<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>完成订单</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">房间预订成功</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="traffic-maintain" style="text-align:center">
        <div class="traffic-word">
            <h3 class="traffic-title" style="color:#33ccff">恭喜您,房间预订成功!</h3>
            <span>已经将您的订单信息通知酒店, 为您省去酒店办理入住手续</span>

        </div>
    </div>
    <div class="traffic-maintain" style="text-align:center">
<img src="${rctx }/image/success4.png">
    </div>


</div>
  <%@ include file="footer.jsp" %>

</body>
</html>