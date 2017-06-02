package org.dao;

import java.util.List;

import org.model.Book;

public interface IBookDAO {

	//ͨ��ͼ�����id�ţ��õ���Ӧ����ͼ��
	public List getBookbyCatalogid(Integer catalogid);
	//��ҳ��ʾͼ��
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	//�õ�ĳ������ͼ�����Ŀ
	public int getTotalbyCatalog(Integer catalogid);
	 //����ͼ��
    public List getRequiredBookbyHql(String hql);
    //��ӹ��ﳵ
    public Book getBookbyId(Integer bookid);
}
