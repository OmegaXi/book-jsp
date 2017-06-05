package org.action;

import java.util.Map;
import org.service.IUserService;
import org.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//属性user，用于接收从界面输入的用户信息
		private User user;
		//属性userService，用于帮助action完成相关的操作
		protected IUserService userService;
		//用户注册，调用Service层的saveUser()方法
		public String register() throws Exception{
			userService.saveUser(user);
			return SUCCESS;
		}
		
		//用户修改
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
		//用户登录，调用Service层的validateUser()方法
		public String execute() throws Exception{
			User u=userService.validateUser(user.getUsername(),user.getPassword());
			if(u!=null)
			{
				Map session=ActionContext.getContext().getSession();
				//保存此次会话的账号信息
				session.put("user",u);
				return SUCCESS;
			}
			return INPUT;
		}
		//用户注销，去除会话中的用户账号信息即可，无须调用Service层
		public String logout() throws Exception{
			Map session=ActionContext.getContext().getSession();
                   //从jsp页面获取值
			session.remove("user");
			return SUCCESS;
		}
		//属性user的getter/setter方法
		public User getUser(){
			return this.user;
		}
		public void setUser(User user){
			this.user=user;
		}
		//属性userService的getter/setter方法
		public IUserService getUserService(){
			return this.userService;
		}
		public void setUserService(IUserService userService){
			this.userService=userService;
		}

}
