package org.service;

import java.util.List;

import org.model.Book;

public interface IBookService {

	// ����ͼ������id���õ������������ͼ��
		public List getBookbyCatalogid(Integer catalogid);

		public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,
				int pageSize);

		public int getTotalbyCatalog(Integer catalogid);

		public List getRequiredBookbyHql(String hql);

		// ����bookid�õ�ͼ����Ϣ
		public Book getBookbyId(Integer bookid);
}
