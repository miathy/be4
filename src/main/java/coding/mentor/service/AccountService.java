package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Account;


public class AccountService {
	public static Account getAccountByUsernameAndPassword(String username, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;		
		ResultSet rs = null;
		Account account = null;
		
		
		try {
			// make connection to mySQL 
			conn = DBUtil.makeConnection();	
			// create sql 
			String sql = "select * from account where email = ? and password = ?";
			
			ps = conn.prepareStatement(sql);
			
			//set params
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
		
			if(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
			
				account = new Account(id, username, password,email);
						
			}else {
				return null;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		
	
		}finally {
			if(rs !=null) {
				rs.close();
			}
			if(ps !=null) {
				ps.close();
			}
			if(rs !=null) {
				conn.close();
		}
	}
	
	return account;
	
	}
}
