package org.service.imp;

import java.util.List;

import org.dao.ICatalogDAO;
import org.service.ICatalogService;

public class CatalogService implements ICatalogService {


	private ICatalogDAO catalogDAO;	//属性catalogDAO
	//得到所有图书种类
	public List getAllCatalogs(){
		return catalogDAO.getAllCatalogs();
	}
	//属性catalogDAO的getter/setter方法
		public ICatalogDAO getCatalogDAO(){
			return catalogDAO;
		}
		public void setCatalogDAO(ICatalogDAO catalogDAO){
			this.catalogDAO=catalogDAO;
		}


}
