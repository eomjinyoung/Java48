<%-- EL
* 배열 값 표현 
 --%>
<%@page import="vo.SubjectVo"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test02</title>
</head>
<body>
<%
//1) 배열 
pageContext.setAttribute("scores", new int[]{100,100,100});
request.setAttribute("scores", new int[]{90,90,90});
session.setAttribute("scores", new int[]{80,80,80});
application.setAttribute("scores", new int[]{70,70,70});
%>

${pageScope.scores[2]}<br>
${requestScope.scores[2]}<br>
${sessionScope.scores[2]}<br>
${applicationScope.scores[2]}<br>

<%-- ${프로퍼티명} 
=> 조회 순서: pageScope -> requestScope -> sessionScope -> applicationScope
 --%>
${scores[2]}<br>

<hr>

<%
//2) 맵 객체
HashMap<String,String> map = new HashMap<String,String>();
map.put("s01", "홍길동");
map.put("s02", "임꺽정");
map.put("s03", "장길산");
pageContext.setAttribute("students", map);
%>

${students.s01}<br>
${students.s02}<br>
${students.s03}<br>
${students.s04}<br>

<hr>

<%
//3) 자바 빈에서 값 꺼내기
SubjectVo vo = new SubjectVo();
vo.setNo(20);
vo.setTitle("오호라..");
vo.setDescription("설명.....");

pageContext.setAttribute("subject", vo);
%>

${subject.no}<br>
${subject.title}<br>
${subject.description}<br>

</body>
</html>



















