package Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import Model.Category;
import Service.CategoryService;
import Service.Impl.CategoryServiceImpl;
import Utils.Constant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addcategory.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();

        DiskFileItemFactory diskFileItemFactory = DiskFileItemFactory.builder().get();
        JakartaServletFileUpload servletFileUpload = new JakartaServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);

            for (FileItem item : items) {
                if (item.isFormField() && item.getFieldName().equals("name")) {
    
                    category.setCatename(item.getString());
                } else if (!item.isFormField() && item.getFieldName().equals("icon")) {
                    String originalFileName = item.getName();
                    if (originalFileName != null && !originalFileName.isEmpty()) {
                        int index = originalFileName.lastIndexOf(".");
                        String ext = (index > 0) ? originalFileName.substring(index + 1) : "";
                        String fileName = System.currentTimeMillis() + "." + ext;

                        // 🔥 Sửa chỗ tạo đường dẫn
                        Path uploadPath = Paths.get(Constant.DIR, "category", fileName);
                        item.write(uploadPath);

                        category.setIcon("category/" + fileName);
                    }
                }
            }

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Upload failed!");
        }
    

    }
}
