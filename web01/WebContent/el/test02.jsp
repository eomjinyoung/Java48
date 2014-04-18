<%-- EL
* 배열 값 표현 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//1) 배열 
pageContext.setAttribute("scores", new int[]{100,100,100});
request.setAttribute("scores", new int[]{90,90,90});
session.setAttribute("scores", new int[]{80,80,80});
application.setAttribute("scores", new int[]{70,70,70});
%>

<%
int[] a = (int[]) request.getAttribute("scores");
%>

${pageScope.scores[2]}<br>
${requestScope.scores[2]}<br>
${sessionScope.scores[2]}<br>
${applicationScope.scores[2]}<br>

<%-- ${프로퍼티명} 
=> 조회 순서: pageScope -> requestScope -> sessionScope -> applicationScope
 --%>
${scores[2]}<br>

</body>
</html>



















