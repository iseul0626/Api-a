<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String data = (String)request.getAttribute("key");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>sample02.jsp입니다.</h2>
	<%= data %>
	<!-- home.jsp에서 samle1.do링크 클릭시 sample01.jsp로 포워딩하세요.
	이때 컨트롤러에서는 '안녕하세요'라는 데이터를 받아와서 출력하세요 -->
</body>
</html>