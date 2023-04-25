<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<form method="post" action="${pageContext.request.contextPath}/sayHello">
	<label for="username">Tên người dùng:</label>
        <input type="text" id="username" name="username" />
		 <button type="submit">SAY</button>
	</form>
</body>
</html>