package com.kdyzm.service;

import java.util.Collection;

import org.jbpm.api.ProcessDefinition;

import com.kdyzm.domain.FormTemplate;

public interface FormTemplateService {

	Collection<ProcessDefinition> getAllProcessDefinitions();

	void save(FormTemplate formTemplate);

	Collection<FormTemplate> getAllFormTemplates();

	void deleteFormTemplateById(String formTemplateId);

	FormTemplate getFormTemplateById(String formTemplateId);

}
