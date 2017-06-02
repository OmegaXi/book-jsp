package org.dao;

import java.util.List;

import org.model.Book;

public interface IBookDAO {

	//通过图书类别id号，得到相应类别的图书
	public List getBookbyCatalogid(Integer catalogid);
	//分页显示图书
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	//得到某种类型图书的数目
	public int getTotalbyCatalog(Integer catalogid);
	 //搜索图书
    public List getRequiredBookbyHql(String hql);
    //添加购物车
    public Book getBookbyId(Integer bookid);
}
