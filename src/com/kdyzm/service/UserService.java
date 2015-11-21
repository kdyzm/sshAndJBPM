package com.kdyzm.service;

import com.kdyzm.domain.User;

public interface UserService {

	User checkUser(User user);

	void saveUser(User user1);

}
