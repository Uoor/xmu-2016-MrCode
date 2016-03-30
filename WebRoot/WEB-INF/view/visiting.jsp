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
    <title>旅游攻略</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">游玩攻略</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="list-group-no">
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height: 290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('image/visit1.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        西藏雪山
                    </div>
                    <div class="listitem-describation-body">
                        <p>白雪皑皑，绵延千里</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$200</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no" style="border:1px solid #eee;height:290px">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('image/visit2.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                       绝壁栈道
                    </div>
                    <div class="listitem-describation-body">
                        <p>要的就是心惊肉跳</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$250</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special" >
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('image/visit3.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        香山美景
                    </div>
                    <div class="listitem-describation-body">
                        <p>香山美景美如画</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$100</span>
                    </div>
                </div>
            </div>
        </a>
        <a href="#" class="list-group-item-no">
            <div class="listitem-group-decration-no decration-no-style-special">
                <div  class="listitem-image-no listitem-image-no-special" style="background-image: url('image/visit5.jpg')">
                </div>
                <div class="listitem-info-no">
                    <div class="listitem-describation-title">
                        丽江古城
                    </div>
                    <div class="listitem-describation-body">
                        <p>连丽江的海都多了几分的柔情</p>
                    </div>
                    <div class="listitem-buttom">
                        <span class="listitem-money">$300</span>
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