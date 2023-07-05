package coding.mentor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("success.html");
		PrintWriter out = response.getWriter();
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int i=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/be_k4?user=admin&password=0000&useLegacyDatetimeCode=false&serverTimezone=UTC"				
				);
			
			PreparedStatement ps = conn.prepareStatement("insert into account (username, password, email) values (?,?,?)");	
			ps.setString(1,username);
			ps.setString(2, password);
			ps.setString(3, email);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if (i>0) {
			out.print("Data inserted");
		}else {
			out.print("Data not inserted");
		}
				
	}

}
