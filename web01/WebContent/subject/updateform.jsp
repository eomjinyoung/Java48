<%-- EL 적용 --%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목변경폼</title>
</head>
<body>
<h1>과목 변경폼(JSP, JSP Action Tag)</h1>
<form action='update.bit' method='post'>
번호: <input type='text' name='no' value='${subject.no}' readonly><br>
과목명: <input type='text' name='title' value='${subject.title}'><br>
설명: <textarea name='descrijspption' 
        rows='10' cols='80'>${subject.description}</textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소' 
        onclick="location.href='detail.bit?no=${subject.no}'">
</form>
<jsp:include page="/footer.jsp">
  <jsp:param value="Java48$$" name="studyClass"/>
</jsp:include>
</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    