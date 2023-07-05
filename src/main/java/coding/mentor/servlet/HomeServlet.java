package coding.mentor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.entity.Book;
import coding.mentor.entity.Category;
import coding.mentor.service.BookService;
import coding.mentor.service.CategoryService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			// Controller use Service to take data
			CategoryService categoryService = new CategoryService();
			List<Category> categoryList = categoryService.getAllCategories();
			
			BookService bookService= new BookService();
			String categoryId = request.getParameter("categoryId");
			
			List<Book> bookList =  new ArrayList<Book>();
			
			//List<Book> allBooks =bookService.getAllBooks();
			String bookName = request.getParameter("bookName");
			//List<Book> bookNameList =  new ArrayList<Book>();
			
			if(categoryId != null) {
				bookList = bookService.getBooksByCategoryId(Integer.parseInt(categoryId));
			}
			
			else if ( bookName != null) {
				bookList = bookService.getBooksByName(bookName);
						
			}
			
			else {
				bookList =   bookService.getAllBooks();
			}
			
			
			
			// Controller pass data to View(jsp file) 
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("bookList", bookList);
			//request.setAttribute("bookNameList", bookNameList);
			rd.forward(request, response);
			
			
//			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
//			BookService service = new BookService();
//			List<Book> bookList =  service.getBooksByCategoryId(categoryId);
			
//			RequestDispatcher rd = request.getRequestDispatcher("book-list.jsp");
//			request.setAttribute("booklist", bookList);
//			rd.forward(request, response);
		
		
			/*PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<h1> Welcome to HomeServlet</h1>");
			out.println("<ul>");
			for(Book book : bookList) {
				out.println("<li>" + book.getName() + "</li>");
			}		
			out.println("</ul>");
			out.println("</html>"); */
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
