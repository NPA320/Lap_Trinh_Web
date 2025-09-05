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

@WebServlet(urlPatterns = {"/admin/category/add"})
public class AddCategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CategoryService cateService = new CategoryServiceImpl();

    // Hiển thị form thêm danh mục
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/addCategories.jsp");
        rd.forward(req, resp);
    }

    // Xử lý thêm mới danh mục
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String categoryName = req.getParameter("categoryname");

        Category cate = new Category();
        cate.setCategoryname(categoryName);

        cateService.create(cate);

        // quay về danh sách
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}
