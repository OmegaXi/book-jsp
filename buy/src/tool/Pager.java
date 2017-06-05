package tool;

public class Pager {
	private int currentPage;//��ǰҳ��
	private int pageSize=3;//ÿҳ�ļ�¼�����˴�����һ����ʼֵ��ÿҳ��ʾ3��
	private int totalSize;	//�ܵļ�¼��
	private int totalPage;	//�ܵ�ҳ�������ܵļ�¼������ÿҳ�ļ�¼���õ���totalSize/pageSize

	private boolean hasFirst;	//�Ƿ��е�һҳ
	private boolean hasPrevious;	//�Ƿ�����һҳ
	private boolean hasNext;	//�Ƿ�����һҳ
	private boolean hasLast;	//�Ƿ������һҳ
	//���캯�������ݵ�ǰҳ���ܵļ�¼��	
	public Pager(int currentPage,int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	//����currentPage��getter/setter����
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage=currentPage;
	}
	//����pageSize ��getter/setter����
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize=pageSize;
	}
	//����totalSize��getter/setter����
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize=totalSize;
	}
	//����totalPage��getter/setter����
	public int getTotalPage() {
		//���е�ҳ������ͨ���ܵļ�¼������ÿҳ����Ŀ���
		totalPage=totalSize/pageSize;
		if(totalSize%pageSize!=0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage=totalPage;
	}
	//�жϵ�ǰҳ�Ƿ�Ϊ1�����ǣ���û�С���ҳ��
	public boolean isHasFirst() {
		if(currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst=hasFirst;
	}
	//�ж���û�С���һҳ��
	public boolean isHasPrevious() {
		//�������ҳ�����ڣ���һ���С���һҳ��
		if(isHasFirst())
			return true;
		else
			return false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious=hasPrevious;
	}
	//�ж���û�С���һҳ��
	public boolean isHasNext() {
		//����С�βҳ�����ڣ���һ���С���һҳ��
		if(isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext=hasNext;
	}
	//�ж���û�С�βҳ��
	public boolean isHasLast() {
		//�����ǰҳ������ҳ����˵�����Ѿ������һҳ�ˣ�û�С�βҳ��
		if(currentPage==getTotalPage())
			return false;
		else
			return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast=hasLast;
	}
}
