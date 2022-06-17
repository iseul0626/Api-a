<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<% String data = (String)request.getAttribute("serverTime"); %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1> 
	Hello world! 
	<c:if test="${login != null }">
		${login.name }님 환영합니다!
	</c:if>
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%= data %>

<a href="sample1.do">sample1.do</a> |
<a href="sample2.do">sample2.do</a> |
<br>
<a href="user/register.do">register로 이동</a>	
<br>
<c:if test="${login == null }">
	<a href="user/join.do">회원가입하기</a>
	<br>
	<a href="user/login.do">로그인</a>
	<br>
</c:if>
<c:if test="${login != null }">
	<a href="user/mypage.do">마이페이지</a>
	<a href="user/logout.do">로그아웃</a>
</c:if>
</body>
</html>










