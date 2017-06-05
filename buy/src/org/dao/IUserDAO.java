package org.dao;

import org.model.User;

public interface IUserDAO {

	//用户注册时，保存注册信息
		public void saveUser(User user);
		//用户登录时，验证用户信息
		public User validateUser(String username,String password);
}
