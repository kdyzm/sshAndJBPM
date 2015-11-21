package com.kdyzm.dao;

import com.kdyzm.dao.base.BaseDao;
import com.kdyzm.domain.User;

public interface UserDao<T> extends BaseDao<T> {

	User getUserByName(String userName);

}
