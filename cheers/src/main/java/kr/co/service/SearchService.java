package kr.co.service;

import java.util.List;

import kr.co.vo.StoreVO;

public interface SearchService {
	
	//Ű���� �˻�
	public List search(String keyword) throws Exception;
}