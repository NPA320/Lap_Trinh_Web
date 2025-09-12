<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<title>Quản lý Category (User)</title>

<div class="container mt-4">

	<!-- Thông tin người dùng -->
	<div class="d-flex justify-content-between align-items-center mb-3">
		<div>
			<h2>Xin chào: ${sessionScope.account.fullname}</h2>
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

		<div class="d-flex gap-2">
			<a href="${pageContext.request.contextPath}/user/profile"
				class="btn btn-outline-primary"> Hồ sơ (avatar/background) </a> <a
				href="${pageContext.request.contextPath}/logout"
				class="btn btn-outline-danger">Đăng xuất</a>
		</div>
	</div>

	<!-- Danh sách Category của user -->
	<div class="d-flex justify-content-between align-items-center mb-2">
		<h3 class="mb-0">Danh sách Category</h3>
		<a href="${pageContext.request.contextPath}/user/add"
			class="btn btn-primary">Thêm Category</a>
	</div>

	<div class="card">
		<div class="card-body p-0">
			<table class="table table-bordered mb-0">
				<thead class="table-light">
					<tr>
						<th style="width: 80px;">ID</th>
						<th>Tên danh mục</th>
						<th style="width: 100px;">UserID</th>
						<th style="width: 120px;">Role</th>
						<th style="width: 220px;">Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listcate}" var="cate">
						<tr>
							<td>${cate.id}</td>
							<td>${cate.categoryname}</td>
							<td>${sessionScope.account.id}</td>
							<td><c:choose>
									<c:when test="${sessionScope.account.roleid == 1}">Admin</c:when>
									<c:when test="${sessionScope.account.roleid == 2}">Manager</c:when>
									<c:when test="${sessionScope.account.roleid == 3}">User</c:when>
									<c:otherwise>Không xác định</c:otherwise>
								</c:choose></td>

							<td><a
								href="${pageContext.request.contextPath}/user/edit?id=${cate.id}"
								class="btn btn-sm btn-warning">Sửa</a> <a
								href="${pageContext.request.contextPath}/user/delete?id=${cate.id}"
								class="btn btn-sm btn-danger"
								onclick="return confirm('Bạn có chắc muốn xóa danh mục này?')">Xóa</a>
							</td>
						</tr>
					</c:forEach>

					<!-- Nếu không có danh mục nào -->
					<c:if test="${empty listcate}">
						<tr>
							<td colspan="5" class="text-center text-muted">Chưa có danh
								mục nào</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>
