<%@ page contentType="text/html; charset=UTF-8" %>

<title>Trang chủ</title>

<div class="container mt-5">

    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Chào mừng đến với UTESHOP</h3>
                </div>
                <div class="card-body">
                    <p>
                        Đây là hệ thống bán hàng trực tuyến UTESHOP.  
                        Tại đây bạn có thể tìm thấy nhiều sản phẩm chất lượng 
                        với giá cả hợp lý và dịch vụ hỗ trợ khách hàng tận tình.
                    </p>

                    <h5 class="mt-4">Thông tin liên hệ</h5>
                    <ul class="list-unstyled">
                        <li><strong>Email:</strong> support@uteshop.com</li>
                        <li><strong>Điện thoại:</strong> 0123 456 789</li>
                        <li><strong>Địa chỉ:</strong> 123 Đường ABC, Quận XYZ, TP.HCM</li>
                    </ul>

                    <!-- Nút đăng nhập -->
                    <div class="text-center mt-4">
                        <a href="${pageContext.request.contextPath}/login" 
                           class="btn btn-primary btn-lg">Đăng nhập</a>
                    </div>
                </div>
                <div class="card-footer text-muted text-center">
                    Cảm ơn bạn đã ghé thăm UTESHOP 💙
                </div>
            </div>
        </div>
    </div>

</div>
