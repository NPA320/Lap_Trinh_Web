<%@ page contentType="text/html; charset=UTF-8" %>

<footer class="bg-dark text-white text-center py-3 mt-5">
    <div class="container">
        <p class="mb-1">&copy; <%= java.time.Year.now() %> UTESHOP. All rights reserved.</p>
        <p class="small mb-0">
            <a href="${pageContext.request.contextPath}/about" class="text-decoration-none text-white-50">About</a> | 
            <a href="${pageContext.request.contextPath}/contact" class="text-decoration-none text-white-50">Contact</a> | 
            <a href="${pageContext.request.contextPath}/privacy" class="text-decoration-none text-white-50">Privacy Policy</a>
        </p>
    </div>
</footer>
