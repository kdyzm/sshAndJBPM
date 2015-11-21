package com.kdyzm.dao;

import java.util.Collection;

import com.kdyzm.dao.base.BaseDao;
import com.kdyzm.domain.Form;

public interface FormDao<T> extends BaseDao<T> {

	Collection<Form> getAllFormsByUserName(String userName);

}
