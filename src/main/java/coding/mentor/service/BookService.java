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
			//execute and get result set
			rs = ps.executeQuery();
			// mapping data in result set into entity class
			while(rs.next()) {
			
				int id = rs.getInt("id");
				String name = rs.getString("name");
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
	public List<Book> getAllBooks()  throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;		
		ResultSet rs = null;
		Book book = null;
		
		List<Book> list = new ArrayList<Book>();
		try {
			//make connection to mySQL
			conn = DBUtil.makeConnection();			
			ps = conn.prepareStatement("select * from `book`");		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				
				book = new Book(id, name, categoryId);
				list.add(book);
				}
		} catch (Exception e) {
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
	
	public Book getBookDetails(int bookId)  throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;		
		ResultSet rs = null;
		Book book = null;
		
		try {
			//make connection to mySQL
			conn = DBUtil.makeConnection();			
			ps = conn.prepareStatement("select * from `book` where id=? ");	
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");				
				int categoryId = rs.getInt("category_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int stock = rs.getInt("stock");
				
				book = new Book(id, name, categoryId, title, author, stock);
				
				}
		} catch (Exception e) {
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
	return book;
	
	}

}
