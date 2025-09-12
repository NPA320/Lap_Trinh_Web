package controller.account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.UUID;

import Utils.Constant;
import entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import services.UsersService;
import services.impl.UsersServiceImpl;

@WebServlet(urlPatterns = {"/user/profile"})
@MultipartConfig(
    fileSizeThreshold = 1 * 1024 * 1024,  // 1MB
    maxFileSize       = 5L * 1024 * 1024, // 5MB/file
    maxRequestSize    = 12L * 1024 * 1024 // 12MB tổng
)
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final UsersService usersService = new UsersServiceImpl();
    private static final Set<String> ALLOWED_EXT = Set.of(".jpg", ".jpeg", ".png", ".webp");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Users current = resolveCurrentUser(req.getSession(false));
        if (current == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute("user", current);
        req.getRequestDispatcher("/views/user/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Users current = resolveCurrentUser(req.getSession(false));
        if (current == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // ===== 1) Lấy dữ liệu text từ form (multipart vẫn dùng getParameter bình thường) =====
        String fullname = emptyToNull(req.getParameter("fullname"));
        String phone    = emptyToNull(req.getParameter("phone"));

        // Validate đơn giản
        String err = null;
        if (fullname == null || fullname.length() > 150) {
            err = "Họ tên không hợp lệ (rỗng hoặc quá 150 ký tự).";
        } else if (phone != null && !phone.matches("^[0-9+()\\-\\s]{8,20}$")) {
            err = "Số điện thoại không hợp lệ.";
        }
        if (err != null) {
            req.setAttribute("user", current);
            req.setAttribute("alert", err);
            req.getRequestDispatcher("/views/user/profile.jsp").forward(req, resp);
            return;
        }

        // ===== 2) Ảnh cũ (để giữ lại nếu không upload mới) =====
        String oldAvatar     = req.getParameter("oldAvatar");
        String oldBackground = req.getParameter("oldBackground");

        // ===== 3) Upload file (nếu có) =====
        String newAvatarPath     = handleUpload(req.getPart("avatar"));
        String newBackgroundPath = handleUpload(req.getPart("background"));

        String finalAvatar     = (newAvatarPath     != null) ? newAvatarPath     : oldAvatar;
        String finalBackground = (newBackgroundPath != null) ? newBackgroundPath : oldBackground;

        // Xóa file cũ nếu có thay mới
        if (newAvatarPath != null && oldAvatar != null && !oldAvatar.isBlank()) {
            deleteIfExists(oldAvatar);
        }
        if (newBackgroundPath != null && oldBackground != null && !oldBackground.isBlank()) {
            deleteIfExists(oldBackground);
        }

        // ===== 4) Cập nhật DB =====
        current.setFullname(fullname);
        current.setPhone(phone);
        current.setAvatar(finalAvatar);
        current.setBackground(finalBackground);
        usersService.update(current);        // em.merge(user)

        // Đồng bộ session (nếu code nơi khác đang dùng sessionScope.account)
        HttpSession session = req.getSession(false);
        if (session != null) session.setAttribute("account", current);

        req.setAttribute("user", current);
        req.setAttribute("msg", "Đã cập nhật hồ sơ.");
        req.getRequestDispatcher("/views/user/profile.jsp").forward(req, resp);
    }

    // ===== Helpers =====

    /** Lấy user từ session: ưu tiên 'account', nếu chưa có thì lấy theo 'username' rồi cache lại. */
    private Users resolveCurrentUser(HttpSession session) {
        if (session == null) return null;

        Object acc = session.getAttribute("account");
        if (acc instanceof Users) return (Users) acc;

        Object un = session.getAttribute(controller.account.LoginController.SESSION_USERNAME);
        if (un instanceof String) {
            String username = (String) un;
            if (!username.isBlank()) {
                Users u = usersService.get(username);
                if (u != null) session.setAttribute("account", u);
                return u;
            }
        }
        return null;
    }

    /** Lưu file ảnh vào Constant.DIR/users và trả về đường dẫn tương đối (ví dụ "users/uuid.png"); null nếu không có file. */
    private String handleUpload(Part part) throws IOException {
        if (part == null || part.getSize() == 0) return null;

        String contentType = part.getContentType();            // image/png, image/jpeg, ...
        if (contentType == null || !contentType.startsWith("image/")) return null;

        String submitted = Path.of(part.getSubmittedFileName()).getFileName().toString();
        String ext = "";
        int dot = submitted.lastIndexOf('.');
        if (dot >= 0) ext = submitted.substring(dot).toLowerCase();

        if (!ALLOWED_EXT.contains(ext)) return null;           // chặn đuôi lạ

        String fileName = UUID.randomUUID().toString() + ext;

        Path dir = Path.of(Constant.DIR, "users");             // ví dụ: D:/upload/users
        Files.createDirectories(dir);

        Path dest = dir.resolve(fileName);
        part.write(dest.toString());

        return "users/" + fileName;                            // lưu chuỗi này vào DB
    }

    private void deleteIfExists(String relPath) {
        try { Files.deleteIfExists(Path.of(Constant.DIR, relPath)); }
        catch (Exception ignore) { }
    }

    private String emptyToNull(String s) {
        return (s == null || s.isBlank()) ? null : s.trim();
    }
}
