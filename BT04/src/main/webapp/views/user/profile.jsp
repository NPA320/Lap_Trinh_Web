<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Hồ sơ người dùng</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

  <h2 class="mb-3">Hồ sơ người dùng</h2>

  <c:if test="${not empty alert}">
    <div class="alert alert-danger">${alert}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="alert alert-success">${msg}</div>
  </c:if>

  <!-- Thông tin cơ bản -->
  <div class="row g-4">
    <div class="col-md-6">
      <!-- Form cập nhật (multipart) -->
      <form action="${pageContext.request.contextPath}/user/profile"
            method="post" enctype="multipart/form-data">

        <!-- giữ đường dẫn cũ -->
        <input type="hidden" name="oldAvatar" value="${user.avatar}">
        <input type="hidden" name="oldBackground" value="${user.background}">

        <div class="mb-3">
          <label class="form-label">Họ tên</label>
          <input class="form-control" type="text" name="fullname"
                 maxlength="150" value="${user.fullname}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Phone</label>
          <input class="form-control" type="text" name="phone"
                 value="${user.phone}" pattern="[0-9+\(\)\-\s]{8,20}"
                 placeholder="VD: 0901234567">
          <div class="form-text">8–20 ký tự, cho phép số và + ( ) - khoảng trắng.</div>
        </div>

        <div class="mb-3">
          <label class="form-label">Avatar mới</label>
          <input class="form-control" type="file" name="avatar" accept="image/*">
        </div>

        <div class="mb-3">
          <label class="form-label">Background mới</label>
          <input class="form-control" type="file" name="background" accept="image/*">
        </div>

        <button class="btn btn-primary">Lưu thay đổi</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/user/home">Quay lại</a>
      </form>
    </div>

    <!-- Cột xem trước ảnh -->
    <div class="col-md-6">
      <div class="mb-4">
        <p class="mb-1 fw-semibold">Avatar hiện tại:</p>
        <c:choose>
          <c:when test="${not empty user.avatar}">
            <img src="${pageContext.request.contextPath}/image?f=${user.avatar}" width="160"
                 class="rounded border">
          </c:when>
          <c:otherwise><em>Chưa có</em></c:otherwise>
        </c:choose>
      </div>

      <div class="mb-4">
        <p class="mb-1 fw-semibold">Background hiện tại:</p>
        <c:choose>
          <c:when test="${not empty user.background}">
            <img src="${pageContext.request.contextPath}/image?f=${user.background}" width="320"
                 class="rounded border">
          </c:when>
          <c:otherwise><em>Chưa có</em></c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>

</body>
</html>
