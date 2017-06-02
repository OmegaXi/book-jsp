package org.service.impl;

import java.util.List;

import org.dao.IBookDAO;
import org.service.IBookService;
import org.model.Book;

public class BookService implements IBookService {

	
	private IBookDAO bookDAO;	//为了使用DAO组件而设置的属性
	//根据图书种类id，得到该种类的所有图书
	public List getBookbyCatalogid(Integer catalogid){
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	// 属性bookDAO的getter/setter方法
	public IBookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO=bookDAO;
	}
	@Override
	public List getBookbyCatalogidPaging(Integer catalogid,
			int currentPage, int pageSize) {
		return bookDAO.getBookbyCatalogidPaging(catalogid, currentPage, pageSize);
	}
	@Override
	public int getTotalbyCatalog(Integer catalogid) {
		return bookDAO.getTotalbyCatalog(catalogid);
	}
	@Override
	public List getRequiredBookbyHql(String hql) {
		return bookDAO.getRequiredBookbyHql(hql);
	}
	@Override
	public Book getBookbyId(Integer bookid){
	    return bookDAO.getBookbyId(bookid);
	}

}
