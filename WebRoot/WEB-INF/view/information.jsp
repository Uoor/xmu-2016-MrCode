<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><%@ include file="/common/common.jsp" %>
    <title>完善信息</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--bootstrap-->
    <!--设置上传图片功能-->
    <!-- 引用控制层插件样式 -->
    <link rel="stylesheet" href="${rctx }/css/zyUpload.css" type="text/css">
    <!-- 引用核心层插件 -->
    <script src="${rctx }/js/zyFile.js"></script>
    <!-- 引用控制层插件 -->
    <script src="${rctx }/js/zyUpload.js"></script>
    <!-- 引用初始化JS -->
    <script src="${rctx }/js/jq22.js"></script>
    <!--对上传图片的样式的设置-->
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
    <!--&lt;!&ndash;日期输入框&ndash;&gt;-->
    <!--<script src="js/bootstrap-datepicker.js"></script>-->
    <!--<script src="js/locales/bootstrap-datepicker.zh-CN.js"></script>-->
    <!--<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.min.css">-->
    <!--&lt;!&ndash;轮播,搜索，商品列表&ndash;&gt;-->
    <!--<link rel="stylesheet" type="text/css" href="css/yj_supply_css.css">-->
    <!--<script src="js/yj_supply.js"></script>-->
    <!--&lt;!&ndash;轮播&ndash;&gt;-->
    <!--&lt;!&ndash;前三种&ndash;&gt;-->
    <!--<script src="js/jquery.luara.0.0.1.min.js"></script>-->
    <!--&lt;!&ndash;第四种和第五种&ndash;&gt;-->
    <!--<script src="js/unslider.min.js"></script>-->


</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">完善信息</span>
        <a href="index.html"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <nav id="menu">
        <ul>
            <li class="menu-li-head"><a href="hotel.html">酒店入住 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="information.html">完善信息 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="hotel.html">房间管理 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="groom.html">猜你喜欢 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="restaurant.html">餐馆美食 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="visiting.html">游玩攻略 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="traffic.html">交通指南 <i class="fa fa-angle-double-right"></i></a></li>
            <li class="menu-li-head"><a href="aboutus.html">关于我们 <i class="fa fa-angle-double-right"></i></a></li>
        </ul>
    </nav>

</div>
<div class="content">
    <div class="aboutus-content">
        <p class="mobile choose-style-p"><i class=" mobile-special information-name">用户名：</i><span class="content-word">code-sir</span></p>
        <p class="mobile choose-style-p"><i class=" mobile-special information-name">手机号：</i><span class="content-word">18805062345</span> </p>
        <p class="mobile choose-style-p" id="choose-type"><i class=" mobile-special information-name">身份证填写：</i>
            <span class="choose-style-span"><input type="radio" class="choose-style " name="choose" checked="true" value="camera" onclick="changechoose(this)"><i class="fa fa-camera choose-style-i"></i></span>
            <span class="choose-style-span"><input type="radio" class="choose-style" name="choose" value="edit" onclick="changechoose(this)"><i class="fa fa-edit choose-style-i"></i></span>
        </p>
        <!--以下一行是显示上传的框用的是jquery的zyupload插件-->
        <form  class="form-style" action="${ctx }/customer/addInformation" method="post">
        <div id="demo" class="demo choose-camera"></div>
        <div id="choose-edit" style="margin-bottom: 50px;text-align: center;display:none">
            <div class="control-group input-top" style="margin-top:50px">
                <input type="text" class="login-in-input" placeholder="请输入身份证号">
            </div>
            <div class="control-group">
                <input type="text" class="login-in-input" placeholder="请输入姓名">
            </div>
            <div class="control-group">
                <button type="submit" class="login-now">提交</button>
            </div>
        </div>
        </form>
        <!--一下一个按钮是为了回到码券继续预定-->
        <div class="back_to_order">
            <button  class="login-now"><a class="back_order" href="orderstep1.html">继续预定</a></button>
        </div>
    </div>

</div>
<div class="footer">
    <p class="footer-bottom">
        <a href="index.html">首页</a>
        <span class="footer_vertical_line">|</span>
        <a href="groom.html">推荐</a>
        <span class="footer_vertical_line">|</span>
        <a href="management.html">管理</a>
        <span class="footer_vertical_line">|</span>
        <a href="aboutus.html">我们团队</a>

    </p>

</div>

</body>
</html>