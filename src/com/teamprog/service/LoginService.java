package com.teamprog.service;

import java.util.ArrayList;

import com.teamprog.vo.UserVO;
import com.teamrpog.dao.UserDAO;


public class LoginService {
	private static LoginService service = new LoginService();
	public UserDAO dao = UserDAO.getInstance();

	public static LoginService getInstance() {
		return service;
	}

	public void createUser(UserVO user) {
		dao.createUser(user);
	}

	public UserVO getUserByName(String phone) {
		return dao.getUserByName(phone);
	}

	public ArrayList<UserVO> userList() {
		ArrayList<UserVO> list = dao.userList();
		return list;
	}
}
