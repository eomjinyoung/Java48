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
<h1>학생등록확인</h1>
<h2>기본정보</h2>
이름: ${student.name}<br>
이메일: ${student.email}<br>
전화: ${student.tel}<br>
암호: ${student.password}<br>
팩스: ${student.fax}<br>
우편번호: ${student.postNo}<br>
주소: ${student.address}<br>

<h2>추가정보</h2>
회사: ${student.company}<br>
직위: ${student.position}<br>
상태: ${student.workingState}<br>
최종학교: ${student.lastSchool}<br>
계좌번호: ${student.bankingAccount}<br>

<form action="insert4.bit" method="post" role="form">
입력 정보를 등록하시겠습니까?
<input type="submit" value="확인" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>



















