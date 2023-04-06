package kr.co.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.EatVO;
import kr.co.vo.Store_infoVO;
import kr.co.vo.UserVO;

@Repository
public class StoreDAOImpl implements StoreDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	//����
	private static String namespace="store";
	
	//���Ե��
	@Override
	public void register(Store_infoVO infoVO) {
		sqlSession.insert("store.register",infoVO);
	}

	//���Ͼ��ε�
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		sqlSession.insert("store.insertFile",map);
		
	}
	
	//Ű���忡 �ش��ϴ� ��������Ʈ
	@Override
	public void foodList(String keyword) {
		// TODO Auto-generated method stub
		
	}
	
	//���� ���� ��ȸ
	@Override
	public Store_infoVO storeInfo(int s_num) {
		Store_infoVO vo=sqlSession.selectOne("store.storeInfo", s_num);
		return vo;
	}//storeInfo()-end

	//���� �̹��� ��ȸ
	@Override
	public List<Map<String, Object>> storeImage(int s_num) throws Exception {
		return sqlSession.selectList("store.storeImage",s_num);
	}
	
	//Ű���� �˻�
	@Override
	public List search(String keyword) throws Exception {
		List list=sqlSession.selectList("store.searchName",keyword);
		return list;
	}//searchInfo()-end

	//���� �̹��� �ϳ� ��������(�������� ����Ұ�)
	@Override
	public List storeImageOne(int s_num) throws Exception {
		return sqlSession.selectOne("store.imageOne",s_num);
	}
	
	//���Ը���Ʈ
	@Override
	public List<Store_infoVO> storeList() throws Exception {
		
		return sqlSession.selectList("store.storeList");
	}

	//�յ����
	@Override
	public void eatInsert(EatVO eatVO) {
		sqlSession.insert("store.eatInsert", eatVO);
		
	}
	//�յ� ���Ͼ��ε�
	@Override
	public void insertFileEat(Map<String, Object> map) throws Exception {
		sqlSession.insert("store.insertFileEat",map);
		
	}
	
	//�յ�����Ʈ
	@Override
	public List<EatVO> eatList() throws Exception {
		
		return sqlSession.selectList("store.eatList");
	}

	@Override
	public List<Map<String, Object>> eatImage(int e_num) throws Exception {
		return sqlSession.selectList("store.storeImageEat",e_num);
	}
	
	//������ s_num ���
	@Override
	public void userSnum(String u_id) {
		sqlSession.update("store.userSnum",u_id);
	}
	
	//u_id�� �ش��ϴ� s_num
	@Override
	public UserVO getSnum(String u_id) {
		return sqlSession.selectOne("store.getSnum",u_id);
		
	}
	
	//Ŭ���� �յ����� ����
	@Override
	public EatVO eatInfo(int e_num) {
		EatVO vo=sqlSession.selectOne("store.eatInfo", e_num);
		return vo;
	}
	

}