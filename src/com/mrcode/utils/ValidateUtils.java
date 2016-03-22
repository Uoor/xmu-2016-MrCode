package com.mrcode.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


/**
 * 
 * @author 羽中
 *
 */
public class ValidateUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String email = " ab7925920@qq.com ";
		String mobileNumber = " 0599-7925920 ";
		String val = "";
		System.out.println(ValidateUtils.checkVerificationCode(val));
		//System.out.println(ValidateTools.checkEmail(email));
		//checkValidTelephoeNo
	}
	/**
	 * 
	 * @param regex
	 * @param value
	 * @return
	 */
	public static boolean check(String regex,String value){
		boolean flag = false;
		try {
			if(StringUtils.isNotEmpty(value)){
				value = StringUtils.trim(value);
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(value);
				flag = m.matches();
			}
		} catch (Exception e) {
			System.out.println("正则表达式验证出错！");
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		return check(regex, email);
	}
	/**
	 * 验证固定电话或移动电话
	 * eg:0599-7925925,13388093155
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber){
		String regex = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		return check(regex, mobileNumber);
	}
	/**
	 * 匹配英文字母或汉字
	 * eg:"ShenZhen" "深圳"
	 * @param value
	 * @return
	 */
	public static boolean checkValidEnglishOrChinese(String value){
		String regex = "^[A-Za-z]*|[\u4E00-\u9FA5]*$";
		return check(regex, value);
	}
	////////////////////////////////
	public static boolean checkValidName(String name){
		String regex = "^([A-Za-z]+[\\s][A-Za-z]+)|[\u4E00-\u9FA5]*";
		return check(regex, name);
		
	}
	/**
	 * 匹配正整数
	 * 不包括0
	 * @param value
	 * @return
	 */
	public static boolean checkValidInteger(String value){
		String regex = "^[1-9]\\d*$";
		return check(regex, value);
	}
	/**
	 * 匹配验证码
	 * 六位正整数
	 * @param value
	 * @return
	 */
	public static boolean checkVerificationCode(String value){
		String regex = "^\\d{6}$";
		return check(regex, value);
	}
	/**
	 * 匹配整数
	 * 包括0
	 * @param value
	 * @return
	 */
	public static boolean checkValidNo(String value){
		String regex = "^-?\\d*$";
		return check(regex, value);
	}
	/**
	 * 验证非负整数(0+正整数)
	 * @param value
	 * @return
	 */
	public static boolean checkValidNonNegative(String value){
		String regex = "^\\d+$";
		return check(regex, value);
	}
	/**
	 * 匹配英文
	 * @param value
	 * @return
	 */
	public static boolean checkValidEnglish(String value){
		String regex = "^[A-Za-z]*$";
		return check(regex, value);
	}
	/**
	 * 匹配英文字母 或者汉字，数字 过滤特殊字符 
	 * @param value
	 * @return
	 */
	public static boolean checkValidNonSpecialChar(String value){
		String regex = "^[A-Za-z\u4E00-\u9FA5\\d]*$";
		return check(regex, value);
	}
	/**
	 * 验证用户名注册是否合法(由数字、26个英文字母或者下划线组成的字符串 )
	 * eg:jane_12306
	 * @param value
	 * @return
	 */
	public static boolean checkRegUserName(String value){
		String regex = "^\\w{6,}$";
		return check(regex, value);
	}
	//////////////////
	/**
	 * 验证输入密码长度(6-18位)
	 * @param value
	 * @return
	 */
	public static boolean checkPasswordLength(String value){
		String regex = "^\\d{6,18}$";
		return check(regex, value);
	}
	/**
	 * 验证手机号码 
	 * @param value telNo 电话号码字符串 130到139 和 150，152 ，157，158，159 ，186，189，187 
	 * @return
	 */
	public static boolean checkValidMobileNo(String value){
		String regex = "^((13[0-9])|(15[02789])|(18[679]))\\d{8}$";
		return check(regex, value);
	}
	//////////////
	/**
	 * 验证电话号码 
	 * @param value 
	 * @return
	 */
	public static boolean checkValidTelephoeNo(String value){
		String regex = "(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		return check(regex, value);
	}
	/**
	 * 验证15位或18位身份证号码
	 * @param value 
	 * @return
	 */
	public static boolean checkValidIdCard(String idCard){
		String regex18 = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
		String regex15 = "^\\d{15}$";
		return check(regex18, idCard)||check(regex15, idCard);
	}
}
