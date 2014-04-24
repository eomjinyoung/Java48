<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목등록폼</title>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp"/>
<h1>과목등록폼</h1>
<form action="insert.bit" method="post" role="form">
<div class="form-group">
  <label for="title">과목명</label> 
  <input id="title" class="form-control" 
    placeholder="과목명을 입력하세요"
    type="text" name="title">
</div>
<div class="form-group">
  <label for="description">설명</label>
  <textarea id="description" class="form-control"
      placeholder="과목에 대한 설명을 입력하세요" 
     name="description" rows="10" cols="80"></textarea><br>
</div>
<input type="submit" value="등록" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>




















