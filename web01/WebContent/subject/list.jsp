<%-- JSTL 및 EL 적용하기 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목목록</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>과목 목록(JSTL,EL)</h1>
<a href='form.html'>새과목</a><br>
<table border='1'>
<tr>
  <th>번호</th>
  <th>과목명</th>
</tr>
<c:forEach var="subject" items="${list}">
<tr>
  <td>${subject.no}</td>
  <td><a href='detail.bit?no=${subject.no}'>${subject.title}</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body></html>















    