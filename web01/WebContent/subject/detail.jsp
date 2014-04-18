<%-- 
JSP 액션 태그
=> JSP에서만 사용하는 태그. 특정 자바 코드를 생성한다.
=> 자바를 잘 모르는 사람들이 쉽게 JSP를 작성할 수 있도록 하기 위함.

<jsp:useBean>
=> 인스턴스를 준비
=> id: 인스턴스 변수명, 보관소에 저장할 키.
=> class: 클래스 이름(fully-qualified name).
=> scope: 인스턴스를 찾거나 보관할 보관소.(page, request, session, application)
=> type: 인스턴스 변수의 타입. 지정하지 않으면 class 속성의 지정된 타입을 사용한다.

<jsp:setProperty>
=> 빈의 프로퍼티 값 설정. (셋터 메서드 호출)
=> name: 자비 빈 이름
=> property: 프로퍼티 이름
=> value: 프로퍼티 값

<jsp:getProperty>
=> 빈의 프로퍼티 값 꺼내기. (겟터 메서드 호출)
=> name: 자비 빈 이름
=> property: 프로퍼티 이름
 --%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="subject" class="vo.SubjectVo" scope="request" />
<%--
SubjectVo subject = (SubjectVo) request.getAttribute("subject");
if (subject == null) {
	subject = new SubjectVo();
	request.setAttribute("subject", subject);
}
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목상세정보</title>
</head>
<body>
<h1>과목 상세정보(JSP, JSP Action)</h1>
<table border='1'>
<tr>
  <th>번호</th>
  <td><jsp:getProperty name="subject" property="no"/></td>
</tr>
<tr>
  <th>과목명</th>
  <td><jsp:getProperty name="subject" property="title"/></td>
</tr>
<tr>
  <th>내용</th>
 <td><textarea rows='5' cols='60'><jsp:getProperty name="subject" property="description"/></textarea></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a> 
<a href='delete.bit?no=<jsp:getProperty name="subject" property="no"/>'>삭제</a> 
<a href='update.bit?no=<jsp:getProperty name="subject" property="no"/>'>변경</a><br>
<jsp:include page="/footer.jsp"/>
</body></html>










