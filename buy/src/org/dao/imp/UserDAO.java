package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.IUserDAO;
import org.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO extends BaseDAO implements IUserDAO {

	@Override
	//保存用户的注册信息到数据库中
		public void saveUser(User user){
			Session session=getSession();
			//将user对象保存到数据库中
			Transaction tx=session.beginTransaction();
			session.save(session.merge(user));
			tx.commit();
			session.close();
		}
		//验证用户信息，如果正确，返回一个User实例，否则返回null
		public User validateUser(String username,String password){		
			String sql="from User u where u.username=? and u.password=?";
			Session session=getSession();
			Query query=session.createQuery(sql);
			query.setParameter(0,username);
			query.setParameter(1,password);
			List users=query.list();
			if(users.size()!=0)
			{
				User user=(User)users.get(0);
				return user;
			}
			session.close();
			return null;
		}
}
