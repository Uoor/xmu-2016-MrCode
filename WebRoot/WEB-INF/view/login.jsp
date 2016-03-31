<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>登录</title>
     <!--设置页面的样式-->
    <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css"/>
     <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">登录</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

   <%@ include file="header.jsp" %>

</div>
<div class="content">
    <form class="form-style" action="${ctx }/customer/login" method="post">
        <div class="control-group input-top" style="margin-top:50px">
         <input type="text" name="loginName" class="login-in-input" placeholder="请输入手机号/邮箱/登录名">
        </div>
        <div class="control-group">
         <input type="password" name="password" class="login-in-input" placeholder="请输入密码">
        </div>
        <div class="control-group">
            <div class="wrap-words">
                <label class="check-remember fl">
                    <input type="checkbox"><span class="checkbox-word">记住账号</span>
                </label>

                    <span class="forget-password">忘记密码？</span>

            </div>
        </div>
        <div class="control-group">
            <button class="login-now" type="submit">立即登录</button>
        </div>
        <div class="control-group">
            <span class="no-login-word">还没账号？</span>
            <span class="no-login-href">立即注册</span>
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>