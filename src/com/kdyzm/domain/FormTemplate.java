package com.kdyzm.domain;

import java.util.Set;

/**
 * 对应着申请模板表
 * @author kdyzm
 *
 */
public class FormTemplate {
	private String formTemplateId;		//表单模板id
	private String name;				//表单模板名称
	private String processKey;			//流程key
	private String url;					//表单模板的存取位置
	private Set<Form> forms;			//一对多的关系，一个表单模板可以有多个申请表单
	public String getFormTemplateId() {
		return formTemplateId;
	}
	public void setFormTemplateId(String formTemplateId) {
		this.formTemplateId = formTemplateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Form> getForms() {
		return forms;
	}
	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
}	
