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

<meta charset="utf-8"/>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- common js -->
<script src="${rctx }/js/jquery-2.1.3.min.js"></script>
<script src="${rctx }/js/bootstrap.min.js"></script>
<script src="${rctx }/js/check.js"></script>
<script src="${rctx }/js/cookie.js"></script>
<%-- <script src="${rctx }/js/media.js"></script> --%>
<script src="${rctx }/js/jquery.mmenu.min.all.js"></script>
<%-- <script src="${rctx }/js/yj_style.js"></script><!--关于删除和选择房间的js也在这个文件里面--> --%>

<%-- <script src="${rctx }/js/bootstrap-datepicker.js"></script> --%>
<!-- common css -->
<link rel="stylesheet" href="${rctx }/css/common/bootstrap.min.css"/> <!-- 影响百度地图api的地图的label显示  -->
<link rel="stylesheet" href="${rctx }/css/common/font-awesome.min.css"/>
<link rel="stylesheet" href="${rctx }/css/common/font.css"/>
<link rel="stylesheet" href="${rctx }/css/common/jquery.mmenu.all.css"/>
<link rel="stylesheet" href="${rctx }/css/common/common.css"/>
<%-- <link rel="stylesheet" href="${rctx }/css/common/bootstrap-datepicker.min.css"/> --%>
<link type="text/css" rel="stylesheet" href="${rctx }/css/common/static.css">
<%-- <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css"> --%>
<%-- <link rel="stylesheet" href="${rctx }/css/common/footer.css" type="text/css"> --%>
<%--  <link type="text/css" rel="stylesheet" href="${rctx }/css/yj_supply_css.css"> --%>
<%-- <link rel="stylesheet" href="${rctx }/css/common/header.css" type="text/css"> --%>
<script type="text/javascript">
	//禁止页面右键菜单
	function disableContextMenu(){
	    $(document).bind("contextmenu",function(e){ 
	        return false;
	    });
	}
	function toDefault(obj,type){
		if(type =="people"){ 
			$(obj).attr("src","${mctx }/images/default/default_user.png");
		}else if(type=="other"){
			$(obj).attr("src","${mctx }/images/default/default_other.png");
		}
	}
</script>
