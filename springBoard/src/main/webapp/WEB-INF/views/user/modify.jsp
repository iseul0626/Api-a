<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<form action="modify.do" method="post">
		midx : ${vo.midx }<br>
		id : ${vo.id }<br>
		pwd : <input type="password" name="password" value="${vo.password }"><br>
		name : <input type="text" name="name" value="${vo.name }"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>