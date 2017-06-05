package org.action;

import java.util.List;
import java.util.Map;

import org.service.IBookService;
import org.service.ICatalogService;
import tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	protected ICatalogService catalogService; // Ϊʹ��ҵ�������õ�����
	protected Integer catalogid; // ����id
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

	// �������Ŀ¼
	public String browseCatalog() throws Exception {
		List catalogs = catalogService.getAllCatalogs(); // ֱ�ӵ���ҵ��㷽��
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

	// ��ҳ��ʾͼ��
	public String browseBookPaging() throws Exception {
		int totalSize = bookService.getTotalbyCatalog(catalogid);
		Pager pager = new Pager(currentPage, totalSize);
		List books = bookService.getBookbyCatalogidPaging(catalogid,
				currentPage, pager.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		// ���ﳵҪ����ʱ����Ҫ��ס���صĵ�ַ
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

	// ����Ϊ�����Ե�getter/setter����
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
