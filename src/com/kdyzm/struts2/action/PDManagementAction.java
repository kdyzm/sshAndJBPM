package com.kdyzm.struts2.action;

import java.io.File;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kdyzm.service.PDManagementService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("pdManagementAction")
@Scope("prototype")
public class PDManagementAction extends ActionSupport{
	private File file;
	private String fileFileName;
	private InputStream is;
	@Resource(name="pdManagementService")				//这里不需要提供get/set方法，之前真是多此一举了
	private PDManagementService pdManagementService;
	public InputStream getInputStream() {
		return is;
	}
	public void setInputStream(InputStream is) {
		this.is = is;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String deploy() throws Exception{
		pdManagementService.deploy(file);
		return "toIndexAction";
	}
	//删除流程定义的方法
	public String deleteByKey() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String processKey=request.getParameter("processKey");
		this.pdManagementService.deleteByProcessKey(processKey);
		return "toIndexAction";
	}
	//显示流程图的方法
	public String showProcessImageByPdid() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String processId=request.getParameter("processId");
		InputStream is=this.pdManagementService.getImageInputStreamByPDID(processId);
		this.is=is;
		return "stream";
	}
	public String showImageUI() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String processId=request.getParameter("processId");
		ActionContext.getContext().put("processId", processId);
		return "showImage";
	}
}
