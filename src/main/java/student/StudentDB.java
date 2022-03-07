package student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class StudentDB
 */
@WebServlet("/StudentDB")
public class StudentDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		saveData(request);
		 
		 String studentNo=request.getParameter("studentN0");  
		 System.out.println(studentNo);
		 String studentName =request.getParameter("studentName");  
		 System.out.println(studentName);
		 String studentDob=request.getParameter("studentDOB");  
		 System.out.println(studentDob);
		 String studentDoj=request.getParameter("studentDOJ");  
		 System.out.println(studentDoj);

		
	}
	
	private void saveData(HttpServletRequest request) {
		Connection con	=connection();
		String studentNo=request.getParameter("studentN0");  
		 System.out.println(studentNo);
		 String studentName =request.getParameter("studentName");  
		 System.out.println(studentName);
		 String studentDob=request.getParameter("studentDOB");  
		 System.out.println(studentDob);
		 String studentDoj=request.getParameter("studentDOJ");  
		 System.out.println(studentDoj);
		 
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement(  
					 "insert into studentdb.student_table  values(?,?,?,?)");
			 ps.setString(1,studentNo);  
			 ps.setString(2,studentName);  
			 ps.setString(3,studentDob);  
			 ps.setString(4,studentDoj);  
			           
			 int i=ps.executeUpdate();  
			 if(i>0)  
			 System.out.println("You are successfully registered...");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				   
				
	}
    private Connection connection() {
    	  // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "studentdb";
        String dbUsername = "root";
        String dbPassword = "Jayesh24";
        
       
        Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL + dbName,dbUsername, dbPassword);
			   System.out.println("Msg Establish");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     
        return con;
		
	}
}
