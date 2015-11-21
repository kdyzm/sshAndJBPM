package com.kdyzm.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.FormDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.Form;
@Repository("formDao")
public class FormDaoImpl extends BaseDaoImpl<Form> implements FormDao<Form> {

	@Override
	public Collection<Form> getAllFormsByUserName(String userName) {
		String sql="from Form where applicator = ?";
		return this.hibernateTemplate.find(sql,userName);
	}

}
