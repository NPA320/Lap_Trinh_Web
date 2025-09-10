package model.User;

import java.io.IOException;

import entity.Category;
import services.CategoryService;
import services.impl.CategoryServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/user/add" })
public class AddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/addcategory.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");

            // Lấy user đang đăng nhập từ session
            jakarta.servlet.http.HttpSession session = req.getSession(false);
            entity.Users currentUser = (entity.Users) (session != null ? session.getAttribute("account") : null);

            if (currentUser == null) {
                // Nếu chưa login thì chuyển hướng về trang login
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            // Lấy tên danh mục từ form
            String categoryName = req.getParameter("name");

            // Tạo entity Category và gán user
            Category category = new Category();
            category.setCategoryname(categoryName);
            category.setUser(currentUser);   // 🔥 Gán user_id cho Category

            // Lưu vào DB
            cateService.create(category);

            // Redirect về danh sách
            resp.sendRedirect(req.getContextPath() + "/user/home");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Thêm danh mục thất bại!");
        }
    }

}
