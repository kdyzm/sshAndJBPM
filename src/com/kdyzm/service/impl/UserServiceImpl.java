package com.kdyzm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kdyzm.dao.UserDao;
import com.kdyzm.domain.User;
import com.kdyzm.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao<User> userDao;
	/**
	 * 验证用户名和密码的方法
	 */
	@Override
	public User checkUser(User user) {
		User temp=userDao.getUserByName(user.getUserName());
		if(temp.getPassword().equals(user.getPassword())){
			return temp;
		}
		return null;
	}
	@Override
	public void saveUser(User user1) {
		userDao.saveEntry(user1);
	}

}
