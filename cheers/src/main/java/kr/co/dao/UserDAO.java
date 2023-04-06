package kr.co.dao;

import kr.co.vo.UserVO;

public interface UserDAO {
	// ȸ������
	public void register(UserVO vo) throws Exception;


	// �α���
	public UserVO login(UserVO vo) throws Exception;

	// ���̵� �ߺ�üũ
	public String idCheck(UserVO vo) throws Exception;
	
	//ȸ�� ���� ����
	public void modify(UserVO vo) throws Exception;
	
	public UserVO findId(String u_email)throws Exception;
	
	public int findIdCheck(String u_email)throws Exception;

	// ȸ�� Ż��
	public void delete(UserVO vo) throws Exception;
	
	//�������� ��������
	public UserVO userInfo(String u_id) throws Exception;
}


