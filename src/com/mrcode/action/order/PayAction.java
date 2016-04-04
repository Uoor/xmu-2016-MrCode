package com.mrcode.action.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.mrcode.utils.MessageSend;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Contactors;
import com.mrcode.model.Mrcodeorder;
import com.mrcode.model.Password;
import com.mrcode.service.MrcodeorderService;
/**
 * 
 * 支付功能
 */

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class PayAction extends BaseAction<Mrcodeorder> {
	@Autowired
	MrcodeorderService mrcodeorderService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4346153878444031652L;
	/**
	 * 进入支付宝界面
	 * 
	 * @return
	 */
	@Action(value = "alipayHandler", results = { @Result(name = "alipayUI", location = ViewLocation.View_ROOT
			+ "alipay.jsp") })
	public String alipayHandler() throws Exception {
		System.out.println("PayAction.alipayHandler()");
		//获取需要的参数
		int orderId = getIntParameter("id", -1);
		if(orderId == -1){
			throw new Exception("alipayHandler get parameters error!");
		}
		Mrcodeorder order = mrcodeorderService.getById(orderId);
		//商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getOrderCode();
        //订单名称，必填
        String subject = "OrderNumber-"+out_trade_no;
        //付款金额，必填
        String total_fee = order.getDepositPrice().toString();
        //商品描述，可空,含有中文会导致校验失败
        /*StringBuilder builder = new StringBuilder();
        for (OrderDish orderDish : order.getOrderDishes()) {
			builder.append("orderId:"+orderDish.getId()+"-DISHNAME-"+orderDish.getDishName()+"-PRICE-"+orderDish.getDishPrice()+"-COUNT-"+orderDish.getDishCount());
		}
        String body = builder.toString();*/
        //String body = "对商品的描述";
        String body = order.getOrderCode();
        //把请求参数打包成数组
      	Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("service", AlipayConfig.service);
        paramMap.put("partner", AlipayConfig.partner);
        paramMap.put("seller_id", AlipayConfig.seller_id);
        paramMap.put("_input_charset", AlipayConfig.input_charset);
        paramMap.put("payment_type", AlipayConfig.payment_type);
		paramMap.put("notify_url", AlipayConfig.notify_url);
		paramMap.put("return_url", AlipayConfig.return_url);
		paramMap.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		paramMap.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		paramMap.put("out_trade_no", out_trade_no);
		paramMap.put("subject", subject);
		paramMap.put("total_fee", total_fee);
		paramMap.put("body", body);
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(paramMap,"get","确认");
		//System.out.println(sHtmlText);
		request.setAttribute("sHtmlText", sHtmlText);
		return "alipayUI";
	}
	
	/**
	 * 处理支付宝返回的结果
	 * @return
	 */
	@Action(value = "alipayResultHandler", results = { @Result(name = "alipaySuccessResultUI", location = ViewLocation.View_ROOT
			+ "orderstep4.jsp") })
	public String alipayResultHandler() throws Exception {
		System.out.println("PayAction.alipayResultHandler()");
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
			System.out.println("name->"+name);
			System.out.println("valueStr->"+valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("out_trade_no->"+out_trade_no);
		//支付宝交易号

		//购买者支付宝邮箱
		String buyer_email = params.get("buyer_email");
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("trade_no->"+trade_no);
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("trade_status->"+trade_status);
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		System.out.println("verify_result->"+verify_result);
		if(verify_result){//验证成功
			System.out.println("verify_ok");
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				//根据订单号找到订单
				Mrcodeorder mrcodeorder = mrcodeorderService.getWithContactorsByOrderNum(trade_no);
				//1.处理业务逻辑
				//1-1. 将orderList的状态
				mrcodeorder.setDepositAlready(1);
				mrcodeorderService.update(mrcodeorder);
				//1-2. 给相应的朋友发送短信
				Set<Password> passwords = mrcodeorder.getPasswords();
				
				/*for(Password p : passwords){
					String msg = "【码先生】"+p.getContactors().getName()+"您好！您的"+mrcodeorder.getOrderCode()+
							"号订单下单成功，请于"+p.getEstimatedTime().toString().substring(0,9)+
							"日12点后至酒店前台确认身份信息，即可凭借房间密码"+p.getPassword()+"入住"+p.getRoom().getRoomNumber()+"号房间";
					
					JSONObject o = JSONObject.fromObject(MessageSend.sendSms(msg, p.getContactors().getPhoneNumber()));
				}*/
				
				//2.准备显示数据
				request.setAttribute("orderNum", mrcodeorder.getOrderCode());
				request.setAttribute("buyer_email", buyer_email);
				request.setAttribute("orderMoney", mrcodeorder.getDepositPrice());
			}
			
			//该页面可做页面美工编辑
			request.setAttribute("result", "验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			return "alipaySuccessResultUI";
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			System.out.println("verify_failed");
			//该页面可做页面美工编辑
			request.setAttribute("result", "验证失败");
			return "alipaySuccessResultUI";
		}
		
	}
}
