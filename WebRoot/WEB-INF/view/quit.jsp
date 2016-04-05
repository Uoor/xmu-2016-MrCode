<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>我的</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
    <link type="text/css"  rel="stylesheet"  href="${rctx }/css/login.css"/>
   
</head>
 
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">我的</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <%@ include file="header.jsp" %>
</div>
<div class="content">
    <div class="aboutus-content quit_now_content">
        <p class="mobile"><i class="fa fa-pencial mobile-special"></i><span class="content-word"></span> </p>
        <p class="mobile"><i class="fa fa-tag  mobile-special"></i><span class="content-word">${userName }</span></p>
        <p class="mobile"><i class="fa fa-phone mobile-special"></i><span class="content-word">${phoneNumber }</span></p>
   
    </div>
    <form action = "${ctx }/customer/logout">
    <div class="control-group quit_now">
             <button class="login-now" type="submit">立即退出</button>
     </div>
     </form>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>