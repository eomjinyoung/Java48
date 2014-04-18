<%-- 
Expression Language
1. 문법: ${객체명.프로퍼티}
1) pageContext : PageContext 객체 (JSP페이지와 태그 핸들러 사이에서 값 공유)
2) pageContext.servletContext: ServletContext 객체
3) pageContext.session: HttpSession 객체
4) pageContext.request: ServletRequest 객체
5) response: ServletResponse 객체
6) param: 요청 파라미터 값 조회
7) paramValues : 요청 파라미터 값(배열일 경우) 조회 
8) header: 헤더값 조회
9) cookie: 쿠키 값 조회
10) initParam: 컨텍스트 파라미터 값 조회
11) pageScope: PageContext의 getAttribute() 호출
12) requestScope: ServletRequest의 getAttribute() 호출
13) sessionScope: HttpSession의 getAttribute() 호출
14) applicationScope: ServletContext의 getAttribute() 호출 

* EL로 리터럴(literal) 값 표현
- 문자열과 숫자 표현 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 리터럴 값 표현</title>
</head>
<body>
${"문자열"}<br>
${'문자열'}<br>
${20}<br>
${3.14}<br>
${true}<br>
${null}<br>
</body>
</html>




















