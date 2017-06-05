package org.action;

import java.util.Map;
import org.service.IUserService;
import org.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//����user�����ڽ��մӽ���������û���Ϣ
		private User user;
		//����userService�����ڰ���action�����صĲ���
		protected IUserService userService;
		//�û�ע�ᣬ����Service���saveUser()����
		public String register() throws Exception{
			userService.saveUser(user);
			return SUCCESS;
		}
		
		//�û��޸�
		public String rewrite() throws Exception{
			Map session=ActionContext.getContext().getSession();
			User user1 = (User) session.get("user");
			user1.setUsername(user.getUsername());
			user1.setPassword(user.getPassword());
			user1.setAge(user.getAge());
			user1.setSex(user.getSex());
			userService.saveUser(user1);
			session.put("user", user1);
			return SUCCESS;
		}
		//�û���¼������Service���validateUser()����
		public String execute() throws Exception{
			User u=userService.validateUser(user.getUsername(),user.getPassword());
			if(u!=null)
			{
				Map session=ActionContext.getContext().getSession();
				//����˴λỰ���˺���Ϣ
				session.put("user",u);
				return SUCCESS;
			}
			return INPUT;
		}
		//�û�ע����ȥ���Ự�е��û��˺���Ϣ���ɣ��������Service��
		public String logout() throws Exception{
			Map session=ActionContext.getContext().getSession();
                   //��jspҳ���ȡֵ
			session.remove("user");
			return SUCCESS;
		}
		//����user��getter/setter����
		public User getUser(){
			return this.user;
		}
		public void setUser(User user){
			this.user=user;
		}
		//����userService��getter/setter����
		public IUserService getUserService(){
			return this.userService;
		}
		public void setUserService(IUserService userService){
			this.userService=userService;
		}

}
