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
	<h2>sample02.jsp�Դϴ�.</h2>
	<%= data %>
	<!-- home.jsp���� samle1.do��ũ Ŭ���� sample01.jsp�� �������ϼ���.
	�̶� ��Ʈ�ѷ������� '�ȳ��ϼ���'��� �����͸� �޾ƿͼ� ����ϼ��� -->
</body>
</html>