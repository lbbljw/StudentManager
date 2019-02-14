package com.login.dao;

import com.login.bean.User;

public interface UserDao {

	public User getUserByUsernameAndPassword(String username,String password);
}

