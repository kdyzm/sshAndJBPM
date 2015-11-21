package com.kdyzm.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kdyzm.domain.Form;
import com.kdyzm.domain.FormTemplate;
import com.kdyzm.domain.Rectangle;
import com.kdyzm.domain.TaskView;
import com.kdyzm.domain.User;
import com.kdyzm.service.ApproveService;
import com.kdyzm.service.FormService;
import com.kdyzm.service.FormTemplateService;
import com.kdyzm.service.JBPMProcessManagementService;
import com.kdyzm.service.PDManagementService;
import com.kdyzm.utils.DateUtils;
import com.kdyzm.utils.FileUploadUtils;
import com.kdyzm.utils.FormState;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller("formAction")
@Scope("prototype")
public class FormAction extends ActionSupport{
	@Resource(name="formService")
	private FormService formService;
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	@Resource(name="jbpmProcessManagementService")
	private JBPMProcessManagementService jbpmProcessManagementService;
	@Resource(name="approveService")
	private ApproveService approveService;
	public String showApplicationUI() throws Exception{
		HttpServletRequest httpServletRequest=ServletActionContext.getRequest();
		String formTemplateId=httpServletRequest.getParameter("formTemplateId");
		FormTemplate formTemplate=formTemplateService.getFormTemplateById(formTemplateId);
		ActionContext.getContext().put("formTemplate", formTemplate);
		return "showApplicationUI";
	}
	private File formFile;
	private String formFileFileName;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JSON(serialize=false)
	public File getFormFile() {
		return formFile;
	}
	public void setFormFile(File formFile) {
		this.formFile = formFile;
	}
	@JSON(serialize=false)
	public String getFormFileFileName() {
		return formFileFileName;
	}
	public void setFormFileFileName(String formFileFileName) {
		this.formFileFileName = formFileFileName;
	}
	
	//不仅仅是上传表单，还有更重要的流程控制的问题
	public String uploadForm() throws Exception{
		Form form=new Form();
		HttpServletRequest request=ServletActionContext.getRequest();
		String formTemplateId=request.getParameter("formTemplateId");
		FormTemplate formTemplate=formTemplateService.getFormTemplateById(formTemplateId);
		Date date=new Date();
		String dateString=DateUtils.dateToString(date);
		User user=(User) request.getSession().getAttribute("user");
		//先部署流程实例
		
		form.setApplicateTime(dateString);
		form.setApplicator(user.getUserName());				//申请人设置，谁登陆系统的就是谁申请的
		form.setDate(dateString);
		form.setFormTemplate(formTemplate);
		form.setState(FormState.SHENQINGZHONG);				//一开始的时候申请状态就是申请中
		form.setTitle(formTemplate.getProcessKey()+"-"+user.getUserName()+"-"+dateString);
		File file=FileUploadUtils.saveUploadFileToDestDir(formFile, formFileFileName);
		form.setUrl(file.getAbsolutePath());
		form.setName(formFileFileName);
		
		formService.saveForm(form);
		jbpmProcessManagementService.startProcessByKey(formTemplate.getProcessKey(),form);
		//发起申请之后应当跳转到我的所有的申请表上
		return "toListAllApplicationAction";
	}
	
	public String listAllApplication() throws Exception{
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Collection<Form>taskViews=formService.getAllFormsByUserName(user.getUserName());
		ActionContext.getContext().put("forms", taskViews);
		return "listAllApplication";
	}
	
	//根据formId下载form对象的方法
	public String downloadFormByFormId() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String fid=request.getParameter("fid");
		Form form=formService.getFormByFormId(fid);
		File file=new File(form.getUrl());
		String fileName=form.getName();
		fileName=URLEncoder.encode(fileName,"utf-8");
		
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition","attachment;filename="+fileName);
		FileInputStream fis=new FileInputStream(file);
		OutputStream os=response.getOutputStream();
		int length=-1;
		byte buff[]=new byte[1024];
		while((length=fis.read(buff))!=-1){
			os.write(buff, 0, length);
		}
		os.close();
		fis.close();
		return null;
	}
	
	
	private InputStream is;
	public InputStream getInputStream() {
		return is;
	}
	public void setInputStream(InputStream is) {
		this.is = is;
	}
	@Resource(name="pdManagementService")
	private PDManagementService pdManagementService;
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	public String showImageUI() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String processId=request.getParameter("processId");
		ProcessInstance processInstance=processEngine.getExecutionService().createProcessInstanceQuery().processInstanceId(processId).uniqueResult();
		Set<String> names=processInstance.findActiveActivityNames();
		List<Rectangle>rectanglelist=new ArrayList<Rectangle>();
		for(String name:names){
			ActivityCoordinates ac=this.processEngine.getRepositoryService().getActivityCoordinates(processInstance.getProcessDefinitionId(), name);
			Rectangle rectangle=new Rectangle();
			rectangle.setX(ac.getX());
			rectangle.setY(ac.getY());
			rectangle.setHeight(ac.getHeight());
			rectangle.setWidth(ac.getWidth());
			rectanglelist.add(rectangle);
			System.out.println(rectangle);
		}
		ActionContext.getContext().put("processId", processId);
		ActionContext.getContext().put("rectanglelist", rectanglelist);
		return "showImageUI";
	}
	
	public String showCurrentActivityImage() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String processId=request.getParameter("processId");
		ProcessInstance processInstance=this.processEngine.getExecutionService().findProcessInstanceById(processId);
		InputStream is=this.pdManagementService.getImageInputStreamByPDID(processInstance.getKey());
		this.is=is;
		return "stream";
	}
}
