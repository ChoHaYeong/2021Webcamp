package com.javatpoint.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.javatpoint.bean.Book;  


public class BookDao {  
  
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12388208","sql12388208","XNLTuMUvg6");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Book u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into BOARD(title,writer,content) values(?,?,?)"); 
	        System.out.println(u.getTitle());
	        ps.setString(1,u.getTitle());  
	        ps.setString(2,u.getAuthor());  
	        ps.setString(3,u.getComments()); 
	        //ps.setString(4,u.getImage()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Book u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update BOARD set title=?,writer=?,content=?where seq=?");  
	        ps.setString(1,u.getTitle());  
	        System.out.println(u.getTitle());
	        ps.setString(2,u.getAuthor());  
	        ps.setString(3,u.getComments()); 
	        //ps.setString(4,u.getImage()); 
	        ps.setInt(4,u.getId()); 
	        System.out.println(u.getId());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println("-----> " + e);}  
	    return status;  
	}  
	public static int delete(Book u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from BOARD where seq=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<Book> getAllRecords(){  
	    List<Book> list=new ArrayList<Book>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from BOARD");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Book u=new Book();  
	            u.setId(rs.getInt("seq"));  
	            u.setTitle(rs.getString("title"));  
	            u.setAuthor(rs.getString("writer"));  
	            u.setComments(rs.getString("content"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static Book getRecordById(int id){  
	    Book u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from BOARD where seq=?");  
	        System.out.println("int id : " + id);
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Book();  
	            u.setId(rs.getInt("seq"));  
	            System.out.println("getRecordById : " + u.getId());
	            u.setTitle(rs.getString("title"));  
	            u.setAuthor(rs.getString("writer"));  
	            u.setComments(rs.getString("content"));  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
}  