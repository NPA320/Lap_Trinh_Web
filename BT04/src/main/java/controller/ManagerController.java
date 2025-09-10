package controller;

import java.io.IOException;
import java.util.List;

import entity.Category;
import entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.CategoryService;
import services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/manager/home"})
public class ManagerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Users user = (Users) (session != null ? session.getAttribute("account") : null);

        // Nếu chưa login hoặc không phải Manager -> quay về login
        if (user == null || user.getRoleid() != 2) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Lấy tất cả Category của những user có roleid = 2 (Manager)
        List<Category> listcate = cateService.findByRole(2);

        // Gắn vào request để JSP hiển thị
        req.setAttribute("listcate", listcate);

        // Forward sang trang JSP
        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);
    }
}
