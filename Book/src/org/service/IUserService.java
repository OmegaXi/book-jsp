package org.service;

import org.model.User;

public interface IUserService {

	//����ע����Ϣ
		public void saveUser(User user);
		//��֤�û���Ϣ
		public User validateUser(String username,String password);

}
