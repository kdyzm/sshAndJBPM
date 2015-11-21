package com.kdyzm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.UserDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{

	@Override
	public User getUserByName(String userName) {
		String sql="from User where userName=?";
		List<User> list=this.hibernateTemplate.find(sql,userName);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
