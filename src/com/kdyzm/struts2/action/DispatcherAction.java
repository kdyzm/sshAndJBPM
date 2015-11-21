package com.kdyzm.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 转发到框架页面的Action
 * @author kdyzm
 *
 */
@SuppressWarnings("serial")
@Controller("dispatcherAction")
@Scope("prototype")
public class DispatcherAction extends ActionSupport{
	public String toLeft() throws Exception{
		return "left";
	}
	public String toRight() throws Exception{
		return "right";
	}
	public String toTop() throws Exception{
		return "top";
	}
	public String toLogin() throws Exception{
		return "login";
	}
}
