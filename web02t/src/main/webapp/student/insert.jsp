<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>학생등록폼</title>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp"/>
<h1>학생등록폼</h1>
<form action="insert2.bit" method="post" role="form">
<h2>기본정보</h2>
<div class="form-group">
  <label for="name">이름</label><input id="name" class="form-control" 
    placeholder="예)홍길동" type="text" name="name">
</div>
<div class="form-group">
  <label for="email">이메일</label><input id="email" class="form-control" 
    placeholder="예)hong@test.com" type="email" name="email">
</div>
<div class="form-group">
  <label for="tel">전화</label><input id="tel" class="form-control" 
    placeholder="예)010-1234-5678" type="tel" name="tel">
</div>
<div class="form-group">
  <label for="password">암호</label><input id="password" class="form-control" 
    placeholder="8자리 이상의 암호" type="password" name="password">
</div>
<div class="form-group">
  <label for="fax">팩스</label><input id="fax" class="form-control" 
    placeholder="예)02-1234-5678" type="tel" name="fax">
</div>
<div class="form-group">
  <label for="postNo">우편번호</label><input id="postNo" class="form-control" 
    placeholder="예)333-222" type="text" name="postNo">
</div>
<div class="form-group">
  <label for="address">주소</label><input id="address" class="form-control" 
    placeholder="예)서울시 강남구" type="text" name="address">
</div>
<div class="form-group">
  <label for="photo">사진</label><input id="photo" class="form-control" 
    type="file" name="photo">
</div>
<input type="submit" value="다음" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>






