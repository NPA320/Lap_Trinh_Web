package controller;

import java.io.IOException;
import java.util.List;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/categories"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryServiceImpl cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> listCategory = cateService.findAll();
        req.setAttribute("listcate", listCategory);
        req.getRequestDispatcher("/views/category.jsp").forward(req, resp);
    }
}
