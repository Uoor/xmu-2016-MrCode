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
<title>码券列表</title>
<script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<style>
    .col-xs-2{
        padding-left: 2px;
        padding-right: 2px
    }
    .col-xs-3{
        padding-left:0px;
        padding-right: 0px
    }
    .col-xs-7{
        padding-right:5px
    }
    .list-group-item{
        padding-right:0px;
        padding-left: 0px;
    }
</style>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">码券列表</span>
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
<div class="content" >
    <div class="list-group">
        <c:forEach items="${rgMap }" var="item">
	        <div class="list-group-item ticket-item">
	            <div class="col-xs-7" >
	                <div class="ticket-name" >
	                    <span class="hotel-name">${item.key.hotel.name }</span>
	                    <span class="room-type">${item.key.typeName }</span>
	                </div>
	                <div class="ticket_order_detail" data-target="#information${item.key.id }" data-toggle="modal">
	                    <span class="">详情</span>
	                   <!--  <span class="date">有效期至<span class="available_period">2016-5-1</span></span> -->
	                </div>
	            </div>
	            <div class="col-xs-2" >
	                <div class="ticket-num-body">
	                    X<span><c:out value="${fn:length(item.value)}"></c:out></span>
	
	                </div>
	            </div>
	            <div class="col-xs-3">
	                <c:if test="${customer.perfectInformation!=1 }">
	                	<div class="ticket_order ticket-num-body" param="${item.key.id}" data-toggle="modal" onclick="updateType(this)" data-target="#myModal">
	                </c:if>
	                <c:if test="${customer.perfectInformation==1 }">
	                	<div class="ticket_order ticket-num-body toNext" param="${item.key.id}">
	                </c:if>
	                    <button class="ticket_order_now" >使用<i class="fa fa-angle-double-right hand-right-style"></i></button>
	                   </div>
	           </div>
	           <!-- 模态框（Modal） -->
		        <div class="modal fade" id="information${item.key.id }" tabindex="-1" role="dialog"
		             aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 40px;">
		            <div class="modal-dialog">
		                <div class="modal-content">
		                    <div class="modal-header">
		                        <button type="button" class="close"
		                                data-dismiss="modal" aria-hidden="true">
		                            &times;
		                        </button>
		                        <h4 class="modal-title" id="myModalLabel">
		                            酒店详情
		                        </h4>
		                    </div>
		                    <div class="modal-body modal-body-size">
		                         <c:forEach items="${item.key.pictures }" var="pic">
			                        <div class="hotel-image" style="background: url('${ctx}${pic }') center no-repeat;background-size:contain; ">
									</div>
		                        </c:forEach>
		                        <div>
		                            <span>房间类型：</span><span>${item.key.typeName }</span>
		                        </div>
		                        <div>
		                            <span>单价：</span><span>${item.key.price }</span>元
		                        </div>
		                        <!-- <div>
		                            <span>房间数：</span><span>2</span>个
		                        </div> -->
		                        <div>
		                            <span>有效期至：</span><span>2016-5-1</span>
		                        </div>
		                        <div>
		                            <span>网络：</span><span>wifi,宽带</span>
		                        </div>
		                    </div>
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
		                            <a  class="modal-right">确定</a>
		                        </button>
		                    </div>
		                </div><!-- /.modal-content -->
		            </div><!-- /.modal -->
		        </div>
	        </div>
        </c:forEach>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 200px;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        提示
                    </h4>
                </div>
                <div class="modal-body">
                    是否立即完善信息
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default">
                        <a href="javascript:;" class="modal-default toNext">否</a>
                    </button>
                    <button type="button" class="btn btn-primary">
                        <a href="${ctx }/customer/perfectInformation" class="modal-right">是</a>
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
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
<script>
	var typeId;
	
	$(".toNext").click(function(){
		if(typeof(typeId) == "undefined"){
			typeId = $(this).attr("param");
		}
		location.href="${ctx}/order/toFirst?typeId="+typeId;
	})
	function updateType(thiz){
		typeId = $(thiz).attr("param");
	}
</script>
</html>