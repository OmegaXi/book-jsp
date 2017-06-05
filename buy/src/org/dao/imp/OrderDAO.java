package org.dao.imp;

import org.dao.BaseDAO;
import org.dao.IOrderDAO;
import org.model.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	@Override
	//保存购物信息
    public Orders saveOrder(Orders order) {
	Session session = getSession();
	    Transaction tx = session.beginTransaction();
	    session.save(order);
	    tx.commit();
	    session.close();
	    return order;
    }
}
