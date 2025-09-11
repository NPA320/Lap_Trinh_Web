<%@ page contentType="text/html; charset=UTF-8" %>

<header class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <!-- Logo / Trang chủ -->
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
      UTESHOP
    </a>

    <!-- Nút toggle cho mobile -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
            data-bs-target="#navbarNav" aria-controls="navbarNav" 
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Menu -->
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/home">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/about">Giới thiệu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/contact">Liên hệ</a>
        </li>
      </ul>
    </div>
  </div>
</header>
