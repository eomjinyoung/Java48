<%-- 
Directive element
- <%@ page 속성들... %>
   => 페이지 관련 설정 코드 생성
   
- <%@ include 속성들...%>
  => 다른 파일의 내용 포함
  
- <%@ taglib 속성들...%>
  => JSP 표준 외의 기타 태그를 사용 

--%>
<%-- contentType에 문자집합이 설정되어 있지 않으면, 
      pageEncoding 값을 출력데이터의 문자집합으로 사용한다. 
<%@ page language="java" contentType="text/html" pageEncoding="MS949"%>
--%>

<%@ page language="java" 
          contentType="text/html; charset=UTF-8" 
          pageEncoding="UTF-8"%> 
<%-- include는 지정된 파일의 내용을 그 자리에 붙임. --%>   
<%@ include file="header.inc" %>
<title>test05</title>
</head>
<body>
<h1>Directive element</h1>
<%@ include file="footer.inc" %>
















