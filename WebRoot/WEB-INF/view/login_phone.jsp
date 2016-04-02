<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>立即退出</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
    <link type="text/css" href="${rctx }/css/login.css"/>

</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">立即退出</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <%@ include file="header.jsp" %>
</div>
<div class="content">
    <div id="choose-edit" style="margin-bottom: 50px;text-align: center;">
        <div class="control-group input-top" style="margin-top:50px">
            <input type="text" class="login-in-input" placeholder="请输入手机号">
        </div>
        <div class="control-group">
            <input type="text" class="login-in-input login-phone-input" placeholder="请输入验证码"><button class="login_phone_num">获取验证码</button>
        </div>
        <div class="control-group login_phone_submit">
            <button type="submit" class="login-now">立即登录</button>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>