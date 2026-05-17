package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        String jdbcUrl = getServletContext().getInitParameter("jdbcUrl");

        String dbUser = getServletContext().getInitParameter("dbUser");

        String dbPass = getServletContext().getInitParameter("dbPass");

        userDAO = new UserDAO(jdbcUrl, dbUser, dbPass);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("===== LOGIN =====");

        String username = req.getParameter("username");

        String password = req.getParameter("password");

        // Kiểm tra rỗng
        if (username == null || username.isBlank()
                || password == null || password.isBlank()) {

            req.setAttribute("error",
                    "Vui lòng nhập username và mật khẩu!");

            req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(req, resp);

            return;
        }

        try {

            // Tìm user
            User user = userDAO.findByUserName(username);

            // Không tồn tại
            if (user == null) {

                req.setAttribute("error",
                        "Tên đăng nhập không tồn tại!");

                req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                        .forward(req, resp);

                return;
            }

            // Sai password
            if (!password.equals(user.getPassword())) {

                req.setAttribute("error",
                        "Mật khẩu không đúng!");

                req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                        .forward(req, resp);

                return;
            }

            // Login thành công
            HttpSession session = req.getSession();

            session.setAttribute("currentUser", user);

            // 30 phút
            session.setMaxInactiveInterval(30 * 60);

            // Chuyển dashboard
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } catch (SQLException e) {

            e.printStackTrace();

            throw new ServletException("Lỗi đăng nhập", e);
        }
    }
}