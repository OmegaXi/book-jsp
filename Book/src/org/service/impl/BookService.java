package org.service.impl;

import java.util.List;

import org.dao.IBookDAO;
import org.service.IBookService;
import org.model.Book;

public class BookService implements IBookService {

	
	private IBookDAO bookDAO;	//Ϊ��ʹ��DAO��������õ�����
	//����ͼ������id���õ������������ͼ��
	public List getBookbyCatalogid(Integer catalogid){
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	// ����bookDAO��getter/setter����
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
