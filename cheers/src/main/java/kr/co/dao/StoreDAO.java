package kr.co.dao;

import java.util.List;
import java.util.Map;

import kr.co.vo.EatVO;
import kr.co.vo.Store_infoVO;
import kr.co.vo.UserVO;

public interface StoreDAO {
	
	//���� ���
	public void register(Store_infoVO infoVO);
	
	//÷������ ���ε�
	public void insertFile(Map<String, Object> map) throws Exception;
	
	//Ű���忡 �ش��ϴ� ��������Ʈ
	public void foodList(String keyword);
	
	//Ŭ���� �������� ����
	public Store_infoVO storeInfo(int s_num);
	
	//���� �̹��� ��ȸ
	public List<Map<String, Object>> storeImage(int s_num) throws Exception;
	
	//Ű���� �˻�
	public List search(String keyword) throws Exception;
	
	//���� �̹��� �ϳ��� ��������
	public List storeImageOne(int s_num) throws Exception;
	
	//���Ը���Ʈ
	public List<Store_infoVO> storeList() throws Exception;
	
	//�յ����
	public void eatInsert(EatVO eatVO);
	
	//�յ� ���Ͼ��ε�
	public void insertFileEat(Map<String, Object> map) throws Exception;
	
	//�յ�����Ʈ
	public List<EatVO> eatList() throws Exception;
	
	//���� �̹��� ��ȸ
	public List<Map<String, Object>> eatImage(int e_num) throws Exception;
	
	//������ s_num ���
	public void userSnum(String u_id);
	
	//u_id�� �ش��ϴ� s_num
	public UserVO getSnum(String u_id);
	
	//Ŭ���� �յ����� ����
	public EatVO eatInfo(int e_num);
}