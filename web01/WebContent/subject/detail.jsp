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
  <title>과목상세정보</title>
</head>
<body>
<h1>과목 상세정보(by JSP)</h1>
<table border='1'>
<tr>
  <th>번호</th>
  <td><%=subject.getNo()%></td>
</tr>
<tr>
  <th>과목명</th>
  <td><%=subject.getTitle()%></td>
</tr>
<tr>
  <th>내용</th>
 <td><textarea rows='5' cols='60'><%=subject.getDescription()%></textarea></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a> 
<a href='delete.bit?no=<%=subject.getNo()%>'>삭제</a> 
<a href='update.bit?no=<%=subject.getNo()%>'>변경</a><br>
</body></html>










