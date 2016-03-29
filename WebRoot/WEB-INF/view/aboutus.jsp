<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- 系统根路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!-- 系统资源根路径 -->
<c:set var="rctx" value="${ctx }/resource"></c:set>
<!-- 系统页面根路径 -->
<c:set var="vctx" value="${ctx }/WEB-INF/view"></c:set>
<!-- 测试用jsp使用的根路径 -->
<c:set var="tctx" value="/WEB-INF/view/"></c:set>
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>关于我们</title>
  <!--   <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
    <!--bootstrap-->
    <!--设置头部-->
    
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
        <span class="header-word">关于我们</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

    <%@ include file="header.jsp" %>
</div>
<div class="content">

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>

        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${rctx }/image/2.jpg" alt="..." class="carsousel-image">

                <!--<div class="carousel-caption">-->
                <!--...-->
                <!--</div>-->
            </div>
            <div class="item">
                <img src="${rctx }/image/4.jpg" alt="..." class="carsousel-image">

                <!--<div class="carousel-caption">-->
                <!--...-->
                <!--</div>-->
            </div>
            <!--...-->
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- example_04 end -->
    <div class="aboutus-content">
        <p class="mobile"><i class="fa fa-phone mobile-special"></i><span class="content-word">18805063234</span></p>
        <p class="mobile"><i class="fa fa-envelope mobile-special"></i><span class="content-word">www.masir@qq.com</span> </p>
        <p class="mobile"><i class="fa fa-tag  mobile-special"></i><span class="content-word">厦门大学厦大学生公寓</span></p>
    </div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>