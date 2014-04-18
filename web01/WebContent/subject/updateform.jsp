<%-- jsp:useBean 사용 
<use:include>, <use:forward>
=> 서블릿 또는 JSP로 실행 호출 
=> 호출하는 페이지는 반드시 서블릿(JSP) URL이다.

<%@ include%>
=> 해당 파일의 내용을 복사해 온다.
=> 파일이 JSP, 서블릿 상관없다.

--%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="subject" class="vo.SubjectVo" scope="request"/>
<%--
SubjectVo subject = (SubjectVo) request.getAttribute("subject");
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목변경폼</title>
</head>
<body>
<h1>과목 변경폼(JSP, JSP Action Tag)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' value='<jsp:getProperty 
            name="subject" property="no"/>' readonly><br>
과목명: <input type='text' name='title' value='<jsp:getProperty 
            name="subject" property="title"/>'><br>
설명: <textarea name='descrijspption' 
        rows='10' cols='80'><jsp:getProperty 
          name="subject" property="description"/></textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소' 
        onclick="location.href='detail.bit?no=<jsp:getProperty 
             name="subject" property="no"/>'">
</form>
<jsp:include page="/footer.jsp"/>
</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    