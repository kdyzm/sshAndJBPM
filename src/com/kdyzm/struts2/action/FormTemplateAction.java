package com.kdyzm.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kdyzm.domain.FormTemplate;
import com.kdyzm.service.FormTemplateService;
import com.kdyzm.utils.FileUploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends ActionSupport{
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	public String createNewUI() throws Exception{
		Collection<ProcessDefinition> processDefinitions=formTemplateService.getAllProcessDefinitions();
		Set<String> processDefinitionNames=new HashSet<String>();
		for(ProcessDefinition processDefinition:processDefinitions){
			processDefinitionNames.add(processDefinition.getKey());
		}
		ActionContext.getContext().put("processDefinitionNames", processDefinitionNames);
		return "toCreateNewUI";
	}
	public String toFormTemplateIndex() throws Exception{
		Collection<FormTemplate>formTemplates=formTemplateService.getAllFormTemplates();
		ActionContext.getContext().put("formTemplates", formTemplates);
		return "toIndex";
	}
	public String deleteByFormTemplateId() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String formTemplateId=request.getParameter("formTemplateId");
		FormTemplate formTemplate=formTemplateService.getFormTemplateById(formTemplateId);
		File file=new File(formTemplate.getUrl());
		file.delete();
		formTemplateService.deleteFormTemplateById(formTemplateId);
		return "toIndexAction";
	}
	private String formTemplateName;
	private String processDefinitionKey;
	private File formTemplateFile;
	private String formTemplateFileFileName;
	
	public String getFormTemplateFileFileName() {
		return formTemplateFileFileName;
	}
	public void setFormTemplateFileFileName(String formTemplateFileFileName) {
		this.formTemplateFileFileName = formTemplateFileFileName;
	}
	public String getFormTemplateName() {
		return formTemplateName;
	}
	public void setFormTemplateName(String formTemplateName) {
		this.formTemplateName = formTemplateName;
	}
	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}
	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}
	public File getFormTemplateFile() {
		return formTemplateFile;
	}
	public void setFormTemplateFile(File formTemplateFile) {
		this.formTemplateFile = formTemplateFile;
	}
	public String addNewFormTemplate() throws Exception{
		FormTemplate formTemplate=new FormTemplate();
		String[] arr=this.getFormTemplateFileFileName().split("\\.");
		formTemplate.setName(this.getFormTemplateName()+"."+arr[arr.length-1]);
		formTemplate.setProcessKey(this.getProcessDefinitionKey());
		File file=FileUploadUtils.saveUploadFileToDestDir(formTemplateFile,this.getFormTemplateFileFileName());
		formTemplate.setUrl(file.getAbsolutePath());
		formTemplateService.save(formTemplate);
		return "toIndexAction";
	}
	public String showAllFormTemplate() throws Exception{
		Collection<FormTemplate>formTemplates=formTemplateService.getAllFormTemplates();
		ActionContext.getContext().put("formTemplates", formTemplates);
		return "showAllTemplateForApplicator";
	}
	/**
	 * 下载指定formTemplateId指向的文件的方法
	 */
	public String downloadFormTemplateById() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String formTemplateId=request.getParameter("formTemplateId");
		FormTemplate formTemplate=formTemplateService.getFormTemplateById(formTemplateId);
		File file=new File(formTemplate.getUrl());
		String fileName=URLEncoder.encode(formTemplate.getName(),"utf-8");
		
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
}
