package com.kdyzm.struts2.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kdyzm.domain.User;
import com.kdyzm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{
	@Resource(name="userService")
	private UserService userService;
	/**
	 * 定义登陆的验证方法
	 * @return
	 * @throws Exception
	 */
	public String checkUserNameAndPassword() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		User temp=userService.checkUser(user);
		if(temp==null){
			return "login";
		}
		ServletActionContext.getRequest().getSession().setAttribute("user", temp);
		return "toIndex";
	}
	
	public String logout() throws Exception{
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "login";
	}
}
