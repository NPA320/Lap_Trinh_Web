<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<title>Admin Home</title>

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
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger">Đăng xuất</a>
    </div>

    <!-- Danh sách Category -->
    <h3>Danh sách tất cả Category</h3>
    <div class="card">
        <div class="card-body p-0">
            <table class="table table-bordered mb-0">
                <thead class="table-light">
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
                            <td>
                                <c:choose>
                                    <c:when test="${cate.user.roleid == 1}">Admin</c:when>
                                    <c:when test="${cate.user.roleid == 2}">Manager</c:when>
                                    <c:when test="${cate.user.roleid == 3}">User</c:when>
                                    <c:otherwise>Không xác định</c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/category/add" 
                                   class="btn btn-sm btn-success">Thêm</a>
                                <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}" 
                                   class="btn btn-sm btn-warning">Sửa</a>
                                <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}" 
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Bạn có chắc muốn xóa danh mục này?')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <!-- Nếu không có danh mục nào -->
                    <c:if test="${empty listcate}">
                        <tr>
                            <td colspan="5" class="text-center">Chưa có danh mục nào</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

</div>
