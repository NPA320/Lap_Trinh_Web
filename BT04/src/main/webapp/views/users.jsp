<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Categories</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">

		<!-- Thông tin người dùng -->
		<div class="d-flex justify-content-between align-items-center mb-3">
			<div>
				<h2>Xin chào: ${sessionScope.account.fullname}</h2>
				<p class="mb-1">
					<span class="text-muted">UserID:</span> <span
						class="badge bg-secondary">${sessionScope.account.id}</span>
				</p>
				<p>
					Vai trò:
					<c:choose>
						<c:when test="${sessionScope.account.roleid == 1}">Admin</c:when>
						<c:when test="${sessionScope.account.roleid == 2}">Manager</c:when>
						<c:when test="${sessionScope.account.roleid == 3}">User</c:when>
						<c:otherwise>Không xác định</c:otherwise>
					</c:choose>
				</p>
			</div>
			<a href="${pageContext.request.contextPath}/logout"
				class="btn btn-outline-danger">Đăng xuất</a>
		</div>

		<!-- Tiêu đề + nút thêm -->
		<div class="d-flex justify-content-between align-items-center mb-2">
			<h3>Danh sách Categories</h3>
			<a href="${pageContext.request.contextPath}/user/add"
				class="btn btn-success">+ Thêm Category</a>
		</div>

		<!-- Danh sách Categories -->
		<div class="card">
			<div class="card-body p-0">
				<table class="table table-bordered table-hover mb-0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên danh mục</th>
							<th>UserID</th>
							<th>Role</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listcate}" var="cate">
							<tr>
								<td>${cate.id}</td>
								<td>${cate.categoryname}</td>
								<td>${cate.user.id}</td>
								<td><c:choose>
										<c:when test="${cate.user.roleid == 1}">Admin</c:when>
										<c:when test="${cate.user.roleid == 2}">Manager</c:when>
										<c:when test="${cate.user.roleid == 3}">User</c:when>
										<c:otherwise>Không xác định</c:otherwise>
									</c:choose></td>
								<td>
									<!-- Chỉ để Sửa và Xóa trong bảng --> <a
									href="${pageContext.request.contextPath}/user/edit?id=${cate.id}"
									class="btn btn-sm btn-warning">Sửa</a> <a
									href="${pageContext.request.contextPath}/user/delete?id=${cate.id}"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa danh mục này không?');">Xóa</a>
								</td>
							</tr>
						</c:forEach>

						<c:if test="${empty listcate}">
							<tr>
								<td colspan="5" class="text-center text-muted">Chưa có
									Category nào</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>
