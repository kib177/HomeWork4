package by.HomeWork.controller;

import by.HomeWork.model.Song;
import by.HomeWork.service.PlaylistService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet ("/songs")
public class GetSongsServlet extends HttpServlet {
    private final PlaylistService service = new PlaylistService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Email not set");
            return;
        }

        String email = (String) session.getAttribute("userEmail");
        List<Song> songs = service.getSongs(email);

        resp.setContentType("application/json");
        resp.getWriter().print(convertToJson(songs));
    }

    private String convertToJson(List<Song> songs) {
        StringBuilder json = new StringBuilder("[");
        for (Song song : songs) {
            json.append(String.format(
                    "{\"id\":\"%s\",\"title\":\"%s\",\"artist\":\"%s\"},",
                    song.getTitle(), song.getTitle(), song.getArtist()
            ));
        }
        if (!songs.isEmpty()) json.deleteCharAt(json.length() - 1);
        json.append("]");
        return json.toString();
    }
}

