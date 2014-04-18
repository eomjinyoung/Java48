<%-- EL: 흐름제어 태그 사용  --%>
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
<%-- c:if 태그 --%>
<c:if test="${10 < 20}">
10은 20보다 작다!<br>
</c:if>

<c:set var="s01" value="홍길동"/>
<c:if test="${s01 == '홍길동'}">
나는 홍길동이다!
</c:if>
<hr>

<%-- c:choose 사용 --%>
<c:set var="age" value="22"/>
<c:choose>
  <c:when test="${age < 18 }">
    청소년입니다.
  </c:when>
  <c:when test="${age >= 18 && age < 65 }">
    성인입니다.
  </c:when>
  <c:otherwise>
    노인입니다.
  </c:otherwise>
</c:choose>
<hr>

<%-- c:forEach 
-items : 배열, java.util.Collection(List, ArrayList, Vector, EnumSet...)
--%>
<%
String[] names = new String[]{"홍길동", "임꺽정", "장길산"};
pageContext.setAttribute("names", names);
%>
<ol>
<c:forEach var="n" items="${names}">
  <li>${n}</li>
</c:forEach>
</ol>
<hr>

<ol>
<c:forEach var="n" items="${names}" begin="1" end="2">
  <li>${n}</li>
</c:forEach>
</ol>
<hr>

<%-- c:forTokens
String url = "name=aaa&age=10&tel=111-1111";
for(String item : url.split("&")) {
...
}
--%>
<c:set var="url" value="name=aaa&age=10&tel=111-1111"/>
<ul>
<c:forTokens var="item" items="${url}" delims="&">
  <li>${item}</li>
</c:forTokens>
</ul>
</body>
</html>





















