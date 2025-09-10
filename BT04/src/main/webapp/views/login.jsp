<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập hệ thống</title>
    <!-- Có thể thêm Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="card shadow-lg p-4" style="width: 400px; border-radius: 15px;">
        <h2 class="text-center mb-4">Đăng nhập</h2>

        <!-- Hiển thị thông báo lỗi -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>

        <form action="login" method="post">
            <!-- Username -->
            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" class="form-control" name="username" placeholder="Nhập tài khoản" required>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="password" placeholder="Nhập mật khẩu" required>
            </div>

            <!-- Remember me -->
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" name="remember" id="remember">
                <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
            </div>

            <!-- Submit -->
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>

			<div class="text-center mt-3">
                <span>Quên mật khẩu?</span> 
                <a href="${pageContext.request.contextPath}/ForgetPassword">Quên mật khẩu</a>
            </div>


            <!-- Link đăng ký -->
            <div class="text-center mt-3">
                <span>Chưa có tài khoản?</span> 
                <a href="${pageContext.request.contextPath}/register">Đăng ký ngay</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
