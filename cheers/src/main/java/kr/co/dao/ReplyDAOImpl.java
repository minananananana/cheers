package kr.co.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dao.ReplyDAO;
import kr.co.vo.ReplyVO;
import kr.co.vo.UpdateReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Inject SqlSession sql;

	//��� ��ȸ
	@Override
	public List<ReplyVO> readReply(int s_num) throws Exception {
		return sql.selectList("replyMapper.readReply", s_num);
	}//readReply()-end

	//��� ����
	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		sql.insert("replyMapper.writeReply", vo);
	}//writeReply()-end

	//���Ͼ��ε�
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		sql.insert("replyMapper.insertFile",map);

	}

	//��� ����
	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		sql.update("replyMapper.updateReply", vo);
	}

	//��� ����
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		sql.delete("replyMapper.deleteReply", vo);
	}

	//���õ� ��� ��ȸ
	@Override
	public ReplyVO selectReply(int r_num) throws Exception {
		return sql.selectOne("replyMapper.selectReply", r_num);
	}

	@Override
	public List<Map<String, Object>> replyImage(int r_num) throws Exception {
		return sql.selectList("replyMapper.replyImage",r_num);
	}

	@Override
	public Double getRatingAverage(int s_num) {
		return sql.selectOne("replyMapper.getRatingAverage",s_num);
	}

	@Override
	public void updateRating(UpdateReplyVO vo) {
		sql.update("replyMapper.updateRating", vo);
	}

}
