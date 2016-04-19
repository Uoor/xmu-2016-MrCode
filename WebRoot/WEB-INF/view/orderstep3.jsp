<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>缴纳押金</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">缴纳押金</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="paying_information">
        <div class="paying_content">
        <span class="paying_title">支付押金:</span><span class="paying_num">${order.depositPrice }</span>元
        </div>
        <div class="paying_content">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">选择支付方式</h3>
                </div>
                <div class="panel-body" >
                    <a href="${ctx }/customer/alipayHandler?id=${order.id}" class="zhifubao">支付宝</a>
                </div>
                <div class="panel-body">
                    <a href="#">微信</a>
                </div>
                <div class="panel-body">
                    <a href="#">银联</a>
                </div>
            </div>
        </div>
        <div class="paying_content_word">
            <span class="paying_title">押金说明:</span>
            <p class="paying_word">此押金将作为您入住期间的保障金。押金在离店时，房间物品无损坏无丢失的情况下，抵房费后的剩余款项退还给您。</p>
        </div>
    </div>

</div>
  <%@ include file="footer.jsp" %>

</body>
</html>