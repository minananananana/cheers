package kr.co.dao;

import java.util.List;

import kr.co.vo.StoreVO;

public interface SearchDAO {
	
	//Ű���� �˻�
	public List search(String keyword) throws Exception;
}