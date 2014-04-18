<%@page import="vo.SubjectVo2"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- c:out 태그 사용 
- 출력문을 만든다.
 --%>
<c:out value="OKOK!"/><br>
<c:out value="${null}">NONO!</c:out><br>
<c:out value="AAAA">BBBB</c:out><br>
<c:out value="${10 + 2}"/><br>
<hr>
<%-- c:set 태그 사용
- 보관소에 값 설정 
- var: 값 저장할 때 사용하는 키
- value: 값
- scope: 보관소(기본 pageScope)
 --%>
<c:set var="s01" value="홍길동"/>
${s01}<br>
${pageScope.s01}<br>
<hr>

<c:set var="s02" value="임꺽정" scope="request"/>
${s02}<br>
${requestScope.s02}<br>
<hr>

<%
pageContext.setAttribute("s03", "오호라");
%>
${s03}<br>
<c:set var="s03" value="장길산"/>
${s03}<br>
<hr>

<%
SubjectVo2 vo = new SubjectVo2();
vo.setNo(10);
vo.setTitle("자바");
vo.setDescription("설명..");

pageContext.setAttribute("subject", vo);
%>
${subject.title}<br>
<c:set target="${subject}" property="title" value="Java++"/>
${subject.title}<br>
<c:remove var="subject"/>
삭제 후: ${subject.title}<br>



</body>
</html>





















