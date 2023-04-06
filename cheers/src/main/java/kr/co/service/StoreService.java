package kr.co.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.EatVO;
import kr.co.vo.Store_infoVO;
import kr.co.vo.UserVO;

public interface StoreService {
	
	//���� ���
	public void register(Store_infoVO infoVO, MultipartHttpServletRequest mpRequest,String u_id) throws Exception;
	
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
	
	//�յ����,�յ� ���Ͼ��ε�
	public void eatInsert(EatVO eatVO,MultipartHttpServletRequest mpRequest) throws Exception;
	
	//�յ�����Ʈ
	public List<EatVO> eatList() throws Exception;
	
	//���� �̹��� ��ȸ
	public List<Map<String, Object>> eatImage(int e_num) throws Exception;
	
	//u_id�� �ش��ϴ� s_num
	public UserVO getSnum(String u_id);
	
	//Ŭ���� �յ����� ����
	public EatVO eatInfo(int e_num);
	
}