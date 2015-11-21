package com.kdyzm.service;

import java.util.Collection;

import com.kdyzm.domain.Form;

public interface FormService {

	void saveForm(Form form);

	Collection<Form> getAllForms();

	Collection<Form> getAllFormsByUserName(String userName);

	Form getFormByFormId(String fid);

	void updateForm(Form form);

}
