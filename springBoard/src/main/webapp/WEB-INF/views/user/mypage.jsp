<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>마이페이지</h2>
	midx : ${vo.midx }<br>
	id : ${vo.id }<br>
	pwd : ${vo.password }<br> 
	name : ${vo.name }<br>
	
	<button onclick="location.href='modify.do?midx=${vo.midx}'">수정</button>
</body>
</html>