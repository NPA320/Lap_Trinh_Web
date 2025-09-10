package model.User;

import java.io.IOException;

import entity.Category;
import entity.Users;
import services.CategoryService;
import services.impl.CategoryServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/user/edit" })
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null) {
                Category category = cateService.findById(Integer.parseInt(id));
                req.setAttribute("category", category);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/editcategory.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không tìm thấy danh mục!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

 
            jakarta.servlet.http.HttpSession session = req.getSession(false);
            Users currentUser = (Users) (session != null ? session.getAttribute("account") : null);

            if (currentUser == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");

            Category category = cateService.findById(id);

            if (category == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Danh mục không tồn tại!");
                return;
            }

            if (currentUser.getRoleid() == 3 && category.getUser().getId() != currentUser.getId()) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Bạn chỉ có thể sửa Category của chính mình tạo ra!");
                return;
            }

        
            category.setCategoryname(name);
            cateService.update(category);

       
            resp.sendRedirect(req.getContextPath() + "/user/home");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Cập nhật danh mục thất bại!", e);
        }
    }
}
