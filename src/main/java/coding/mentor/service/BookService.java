package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;

public class BookService {
	public List<Book> getBooksByCategoryId(int categoryId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;		
		ResultSet rs = null;
		Book book = null;
		
		List<Book> list = new ArrayList<Book>();
		
		try {
			// make connection to mySQL 
			conn = DBUtil.makeConnection();	
			ps = conn.prepareStatement("select * from  `book` where category_id=?");
			ps.setInt(1,categoryId);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
			
				int id = rs.getInt("id");
				String name = rs.getString("name");
				book = new Book(id, name, categoryId);
				
				list.add(book);			
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
	
	return list;
	
	}
	
	
	public List<Book> getBooksByName(String bookName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;		
		ResultSet rs = null;
		Book book = null;
		
		List<Book> list = new ArrayList<Book>();
		
		try {
			// make connection to mySQL 
			conn = DBUtil.makeConnection();	
			ps = conn.prepareStatement("select * from  `book` where name like ?");
			ps.setString(1,"%"+bookName +"%");
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
			
				int id = rs.getInt("id");
				String name = rs.getString("name");
				book = new Book(id, name, id);
				int categoryId = rs.getInt("category_id");
				
				book = new Book(id, name, categoryId);
				list.add(book);
				
				
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
	
	return list;
	
	}

}
