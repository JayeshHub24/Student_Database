package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='Student.html'>Add New Student</a>");  
	        out.println("<h1>Student List</h1>");  
	          
	        List<Student> list=StudentDao.getAllStudent();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Name</th><th>Date Of Birth</th><th>Date Of Joining</th> <th>Edit</th><th>Delete</th></tr>");  
	        for(Student s:list){  
	         out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getDob()+"</td><td>"+s.getDoj()+"</td><td><a href='EditServlet?id="+s.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+s.getId()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	    }  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
