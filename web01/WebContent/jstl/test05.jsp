<%-- c:parseDate, c:formatDate --%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- c:parseDate
=> 문자열로부터 java.util.Date 객체 생성
 --%>
<fmt:parseDate var="date1" value="2014-5-5" pattern="yyyy-MM-dd"/>
<%
Date test = (Date)pageContext.getAttribute("date1");
if (test != null && test instanceof Date) {
	out.println("날짜 맞네!!@");
}
%>
<hr>

<%-- c:formatDate
=> java.util.Date 객체로부터 문자열 생성  
 --%>
<%
pageContext.setAttribute("date2", new Date());
%>
<fmt:formatDate value="${date2}" pattern="yyyy/MM/dd"/><br>
<fmt:formatDate value="${date2}" pattern="MM/dd/yyyy"/><br>
<fmt:formatDate value="${date2}" pattern="yyyy-MM-dd hh:mm:ss D"/><br>

</body>
</html>























