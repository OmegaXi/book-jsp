package org.service.imp;

import org.dao.IOrderDAO;
import org.service.IOrderService;
import org.model.Orders;

public class OrderService implements IOrderService {

	private IOrderDAO orderDAO;	//����orderDAO
	//����orderDAO��setter����
	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO=orderDAO;
	}
	//���湺����Ϣ
	public Orders saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}
}
