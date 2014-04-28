<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목변경폼</title>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp"/>
<h1>과목 변경폼(JSP, JSP Action Tag)</h1>
<form action='update.bit' method='post' role="form">
<div class="form-group">
  <label for="no">번호</label>
  <input type='text' id="no" name='no' class="form-control"
    value='${subject.no}' readonly><br>
</div>
<div class="form-group">
  <label for="title">과목명</label>
  <input type='text' name='title' class="form-control"
    value='${subject.title}'><br>
</div>
<div class="form-group">
  <label for="description">설명</label>
  <textarea id="description" name='description' 
        class="form-control"
        rows='10' cols='80'>${subject.description}</textarea><br>
</div>
<input type='submit' value='변경' class="btn btn-primary">
<input type='button' value='취소'  class="btn btn-primary"
        onclick="location.href='detail.bit?no=${subject.no}'">
</form>
<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    