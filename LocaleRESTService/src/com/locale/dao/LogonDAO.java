package com.locale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.locale.database.DBConnection;

public class LogonDAO {

	
	public Integer getUserIdByLogonName(String logonName) {
		
		Integer userId = null;
		
		Connection c = null;
 
        try {
            c = DBConnection.getConnection();
            String selectStatement = "SELECT user_id FROM t_users WHERE username = ? ";
    		PreparedStatement prepStmt = c.prepareStatement(selectStatement);
    		prepStmt.setString(1, logonName);
    		ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                userId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		
		
		
		return userId;
		
	}
	
	
	public Integer createUserLogonName(String logonName, String logonPwd) {
		
		Connection c = null;
		Integer rowsUpd = 0;
        try {
            c = DBConnection.getConnection();
            String selectStatement = "INSERT INTO t_users(username, password) VALUES(?,?)";
    		PreparedStatement prepStmt = c.prepareStatement(selectStatement);
    		prepStmt.setString(1, logonName);
    		prepStmt.setString(2, logonPwd);
    		rowsUpd = prepStmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		
		return rowsUpd;
	}
	
	
}
