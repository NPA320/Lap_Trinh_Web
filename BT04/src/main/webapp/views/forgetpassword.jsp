<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<!-- FontAwesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="card shadow-lg p-4" style="width: 450px; border-radius: 15px;">
        <h2 class="text-center mb-4">Quên mật khẩu</h2>

        <!-- Hiển thị thông báo -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>
        <c:if test="${message != null}">
            <div class="alert alert-success text-center">${message}</div>
        </c:if>

        <form action="ForgetPassword" method="post">
            <section>
                <!-- Email -->
                <label class="input login-input w-100 mb-3">
                    <div class="input-group">
                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                        <input type="email" placeholder="Nhập email đăng ký" name="email" class="form-control" required>
                    </div>
                </label>

                <!-- New Password -->
                <label class="input login-input w-100 mb-3">
                    <div class="input-group">
                        <span class="input-group-text"><i class="fa fa-lock"></i></span>
                        <input type="password" placeholder="Nhập mật khẩu mới" name="password" class="form-control" required>
                    </div>
                </label>

                <!-- Submit -->
                <button type="submit" class="btn btn-primary w-100">Đặt lại mật khẩu</button>

                <!-- Link quay lại đăng nhập -->
                <div class="text-center mt-3">
                    <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
                </div>
            </section>
        </form>
    </div>
</div>

</body>
</html>
