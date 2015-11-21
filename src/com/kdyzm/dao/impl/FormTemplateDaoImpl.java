package com.kdyzm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.FormTemplateDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.FormTemplate;
@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends BaseDaoImpl<FormTemplate> implements FormTemplateDao<FormTemplate>{

}
