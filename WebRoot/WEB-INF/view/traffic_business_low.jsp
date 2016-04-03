<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
      <title>交通指南</title>
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
     <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">交通指南</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

  <%@ include file="header.jsp" %>

</div>
<div class="content">
    <div class="traffic-maintain">
        <i class="fa fa-train fa-2x traffic-modal"></i>
        <div class="traffic-word">
            <h3 class="traffic-title">北京-->张家口</h3>
            <span>前往北京站，硬座￥100</span>

        </div>
    </div>
    <div class="traffic-maintain">
        <i class="fa fa-train fa-2x traffic-modal"></i>
        <div class="traffic-word">
            <h3 class="traffic-title">北京-->济南</h3>
            <span>前往北京站，硬座￥200</span>

        </div>
    </div>
    <div class="traffic-maintain">
        <i class="fa fa-train fa-2x traffic-modal"></i>
        <div class="traffic-word">
            <h3 class="traffic-title">北京-->石家庄</h3>
            <span>前往北京站，硬座￥300</span>

        </div>
    </div>
    <div class="traffic-maintain">
        <i class="fa fa-train fa-2x traffic-modal"></i>
        <div class="traffic-word">
            <h3 class="traffic-title">北京-->承德</h3>
            <span>前往北京站，硬座￥200</span>

        </div>
    </div>

</div>
<%@ include file="footer.jsp" %>

</body>
</html>
