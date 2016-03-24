<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="/common/common.jsp" %>
<title>码团——酒店入住系统</title>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">

<link type="text/css" rel="stylesheet" href="${rctx }/css/index.css" />
<script type="text/javascript" src="${rctx }/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${rctx }/js/g.base.js"></script>
<script type="text/javascript" src="${rctx }/js/iscroll.js"></script>

<script type="text/javascript">
    var myScroll;
    function loaded() {
        myScroll = new iScroll('wrapper', {
            snap: true,
            momentum: false,
            hScrollbar: false,
            onScrollEnd: function() {
                document.querySelector('#indicator > li.active').className = '';
                document.querySelector('#indicator > li:nth-child(' + (this.currPageX + 1) + ')').className = 'active';
            }
        });
    }
    document.addEventListener('DOMContentLoaded', loaded, false);
    $(function(){

    })
</script>

</head>

<body>
<header class="header" style="height:30%">
    <div class="banner">
        <div id="wrapper" style="overflow: hidden; ">
            <div id="scroller">
                <ul id="thelist">
                    <li><p></p><a href="#"><img src="${rctx }/image/index1.jpg" /></a></li>
                    <li><p></p><a href="#"><img src="${rctx }/image/index2.jpg" /></a></li>
                    <li><p></p><a href="#"><img src="${rctx }/image/index3.jpg" /></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="nav">
        <div id="prev" onClick="javascript:myScroll.scrollToPage('prev', 0);"></div>
        <ul id="indicator">
            <li class="active"></li>
            <li ></li>
            <li ></li>
        </ul>
        <div id="next" onClick="javascript:myScroll.scrollToPage('next', 0, 400, 2);"></div>
    </div>
    <div class="clr"></div>
</header>
<script>
    var count = document.getElementById("thelist").getElementsByTagName("img").length;
    for (i = 0; i < count; i++) {
        document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:" + document.body.clientWidth + "px";
    }
    document.getElementById("scroller").style.cssText = " width:" + document.body.clientWidth * count + "px";
    setInterval(function() {
        myScroll.scrollToPage('next', 0, 400, count);
    }, 3500);
    window.onresize = function() {
        for (i = 0; i < count; i++) {
            document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:" + document.body.clientWidth + "px";
        }
        document.getElementById("scroller").style.cssText = " width:" + document.body.clientWidth * count + "px";
    };
</script>
<div class="content" style="height:50%">
    <a href="hotel.html">
        <div class="img" style="background:url(${rctx }/image/13809673822754.png) center no-repeat; background-size:contain;"></div>
        <div class="text">酒店入住</div>
    </a>
    <a href="${ctx }/customer/addLinkman">
    <div class="img" style="background:url(${rctx }/image/13809674805918.png) center no-repeat; background-size:contain;"></div>
    <div class="text">完善信息</div>
    </a>
    <a href="groom.html">
    <div class="img" style="background:url(${rctx }/image/13809674461949.png) center no-repeat; background-size:contain;"></div>
    <div class="text">猜你喜欢</div>
    </a>
    <a href="management.html">
        <div class="img" style="background:url(${rctx }/image/13809674319154.png) center no-repeat; background-size:contain;"></div>
        <div class="text">房间管理</div>
    </a>
    <a href="restaurant.html">
    <div class="img" style="background:url(${rctx }/image/13809674157426.png) center no-repeat; background-size:contain;"></div>
    <div class="text">餐馆美食</div>
    </a>
    <a href="visiting.html">
    <div class="img" style="background:url(${rctx }/image/13809673974739.png) center no-repeat; background-size:contain;"></div>
    <div class="text">游玩攻略</div>
    </a>
    <a href="traffic.html">
        <div class="img" style="background:url(${rctx }/image/13809674651404.png) center no-repeat; background-size:contain;"></div>
        <div class="text">交通指南</div>
    </a>
    <a href="aboutus.html">
        <div class="img" style="background:url(${rctx }/image/13809674974016.png) center no-repeat; background-size:contain;"></div>
        <div class="text">关于我们</div>
    </a>
    </div>
<div class="footer" style="position:absolute;bottom:0;width:100%;">
    <p class="footer-top">&COPY;码先生团队</p>
    <p class="footer-bottom">
        <a href="${ctx }/customer/toIndex">首页</a>
        <span class="footer_vertical_line">|</span>
        <a href="groom.html">推荐</a>
        <span class="footer_vertical_line">|</span>
        <a href="management.html">管理</a>
        <span class="footer_vertical_line">|</span>
        <a href="aboutus.html">我们团队</a>

    </p>
    <p class="footer-bottom">
        <span class="foot_fix_"></span>
    </p>
</div>
</body>
</html>