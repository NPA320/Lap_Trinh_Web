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

@WebServlet(urlPatterns = {"/user/home"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // inject DAO/Service
    private CategoryService categoryService = new CategoryServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	  // Lấy toàn bộ Category từ DB
        List<Category> listcate = categoryService.findAll();

        // Gắn vào request để JSP sử dụng
        req.setAttribute("listcate", listcate);


        // Forward sang JSP
        req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
    }
}
