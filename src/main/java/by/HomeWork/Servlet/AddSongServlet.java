package by.HomeWork.Servlet;


import by.HomeWork.Service.PlaylistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-song")
public class AddSongServlet extends HttpServlet {
    private final PlaylistService service = new PlaylistService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Email отсутствует");
            return;
        }

        String email = (String) session.getAttribute("userEmail");

        response.getWriter().write("Песня добавлена в плейлист");
    }
}