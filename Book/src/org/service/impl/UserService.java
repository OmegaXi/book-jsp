package org.service.impl;

import org.dao.IUserDAO;
import org.service.IUserService;
import org.model.User;

public class UserService implements IUserService {


	private IUserDAO userDAO;
	//保存注册信息
	public void saveUser(User user){
		this.userDAO.saveUser(user);
	}
	//验证用户信息
	public User validateUser(String username,String password){
		return userDAO.validateUser(username, password);
	}
	public IUserDAO getUserDAO(){
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO){
		this.userDAO=userDAO;
	}
}

