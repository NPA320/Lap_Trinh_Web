<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<!-- FontAwesome (nếu dùng icon fa-user, fa-lock, fa-envelope, ...) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-light">

	<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
		<div class="card shadow-lg p-4" style="width: 450px; border-radius: 15px;">
			<h2 class="text-center mb-4">Tạo tài khoản mới</h2>

			<!-- Hiển thị thông báo lỗi -->
			<c:if test="${alert != null}">
				<div class="alert alert-danger text-center">${alert}</div>
			</c:if>

			<form action="register" method="post">
				<section>
					<!-- Username -->
					<label class="input login-input w-100 mb-3">
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-user"></i></span>
							<input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
						</div>
					</label>

					<!-- Password -->
					<label class="input login-input w-100 mb-3">
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-lock"></i></span>
							<input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
						</div>
					</label>

					<!-- Email -->
					<label class="input login-input w-100 mb-3">
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-envelope"></i></span>
							<input type="email" placeholder="Email" name="email" class="form-control" required>
						</div>
					</label>

					<!-- Fullname -->
					<label class="input login-input w-100 mb-3">
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-id-card"></i></span>
							<input type="text" placeholder="Họ và tên" name="fullname" class="form-control" required>
						</div>
					</label>

					<!-- Phone -->
					<label class="input login-input w-100 mb-3">
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-phone"></i></span>
							<input type="tel" placeholder="Số điện thoại" name="phone" class="form-control" required>
						</div>
					</label>

					<!-- Submit -->
					<button type="submit" class="btn btn-success w-100">Đăng ký</button>

					<!-- Link đăng nhập -->
					<div class="text-center mt-3">
						<span>Đã có tài khoản?</span>
						<a href="${pageContext.request.contextPath}/login">Đăng nhập ngay</a>
					</div>
				</section>
			</form>
		</div>
	</div>

</body>
</html>
