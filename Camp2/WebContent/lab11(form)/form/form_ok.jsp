<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원입력 정보</title>
</head>
<body>
 
<%   
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userId");  
String passwd = request.getParameter("passwd"); 
String email = request.getParameter("email"); 
String emailAgree = request.getParameter("emailAgree"); 
String interest = request.getParameter("interest"); 
String hp_1 = request.getParameter("hp_1"); 
String hp_2 = request.getParameter("hp_2"); 
String introduce = request.getParameter("introduce"); 
%>  

<p>아이디 : <%= userId %></p>
<p>패스워드 : <%= passwd %></p>
<p>이메일 : <%= email %></p>
<p>이메일 수신여부 : <%= emailAgree %></p>
<p>관심사항: <%= interest %></p>




<p>핸드폰 : <%= hp_1 + " - " + hp_2 %></p> 
<p>자기소개 : <%= introduce %></p>
     
 
</body>
</html>