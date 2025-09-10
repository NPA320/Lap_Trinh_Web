package model.Manager;

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

@WebServlet(urlPatterns = { "/manager/edit" })
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && !id.isEmpty()) {
                Category category = cateService.findById(Integer.parseInt(id));
                if (category != null) {
                    req.setAttribute("category", category);
                }
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/manager/editcategory.jsp");
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

            // Lấy dữ liệu từ form
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");

            // Tìm Category trong DB
            Category category = cateService.findById(id);
            if (category != null) {
                category.setCategoryname(name);
                cateService.update(category); // update DB
            }

            // Quay lại danh sách
            resp.sendRedirect(req.getContextPath() + "/manager/home");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Cập nhật danh mục thất bại!", e);
        }
    }
}
