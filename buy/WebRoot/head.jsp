<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>网上书店</title>
<link href="css/bookstore.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="head">
		<div class="head_left">
			 <h1>网上书店</h1>
		</div>
		<div class="head_right">
			<div class="head_right_nei">
				<div class="head_top">
					<div class="head_buy" style="width: 85px; ">
						<a href="showCart.jsp"><strong>我的购物车</strong></a>
					</div>
				</div>
				<div class="head_middle">
					<a class="title01" href="index.jsp"> <span>&nbsp;&nbsp;首页&nbsp;&nbsp;</span>
					</a>
					<s:if test="#session.user==null">
						<a class="title01" href="login.jsp"> <span>&nbsp;&nbsp;登录&nbsp;&nbsp;</span>
						</a>
					</s:if>
					<s:else>
						<a class="title01" href="logout.action"> <span>&nbsp;&nbsp;注销&nbsp;&nbsp;</span>
						</a>
						<a class="title01" href="rewrite.jsp"> <span>&nbsp;&nbsp;修改个人信息&nbsp;&nbsp;</span>
						</a>
					</s:else>
					<a class="title01" href="register.jsp"> <span>&nbsp;&nbsp;注册&nbsp;&nbsp;</span>
					</a>
				</div>
				<div class="head_bottom">
					<form action="searchBook.action" method="post">
						<input type="text" name="bookname" size="50" align="middle" /> <input
							type="image" name="submit" src="picture/search02.jpg" align="top"
							style="width: 48px; height: 22px" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
