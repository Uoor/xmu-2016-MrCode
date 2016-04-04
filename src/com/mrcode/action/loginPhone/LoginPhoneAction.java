package com.mrcode.action.loginPhone;


import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrcode.service.ContactorsService;
import com.mrcode.service.CustomerService;
import com.mrcode.utils.Const;
import com.mrcode.utils.DataUtils;
import com.mrcode.utils.DigestUtil;
import com.mrcode.utils.MessageSend;
import com.mrcode.utils.ValidateUtils;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.model.Contactors;
import com.mrcode.model.Customer;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class LoginPhoneAction extends BaseAction<Customer>{

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ContactorsService contactorsService;

	/**
	 * 短信快捷登录
	 * 
	 * @return
	 */
	@Action(value = "mobileLogin")
	public String mobileLogin() throws Exception {
		
		String phone = getParameter("phone");
		String dynamic = getParameter("dynamicCode");
		System.out.println("phone->" + phone);
		System.out.println("dynamic->" + dynamic);
		if (ValidateUtils.checkMobileNumber(phone)
				&& ValidateUtils.checkVerificationCode(dynamic)) {
			String verificationCode = (String) getSession().get(
					"verificationCode");
			System.out.println("verificationCode->" + verificationCode);
			if (verificationCode != null) {
				// 进行短信验证码比较
				if (verificationCode.equals(dynamic)) {
					// 验证码通过，跳转至主页面
					System.out
							.println("===============进入main code==============>");
					Customer customer = customerService.findUniqueByHql(
							"from Customer c where c.phoneNumber=:phoneNumber",
							DataUtils.getMap("phoneNumber", phone));
					System.out.println(customer);
					if (customer != null) {
						// 如果数据库中存在该手机的账号，则直接登录
						getSession().put("customer", customer);
						return "toIndex";
					} else {
						// 若不存在，则创建一个账号，账户名，密码都为手机号
						System.out.println("创建新账号");
						Customer newCust = new Customer();
						newCust.setUserName(phone);
						newCust.setPhoneNumber(phone);
						newCust.setPassword(phone);
						
						customerService.save(newCust);
						
						Contactors cont = new Contactors();
						cont.setCustomer(newCust);
					//	cont.setIdentityCard(phone);
					//	cont.setName(phone);
						cont.setPhoneNumber(phone);
						cont.setId(1);
						contactorsService.save(cont);
						
						
						
						getSession().put("customer", newCust);
						return "toIndex";
					}

				} else {
					return "toLogin";
				}
			} else {
				return "toLogin";
			}
		} else {
			return "toLogin";
		}
	}

	/**
	 * 发送短信验证码
	 * 
	 * @return
	 */
	@Action(value = "sendVerification")
	public void sendVerification() throws Exception {
		String phone = getParameter("phone");
		System.out.println("CustomerAction.sendVerification()");
		// 1.生成验证码
		String verificationCode = MessageSend.getVerificationCode();
		try {
			JSONObject result = JSONObject
					.fromObject(MessageSend.sendDynamicVerification(
							verificationCode, phone));
			if ("OK".equals(result.get("msg"))) {
				session.clear();
				session.put("verificationCode", verificationCode);
				writeStringToResponse("【ok】");
			}
		} catch (Exception e) {
			log.error("发送验证码失败！");
			e.printStackTrace();
		}

	}
	
}
