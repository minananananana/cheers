package kr.co.vo;

public class Criteria {

	private int page;//���� ������
	private int perPageNum;//�������� �� ����
	private int rowStart;//�� ����
	private int rowEnd;//�� ��
	
	public Criteria() {//�⺻ ������
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {//���� ������ ����
		if (page <= 0) {//�������� 0�̸� 1�� ����
			this.page = 1;
			return;
		}
		this.page = page;//���� ������
	}
	
	public void setPerPageNum(int perPageNum) {//�������� �� ����
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {//���� ������ ��������
		return page;
	}
	
	public int getPageStart() {//������ ���� ��������
		return (this.page - 1) * perPageNum;
		// ���� �������� 1�̸� (1-1) * 10 = 0
		// ���� �������� 2�̸� (2-1) * 10 = 10
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum);
		return rowStart;
	}
	
	public int getRowEnd() {
		rowEnd = 10;
		return rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}
	
	
}