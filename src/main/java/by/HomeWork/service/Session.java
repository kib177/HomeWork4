package by.HomeWork.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Session {
    private static final String EMAIL = "email";

    public static String getEmailFromAnyWhere(HttpServletRequest request) {

        String email = request.getParameter(EMAIL);
        if(email == null || email.trim().isEmpty()) {
            HttpSession session = request.getSession();
            if(!session.isNew()) {
                email = (String) session.getAttribute(email);
            }
        }
        return email;
    }

    public static void saveSession(HttpServletRequest request, String email, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(email, value);
    }

    public static boolean isEmailValid(HttpServletResponse resp, String email) {

        if (email == null || email.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        return true;
    }
}
