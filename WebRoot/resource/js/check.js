var canSubmit=true;
$(function(){
	//hideErrorTip();//隐藏提示
	/* var inputEle = $("#oldName");
	tipError(inputEle,"出生日期不能为空请输入出生日期，请输入出生日期");
	$("#addBasicInfoSave").click(function(){
		$("#addBasicInfoForm").submit();
	}); */
	$(".check").each(function(i){
		if ($(this).hasClass("checkLevel1")){//check if is null
			$(this).blur(function(){
				if ($.trim($(this).val())==""){
					$(this).parent().children(".errormsg").html("此处不能为空");
					canSubmit=false;
				}
				else
					$(this).parent().children(".errormsg").html('');
			});
		}
		else if ($(this).hasClass("checkLevel2")){//check if is null and check some else , further check
			$(this).blur(function(){
				if ($.trim($(this).val())==""){
					$(this).parent().children(".errormsg").html("此处不能为空");
					canSubmit=false;
				}
				else if ($(this).hasClass("checkPhone")){
					if (!(checkPhone($.trim($(this).val()))||checkMobile($.trim($(this).val())))){
						$(this).parent().children(".errormsg").html("请输入正确的联系电话, 固话请加上区号，如0596-3214567");
						canSubmit=false;
					}
					else 
						$(this).parent().children(".errormsg").html('');
				}
				else if ($(this).hasClass("checkIdentity")){
					if ($.trim($("#identityType").val())=="11"){
						if (!IdentityCodeValid($(this).val())){
							$(this).parent().children(".errormsg").html("身份证号码出错");
							canSubmit=false;
						}
						else
							$(this).parent().children(".errormsg").html('');
					}
				}
				else if ($(this).hasClass("checkEmail")){
					if (!isEmail($.trim($(this).val()))){
						$(this).parent().children(".errormsg").html("邮箱格式出错");
						canSubmit=false;
					}
					else
						$(this).parent().children(".errormsg").html('');
				}
				else if ($(this).hasClass("checkPostCode")){
					if (!isPostCode($.trim($(this).val()))){
						$(this).parent().children(".errormsg").html("邮编格式出错");
						canSubmit=false;
					}
					else
						$(this).parent().children(".errormsg").html('');
				}
				else
					$(this).parent().children(".errormsg").html('');
			});
		}
	});
});
//密码合法性验证6-18位
function checkPassword(password){
	if(password.length>=6 && password.length<=18)
		return true;
	else return false;
}
//登陆账号验证,用户 名只能是数字字母及下划线，至少6位
function checkUsername(username){
	var reg=/^[0-9A-Za-z_]{6,}$/;
	if(username.match(reg))
		return true;
	return false;
}
//手机号码验证
function checkMobile(obj){
	 var 
	 re = /^(((13[0-9])|(15([0-3]|[5-9]))|(18[0-9]))\d{8})|(0\d{2}-\d{8})|(0\d{3}-\d{7})$/
	    if (re.test(obj)) {
	        return true;
	    } else {
	        return false;
	    }
}
//电话号码验证 区号-号码 也可无-
function checkPhone(str){
   var re = /^0\d{2,3}-?\d{7,8}$/;
   if(re.test(str)){
	   return true;
   }else{
	   return false;
   }
}
//身份证验证
function IdentityCodeValid(code) { 
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var tip = "";
    var pass= true;
    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
        tip = "身份证号格式错误";
        pass = false;
    }
    
   else if(!city[code.substr(0,2)]){
        tip = "地址编码错误";
        pass = false;
    }
    else{
        //18位身份证需要验证最后一位校验位
        if(code.length == 18){
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++)
            {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if(parity[sum % 11] != code[17]){
                tip = "校验位错误";
                pass =false;
            }
        }
    }
    return pass;
}
function isEmail(str) { 
    var myReg = /^[-._A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
    if (myReg.test(str)){
          return true; 
     }  
      return false; 
}
function getSubmitFlag(){
	window.canSubmit=true;
	$(".check").each(function(){
		$(this).blur();
	});
	return window.canSubmit;
}
//JavaScript检查字符串是否是邮编：
function isPostCode( sValue )
{
if( sValue == null )
{
return false;
}
if( sValue.length != 6 )
{
return false;
}
else
{
for( i = 0; i < 6; i ++ )
{
if( isDigital( sValue.charAt( i ) ) == false )
{
return false;
}
}
}
return true;
} 

// 以下是相关的JS检测函数：检查是否是数字字符串，可作参数，并不是检测邮编中的内容：
// sValue：输入值
function isDigitalString( sValue )
{
if( sValue == null )
{
return false;
}

for( i = 0; i < sValue.length; i ++ )
{
if( isDigital( sValue.charAt( i ) ) == false )
{
return false;
}
}
}
function isDigital(str){
	for(ilen=0;ilen<str.length;ilen++){
		if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' ){
			return false;
		} 
	}
}
/*	判断图片格式是否合法	*/
function isPicLegal(pic){
	if(pic=="jpg"||pic=="jpeg"||pic=="gif"||pic=="bmp"||pic=="png"){
		return true;
	}
	return false;
}
/*	判断银行卡号格式是否合法	*/
function isBankAccount(account){
	var reg = /^\d{19}$/g;   // 由19位数字组成
    if( !reg.test(account) ){
       return false;
    }
    return true;
}
/*	判断时间输入早晚是否正确,起始日期不得晚于结束日期	*/
function checkDateBeginEnd(begin, end){
	if(begin!='' && begin!='undefined' && 
			end!='' && end!='undefined'){
		if(Date.parse(begin)>Date.parse(end)){
			return false;
		}
	}
	return true;
}