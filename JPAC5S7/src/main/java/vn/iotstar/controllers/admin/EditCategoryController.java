package vn.iotstar.controllers.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category/edit"})
public class EditCategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CategoryService cateService = new CategoryServiceImpl();

    // Hiển thị form edit
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));  // lấy id từ URL
            Category category = cateService.findById(id);       // tìm category theo id
            req.setAttribute("category", category);

            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/editCategories.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Category ID");
        }
    }

    // Xử lý update
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("categoryname");

            Category category = new Category();
            category.setId(id);
            category.setCategoryname(name);

            cateService.update(category); // gọi service để update DB

            // Quay về danh sách sau khi update
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Update failed!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/editCategories.jsp");
            rd.forward(req, resp);
        }
    }
}

