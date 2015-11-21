package com.kdyzm.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import com.kdyzm.dao.FormTemplateDao;
import com.kdyzm.domain.FormTemplate;
import com.kdyzm.service.FormTemplateService;
@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService{
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	@Resource(name="formTemplateDao")
	private FormTemplateDao<FormTemplate> formTemplateDao;
	//获取所有ProcessDefinition的方法
	@Override
	public Collection<ProcessDefinition> getAllProcessDefinitions() {
		return processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.list();
	}
	/**
	 * 保存模板信息的方法
	 */
	@Override
	public void save(FormTemplate formTemplate) {
		formTemplateDao.saveEntry(formTemplate);
	}
	@Override
	public Collection<FormTemplate> getAllFormTemplates() {
		return this.formTemplateDao.getAllEntry();
	}
	@Override
	public void deleteFormTemplateById(String formTemplateId) {
		FormTemplate formTemplate=this.formTemplateDao.getEntryById(formTemplateId);
		this.formTemplateDao.deleteEntry(formTemplate);
	}
	@Override
	public FormTemplate getFormTemplateById(String formTemplateId) {
		return this.formTemplateDao.getEntryById(formTemplateId);
	}
}
