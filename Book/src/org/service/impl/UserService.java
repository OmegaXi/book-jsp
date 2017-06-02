package org.service.impl;

import org.dao.IUserDAO;
import org.service.IUserService;
import org.model.User;

public class UserService implements IUserService {


	private IUserDAO userDAO;
	//����ע����Ϣ
	public void saveUser(User user){
		this.userDAO.saveUser(user);
	}
	//��֤�û���Ϣ
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

