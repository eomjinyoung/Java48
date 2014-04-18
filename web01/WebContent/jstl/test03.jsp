<%-- c:url, c:import, c:redirect --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="8kb" autoFlush="true"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- c:url 사용 --%>
<a href="http://localhost:9999/web01t/subject/list.bit?pageNo=1&pageSize=10">과제목록</a><br>

<c:url var="listUrl" 
       value="http://localhost:9999/web01t/subject/list.bit">
  <c:param name="pageNo" value="1"/>
  <c:param name="pageSize" value="10"/>
</c:url>
<a href="${listUrl}">과목목록2</a><br>
<hr>

<%-- c:import 
=> 특정 URL의 콘텐츠 가져온다.
--%>
<textarea rows="10" cols="80">
<c:import url="http://www.naver.com"/>
</textarea>

<c:import url="http://www.naver.com" var="test"/>
<textarea rows="10" cols="80">${test}</textarea>
<hr>

<%-- c:redirect --%>
<c:set var="myUrl2" value="http://www.daum.net"/>
<c:if test="${not empty myUrl}">
  <c:redirect url="${myUrl}"/>
</c:if>

</body>
</html>














