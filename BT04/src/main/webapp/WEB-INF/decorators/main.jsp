<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${sitemeshPage.title}</title>
<meta charset="UTF-8" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

${sitemeshPage.head}
</head>
<body>
	<header>
		<%@ include file="/commons/web/header.jsp"%>
	</header>

	<div>
		<sitemesh:write property="body" />
	</div>
	<footer>
		<%@ include file="/commons/web/footer.jsp"%>
	</footer>

	<!-- Bootstrap JS (nếu cần modal, dropdown, toast...) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
