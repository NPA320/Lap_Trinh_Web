package model.Admin;

import java.io.IOException;

import services.CategoryService;              // đổi đúng package: services
import services.impl.CategoryServiceImpl;    // đổi đúng package: services.impl
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/delete" })
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null) {
                cateService.delete(Integer.parseInt(id));
            }
            resp.sendRedirect(req.getContextPath() + "/admin/home");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Xóa danh mục thất bại!");
        }
    }
}
