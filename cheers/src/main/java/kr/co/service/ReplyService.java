package kr.co.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.ReplyVO;

public interface ReplyService {

	//��� ��ȸ
	public List<ReplyVO> readReply(int b_num) throws Exception;
	
	//��� �ۼ�
	public void writeReply(ReplyVO vo,MultipartHttpServletRequest mpRequest) throws Exception;
	
	//��� ����
	public void updateReply(ReplyVO vo) throws Exception;
	
	//��� ����
	public void deleteReply(ReplyVO vo) throws Exception;
	
	//���õ� ��� ��ȸ
	public ReplyVO selectReply(int r_num) throws Exception;
	
	//��� �̹��� ��ȸ
	public List<Map<String, Object>> replyImage(int r_num) throws Exception;
	
	//���� ��� ���ϱ�
	public Double setRating(int s_num) throws Exception;
}
