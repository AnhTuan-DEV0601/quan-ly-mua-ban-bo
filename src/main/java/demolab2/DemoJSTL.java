package demolab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poly/demojstl")
public class DemoJSTL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<String> subjects = new ArrayList<>();

        subjects.add("Java");
        subjects.add("HTML");
        subjects.add("CSS");
        subjects.add("SQL");

        req.setAttribute("subjects", subjects);
        req.setAttribute("age", "10");

        req.getRequestDispatcher("/views/demojstl.jsp")
                .forward(req, resp);
    }
}