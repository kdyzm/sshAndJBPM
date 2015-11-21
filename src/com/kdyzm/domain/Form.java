package com.kdyzm.domain;

import java.util.Set;

/**
 * 对应着申请表单表
 * @author kdyzm
 *
 */
public class Form {
	private String fid;		
	private String title;
	private String applicator;	
	private String applicateTime;			//申请的时间
	private String date;					//申请的日期
	private FormTemplate formTemplate;		//一个表单模板对应着多个表单，表单模板和申请表单之间是一对多的关系
	private Set<Approve> approves;			//一个申请表单对应着多次审批，一次申请有多次审批的过程
	private String url;						//申请表上传到服务器上的位置
	private String state;
	private String name;					//上传的文件名
	private String processId;
/******************************************************/
	public String getFid() {
		return fid;
	}
	public String getProcessId() {
	return processId;
}
public void setProcessId(String processId) {
	this.processId = processId;
}
	public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApplicator() {
		return applicator;
	}
	public void setApplicator(String applicator) {
		this.applicator = applicator;
	}
	public String getApplicateTime() {
		return applicateTime;
	}
	public void setApplicateTime(String applicateTime) {
		this.applicateTime = applicateTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public FormTemplate getFormTemplate() {
		return formTemplate;
	}
	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}
	public Set<Approve> getApproves() {
		return approves;
	}
	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}
}
