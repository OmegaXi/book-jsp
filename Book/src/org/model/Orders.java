package org.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.model.User;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private User user;
	private Date orderdate;
	private Set orderitems = new HashSet(0);

	
	// Constructors

	public Date getOrderdate() {
		return orderdate;
	}

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(User user, Timestamp orderdate) {
		this.user = user;
		this.orderdate = orderdate;
	}

	/** full constructor */
	public Orders(User user, Timestamp orderdate, Set orderitems) {
		this.user = user;
		this.orderdate = orderdate;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date date) {
		this.orderdate = date;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}