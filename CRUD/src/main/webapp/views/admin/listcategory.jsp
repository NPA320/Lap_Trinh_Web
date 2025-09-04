<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh mục</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>STT</th>
            <th>Ảnh</th>
            <th>Tên danh mục</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr class="odd gradeX">
                <td>${STT.index + 1}</td>
                <c:url value="/image" var="imgUrl">
                    <c:param name="fname" value="${cate.icon}" />
                </c:url>
                <td><img height="150" width="200" src="${imgUrl}" /></td>
                <td>${cate.catename}</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>">Sửa</a> |
                    <a href="<c:url value='/admin/category/delete?id=${cate.cateid}'/>">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Thêm danh mục</h3>
    <form role="form" action="add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Tên danh mục:</label>
            <input class="form-control" placeholder="please enter category Name" name="name" />
        </div>
        <div class="form-group">
            <label>Ảnh đại diện:</label>
            <input type="file" name="icon" />
        </div>
        <button type="submit" class="btn btn-default">Thêm</button>
        <button type="reset" class="btn btn-primary">Hủy</button>
        
        <p>
    Xin chào, ${sessionScope.username} |
    <a href="<c:url value='/login.jsp'/>">Đăng xuất</a>
</p>
<hr/>
        
     
    </form>
    
    
</body>
</html>
