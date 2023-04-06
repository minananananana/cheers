package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject 
	private SqlSession sql;

	// ����
	private static String namespace = "userMapper";

	//ȸ������
	@Override
	public void register(UserVO vo) throws Exception {
		sql.insert(namespace + ".register",vo);

	}
	// �α���
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sql.selectOne("userMapper.login", vo);
	}
	// ���̵� �ߺ� üũ
	@Override
	public String idCheck(UserVO vo) throws Exception {
		String result = sql.selectOne("userMapper.idCheck", vo);
		return result;
	}
	
	@Override
	public UserVO findId(String u_email)throws Exception{
		return sql.selectOne("userMapper.findId", u_email);
	}
	
	@Override
	public int findIdCheck(String u_email)throws Exception{
		return sql.selectOne("userMapper.findIdCheck", u_email);
	}
	
	// ȸ������ ����
	@Override
	public void modify(UserVO vo) throws Exception {
		sql.update(namespace + ".modify",  vo);
	}
	
	// ȸ�� Ż��
	@Override
	public void delete(UserVO vo) throws Exception {
		sql.delete(namespace + ".delete", vo);
	}
	
	//���� ���� ��������
	@Override
	public UserVO userInfo(String u_id) throws Exception {
		return sql.selectOne(namespace+".userInfo",u_id);
	}

}
