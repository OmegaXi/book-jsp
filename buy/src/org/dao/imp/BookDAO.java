package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.IBookDAO;
import org.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;

public class BookDAO extends BaseDAO implements IBookDAO {

	//ʵ��IBookDAO�ӿڵ�getBookbyCatalogid()����
		public List getBookbyCatalogid(Integer catalogid){
			Session session=getSession();
			String hql="from Book b where b.catalog.catalogid=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, catalogid);
			List books=query.list();
			session.close();
			return books;
		}

		@Override
		public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,
				int pageSize) {
			Session session=getSession();
			Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
			query.setParameter(0, catalogid);
			//ȷ����ʼ�α��λ��
			int startRow=(currentPage-1)*pageSize;
			query.setFirstResult(startRow);
			query.setMaxResults(pageSize);
			List books=query.list();
			session.close();
			return books;
		}

		@Override
		public int getTotalbyCatalog(Integer catalogid) {
			Session session=getSession();
			Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
			query.setParameter(0,catalogid);
			List books=query.list();
			int totalSize=books.size();
			session.close();
			return totalSize;
		}

		@Override
		public List getRequiredBookbyHql(String hql) {
			Session session=getSession();
		    Query query=session.createQuery(hql);
		    List books=query.list();
		    return books;

		}

		@Override
		public Book getBookbyId(Integer bookid) {
			Session session=getSession();
			//Hibernate����Book��ĳ־ö���
			Book book=(Book)session.get(Book.class,bookid);
			session.close();
			return book;

		}

}
