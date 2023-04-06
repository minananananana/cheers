package kr.co.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //�� �۰���
	private int startPage; //���� ������
	private int endPage; //�� ������
	private boolean prev; //���� ��
	private boolean next; //���� ��
	private int displayPageNum = 10;//�������� ������ �� ����
	private Criteria cri;
	
	public void setCri(Criteria cri) {//��Ʈ�ѷ����� ���� �Ұ�
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {//��Ʈ�ѷ����� ������ ��
		this.totalCount = totalCount;
		calcData();
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public Criteria getCri() {
		return cri;
	}
	 
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum); //�ִ� ������ ������
		//								(���� ������)/(10.0)
		//								(�ø�)(1/10.0) * 10 = 10
		//								(�ø�)(2/10.0) * 10 = 10
		//								(�ø�)(11/10.0)* 10 = 20     ��:  ���� 101�� �϶�
		startPage = (endPage - displayPageNum) + 1; //���� ������
		//			      10 - 10+1=1
		//				  20 - 10+1=11
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));//�ӽ� ������ ������
		//								    (�� �۰��� / ������ �� �� ����)
		//                              (�ø�)(1/10.0) = 1
		//								(�ø�)(2/10.0) = 1
		//								(�ø�)(11/10.0) = 2
		//								(�ø�)(101/10.0) = 11 : ���� 
		//								(�ø�)(200/10.0) = 20
		if (endPage > tempEndPage) { //������ ������ > �ӽ� ������ ����������
			endPage = tempEndPage;    //  ���� �� 12�� ������ ������ �������� 2������ ���̰� 
		}
		prev = startPage == 1 ? false : true; //������������ 1�̸� false �ƴϸ� true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true; // ������ ������ * 10 >= �� �۰��� �̸� false �ƴϸ� true
																		   //  10 * 10 >= 100
																		   //  11 * 10 >= 106
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =  //URI�� �������ִ� Ŭ����
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		//System.out.println(uriComponents.toString());
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page)
	{
	  
	 UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", cri.getPerPageNum())
	            .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	            .queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
	            .build(); 
	    return uriComponents.toUriString();  
	}

	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) { 
			return "";
		}
		 
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch(UnsupportedEncodingException e) { 
			return ""; 
		}
	}
}