<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<title>User Home</title>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Xin chào Manager: ${sessionScope.account.fullname}</h2>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger">Đăng xuất</a>
    </div>

    <h3>Danh sách tất cả Category</h3>
    <ul class="list-group">
        <c:forEach items="${listcate}" var="cate">
            <li class="list-group-item">${cate.categoryname}</li>
        </c:forEach>
        <c:if test="${empty listcate}">
            <li class="list-group-item text-center">Chưa có danh mục nào</li>
        </c:if>
    </ul>

</div>
