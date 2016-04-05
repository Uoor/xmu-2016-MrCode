<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
<title>码券列表</title>
<!--提示框插件-->
<script type="text/javascript" src="${rctx }/js/xcConfirm.js"></script>
<link type="text/css" rel="stylesheet" href="${rctx }/css/xcConfirm.css">
<script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
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
</head>

<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">码券列表</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
  <%@ include file="header.jsp" %>
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
		                            <span>有效期至：</span>
		                            <c:forEach items="${item.value }" var="voucher">
		                            	<span><fmt:formatDate value="${voucher.expiredTime }" pattern="yyyy-MM-dd"/></span>
		                            </c:forEach>
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

<%@ include file="footer.jsp" %>

</body>
<script>
	var typeId;
	
	$(".toNext").click(function(){
		if(typeof(typeId) == "undefined"){
			typeId = $(this).attr("param");
		}
		location.href="${ctx}/order/toFirst?typeId="+typeId;
	});
	function updateType(thiz){
		typeId = $(thiz).attr("param");
	}
		
	//当码券列表的为0的时候就提示没有码券
	$(function(){
		var tempitem=$(".ticket-item").length;
		if(tempitem==0){
			 var txt="您还没有码券，快去团购吧！";
		     window.wxc.xcConfirm(txt,window.wxc.xcConfirm.typeEnum.info);
		}
		
	});	
</script>
</html>