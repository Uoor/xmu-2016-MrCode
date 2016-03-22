package com.mrcode.utils;


import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * 短信http接口的java代码调用示例
 * 基于Apache HttpClient 4.3
 *
 * @author 朱源
 */
public class MessageSend {

    // 查账户信息的http地址
    private static String URI_GET_USER_INFO = "http://yunpian.com/v1/user/get.json";

    //通用发送接口的http地址
    private static String URI_SEND_SMS = "http://yunpian.com/v1/sms/send.json";

    // 模板发送接口的http地址
    private static String URI_TPL_SEND_SMS = "http://yunpian.com/v1/sms/tpl_send.json";

    // 发送语音验证码接口的http地址
    private static String URI_SEND_VOICE = "http://yunpian.com/v1/voice/send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";

    private static String apiKey = "18223cf0207e6bd47451622715cd0d9d";
    
    /*public static void main(String[] args) throws IOException, URISyntaxException {
        //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后用户中心首页看到
        String apikey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        //修改为您要发送的手机号
        String mobile = "xxxxxxxxxxx";

        //查账户信息调用示例
        //System.out.println(JavaSmsApi.getUserInfo(apikey));

        //使用通用接口发短信(推荐)
        //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
        String text = "【云片网】您的验证码是1234";
        //发短信调用示例
        System.out.println(JavaSmsApi.sendSms(apikey, text, mobile));

        //使用模板接口发短信(不推荐，建议使用通用接口)
        //设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
        long tpl_id = 1;
        //设置对应的模板变量值
        //如果变量名或者变量值中带有#&=%中的任意一个特殊符号，需要先分别进行urlencode编码
        //如code值是#1234#,需作如下编码转换
        String codeValue = URLEncoder.encode("#1234#", ENCODING);
        String tpl_value = "#code#=" + codeValue + "&#company#=云片网";
        //模板发送的调用示例
        System.out.println(JavaSmsApi.tplSendSms(apikey, tpl_id, tpl_value, mobile));

        //使用接口发语音验证码
        String code = "1234";
        System.out.println(JavaSmsApi.sendVoice(apikey, mobile ,code));
    }*/
    
    @SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception{
    	/*for (int i = 0; i < 100; i++) {
    		System.out.println(MessageSend.getVerificationCode());
		}*/
		
    	JSONObject result = JSONObject.fromObject(DataUtils.getMap("res","123465461"));
    	System.out.println(result.get("res"));
    	/*try {
			String msg = MessageSend.sendDynamicVerification("546824", "15959277729");
			System.out.println(msg);
    	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
    }

    /**
     * 取账户信息
     *
     * @return json格式字符串
     * @throws java.io.IOException
     */
    public static String getUserInfo() throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apiKey);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 通用接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */
    public static String sendSms(String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apiKey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }
    
    /**
     * 动态登录验证
     * @param verificationCode	六位验证码
     * @param mobile	电话号码
     * @return
     * @throws IOException
     */
    public static String sendDynamicVerification(String verificationCode, String mobile) throws IOException {
    	String text = "【我知盘中餐】"+verificationCode+"（动态登录验证码）。工作人员不会向您索要，请勿向任何人泄露。";
		return sendSms(text, mobile);
    }

    

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */
    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
    /**
     * 生成验证码
     * @return
     */
    public static String getVerificationCode(){
    	Random random = new Random();
    	String code = String.valueOf(random.nextLong());
    	return code.substring(1, 7);
    }
}