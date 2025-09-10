package controller;

import java.io.IOException;
import java.util.List;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CategoryService;
import services.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/admin/home"})
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;


    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        

        List<Category> listcate = categoryService.findAll();


        req.setAttribute("listcate", listcate);

     
        req.getRequestDispatcher("/views/admin.jsp").forward(req, resp);
    }
}
