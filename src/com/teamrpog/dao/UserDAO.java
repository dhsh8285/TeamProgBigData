package com.teamrpog.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.teamprog.vo.UserVO;

public class UserDAO {

	private static UserDAO dao = new UserDAO();
	private UserDAO(){}

	public static UserDAO getInstance() {
		return dao;
	}
	
	public static void main(String[] args) {
//		UserVO user = new UserVO("010-1234-1234",
//				"4321", "테스트", 901010, 1);
		UserDAO test = new UserDAO();
//		test.createUser(user);
		System.out.println(test.getUserByName("010-1234-1234"));
		System.out.println(test.userList());
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void createUser(UserVO user){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into myuser values(?,?,?,?,?)");
			pstmt.setString(1, user.getPhone());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getBirth());
			pstmt.setInt(5, user.getGroup());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public UserVO getUserByName(String phone){
		UserVO user = null;
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from myuser where phone = ?");
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new UserVO(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null ) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	public ArrayList<UserVO> userList() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		UserVO user = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from myuser");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				user = new UserVO(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null ) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	
}
