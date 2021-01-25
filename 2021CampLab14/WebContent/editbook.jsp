<%@page import="com.javatpoint.dao.BookDao"%>  
<jsp:useBean id="u" class="com.javatpoint.bean.Book"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=BookDao.update(u);  
response.sendRedirect("viewbooks.jsp");  
%>  