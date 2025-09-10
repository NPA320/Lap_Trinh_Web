<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Sửa Category</h2>
        <c:url value="/admin/edit" var="edit"></c:url>
        <form role="form" action="${edit}" method="post">

            <input type="hidden" name="id" value="${category.id}" />
            
            <div class="form-group mb-3">
                <label for="name">Tên danh mục:</label>
       
                <input type="text" class="form-control" id="name"
                       value="${category.categoryname}" name="name" required />
            </div>
            
            <button type="submit" class="btn btn-success">Cập nhật</button>
            <button type="reset" class="btn btn-secondary">Làm mới</button>
        </form>
    </div>
</body>
</html>
