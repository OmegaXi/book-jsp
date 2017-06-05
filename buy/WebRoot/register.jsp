<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上书店</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" namespace="/" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<div class="info_bk1">
					<div align="center">
						<s:form action="register.action" method="post" name="form1">
							用户注册<br>
							<s:textfield id="name" name= "user.username" size= "20" label="用户名"/><br>
							<s:password name= "user.password" size="21" label="密码"/><br>
							<s:textfield name= "user.sex" size="20" label="性别"/><br>
							<s:textfield name= "user.age" size="20" label="年龄"/><br>
							<s:submit value="注册"/>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
