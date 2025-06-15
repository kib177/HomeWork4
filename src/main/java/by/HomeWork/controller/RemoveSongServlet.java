package by.HomeWork.controller;

import by.HomeWork.service.PlaylistService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/remove-song")
public class RemoveSongServlet extends HttpServlet {
    private static final String EMAIL = "email";
    private static final String TITLE = "title";
    private final PlaylistService service = new PlaylistService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(EMAIL) == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Email not set");
            return;
        }

        String email = (String) session.getAttribute(EMAIL);
        String title = req.getParameter(TITLE);

        if (title == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        service.removeSong(email, title);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
