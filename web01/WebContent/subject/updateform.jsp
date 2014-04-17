<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SubjectVo subject = (SubjectVo) request.getAttribute("subject");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목변경폼</title>
</head>
<body>
<h1>과목 변경폼(by JSP)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' 
            value='<%=subject.getNo()%>' readonly><br>
과목명: <input type='text' name='title' 
            value='<%=subject.getTitle()%>'><br>
설명: <textarea name='description' 
          rows='10' cols='80'><%=subject.getDescription()%></textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소'
        onclick="location.href='detail.bit?no=<%=subject.getNo()%>'">
</form>
</body>
</html>
</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    