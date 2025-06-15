package by.HomeWork.controller;

import by.HomeWork.model.Song;
import by.HomeWork.service.PlaylistService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-song")
public class AddSongServlet extends HttpServlet {
    private static final String EMAIL = "email";
    private static final String TITLE = "title";
    private static final String ARTIST = "artist";
    private final PlaylistService service = new PlaylistService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(EMAIL) == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Email not set");
            return;
        }

        String email = (String) session.getAttribute(EMAIL);// убрать в сервис
        String title = req.getParameter(TITLE);//убрать в сервис
        String artist = req.getParameter(ARTIST);//убрать в сервис

        if (title == null || artist == null) { // убрать в сервис
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        service.addSong(email, new Song(title, artist));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}