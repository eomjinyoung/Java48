<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header" 
  style="border: 1px solid white; background-color: darkgray; font-weight: bold; font-size: 18px; color: white;">
${loginUser.name}(${loginUser.email})
<a href="${pageContext.request.contextPath}/auth/logout.bit">로그아웃</a>
</div>