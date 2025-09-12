package controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/image"})
public class ImageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // f = đường dẫn tương đối lưu trong DB, vd: "users/uuid_file.png"
        String rel = req.getParameter("f");
        if (rel == null || rel.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing f");
            return;
        }

        Path file = Paths.get(Constant.DIR, rel);
        if (!Files.exists(file)) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // đoán content-type theo đuôi file
        String mime = Files.probeContentType(file);
        if (mime == null) mime = "application/octet-stream";
        resp.setContentType(mime);

        try (OutputStream out = resp.getOutputStream()) {
            Files.copy(file, out);
        }
    }
}
