<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/commonPhoneLogin.jsp" %>
    <title>动态登陆</title>
     <link type="text/css" rel="stylesheet" href="${rctx }/css/login_phone.css"/>
     <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css"/>
     <script type="text/javascript" src="${rctx }/js/yj_style_phone.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <span class="header-word">动态登陆</span>
       
    </div>
</div>
<div class="content">
 <div class="validate-info" style="display:none"></div>
 	<form  action="${ctx }/customer/mobileLogin" onsubmit="return allok()" 
 method="post" class="form form--stack J-wwwtracker-form" >
    	<div id="choose-edit" style="margin-bottom: 50px;text-align: center;">
        	 <div class="control-group input-top" style="margin-top:50px">
                <input type="text" id="login-mobile" class="login-in-input" name="phone" value="" placeholder="请输入手机号"/>
             </div>       	
        	 <div class="control-group">
            	<input type="text" name="dynamicCode" id="login-verify-code"  autocomplete="off" value="" placeholder="请输入动态码" class="login-in-input login-phone-input">
           		<input type="button" id="sendBtnInput" value="发送动态码" class="send login_phone_num" />
        	</div>
        	  <div class="control-group">
                <input type="submit" class="btn b2 login-now" style="background-color: #33ccff" value="登录"/>
            </div>
             <div style="margin-top:20px"><a href="${ctx }/customer/toIndex" class="forget-password">返回密码登陆</a></div>
    	</div>
    </form>
</div>

</body>
 <script>
    var email;  //登录用户名
    var password;  //登录密码
    var mobile;   //phone number
    var verify;  //动态码
    var remember; //记住密码
    var reg=/^0{0,1}(13[0-9]|15[7-9]|153|156|18[0-9])[0-9]{8}$/;
    
    var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数

   
    function getmobile(){
        mobile = $("#login-mobile").val();
        verify=$("#login-verify-code").val();
    }
    
    //timer处理函数
function SetRemainTime() {
    if (curCount == 0) {
        window.clearInterval(InterValObj);//停止计时器
        $(".send").removeAttr("disabled");//启用按钮
        $(".send").val("重新发送验证码");
    }
    else {
        curCount--;
        $(".send").val("重新发送（" + curCount + "）秒");
    }
}
    
    
    function sendMessage() {
   
    curCount = count;
    //设置button效果，开始计时
    $(".send").attr("disabled", "true");
    $(".send").val("重新发送（" + curCount + "）秒");
    InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
    var phone = $("#login-mobile").val();
    $.ajax({
        type: "POST", //用POST方式传输
        dataType: "text", //数据格式:JSON
        url: 'sendVerification', //目标地址
        data: "phone=" + phone/* +"&uid=" + uid + "&code=" + code*/,
        error: function (XMLHttpRequest, textStatus, errorThrown) { },
        success: function (msg){
        	if(msg!="【ok】"){
        		//do something 
        	}
        }
    });
}
    
    
    function testmobile(){
    
        getmobile();
        if(mobile==""||mobile==null){
        swal("手机号不能为空");
           /*  $(".validate-info").css("display","block");
            $(".validate-info").html("手机号不能为空"); */
            $("#login-mobile").focus();
       
           return false;
        }
        if(mobile.length!=11){
        swal("手机号必须为11位");
           /*  $(".validate-info").css("display","block");
            $(".validate-info").html("手机号必须为11位"); */
            $("#login-mobile").focus();
            return false;
        }
        if(!reg.test(mobile)){
        swal("请输入正确的手机号码");
         /*    $(".validate-info").css("display","block");
            $(".validate-info").html("请输入正确的手机号码"); */
            $("#login-mobile").focus();
            return false;
        }
       /*  else if(verify==""||verify==null){
            $(".validate-info").css("display","block");
            $(".validate-info").html("动态码不能为空");
            $("#login-verify-code").focus();
            return false;
        } */
        return true;
        //$("#J-login-form").submit();
    }
     function allok(){
    	testmobile();
    	if(verify==""||verify==null){
    	swal("动态码不能为空");
          /*   $(".validate-info").css("display","block");
            $(".validate-info").html("动态码不能为空"); */
            $("#login-verify-code").focus();
            return false;
        }
        //验证成功执行发送动作
     /*    sendMessage(); */
        //$("#J-login-form").submit();
        return true;
    }
    
    $(document).ready(function () {
   
/*     	var tip = $("#comErrTip").val();
    	if(tip!=""){
    		$(".validate-info").css("display","block");
            $(".validate-info").html(tip);
            $("#login-verify-code").focus();
    	}
        $(".J-show-mobile-login").click(function () {
            $("#J-mobile-login-form").css("display","block");
            $(".J-show-mobile-login").css("display","none");
            $(".validate-info").css("display","none");
            $("#J-login-form").css("display","none");
            $("#J-login-link").css("display","block");
        });
        $("#J-login-link").click(function () {	
            $("#J-mobile-login-form").css("display","none");
            $(".J-show-mobile-login").css("display","block");
            $(".validate-info").css("display","none");
            $("#J-login-form").css("display","block");
            $("#J-login-link").css("display","none");
        }); */
        
        $(".send").click(function(){
         
        	if(testmobile()){
        		 sendMessage();     //如果手机号符合要求，发送验证码
        	}
        
        })
        
       
    })
</script>
</html>