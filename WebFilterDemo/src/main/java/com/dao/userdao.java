package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.user;

import com.utils.userutils;

public class userdao {

	public static void signup(user u) {
		try {
			 Connection conn = userutils.createConnection();
			 String sql="insert into user(fname,lname,email,mobile,password) values (?,?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,u.getFname());
			 pst.setString(2,u.getLname());
			 pst.setString(3,u.getEmail());
			 pst.setLong(4,u.getMobile());
			 pst.setString(5,u.getPassword());
			 pst.executeUpdate();
			 
		} catch (Exception e) {
		
		}
		
	}
	
	public static boolean checkemail(user u) {
		boolean flag=false;
		
		try {
			
			Connection conn =userutils.createConnection();
			String sql = "select * from user where email=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1,u.getEmail());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag=false;
			}
			else {
				flag=true;
			}
			
		} catch (Exception e) {
			
		}
		
		return flag;
		
	}
}
