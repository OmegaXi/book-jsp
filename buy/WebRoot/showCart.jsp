<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
		<title>网上购书系统</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
		<jsp:include page="head.jsp"/>
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
					<s:set name="items" value="#session.cart.items"/>
					<s:if test="#items.size != 0">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="blue">
						<h3>购物车中的图书</h3>
						</font>
						<br/>
			<table id="tb" cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
				<tr>
				<td bgcolor="rgb(238,238,238)" align="center" width="50%" height="12">书 名</td>
				<td bgcolor="rgb(238,238,238)" align="center" width="15%" >定 价</td>
				<td bgcolor="rgb(238,238,238)" align="center" width="15%">数 量</td>
				<td bgcolor="rgb(238,238,238)" align="center" width="20%">
										<font color="gray">操 作</font>
									</td>
								</tr>
							<form action="updateCart.action" method="post">
								<s:iterator value="#items">
									<tr>
										<td>
									<s:property value="value.book.bookname"/>
										</td>
										<td>
									<s:property value="value.book.price"/>
										</td>
										<td>
<input type="text" name="quantity" value="<s:property value="value.quantity"/>" size="4"/>
<input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>
										</td>
										<td>
											<input type="submit" value="更新"/>
										</td>
									</tr>
								</s:iterator>
							</form>
							</table>
						<hr/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;
						<a href="checkout.action"><img src="picture/count.gif"/></a>
					</s:if>
					<s:else>
						对不起，您还没有选购图书！
					</s:else>
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp"/>
</body>
</html>
