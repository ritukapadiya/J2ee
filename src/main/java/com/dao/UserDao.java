package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.bean.UserBean;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.util.DBConnection;

public class UserDao {
	Connection con = DBConnection.dbConn();
//	insert data (sign up)
	public void insert(UserBean userBean) {
		  try {
			PreparedStatement pstmt = con.prepareStatement("insert into users (first_name,last_name,email,password) values (?,?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			
			int nRows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// log in
	public UserBean checkData(UserBean userBean) {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			ResultSet rs = pstmt.executeQuery();
//			return rs.next();
			if(rs.next()) {
				userBean.setFirstName(rs.getString("first_name"));
				userBean.setLastName(rs.getString("last_name"));
				return userBean;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	list of users
	public ArrayList<UserBean> displayData() {
		ArrayList<UserBean> userList = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				UserBean userBean = new UserBean();
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				userBean.setFirstName(firstName);
				userBean.setLastName(lastName);
				userBean.setEmail(email);
				userBean.setPassword(password);
				
				userList.add(userBean);
			}
			return userList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
//	delete user
	public void deleteUser(String userId) {
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from users where email = ?");
			pstmt.setString(1, userId);
			pstmt.executeUpdate();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
//	view particular user details
	public UserBean viewUser(String userId) {
		UserBean userBean = new UserBean();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ?");
			pstmt.setString(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				userBean.setFirstName(firstName);
				userBean.setLastName(lastName);
				userBean.setEmail(email);
				userBean.setPassword(password);
			}
			
			return userBean;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	Update User
	public void UpdateUser(UserBean userBean) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update users set first_name = ?,last_name=?, password=? where email=?");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getPassword());
			pstmt.setString(4, userBean.getEmail());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
