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
        <span class="header-word">您的房间:${roomnumber}</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>

       <%@ include file="header.jsp" %>

</div>
<input type="hidden" value="${roomid}" id="roomid">
<input type="hidden" value="${customer.trueName}" id="customertrueName">
<input type="hidden" value="${customer.phoneNumber}" id="customerphoneNumber">
<input type="hidden" value="${roomnumber}" id="roomNumber">
<div class="content">
    <div class="container">
          <div style="padding:0 5px 0 0;">

            <ul class="unstyled defaultlist pt20">
                <li class="f" id="send_back">
                    <a class="returnroom">
                        <h3>退房服务</h3>
                        <figure class="jp_icon"></figure>
                    </a>
                </li>
                <li class="h" id="clean">
                    <a class="cleanroom">
                        <h3>清洁房间</h3>
                        <figure class="jd_icon"></figure>
                    </a>
                </li>
            </ul>
            <ul class="unstyled defaultlist">
                <li class="a">
                    <a href="${ctx }/customer/toRoomManageBuy">
                        <h3>商品购买</h3>
                        <figure class="hb_icon"></figure>
                    </a>

                </li>
                <li class="p" id="wash">
                    <a class="cleanclothes">
                        <h3> 衣服清洗</h3>
                        <figure class="mp_icon"></figure>
                    </a>
                </li>
            </ul>
            <ul class="unstyled defaultlist">
                <li class="t">
                    <a href="${ctx }/customer/toRoomManageOrderFood">
                        <h3>送餐服务</h3>
                        <figure class="hcp_icon"></figure>
                    </a>
                </li>

                <li class="m" id="call">
                    <a class="callfordesk">
                        <h3> 呼叫总台</h3>
                        <figure class="wdxc_icon"></figure>
                    </a>
                </li>

            </ul>
        </div>
        <div id="showtimes" style="text-align:right">
		<script language="javascript">show_cur_times();</script>
		</div>
    </div>
</div>
   <%@ include file="footer.jsp" %>
<script>
$(".returnroom").click(function(){
	var roomid = $("#roomNumber").val();
	var time = $("#showtimes").text();
	var name = $("#customertrueName").val();;
	var demand = "房间"+roomid+"：本房间请求退房。";
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/JavaPrj_9/guesthistoryctrl.htm?action=customerInformationAndNewsBymrcode",
		data : {
			demand : demand,
			time : time,
			name : name,
			roomid : roomid
		},
		success : function(result) {			
			if (result == "1") {
				swal("预约退房成功，已通知酒店前台为您退房。");
			} 
		}
	});
});

$(".cleanclothes").click(function(){
	var roomid = $("#roomNumber").val();
	var time = $("#showtimes").text();
	var name = $("#customertrueName").val();;
	var demand = "房间"+roomid+"：本房间请求衣服送洗服务。";
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/JavaPrj_9/guesthistoryctrl.htm?action=customerInformationAndNewsBymrcode",
		data : {
			demand : demand,
			time : time,
			name : name,
			roomid : roomid
		},
		success : function(result) {			
			if (result == "1") {
				swal("衣服送洗服务呼叫成功，已通知酒店服务员为您服务。");
			} 
		}
	});
});

$(".callfordesk").click(function(){
	var roomid = $("#roomNumber").val();
	var time = $("#showtimes").text();
	var name = $("#customertrueName").val();;
	var demand = "房间"+roomid+"：本房间请求呼叫总台。";
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/JavaPrj_9/guesthistoryctrl.htm?action=customerInformationAndNewsBymrcode",
		data : {
			demand : demand,
			time : time,
			name : name,
			roomid : roomid
		},
		success : function(result) {			
			if (result == "1") {
				swal("呼叫总台成功，已通知酒店总台为您服务。");
			} 
		}
	});
});
$(".cleanroom").click(function(){
	var roomid = $("#roomNumber").val();
	var time = $("#showtimes").text();
	var name = $("#customertrueName").val();;
	var demand = "房间"+roomid+"：本房间请求房间清洁服务。";
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/JavaPrj_9/guesthistoryctrl.htm?action=customerInformationAndNewsBymrcode",
		data : {
			demand : demand,
			time : time,
			name : name,
			roomid : roomid
		},
		success : function(result) {			
			if (result == "1") {
				swal("房间清洁服务呼叫成功，已通知酒店服务员为您服务。");
			} 
		}
	});
});

function show_cur_times(){
//获取当前日期
 var date_time = new Date();
 //定义星期
 var week;
 //switch判断
 switch (date_time.getDay()){
case 1: week="星期一"; break;
case 2: week="星期二"; break;
case 3: week="星期三"; break;
case 4: week="星期四"; break;
case 5: week="星期五"; break;
case 6: week="星期六"; break;
default:week="星期天"; break;
}
//年
 var year = date_time.getFullYear();
  //判断小于10，前面补0
   if(year<10){
  year="0"+year;
 }
 //月
 var month = date_time.getMonth()+1;
  //判断小于10，前面补0
  if(month<10){
month="0"+month;
 }
 //日
 var day = date_time.getDate();
  //判断小于10，前面补0
   if(day<10){
  day="0"+day;
 }
 //时
 var hours =date_time.getHours();
  //判断小于10，前面补0
    if(hours<10){
  hours="0"+hours;
 }
 //分
 var minutes =date_time.getMinutes();
  //判断小于10，前面补0
    if(minutes<10){
  minutes="0"+minutes;
 }
 //秒
 var seconds=date_time.getSeconds();
  //判断小于10，前面补0
    if(seconds<10){
  seconds="0"+seconds;
 }
 //拼接年月日时分秒
 var date_str = year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds+" "+week;
 //显示在id为showtimes的容器里
 document.getElementById("showtimes").innerHTML= date_str;
}
 //设置1秒调用一次show_cur_times函数
setInterval("show_cur_times()",100);
</script>
</body>
</html>