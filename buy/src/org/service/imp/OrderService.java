package org.service.imp;

import org.dao.IOrderDAO;
import org.service.IOrderService;
import org.model.Orders;

public class OrderService implements IOrderService {

	private IOrderDAO orderDAO;	//属性orderDAO
	//属性orderDAO的setter方法
	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO=orderDAO;
	}
	//保存购物信息
	public Orders saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}
}
