package kr.co.service;

import javax.servlet.http.HttpSession;
import kr.co.vo.UserVO;

public interface UserService {

	//È¸ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public void register(UserVO vo) throws Exception;

	// ï¿½Î±ï¿½ï¿½ï¿½
	public UserVO login(UserVO vo) throws Exception;
	//ï¿½ï¿½ï¿½Ìµï¿½ ï¿½ßºï¿½Ã¼Å©
	public String idCheck(UserVO vo) throws Exception;
	// ï¿½Î±×¾Æ¿ï¿½
	public void signout(HttpSession session) throws Exception;
	// È¸ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	public void modify(UserVO vo) throws Exception;
	
	public UserVO findId(String u_email)throws Exception;

	public int findIdCheck(String u_email)throws Exception;

	// È¸ï¿½ï¿½ Å»ï¿½ï¿½
	public void delete(UserVO vo) throws Exception;
	
	//À¯ÀúÁ¤º¸ °¡Á®¿À±â
	public UserVO userInfo(String u_id) throws Exception;
}

