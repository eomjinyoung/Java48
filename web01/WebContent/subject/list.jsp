<%-- jsp:useBean 액션 태그 사용 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- jsp:useBean 사용  --%>
<%-- 1) type 만 사용 --%>
<jsp:useBean id="list" type="java.util.List<vo.SubjectVo>" 
      scope="request"/>    
<%-- 
List<SubjectVo> list = 
  (List<SubjectVo>) request.getAttribute("list"); 
--%>    

<%-- 2) class 만 사용 --%>
<%--  
<jsp:useBean id="list" class="java.util.ArrayList" 
      scope="request"/>
--%>         
<%-- 
ArrayList list = (ArrayList) request.getAttribute("list");
if (list == null) {
  list = new ArrayList();
  request.setAttribute("list", list);
} 
--%> 

<%-- 3) class, type 모두 사용 --%>
<%-- 
<jsp:useBean id="list" 
              class="java.util.ArrayList"
              type="java.util.List<vo.SubjectVo>" 
              scope="request"/>
--%>
<%--
List<SubjectVo> list = (List<SubjectVo>) request.getAttribute("list");
if (list == null) {
  list = (List<SubjectVo>)new ArrayList();
  request.setAttribute("list", list);
} 
--%>      

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목목록</title>
</head>
<body>
<h1>과목 목록(byJSP)</h1>
<a href='form.html'>새과목</a><br>
<table border='1'>
<tr>
  <th>번호</th>
  <th>과목명</th>
</tr>
<%for(SubjectVo subject : list) {%>
<tr>
  <td><%=subject.getNo()%></td>
  <td><a href='detail.bit?no=<%=subject.getNo()%>'><%=subject.getTitle()%></a></td>
</tr>
<%}%>
</table>
<jsp:include page="/footer.jsp"/>
</body></html>















    