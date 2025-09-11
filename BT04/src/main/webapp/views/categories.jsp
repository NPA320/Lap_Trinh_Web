<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">

    <h2>Quản lý danh mục</h2>

    <!-- Thanh tìm kiếm -->
    <form class="d-flex mb-3" action="">
        <input class="form-control me-2" type="search" placeholder="Search" name="keyword">
        <button class="btn btn-outline-primary" type="submit">Search</button>
    </form>

    <!-- Nút thêm -->
    <div class="mb-3 text-end">
        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary">Thêm danh mục</a>
    </div>

    <!-- Bảng danh mục -->
    <div class="card">
        <div class="card-header bg-info text-white">
            Danh sách danh mục
        </div>
        <div class="card-body p-0">
            <table class="table table-bordered table-hover mb-0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên danh mục</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listcate}" var="cate">
                        <tr>
                            <td>${cate.id}</td>
                            <td>${cate.categoryname}</td>
                            
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}">Cập nhật</a> | 
                                <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}" onclick="return confirm('Bạn có chắc muốn xóa không?');">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
