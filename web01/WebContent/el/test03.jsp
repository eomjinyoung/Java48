<%-- EL: 연산자 --%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test03</title>
</head>
<body>
<%-- 산술 연산자 --%>
${10 + 20 }<br>
${10 - 20 }<br>
${10 * 20 }<br>
${10 / 20 }<br>
${10 div 20 }<br>
${10 % 20 }<br>
${10 mod 20 }<br>
<hr>

<%-- 논리 연산자 --%>
${true && false }<br>
${true and false }<br>
${true || false }<br>
${true or false }<br>
${!true}<br>
${not true}<br>
<hr>

<%-- 관계 연산자 --%>
${10 == 11 }<br>
${10 eq 11 }<br>
${10 != 11 }<br>
${10 ne 11 }<br>
${10 < 11 }<br>
${10 lt 11 }<br>
${10 > 11 }<br>
${10 gt 11 }<br>
${10 <= 11 }<br>
${10 le 11 }<br>
${10 >= 11 }<br>
${10 ge 11 }<br>
<hr>

<%-- empty 연산자 --%>
<%
pageContext.setAttribute("subject", 
		new SubjectVo().setNo(10).setTitle("자바").setDescription("설명.."));
%>

${empty subject}<br>
${empty subject2}<br>

</body>
</html>


















