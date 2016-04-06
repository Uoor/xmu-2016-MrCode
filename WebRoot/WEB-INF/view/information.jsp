<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/common.jsp" %>
    <title>完善信息</title>
    <!--对上传图片的样式的设置-->
    <link type="text/css" rel="stylesheet" href="${rctx }/css/login.css">
    <script type="text/javascript" src="${rctx }/js/picture_send.js"></script><!--专门用来设置图片上传功能的原生js-->
    <script type="text/javascript" src="${rctx }/js/yj_style.js"></script>
</head>
<body>
<div class="head">
    <div class="header">
        <a href="#menu" class="header-a"><i class="fa fa-reorder head-style"></i></a>
        <span class="header-word">完善信息</span>
        <a href="${ctx }/customer/toIndex"><i class="fa fa-home head-style home-style"></i></a>
    </div>
    <%@ include file="header.jsp" %>
</div>
<div class="content">
    <div class="aboutus-content">
        <p class="mobile choose-style-p"><i class=" mobile-special information-name">用户名：</i><span class="content-word">${userName}</span></p>
        <p class="mobile choose-style-p"><i class=" mobile-special information-name">手机号：</i><span class="content-word">${phoneNumber}</span> </p>
        <p class="mobile choose-style-p" id="choose-type"><i class=" mobile-special information-name">身份证填写：</i>
            <span class="choose-style-span"><input type="radio" class="choose-style " name="choose" checked="true" value="camera" onclick="changechoose(this)"><i class="fa fa-camera choose-style-i"></i></span>
            <span class="choose-style-span"><input type="radio" class="choose-style" name="choose" value="edit" onclick="changechoose(this)"><i class="fa fa-edit choose-style-i"></i></span>
        </p>
        <!--以下一行是显示上传的框用的是jquery的zyupload插件-->
        <form  class="form-style" action="${ctx }/customer/addInformation"  enctype="multipart/form-data" method="post">
         <!--以下实现图片上传功能-->
        <div id="choose-picture">
            <div id="imagePreview"></div>

            
                <p><input id="imageInput"  type="file" name="imageInput" onchange="loadImageFile();" /><br />
                </p>
         	    <button type="submit" class="login-now">提交图片</button>       
        </div>
        <!--以上实现图片上传功能-->
        <div id="choose-edit" style="margin-bottom: 50px;text-align: center;display:none">
            <div class="control-group input-top" style="margin-top:50px">
                <input type="text" name="identityCard" id="checkidcard" class="login-in-input" placeholder="请输入身份证号">
            </div>
            <div class="control-group">
                <input type="text" name="truename" class="login-in-input" placeholder="请输入姓名">
            </div>
            <div class="control-group">
                <button type="submit" class="login-now">提交</button>
            </div>
        </div>
        </form>
     
    </div>

</div>
   <%@ include file="footer.jsp" %>
	<script>
	$("#checkidcard").blur(function(){
		var idnum = $("#checkidcard").val();
		//alert(idnum);
		isCardID(idnum);
		
	})
	function isCardID(sId){ 
		//alert("!!!"+sid);  
		var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
		if(reg.test(sId))
		{}
		else{alert("请输入正确的身份证格式");}
 		
} 
 
	</script>
</body>
</html>