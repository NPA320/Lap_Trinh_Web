<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<h2>Thêm mới Category</h2>
		
		<form action="${pageContext.request.contextPath}/admin/add" 
		      method="post">
			<div class="form-group mb-3">
				<label for="name">Tên danh mục:</label>
				<input type="text" class="form-control" id="name" name="name" 
				       placeholder="Nhập tên danh mục" required />
			</div>
			
			<button type="submit" class="btn btn-success">Thêm</button>
			<button type="reset" class="btn btn-secondary">Hủy</button>
		</form>
	</div>
</body>
</html>
