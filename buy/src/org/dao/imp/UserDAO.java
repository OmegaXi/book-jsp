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
	//�����û���ע����Ϣ�����ݿ���
		public void saveUser(User user){
			Session session=getSession();
			//��user���󱣴浽���ݿ���
			Transaction tx=session.beginTransaction();
			session.save(session.merge(user));
			tx.commit();
			session.close();
		}
		//��֤�û���Ϣ�������ȷ������һ��Userʵ�������򷵻�null
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
