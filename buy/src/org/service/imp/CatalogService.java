package org.service.imp;

import java.util.List;

import org.dao.ICatalogDAO;
import org.service.ICatalogService;

public class CatalogService implements ICatalogService {


	private ICatalogDAO catalogDAO;	//����catalogDAO
	//�õ�����ͼ������
	public List getAllCatalogs(){
		return catalogDAO.getAllCatalogs();
	}
	//����catalogDAO��getter/setter����
		public ICatalogDAO getCatalogDAO(){
			return catalogDAO;
		}
		public void setCatalogDAO(ICatalogDAO catalogDAO){
			this.catalogDAO=catalogDAO;
		}


}
