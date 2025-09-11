<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<title>Quản lý Users</title>

<div class="container mt-4">

    <!-- Thanh tiêu đề + Đăng xuất -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Quản lý Users</h2>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger">Đăng xuất</a>
    </div>

   

    <!-- Nút thêm -->
    <div class="mb-3 text-end">
        <a href="${pageContext.request.contextPath}/admin/users/add" class="btn btn-primary">Thêm User</a>
    </div>

    <!-- Bảng Users -->
    <div class="card">
        <div class="card-header bg-info text-white">
            Danh sách Users
        </div>
        <div class="card-body p-0">
            <table class="table table-bordered table-hover mb-0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Họ tên</th>
                        <th>Mật khẩu</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Role ID</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listusers}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.username}</td>
                            <td>${u.fullname}</td>
                            <td>${u.password}</td>
                            <td>${u.email}</td>
                            <td>${u.phone}</td>
                            <td>${u.roleid}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/users/edit?id=${u.id}" 
                                   class="btn btn-sm btn-warning">Sửa</a>
                                <a href="${pageContext.request.contextPath}/admin/users/delete?id=${u.id}" 
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Bạn có chắc muốn xóa User này không?');">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty listusers}">
                        <tr>
                            <td colspan="8" class="text-center text-muted">Chưa có Users nào</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

</div>
