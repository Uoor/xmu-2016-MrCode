package com.mrcode.action.customer;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import com.mrcode.base.BaseAction;
import com.mrcode.common.ViewLocation;
import com.mrcode.common.WebApplication;
import com.mrcode.model.Customer;
import com.mrcode.service.CustomerService;
import com.mrcode.utils.Identification;
import com.mrcode.utils.ImageUtils;
import com.opensymphony.xwork2.ActionContext;


@Controller
@ParentPackage("customers")
@Namespace("/customer")
public class AddLinkmanAction extends BaseAction<Customer>{
	
	@Autowired
	CustomerService customerService;
	
	//update ID page
		@Action(value = "addLinkman", results = { @Result(name = "addLinkman", location = ViewLocation.View_ROOT
				+ "information.jsp") })
		public String addLinkman() throws Exception{
			if(ActionContext.getContext().get("msg")!=null)
				request.setAttribute("msg", ActionContext.getContext().get("msg"));
			
			return "addLinkman";
		}
		
		//update ID 
		
		@Action(value = "addInformation", results = { @Result(name = "addLinkman", location = ViewLocation.View_ROOT
				+ "information.jsp") })
		public String addInformation() throws Exception{
			if(ActionContext.getContext().get("msg")!=null)
				request.setAttribute("msg", ActionContext.getContext().get("msg"));
			Customer cus = (Customer) session.get("customer");
			MultiPartRequestWrapper multipartRequest = (MultiPartRequestWrapper)request;
			if ( multipartRequest.getFiles("imageInput") != null) { 
			File imgFile = multipartRequest.getFiles("imageInput")[0];
			String imgFileName = multipartRequest.getFileNames("imageInput")[0];
			if(imgFile.exists()){
				String path1 = WebApplication.getContextPath()+"\\resource\\upload\\user";
				System.out.println(path1);
				String img = ImageUtils.save(imgFile, path1, imgFileName, UUID.randomUUID().toString(), null);
				System.out.println(img);
				int x=path1.indexOf("upload");
				String path = path1.substring(x-1);
				path = path.replaceAll("\\\\", "/");
				System.out.println(path+"/"+img);
				cus.setIdentityPic(path+"/"+img);
				
				String winPath = path1 + "\\" + img;
				System.out.println("windows" + winPath);
				
				String linuxPath = ("path1" + "\\" + img).replaceAll("\\\\", "/");
				System.out.println(linuxPath);
				
				
				String[] strs = Identification.IdCard(winPath);	
//				String[] strs = Identification.IdCard(linuxPath);	
				System.out.println(strs[0] + "--" + strs[1]);
				System.out.println(cus.getTrueName());
				cus.setIdentityCard(strs[1]);
				cus.setTrueName(strs[0]);
				customerService.update(cus);
				System.out.println(cus.getTrueName());
				
			}
			} else if(getParameter("identityCard") != null && getParameter("identityCard")!=""){
			
			String truename = getParameter("truename");
			String identityCard = getParameter("identityCard");
			System.out.println(truename + "--" + identityCard);
			
			cus.setIdentityCard(identityCard);
			cus.setTrueName(truename);
			
			}
			
			return "addLinkman";
		}

}
