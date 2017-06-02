package org.action;

import java.util.List;
import java.util.Map;

import org.service.IBookService;
import org.service.ICatalogService;
import tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	protected ICatalogService catalogService; // 为使用业务层而设置的属性
	protected Integer catalogid; // 分类id
	protected IBookService bookService;
	private Integer currentPage = 1;
	private String bookname;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	// 浏览分类目录
	public String browseCatalog() throws Exception {
		List catalogs = catalogService.getAllCatalogs(); // 直接调用业务层方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}

	public String browseBook() throws Exception {
		List books = bookService.getBookbyCatalogid(catalogid);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	// 分页显示图书
	public String browseBookPaging() throws Exception {
		int totalSize = bookService.getTotalbyCatalog(catalogid);
		Pager pager = new Pager(currentPage, totalSize);
		List books = bookService.getBookbyCatalogidPaging(catalogid,
				currentPage, pager.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		// 购物车要返回时，需要记住返回的地址
		Map session = ActionContext.getContext().getSession();
		request.put("catalogid", catalogid);
		return SUCCESS;
	}

	public String searchBook() throws Exception {
		StringBuffer hql = new StringBuffer("from Book b ");
		if (bookname != null && bookname.length() != 0)
			hql.append("where b.bookname like '%" + bookname + "%'");
		List books = bookService.getRequiredBookbyHql(hql.toString());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	// 以下为各属性的getter/setter方法
	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public ICatalogService getCatalogService() {
		return this.catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

}
