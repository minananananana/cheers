package kr.co.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kr.co.dao.UserDAO;
import kr.co.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Inject 
	private UserDAO dao;

	//È¸ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	@Override
	public void register(UserVO vo) throws Exception {

		dao.register(vo);		
	}
	// ï¿½Î±ï¿½ï¿½ï¿½
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}
	// ï¿½ï¿½ï¿½Ìµï¿½ ï¿½ßºï¿½ Ã¼Å©
	@Override
	public String idCheck(UserVO vo) throws Exception {
		String result = dao.idCheck(vo);
		return result;
	}
	// ï¿½Î±×¾Æ¿ï¿½
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();  // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	}

	// È¸ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	@Override
	public void modify(UserVO vo) throws Exception {

		dao.modify(vo);
	}
	
	@Override
	public UserVO findId(String u_email)throws Exception{
		return dao.findId(u_email);
	}
	
	@Override
	public int findIdCheck(String u_email)throws Exception{
		return dao.findIdCheck(u_email);
	}

	// È¸ï¿½ï¿½ Å»È¸
	@Override
	public void delete(UserVO vo) throws Exception {
		dao.delete(vo);
	}
	
	//À¯ÀúÁ¤º¸ °¡Á®¿À±â
	@Override
	public UserVO userInfo(String u_id) throws Exception {
		return dao.userInfo(u_id);
	}
} 

