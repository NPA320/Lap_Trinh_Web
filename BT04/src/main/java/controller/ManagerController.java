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
import services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/manager/home"})
public class ManagerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryServiceImpl cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Users user = (Users) (session != null ? session.getAttribute("account") : null);

        if (user == null || user.getRoleid() != 2) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // lấy danh sách category thuộc user đang login
//        List<Category> categories = user.getCategories();

        // nếu muốn lấy từ DB thì dùng service:
        List<Category> categories = cateService.findByUserId(user.getId());
        req.setAttribute("listcate", categories);
        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);


        req.setAttribute("listcate", categories);
        req.getRequestDispatcher("/views/manager.jsp").forward(req, resp);
    }
}
