<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
    <h2>Chào mừng bạn, ${username}</h2>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit">Đăng xuất</button>
    </form>
</body>
</html>
