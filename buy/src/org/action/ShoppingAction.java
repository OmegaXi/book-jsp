package org.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import tool.Cart;

import org.service.IBookService;
import org.service.IOrderService;
import org.model.Book;
import org.model.Orderitem;
import org.model.Orders;
import org.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	private int quantity;
	private Integer bookid;
	private IBookService bookService;
	private IOrderService orderService;

	// 添加到购物车
	public String addToCart() throws Exception {
		Book book = bookService.getBookbyId(bookid);
		Orderitem orderitem = new Orderitem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addBook(bookid, orderitem);
		session.put("cart", cart);
		return SUCCESS;
	}

	// 更新购物车
	public String updateCart() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.updateCart(bookid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}

	// 结账下订单
	public String checkout() throws Exception {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Cart cart = (Cart) session.get("cart");
		if (user == null || cart == null)
			return ActionSupport.ERROR;
		Orders order = new Orders();
		order.setOrderdate((Timestamp) new Timestamp(new Date().getTime()));
		order.setUser(user);
		for (Iterator it = cart.getItems().values().iterator(); it.hasNext();) {
			Orderitem orderitem = (Orderitem) it.next();
			orderitem.setOrders(order);
			order.getOrderitems().add(orderitem);
		}
		orderService.saveOrder(order);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("order", order);
		return SUCCESS;
	}

	// 属性bookid的getter/setter方法
	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	// 属性quantity的getter/setter方法
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// 属性bookService的getter/setter方法
	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
}
