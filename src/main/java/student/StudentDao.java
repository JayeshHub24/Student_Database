package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Jayesh24");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Student s){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into studentdb.student_table(name,dob,doj) values (?,?,?)");  
            ps.setString(1,s.getName());  
            ps.setString(2,s.getDob());  
            ps.setString(3,s.getDoj());  
             
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Student s){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update studentdb.student_table set name=?,dob=?,doj=? where id=?");  
            ps.setString(1,s.getName());  
            ps.setString(2,s.getDob());  
            ps.setString(3,s.getDoj());  
             
            ps.setInt(4,s.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from studentdb.student_table  where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int id){  
        Student s=new Student();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from studentdb.student_table where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                s.setId(rs.getInt(1));  
                s.setName(rs.getString(2));  
                s.setDob(rs.getString(3));  
                s.setDoj(rs.getString(4));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return s;  
    }  
    public static List<Student> getAllStudent(){  
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from studentdb.student_table");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student s=new Student();  
                s.setId(rs.getInt(1));  
                s.setName(rs.getString(2));  
                s.setDob(rs.getString(3));  
                s.setDoj(rs.getString(4));  
                  
                list.add(s);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
