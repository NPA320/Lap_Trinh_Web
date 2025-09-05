<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật danh mục</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    .form-container {
        width: 400px;
        border: 1px solid #ddd;
        padding: 20px;
        border-radius: 5px;
    }
    .form-container h3 {
        background: #e3f2fd;
        margin: -20px -20px 20px -20px;
        padding: 10px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }
    input[type="text"] {
        width: 95%;
        padding: 8px;
        margin-bottom: 15px;
    }
    input[type="submit"] {
        padding: 8px 16px;
        background: #4CAF50;
        border: none;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background: #388E3C;
    }
</style>
</head>
<body>

<div class="form-container">
    <h3>Cập nhật danh mục</h3>
    <form action="${pageContext.request.contextPath}/admin/category/edit" method="post">
        <!-- giữ id ẩn để servlet nhận -->
        <input type="hidden" name="id" value="${category.id}">

        <label for="categoryname">Tên danh mục</label>
        <input type="text" id="categoryname" name="categoryname" value="${category.categoryname}" required>

        <input type="submit" value="Cập nhật">
    </form>
</div>

</body>
</html>
