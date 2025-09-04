package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = "/ForgetPassword")
public class ForgetPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserServiceImpl service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ForgetPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String newPass = req.getParameter("password");

        if (service.updatePassword(email, newPass)) {
            req.setAttribute("message", "Đổi mật khẩu thành công, vui lòng đăng nhập lại!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("alert", "Không thể đổi mật khẩu (email không tồn tại)");
            req.getRequestDispatcher("ForgetPassword.jsp").forward(req, resp);
        }
    }
}

