package kr.co.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //총 글갯수
	private int startPage; //시작 페이지
	private int endPage; //끝 페이지
	private boolean prev; //이전 블럭
	private boolean next; //다음 블럭
	private int displayPageNum = 10;//페이지당 보여줄 글 갯수
	private Criteria cri;
	
	public void setCri(Criteria cri) {//컨트롤러에서 셋팅 할것
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {//컨트롤러에서 셋팅할 것
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
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum); //최대 마지막 페이지
		//								(현재 페이지)/(10.0)
		//								(올림)(1/10.0) * 10 = 10
		//								(올림)(2/10.0) * 10 = 10
		//								(올림)(11/10.0)* 10 = 20     예:  글이 101개 일때
		startPage = (endPage - displayPageNum) + 1; //시작 페이지
		//			      10 - 10+1=1
		//				  20 - 10+1=11
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));//임시 마지막 페이지
		//								    (총 글개수 / 페이지 당 글 갯수)
		//                              (올림)(1/10.0) = 1
		//								(올림)(2/10.0) = 1
		//								(올림)(11/10.0) = 2
		//								(올림)(101/10.0) = 11 : 글이 
		//								(올림)(200/10.0) = 20
		if (endPage > tempEndPage) { //마지막 페이지 > 임시 마지막 페이지보다
			endPage = tempEndPage;    //  글이 총 12개 있을때 마지막 페이지가 2까지만 보이게 
		}
		prev = startPage == 1 ? false : true; //시작페이지가 1이면 false 아니면 true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true; // 마지막 페이지 * 10 >= 총 글갯수 이면 false 아니면 true
																		   //  10 * 10 >= 100
																		   //  11 * 10 >= 106
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =  //URI를 생성해주는 클래스
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