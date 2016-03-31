<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>房间管理</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/NewGlobal.css">
    <!--提示框插件-->
    <script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
    <link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">房间管理</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

       <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="container">
        <div style="padding:0 5px 0 0;">

            <ul class="unstyled defaultlist pt20">
                <li class="f" id="send_back">
                    <a>
                        <h3>退房服务</h3>
                        <figure class="jp_icon"></figure>
                    </a>
                </li>
                <li class="h" id="clean">
                    <a>
                        <h3>清洁房间</h3>
                        <figure class="jd_icon"></figure>
                    </a>
                </li>
            </ul>
            <ul class="unstyled defaultlist">
                <li class="a">
                    <a href="purse.html">
                        <h3>商品购买</h3>
                        <figure class="hb_icon"></figure>
                    </a>

                </li>
                <li class="p" id="wash">
                    <a >
                        <h3> 衣服清洗</h3>
                        <figure class="mp_icon"></figure>
                    </a>
                </li>
            </ul>
            <ul class="unstyled defaultlist">
                <li class="t">
                    <a href="groom.html">
                        <h3>送餐服务</h3>
                        <figure class="hcp_icon"></figure>
                    </a>
                </li>

                <li class="m" id="call">
                    <a >
                        <h3> 呼叫总台</h3>
                        <figure class="wdxc_icon"></figure>
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>
   <%@ include file="footer.jsp" %>

</body>
</html>