package controller;

import java.io.IOException;
import java.util.List;

import entity.Users;
import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.impl.CategoryServiceImpl;
import services.impl.UsersServiceImpl;

@WebServlet(urlPatterns = {"/user/home"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Users account = (Users) req.getSession().getAttribute("account");
        if (account == null) { resp.sendRedirect(req.getContextPath()+"/login"); return; }

        List<Category> listcate = new CategoryServiceImpl().findByUserId(account.getId());
        req.setAttribute("listcate", listcate);

        req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
    }

}
