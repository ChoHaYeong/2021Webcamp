<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>
  
<body>  
<%@page import="com.javatpoint.dao.BookDao,com.javatpoint.bean.Book"%>  
  
<%  
String id=request.getParameter("id"); 
System.out.println(id);
Book u = BookDao.getRecordById(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="editbook.jsp" method="post">  
<input type="text" name="seq" value="<%=u.getId() %>"/>  
<table>  
<tr><td>Title:</td><td>  
<input type="text" name="title" value="<%=u.getTitle() %>"/></td></tr>  
<tr><td>Author:</td><td>  
<input type="text" name="writer" value="<%=u.getAuthor() %>"/></td></tr>  
<tr><td>Comments:</td><td>  
<input type="text" name="content" value="<%=u.getComments() %>"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  