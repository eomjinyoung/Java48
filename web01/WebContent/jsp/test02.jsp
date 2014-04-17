<%-- 
스크립트릿
- <% 자바코드 %> => 자바 파일로 그대로 복사
   void _jspService(...){
        ...
        자바코드
        ...
   }    
--%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test01</title>
<%
int i = 20;
int j = 30;
%>
</head>
<body>
<h1>스크립트릿</h1>
<%
if (i > 10) {
	out.println("<p> i > 10 </p>");
}
for (int x = 0; x < j; x++) {
  out.print("$");
}
%>
</body>
</html>
















