package com.kdyzm.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kdyzm.dao.FormDao;
import com.kdyzm.domain.Form;
import com.kdyzm.service.FormService;
@Service("formService")
public class FormServiceImpl implements FormService{
	@Resource(name="formDao")
	private FormDao<Form> formDao;
	@Override
	public void saveForm(Form form) {
		formDao.saveEntry(form);
	}
	@Override
	public Collection<Form> getAllForms() {
		return formDao.getAllEntry();
	}
	@Override
	public Collection<Form> getAllFormsByUserName(String userName) {
		return formDao.getAllFormsByUserName(userName);
	}
	@Override
	public Form getFormByFormId(String fid) {
		
		return this.formDao.getEntryById(fid);
	}
	@Override
	public void updateForm(Form form) {
		this.formDao.updateEntry(form);
	}

}
